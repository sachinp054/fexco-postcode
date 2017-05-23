/**
 * 
 */
package com.fexco.pcode.response.builder;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

import org.springframework.util.ReflectionUtils;

import com.fexco.pcode.dto.Address;
import com.fexco.pcode.dto.ClientRequest;

/**
 * Class for building addresses.
 * 
 * For every address request this application queries third party API without
 * any query parameter other than addTags attribute. When next request comes it
 * queries Cache or DB to find address with same key if Address is found, this
 * class builds the address in expected format.
 * 
 * @author Sachin
 *
 */

public class AddressBuilder {

	List<Address> addresses;
	ClientRequest clientRequest;

	private AddressBuilder(ClientRequest clientRequest) {
		this.clientRequest = clientRequest;
	}

	public static AddressBuilder forClientRequest(ClientRequest clientRequest) {
		return new AddressBuilder(clientRequest);
	}

	public AddressBuilder withAddresses(List<Address> addresses) {
		this.addresses = addresses;
		return this;
	}

	public List<Address> build() {
		if (Objects.nonNull(this.clientRequest)) {
			for (Address address : addresses) {
				AddressLineAppender.appendAddressLinesWithIncludeExclude(address, clientRequest.getLines(),
						Objects.nonNull(clientRequest.getInclude()) ? clientRequest.getInclude() : "",
						Objects.nonNull(clientRequest.getExclude()) ? clientRequest.getExclude() : "");
			}
		}
		return addresses;
	}

	/*
	 * 
	 * Inner class to append address lines. As per the confirmation from
	 * ThirdPartyApi provider maximum number of lines supported are 10. Address
	 * line sequence is constructed based on specification from thirdparty api.
	 * For uk addresses-
	 * https://developers.alliescomputing.com/postcoder-web-api/address-lookup/
	 * premise [Check Response field descriptions section] ie address-
	 * https://developers.alliescomputing.com/postcoder-web-api/address-lookup/
	 * eircode [Check Response field descriptions section]
	 * 
	 *
	 */
	private static class AddressLineAppender {
		static String[] eirCodeAddressLinesByDeafault = { "pobox", "organisation", "departmentname", "buildingname",
				"subbuildingname", "number", "premise", "dependentstreet", "street", "doubledependentlocality",
				"dependentlocality"};

		static Address appendAddressLinesWithIncludeExclude(Address address, int lines, String includes,
				String excludes) {
			Map<String, String> addressLineMap = new LinkedHashMap<>();
			for (String s : eirCodeAddressLinesByDeafault) {
				Field field = ReflectionUtils.findField(Address.class, s);
				field.setAccessible(true);
				Object fieldValue = ReflectionUtils.getField(field, address);
				if (Objects.nonNull(fieldValue) && !excludes.contains(s)) {
					addressLineMap.put(s, (String) fieldValue);
				}
			}
			List<String> fields = new LinkedList<>();
			fields.addAll(addressLineMap.keySet());
			Set<String> hashSet = new LinkedHashSet<>();
			hashSet.addAll(addressLineMap.values());
			List<String> values = new LinkedList<>();
			values.addAll(hashSet);
			//set values as per the line no
			StringBuilder sb = new StringBuilder();
			if(lines<values.size()){
				if(lines==1){
					for(int l=0;l<values.size();l++){
						sb.append(values.get(l)).append(",");
					}
					values.clear();
					values.add(sb.toString());
					fields.clear();
					fields.add("dummy");
				}else{
					Stack<String> s = new Stack<>();
					while (lines!=values.size()){
						s.push(values.remove(values.size()-1));
						fields.remove(fields.size()-1);
					}
					int size = s.size();
					for(int l=0;l<size;l++){
						sb.append(s.pop()).append(",");
					}
					sb.setLength(sb.length()-1);
					values.set(lines-1, values.get(lines-1)+","+sb.toString());
					//values.add(sb.toString());
				}
			}
			
			int count =1;
			for(Map.Entry<String, String> entry:addressLines(values, fields).entrySet()){
				Field field = ReflectionUtils.findField(Address.class, entry.getKey());
				field.setAccessible(true);
				ReflectionUtils.setField(field, address, entry.getValue());
				count++;
			}
			
			//set other address lines as null
			for(int j=count;j<10;j++){
				Field field = ReflectionUtils.findField(Address.class, "addressline"+j);
				field.setAccessible(true);
				ReflectionUtils.setField(field, address, null);
			}

			return address;
		}

		private static boolean allCharactersDigits(String str) {
			boolean allCharactersDigits = true;
			for (int i = 0; i < str.length(); i++) {
				if (!Character.isDigit(str.charAt(i)) && !"-".equals(Character.toString(str.charAt(i)))) {
					allCharactersDigits = false;
					break;
				}
			}
			return allCharactersDigits;
		}

		private static Map<String, String> addressLines(List<String> values, List<String> keys) {
			Map<String, String> map = new HashMap<>();
			int count =1;
			for (int i = 0; i < values.size(); i++) {
				
				String addressLine = null;
				
				if (allCharactersDigits(values.get(i)) && !keys.get(i).equals("postcode")) {
					
					if(values.get(i).equals(values.get(i + 1))){
						addressLine = values.get(i) + " " + values.get(i + 2);
						i++;
					}else{
						addressLine = values.get(i) + " " + values.get(i + 1);
					}
					i++;
				} else{
					addressLine = values.get(i);
					 if ((i+1) < values.size() && values.get(i).equals(values.get(i + 1))) {				
							i++;
						}
				}

				map.put("addressline" +count, addressLine);
				count++;
			}
			
			return map;
		}
	}
}
