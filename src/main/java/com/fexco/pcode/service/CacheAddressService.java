/**
 * 
 */
package com.fexco.pcode.service;

import java.util.List;

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
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fexco.pcode.service.AddressLookupService#getAllAddresses(com.fexco.
	 * pcode.dto.ClientRequest)
	 */
	@Override
	public List<Address> getAllAddresses(ClientRequest request) {
		return null;
	}

}
