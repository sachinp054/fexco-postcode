/**
 * 
 */
package com.fexco.pcode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Sachin
 *
 */
@Configuration
public class BeanConfig {

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
