/**
 * 
 */
package com.fexco.pcode.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fexco.pcode.dto.Address;
import com.fexco.pcode.dto.ClientRequest;
import com.fexco.pcode.request.processor.RequestProcessorService;
import com.fexco.pcode.util.Constants.RequestStatus;
import static com.fexco.pcode.util.Constants.*;
import com.fexco.pcode.util.DtoBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
/**
 * @author Sachin
 *
 *         RestController for handling all the requests. Class serves as a
 *         wrapper api to
 *         {@https://developers.alliescomputing.com/postcoder-web-api/address-lookup/eircode} and
 *         {@https://developers.alliescomputing.com/postcoder-web-api/address-lookup/premise} with
 *         limited options. This controller will only serve request with
 *         POSTCODE and EIRCODE to above mentioned APIs.
 *
 */
@RestController
@Api("API for getting Address based on Eircode and Postcode. ")
@RequestMapping(name = "/address")
public class Controller {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Inject
	private RequestProcessorService requestProcessor;

	@GetMapping(value = "/ie/postcode/{postCode}", produces = "application/json")
	public ResponseEntity<List<Address>> getIEAddress(
			@ApiParam(required = false,
					value = "Call back url of client. If client sends request and due to some reason this service goes down, "
							+ "at service restart all the previous requests will be executed and response will be sent to failure-callback-url") @RequestHeader(
									value = "failure-callback-url") Optional<String> failureCallBackUri,
			@ApiParam(required = true, value = "Postcode or Eircode") @PathVariable String postCode,
			@ApiParam(required = false,
					value = "An integer value representing number of address lines. Max value =3") @RequestParam("lines") Optional<String> lines,
			@ApiParam(required = false,
					value = "Response format. Currently JSON format is supported. In case client requests with format=xml"
							+ ", Api will respond back saying 'XML format is not supported'") @RequestParam("format") Optional<String> format,
			@ApiParam(required = false,
					value = "Include extra address fields within the address lines returned") @RequestParam("include") Optional<String> include,
			@ApiParam(required = false,
					value = "Exclude address fields within the address lines returned") @RequestParam("exclude") Optional<String> exclude,
			@ApiParam(required = false,
					value = "Add extra address fields such as UDPRN to the return.") @RequestParam("addTags") Optional<String> addTags,
			@ApiParam(required = false,
					value = "	Identify your lookups to make debugging and reviewing stats easier") @RequestParam("identifier") Optional<String> identifier,
			@ApiParam(required = false,
					value = "For use with searches that return more than 100 results") @RequestParam("page") Optional<Integer> page,
			HttpServletRequest request, Pageable pageble) {

		LOGGER.info("Received request : /ie/postcode/{} :: Query Params::{} ", postCode, request.getParameterMap());
		Map<String, String[]> add = request.getParameterMap();

		StringBuilder sb = new StringBuilder();
		add.forEach((k, v) -> {
			sb.append(k).append("=").append(v[0]).append(",");
		});
		String queryParam = sb.toString().replaceAll(",$", "");
		LOGGER.debug("Creating ClientRequest based on query params...");
		String clientHost = request.getRemoteAddr();
		ClientRequest clientRequest = DtoBuilder.buildAndGetClientRequestDto(queryParam, RequestStatus.RECEIVED,
				"address", "ie", postCode,HOST,clientHost);
		LOGGER.info("ClientRequestId::{}, processing request.",clientRequest.getRequestId());
		return ResponseEntity.ok(requestProcessor.process(clientRequest, pageble).getContent());
	}

	@GetMapping(value = "/uk/postcode/{postCode}", produces = "application/json")
	public ResponseEntity<List<Address>> getUKAddress(
			@ApiParam(required = false,
					value = "Call back url of client. If client sends request and due to some reason this service goes down, "
							+ "at service restart all the previous requests will be executed and response will be sent to failure-callback-url") @RequestHeader(
									value = "failure-callback-url") Optional<String> failureCallBackUri,
			@ApiParam(required = true, value = "Postcode or Eircode") @PathVariable String postCode,
			@ApiParam(required = false,
					value = "An integer value representing number of address lines. Max value =3") @RequestParam("lines") Optional<String> lines,
			@ApiParam(required = false,
					value = "Response format. Currently JSON format is supported. In case client requests with format=xml"
							+ ", Api will respond back saying 'XML format is not supported'") @RequestParam("format") Optional<String> format,
			@ApiParam(required = false,
					value = "Include extra address fields within the address lines returned") @RequestParam("include") Optional<String> include,
			@ApiParam(required = false,
					value = "Exclude address fields within the address lines returned") @RequestParam("exclude") Optional<String> exclude,
			@ApiParam(required = false,
					value = "Add extra address fields such as UDPRN to the return.") @RequestParam("addtags") Optional<String> addTags,
			@ApiParam(required = false,
					value = "	Identify your lookups to make debugging and reviewing stats easier") @RequestParam("identifier") Optional<String> identifier,
			@ApiParam(required = false,
					value = "For use with searches that return more than 100 results") @RequestParam("page") Optional<Integer> page,
			HttpServletRequest request, Pageable pageble) {
		
		LOGGER.info("Received request : /ie/postcode/{} :: Query Params::{} ", postCode, request.getParameterMap());
		Map<String, String[]> add = request.getParameterMap();
		String clientHost = request.getRemoteAddr();

		StringBuilder sb = new StringBuilder();
		add.forEach((k, v) -> {
			sb.append(k).append("=").append(v[0]).append(",");
		});
		String queryParam = sb.toString().replaceAll(",$", "");
		LOGGER.debug("Creating ClientRequest based on query params...");
		ClientRequest clientRequest = DtoBuilder.buildAndGetClientRequestDto(queryParam, RequestStatus.RECEIVED,
				"address", "uk", postCode,HOST,clientHost);
		LOGGER.debug("ClientRequestId::{},  ClientRequest::{}",clientRequest.getRequestId(),clientRequest);
		LOGGER.info("ClientRequestId::{}, processing request.",clientRequest.getRequestId());
		return ResponseEntity.ok(requestProcessor.process(clientRequest, pageble).getContent());
	}

}
