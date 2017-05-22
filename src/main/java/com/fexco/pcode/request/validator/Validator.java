 
 /**
 */
package com.fexco.pcode.request.validator;

import com.fexco.pcode.dto.ClientRequest;
import com.fexco.pcode.exception.InvalidRequestException;

/**
 * Interface for validating client request.
 * One available implementation is {@RequestParamValidator}
 * 
 * @author Sachin
 *
 */
public interface Validator {
	/**
	 *  Validate client request
	 *  
	 *  @param clientRequest
	 *  @throws InvalidRequestException
	 */
	public void validate(ClientRequest clientRequest) throws InvalidRequestException;
}
