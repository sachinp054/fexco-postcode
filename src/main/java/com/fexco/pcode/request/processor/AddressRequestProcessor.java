/**
 * 
 */
package com.fexco.pcode.request.processor;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fexco.pcode.dto.Address;
import com.fexco.pcode.dto.ClientRequest;
import com.fexco.pcode.exception.InvalidRequestException;
import com.fexco.pcode.repository.ClientRequestRepository;
import com.fexco.pcode.request.validator.Validator;
import com.fexco.pcode.response.builder.AddressBuilder;
import com.fexco.pcode.service.chain.LookupChain;
import com.fexco.pcode.util.Constants.RequestStatus;

/**
 * @author Sachin
 *
 */
@Service
public class AddressRequestProcessor extends AbstractRequestProcessor<ClientRequest, List<Address>> {

	private LookupChain<ClientRequest, List<Address>> addressLookupChain;
	private ClientRequestRepository clientRequestRepository;
	private List<Validator> validators;
	/**
	 * 
	 */
	@Inject
	public AddressRequestProcessor(LookupChain<ClientRequest, List<Address>> addressLookupChain,
			ClientRequestRepository clientRequestRepository,List<Validator> validators) {
		this.addressLookupChain = addressLookupChain;
		this.clientRequestRepository =clientRequestRepository;
		this.validators = validators;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fexco.pcode.request.processor.AbstractRequestProcessor#
	 * getAddressLookupChain()
	 */
	@Override
	public LookupChain<ClientRequest, List<Address>> getAddressLookupChain() {
		return this.addressLookupChain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fexco.pcode.request.processor.AbstractRequestProcessor#preProcess(
	 * java.lang.Object)
	 */
	@Override
	protected void preProcess(ClientRequest t) {
		super.preProcess(t);
		clientRequestRepository.save(t);		
		validateRequest(t);
	}

	/**
	 * @param t
	 */
	private void validateRequest(ClientRequest t) {
		for (Validator v : validators) {
			try {
				v.validate(t);
			} catch (InvalidRequestException e) {	
				throw e;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fexco.pcode.request.processor.AbstractRequestProcessor#postProcess(
	 * java.lang.Object, java.lang.Object)
	 */
	@Override
	protected List<Address> postProcess(ClientRequest t, List<Address> r) {
		List<Address> addresses = super.postProcess(t, r);
		addresses = AddressBuilder.forClientRequest(t).withAddresses(addresses).build();
		updateRequestStatus(t, null);
		return  addresses;
	}

	@Override
	protected void handleException(ClientRequest request, Exception e) {
		updateRequestStatus(request, e);
	} 
	private void updateRequestStatus(ClientRequest t, Exception e) {
		// TODO Auto-generated method stub
		ClientRequest clientRequest = clientRequestRepository.findClientRequestByRequestId(t.getRequestId());
		RequestStatus status  = null;
		String comment = null;
		if(Objects.nonNull(e)){
			status = RequestStatus.FAILED;
			comment= e.getMessage();
		}else{
			status = RequestStatus.COMPLETED;
			comment= "";
		}
		clientRequest.status(status);
		clientRequest.comment(comment);
		clientRequestRepository.save(clientRequest);
	}
	
	
}
