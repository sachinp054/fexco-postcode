/**
 * 
 */
package com.fexco.pcode.util;

import static com.fexco.pcode.util.Constants.QueryParam.ADDTAGS;
import static com.fexco.pcode.util.Constants.QueryParam.EXCLUDE;
import static com.fexco.pcode.util.Constants.QueryParam.FORMAT;
import static com.fexco.pcode.util.Constants.QueryParam.IDENTIFIER;
import static com.fexco.pcode.util.Constants.QueryParam.INCLUDE;
import static com.fexco.pcode.util.Constants.QueryParam.LINES;
import static com.fexco.pcode.util.Constants.QueryParam.PAGE;

import java.util.Objects;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fexco.pcode.dto.ClientRequest;
import com.fexco.pcode.properties.ThirdPartyApiProperties;

/**
 * @author Sachin
 *
 */
@Service
public class ThirdPartyUriBuilder {

	private ThirdPartyApiProperties properties;

	@Inject
	ThirdPartyUriBuilder(ThirdPartyApiProperties properties) {
		this.properties = properties;
	}

	/**
	 * 
	 * @param clientRequest
	 * @return thirdparty url
	 */

	public String getThirPartyUri(ClientRequest clientRequest) {
		StringBuilder url = new StringBuilder().append(properties.getBaseurl()).append("/")
				.append(properties.getToken()).append("/").append(clientRequest.getEndPointName()).append("/")
				.append(clientRequest.getCountry()).append("/").append(clientRequest.getPostCode()).append("?");
		// .append("postcodeonly=true");
		if (clientRequest.hasQueryParams()) {
			if (Objects.nonNull(clientRequest.getExclude())) {
				url.append("&" + EXCLUDE + "=" + clientRequest.getExclude());
			}
			if (Objects.nonNull(clientRequest.getFormat())) {
				url.append("&" + FORMAT + "=" + clientRequest.getFormat());
			}
			if (Objects.nonNull(clientRequest.getIdentifier())) {
				url.append("&" + IDENTIFIER + "=" + clientRequest.getIdentifier());
			}
			if (Objects.nonNull(clientRequest.getInclude())) {
				url.append("&" + INCLUDE + "=" + clientRequest.getInclude());
			}
			if (Objects.nonNull(clientRequest.getLines())) {
				url.append("&" + LINES + "=" + clientRequest.getLines());
			}
			if (Objects.nonNull(clientRequest.getPage())) {
				url.append("&" + PAGE + "=" + clientRequest.getPage());
			}
			if (Objects.nonNull(clientRequest.getAddtags())) {
				url.append("&" + ADDTAGS + "=" + clientRequest.getAddtags());
			}
		}
		return url.toString();
	}
}
