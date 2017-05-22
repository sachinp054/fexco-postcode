package com.fexco.pcode.dto;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="third_party_response")
public class ThirdPartyResponse {

	private String requestId;
	private String key;
	private List<Address> address;
	
	
	
	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}
	/**
	 * @param requestId the requestId to set
	 */
	public ThirdPartyResponse requestId(String requestId) {
		this.requestId = requestId;
		return this;
	}
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public ThirdPartyResponse key(String key) {
		this.key = key;
		return this;
	}
	
	
	
	/**
	 * @return the address
	 */
	public List<Address> getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public ThirdPartyResponse address(List<Address> address) {
		this.address = address;
		return this;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThirdPartyResponse other = (ThirdPartyResponse) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	
}
