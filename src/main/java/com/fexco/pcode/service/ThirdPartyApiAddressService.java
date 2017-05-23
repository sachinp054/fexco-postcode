/**
 * 
 */
package com.fexco.pcode.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fexco.pcode.dto.Address;
import com.fexco.pcode.dto.ClientRequest;
import com.fexco.pcode.dto.ThirdPartyRequest;
import com.fexco.pcode.dto.ThirdPartyResponse;
import com.fexco.pcode.repository.ThirdPartyRequestRepository;
import com.fexco.pcode.repository.ThirdPartyResponseRepository;
import com.fexco.pcode.util.Constants.RequestStatus;
import com.fexco.pcode.util.ThirdPartyUriBuilder;

/**
 * Class responsible for hitting third party api listed in
 * {@link https://developers.alliescomputing.com/postcoder-web-api/address-lookup/premise}
 * and
 * {@link https://developers.alliescomputing.com/postcoder-web-api/address-lookup/eircode}
 * 
 * @author Sachin
 *
 */
@Service
@Order(value = Ordered.LOWEST_PRECEDENCE)
public class ThirdPartyApiAddressService implements AddressLookupService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Inject
	private RestTemplate restTemplate;
	@Inject
	private ThirdPartyUriBuilder thirdPartyUriBuilder;
	@Inject
	private ThirdPartyRequestRepository thirdPartyRequestRepository;
	@Inject
	private ThirdPartyResponseRepository thirdPartyResponseRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fexco.pcode.service.AddressLookupService#getAllAddresses(com.fexco.
	 * pcode.dto.ClientRequest)
	 */
	@Override
	public List<Address> getAllAddresses(ClientRequest request) {
		LOGGER.info("ClientRequestId::{} finding address using third party api .", request.getRequestId());
		int page = 0;
		String thirdpartyUri = thirdPartyUriBuilder.getThirPartyUri(request);
		LOGGER.info("ClientRequestId::{}. Persisting thirdparty request to db for request :: {}", request.getRequestId(),thirdpartyUri);
		persistThirdPartyRequest(request, thirdpartyUri);
		List<Address> addresses = new ArrayList<>();
		RequestStatus thirdPartyRequestStatus = null;
		String errMessage = null;

		try {
			ResponseEntity<List<Address>> addressResponseEntity = getResponseEntity(thirdpartyUri);
			if (Objects.nonNull(addressResponseEntity.getBody())) {
				LOGGER.info("ClientRequestId::{} found |{}| addresses with thirdparty api", request.getRequestId(),
						addressResponseEntity.getBody().size());
			}else{
				LOGGER.info("ClientRequestId::{} . Api call succeded. Could not find any address.", request.getRequestId());
			
			}
			
			addresses.addAll(addressResponseEntity.getBody());
			while (isNextPageAvailable(addressResponseEntity)) {
				page++;
				request.page(String.valueOf(page));
				thirdpartyUri = thirdPartyUriBuilder.getThirPartyUri(request);
				addressResponseEntity = getResponseEntity(thirdpartyUri);
				addresses.addAll(addressResponseEntity.getBody());
			}
			String key = request.getDerivedKey();
			LOGGER.info("ClientRequestId::{}. Persisting address to db and cache. Key{}",request.getRequestId(),key);
			persistThirdPartyResponse(request, addresses);
			thirdPartyRequestStatus = RequestStatus.COMPLETED;
		} catch (Exception e) {
			LOGGER.error("ClientRequestId::{}. Exception occured while getting address from thirdparty api.",request.getRequestId(),e);
			thirdPartyRequestStatus = RequestStatus.FAILED;
			errMessage = e.getLocalizedMessage();
		} finally {
			LOGGER.error("ClientRequestId::{}. Updating third party request status to::  {}.",request.getRequestId(),thirdPartyRequestStatus);
			ThirdPartyRequest thirdPartyrequest = thirdPartyRequestRepository
					.findRequestByRequestId(request.getRequestId());
			thirdPartyrequest.status(thirdPartyRequestStatus);
			thirdPartyrequest.errMessage(errMessage);
			thirdPartyRequestRepository.save(thirdPartyrequest);
		}
		return addresses;
	}

	/**
	 * @return
	 */
	private boolean isNextPageAvailable(ResponseEntity<List<Address>> addressResponseEntity) {
		return Objects.nonNull(addressResponseEntity) && addressResponseEntity.getBody().size() == 100
				&& Objects.nonNull(addressResponseEntity.getBody().get(99).getNextpage());
	}

	private ResponseEntity<List<Address>> getResponseEntity(String uri) {
		try {
			return restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Address>>() {
			});
		} catch (HttpClientErrorException e) {
			throw e;
		}
	}

	private void persistThirdPartyRequest(ClientRequest clientRequest, String thirdPartyUri) {
		ThirdPartyRequest thirdPartyRequest = new ThirdPartyRequest();
		thirdPartyRequest.requestId(clientRequest.getRequestId());
		thirdPartyRequest.thirdPartyUri(thirdPartyUri);
		thirdPartyRequest.status(RequestStatus.PROCESSING);
		thirdPartyRequestRepository.save(thirdPartyRequest);
	}

	private void persistThirdPartyResponse(ClientRequest clientRequest, List<Address> addresses) {
		ThirdPartyResponse thirdPartyResponse = new ThirdPartyResponse();
		thirdPartyResponse.key(clientRequest.getDerivedKey());
		thirdPartyResponse.requestId(clientRequest.getRequestId());
		thirdPartyResponse.address(addresses);
		thirdPartyResponseRepository.save(thirdPartyResponse);
	}
}
