/**
 * 
 */
package com.fexco.pcode.dto;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Sachin
 *
 */
@Document(collection="client_response")
public class ClientResponse {

	private String requestId;
	private String response;
	
	public String getRequestId() {
		return requestId;
	}
	public ClientResponse requestId(String requestId) {
		this.requestId = requestId;
		return this;
	}
	public String getResponse() {
		return response;
	}
	public ClientResponse response(String response) {
		this.response = response;
		return this;
	}
	
}
