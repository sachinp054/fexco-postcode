/**
 * 
 */
package com.fexco.pcode.util;

import java.util.Objects;

import com.fexco.pcode.dto.ClientRequest;

/**
 * Class generates key for storing data into cache based on ClientRequest
 * 
 * @author Sachin
 *
 */
public class AddressKeyGenerator {

	/**
	 * 
	 * @param clientRequest
	 * @return Generated key
	 */
	public static String generateKey(ClientRequest clientRequest) {
		StringBuilder keyBuilder =  new StringBuilder().append(clientRequest.getEndPointName()).append("#")
				.append(clientRequest.getCountry()).append("#").append(clientRequest.getPostCode());
		if(Objects.nonNull(clientRequest.getAddtags())){
			keyBuilder.append("#").append(clientRequest.getAddtags());
		}
		return keyBuilder.toString();
	}

}
