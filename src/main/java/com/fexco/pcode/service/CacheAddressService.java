/**
 * 
 */
package com.fexco.pcode.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.fexco.pcode.dto.Address;
import com.fexco.pcode.dto.ClientRequest;

/**
 * Class to interact with cache and search addresess in cahce for a given key
 * 
 * @author Sachin
 *
 */
@Service
@Order(value=Ordered.HIGHEST_PRECEDENCE)
public class CacheAddressService implements AddressLookupService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fexco.pcode.service.AddressLookupService#getAllAddresses(com.fexco.
	 * pcode.dto.ClientRequest)
	 */
	@Override
	public List<Address> getAllAddresses(ClientRequest request) {
		LOGGER.info("Fetching address from cache for key, Key::{}",request.getDerivedKey());
		return null;
	}

}
