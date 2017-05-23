package com.fexco.pcode.dto;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;

import com.fexco.pcode.util.Constants.RequestStatus;

@Document(collection="third_party_request")
public class ThirdPartyRequest {

	private String requestId;
	private String thirdPartyUri;
	private String key;
	private HttpStatus errCode;
	private String errMessage;
	private RequestStatus status;
	
	
	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}
	/**
	 * @param requestId the requestId to set
	 */
	public ThirdPartyRequest requestId(String requestId) {
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
	public ThirdPartyRequest key(String key) {
		this.key = key;
		return this;
	}
	/**
	 * @return the errCode
	 */
	public HttpStatus getErrCode() {
		return errCode;
	}
	/**
	 * @param errCode the errCode to set
	 */
	public ThirdPartyRequest errCode(HttpStatus errCode) {
		this.errCode = errCode;
		return this;
	}
	/**
	 * @return the errMessage
	 */
	public String getErrMessage() {
		return errMessage;
	}
	/**
	 * @param errMessage the errMessage to set
	 */
	public ThirdPartyRequest errMessage(String errMessage) {
		this.errMessage = errMessage;
		return this;
	}
	/**
	 * @return the status
	 */
	public RequestStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public ThirdPartyRequest status(RequestStatus status) {
		this.status = status;
		return this;
	}
	
	/**
	 * @return the thirdPartyUri
	 */
	public String getThirdPartyUri() {
		return thirdPartyUri;
	}
	/**
	 * @param thirdPartyUri the thirdPartyUri to set
	 */
	public ThirdPartyRequest thirdPartyUri(String thirdPartyUri) {
		this.thirdPartyUri = thirdPartyUri;
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
		ThirdPartyRequest other = (ThirdPartyRequest) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
	
}
