/**
 * 
 */
package com.fexco.pcode.exception;

/**
 * Exception class for defining Invalid client request. 
 * 
 * @author Sachin
 *
 */
public class InvalidRequestException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public InvalidRequestException(String message) {
		super(message);
	}

}
