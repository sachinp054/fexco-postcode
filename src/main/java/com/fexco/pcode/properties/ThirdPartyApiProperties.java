/**
 * 
 */
package com.fexco.pcode.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sachin
 *
 */
@Configuration
public class ThirdPartyApiProperties {

	@Value("${spring.application.thirdpartyapi.baseurl}")
	private String baseurl;

	@Value("${spring.application.thirdpartyapi.token}")
	private String token;

	@Value("${spring.application.thirdpartyapi.pagesize}")
	private int pagesize;

	/**
	 * @return the baseurl
	 */
	public String getBaseurl() {
		return baseurl;
	}

	/**
	 * @param baseurl
	 *            the baseurl to set
	 */
	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the pagesize
	 */
	public int getPageSize() {
		return pagesize;
	}

	/**
	 * @param pagesize
	 *            the pagesize to set
	 */
	public void setPageSize(int pagesize) {
		this.pagesize = pagesize;
	}
	
}
