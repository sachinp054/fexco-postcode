/**
 * 
 */
package com.fexco.pcode.request.processor;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fexco.pcode.dto.Address;
import com.fexco.pcode.dto.ClientRequest;
import com.fexco.pcode.response.builder.PageBuilder;


/**
 * Class responsible for processing the client request.
 * 
 * @author Sachin
 *
 */
@Service
public class RequestProcessorService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	private RequestProcessor<ClientRequest, List<Address>> processor;

	/**
	 * @param processor
	 */
	@Inject
	public RequestProcessorService(RequestProcessor<ClientRequest, List<Address>> processor) {
		super();
		this.processor = processor;
	}

	public Page<Address> process(ClientRequest clientRequest, Pageable pageble) {
		if(Objects.isNull(pageble)){
			return process(clientRequest);
		}else{
			Page<Address> addressPage = null;
			LOGGER.debug("ClientRequestId::{} Saving client request to db.", clientRequest.getRequestId());

			try {
				List<Address> addresses = processor.process(clientRequest);
				addressPage = PageBuilder.forAddresses(addresses).withPageableInfo(pageble).build();
			} catch (Exception e) {
				LOGGER.error("Exception occured while processing client request:: {}", clientRequest.getRequestId(), e);
			}
			return addressPage;
		}
				
	}
	
	private  Page<Address> process(ClientRequest clientRequest) {
		Page<Address> addressPage = null;
		try {
			 processor.process(clientRequest);
		} catch (Exception e) {
			LOGGER.info("Exception occured while processing client request:: {}", clientRequest.getRequestId(), e);
		}
		return addressPage;
	}

}
