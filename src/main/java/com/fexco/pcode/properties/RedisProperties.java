/**
 * 
 */
package com.fexco.pcode.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Redis configurations
 * 
 * @author Sachin
 *
 */
@Configuration
public class RedisProperties {
	
	@Value("${spring.data.redis.host}")
	private String host;
	
	@Value("${spring.data.redis.port}")
	private int port;
	
	public String getHost() {
		return host;
	}
	public int getPort() {
		return port;
	}	
	
}
