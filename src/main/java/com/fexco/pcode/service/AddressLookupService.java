/**
 * 
 */
package com.fexco.pcode.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.fexco.pcode.dto.Address;
import com.fexco.pcode.dto.ClientRequest;

/**
 * @author Sachin
 *
 */
public interface AddressLookupService {
	@Cacheable(key="#request.getDerivedKey()", cacheNames="addressCache")
	List<Address> getAllAddresses(ClientRequest request);
}
