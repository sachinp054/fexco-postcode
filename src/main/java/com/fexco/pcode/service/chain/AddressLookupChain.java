/**
 * 
 */
package com.fexco.pcode.service.chain;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.fexco.pcode.dto.Address;
import com.fexco.pcode.dto.ClientRequest;
import com.fexco.pcode.service.AddressLookupService;

/**
 * @author Sachin
 *
 */
@Component
public class AddressLookupChain implements LookupChain<ClientRequest, List<Address>> {


	private List<AddressLookupService> service;

	/**
	 * @param service
	 */
	@Inject
	public AddressLookupChain(List<AddressLookupService> service) {
		super();
		this.service = service;

	}
	
	/* (non-Javadoc)
	 * @see com.fexco.pcode.service.chain.LookupChain#chain(java.lang.Object)
	 */
	@Override
	public List<Address> chain(ClientRequest t) {
		List<Address> addresses = null;
		for (AddressLookupService s : service) {
			addresses = s.getAllAddresses(t);
			if (Objects.nonNull(addresses)) {
				break;
			}
		}
		return addresses;
	}

	
}
