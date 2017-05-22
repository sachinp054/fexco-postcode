/**
 * 
 */
package com.fexco.pcode.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fexco.pcode.dto.Address;

/**
 * @author Sachin
 *
 */
public class CacheAddressServiceTest {

	String key = "KEY";
	
	private RedisCacheManager cacheManager;
	private Address expectedAddress;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

	        JedisConnectionFactory factory = new JedisConnectionFactory();
	        factory.setHostName("localhost");
	        factory.setPort(6379);
	        factory.afterPropertiesSet();
	    
	    	final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
			template.setConnectionFactory(factory);
			template.setDefaultSerializer(new StringRedisSerializer());
			template.setValueSerializer(new JdkSerializationRedisSerializer());
			template.afterPropertiesSet();
		
	    
	        cacheManager = new RedisCacheManager(template);
	        Collection<String> cacheNames = new ArrayList<>();
	        cacheNames.add("addressCache");		
	        cacheManager.setCacheNames(cacheNames);
	        cacheManager.afterPropertiesSet();
	        
	    
	        String addString = "{\"addressline1\":\"16 Abercorn Terrace\",\"addressline2\":\"Dublin 8\",\"addressline3\":\"Co Dublin\",\"summaryline\":"
	        		+ "\"16 Abercorn Terrace, Dublin 8, Co Dublin\",\"street\":\"Abercorn Terrace\",\"posttown\":\"Dublin\",\"county\":\"Co Dublin\","
	        		+ "\"postcode\":\"8\",\"number\":\"16\"}";
	        
	        ObjectMapper objectMapper = new ObjectMapper();
	        expectedAddress = objectMapper.readValue(addString, Address.class);
	        cacheManager.getCache("addressCache").put(key, expectedAddress);
	}

	@Test
	public void testGetAllAddresses() {
		Address actualAddress = (Address) cacheManager.getCache("addressCache").get(key).get();
		
		assertEquals(expectedAddress.getAddressline1(),actualAddress.getAddressline1());
	}

}
