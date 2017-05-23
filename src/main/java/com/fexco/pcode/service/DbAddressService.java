/**
 * 
 */
package com.fexco.pcode.service;

import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.fexco.pcode.dto.Address;
import com.fexco.pcode.dto.ClientRequest;
import com.fexco.pcode.repository.ThirdPartyResponseRepository;

/**
 * Class is responsible for finding addresses in database.
 * 
 * @author Sachin
 *
 */
@Service
@Order(value=1)
public class DbAddressService implements AddressLookupService{

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private ThirdPartyResponseRepository trdPartyRspRepository;
	
	@PostConstruct
	void inti(){
		trdPartyRspRepository.deleteAll();
	}
	/* (non-Javadoc)
	 * @see com.fexco.pcode.service.AddressLookupService#getAllAddresses(com.fexco.pcode.dto.ClientRequest)
	 */
	@Override
	public List<Address> getAllAddresses(ClientRequest request) {
		
		String key = request.getDerivedKey();
		LOGGER.info("ClientRequestId::{}, looking for address in db. Key::{}.",request.getRequestId(),key);
		@SuppressWarnings("unchecked")
		List<Address> addresses = (List<Address>) trdPartyRspRepository.findOne(key);
		if(Objects.nonNull(addresses)){
			return addresses;
		}else{
			LOGGER.info("ClientRequestId::{}, Could not find address in db for given request. Key::{}.",request.getRequestId(),key);
			return null;
		}
	}	
}
