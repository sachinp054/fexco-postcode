/**
 * 
 */
package com.fexco.pcode.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fexco.pcode.dto.ClientRequest;
import com.fexco.pcode.properties.ThirdPartyApiProperties;
import com.fexco.pcode.util.Constants.RequestStatus;

/**
 * @author Sachin
 *
 */
public class ThirdPartyUriBuilderTest {

	private ThirdPartyUriBuilder uriBuilder;
	private ClientRequest clientRequest;
	private String expectedUri = "http://ws.postcoder.com/pcw/PCW45-12345-12345-1234X/address/ie/DUMMY_PCODE?"
			+ "&exclude=street&format=json&identifier=identifier&include=posttown&lines=3&page=1&addtags=uddrn";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ThirdPartyApiProperties properties = new ThirdPartyApiProperties();
		properties.setBaseurl("http://ws.postcoder.com/pcw");
		properties.setPageSize(100);
		properties.setToken("PCW45-12345-12345-1234X");

		uriBuilder = new ThirdPartyUriBuilder(properties);

		clientRequest = new ClientRequest().addtags("uddrn").country("ie").endPointName("address").exclude("street")
				.include("posttown").format("json").identifier("identifier").lines(3).page("1").postCode("DUMMY_PCODE")
				.status(RequestStatus.RECEIVED);
	}

	@Test
	public void test() {
		String actualUri = uriBuilder.getThirPartyUri(clientRequest);
		assertEquals(expectedUri, actualUri);
	}

}
