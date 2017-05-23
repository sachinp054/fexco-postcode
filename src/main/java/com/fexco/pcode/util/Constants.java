/**
 * 
 */
package com.fexco.pcode.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Sachin
 *
 */
public final class Constants {
	
	
	/**
	 * 
	 */
	private Constants() {
		super();
	}

	public static enum RequestStatus{
		RECEIVED,PROCESSING,COMPLETED,FAILED
	}
	
	public static class QueryParam{
			public static final String LINES ="lines";
			public static final String FORMAT ="format";
			public static final String INCLUDE ="include";
			public static final String EXCLUDE ="exclude";
			public static final String ADDTAGS ="addtags";
			public static final String IDENTIFIER ="identifier";
			public static final String PAGE ="page";
			public static final String PARAM_SEPRATOR =",";
			public static final String KEY_VALUE_SEPRATOR ="=";
	}
	
	public static String  HOST;
			
			static
			{
				try {
					HOST = InetAddress.getLocalHost().getHostAddress();
				} catch (UnknownHostException e) {
					HOST = "fexco-code";
				}
			}
}
