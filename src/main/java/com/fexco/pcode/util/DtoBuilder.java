/**
 * 
 */
package com.fexco.pcode.util;

import static com.fexco.pcode.util.Constants.QueryParam.ADDTAGS;
import static com.fexco.pcode.util.Constants.QueryParam.EXCLUDE;
import static com.fexco.pcode.util.Constants.QueryParam.FORMAT;
import static com.fexco.pcode.util.Constants.QueryParam.IDENTIFIER;
import static com.fexco.pcode.util.Constants.QueryParam.INCLUDE;
import static com.fexco.pcode.util.Constants.QueryParam.KEY_VALUE_SEPRATOR;
import static com.fexco.pcode.util.Constants.QueryParam.LINES;
import static com.fexco.pcode.util.Constants.QueryParam.PAGE;
import static com.fexco.pcode.util.Constants.QueryParam.PARAM_SEPRATOR;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import com.fexco.pcode.dto.ClientRequest;
import com.fexco.pcode.dto.ThirdPartyRequest;
import com.fexco.pcode.util.Constants.RequestStatus;
import com.google.common.base.Splitter;

/**
 * @author Sachin
 *
 */
public class DtoBuilder {

	/**
	 * @param queryParam
	 * @return ClientRequest
	 */
	public static ClientRequest buildAndGetClientRequestDto(String queryParam, RequestStatus status,
			String endPointName, String country, String postCode,String host,String clientHost) {

		Map<String, String> queryMap = getQueryParamMap(queryParam);

		ClientRequest clientRequest = new ClientRequest().addtags(queryMap.get(ADDTAGS)).country(country)
				.endPointName(endPointName).requestId(UUID.randomUUID().toString()).exclude(queryMap.get(EXCLUDE))
				.include(queryMap.get(INCLUDE)).format(queryMap.get(FORMAT)).identifier(queryMap.get(IDENTIFIER))
				.lines(Objects.nonNull(queryMap.get(LINES))?Integer.parseInt(queryMap.get(LINES)):0).page(queryMap.get(PAGE)).postCode(postCode).status(status)
				.clientHost(clientHost).host(host);
		String derivedKey = AddressKeyGenerator.generateKey(clientRequest);
		clientRequest.derivedKey(derivedKey);
		return clientRequest;
	}

	/**
	 * @param queryParam
	 * @return Map<String, String> queryParamMap
	 */
	private static Map<String, String> getQueryParamMap(String queryParam) {
		return Splitter.on(PARAM_SEPRATOR).withKeyValueSeparator(KEY_VALUE_SEPRATOR).split(queryParam);
	}

	/**
	 * 
	 * @return ThirdPartyRequest
	 */
	public static ThirdPartyRequest buildAndGetThirdPartyRequestDto() {
		return new ThirdPartyRequest();
	}
}
