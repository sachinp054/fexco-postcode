/**
 * 
 */
package com.fexco.pcode.bootstrap;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import com.fexco.pcode.dto.ClientRequest;
import com.fexco.pcode.dto.ThirdPartyResponse;
import com.fexco.pcode.repository.ClientRequestRepository;
import com.fexco.pcode.repository.ThirdPartyResponseRepository;
import com.fexco.pcode.request.processor.RequestProcessorService;
import com.fexco.pcode.util.Constants.RequestStatus;
import com.google.common.collect.Iterables;

/**
 * Class responsible for 1- Loading data into cache 2- Processing pending
 * requests 3- Sending response back to client if failure-callback-url is
 * provided
 * 
 * @author Sachin
 *
 */
@Component
public class ApplicationStateStablizer implements ApplicationRunner {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private CacheManager cacheManager;
	@Inject
	private ThirdPartyResponseRepository thirdPartyResponseRepository;
	@Inject
	private ClientRequestRepository clientRequestRepository;
	@Inject
	private RequestProcessorService requestProcessor;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.boot.ApplicationRunner#run(org.springframework.boot.
	 * ApplicationArguments)
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// populate cache
		populateCahe();
		//process pending client requests
		processFailedClientRequests();
	}

	/*
	 *Method does processing for all failed client requests 
	 */
	private void processFailedClientRequests() {
		List<ClientRequest> clientRequests = clientRequestRepository.findClientRequestByStatus(RequestStatus.FAILED);
		clientRequests.forEach(r->{
			requestProcessor.process(r,null);
		});
		LOGGER.info("Processed |{}| failed client requests",clientRequests.size());
	}

	/*
	 * private method populates the cache. Application is using redis cache
	 * which by default loads all the data at boot start up so there is no need.
	 * 
	 * If cache implementation is this extra step will hold true 
	 * 
	 */
	private void populateCahe() {
		Iterable<ThirdPartyResponse> persistedAddresses = thirdPartyResponseRepository.findAll();
		persistedAddresses.forEach(a->{
			cacheManager.getCache("addressCache").put(a.getKey(), a.getAddress());
		});
		LOGGER.info("Populated |{}| key<=>address to cache",Iterables.size(persistedAddresses));
	}

}
