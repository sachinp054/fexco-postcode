/**
 * 
 */
package com.fexco.pcode.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fexco.pcode.dto.ClientRequest;
import com.fexco.pcode.util.Constants.RequestStatus;

/**
 * @author Sachin
 *
 */
public class DtoBuilderTest {

	private ClientRequest expectedClientRequest;

	private String identifier = "identifier_str";

	/**
	 * @throws java.lang.Exception
	 */

	@Before
	public void setUp() throws Exception {
		expectedClientRequest = new ClientRequest();
		expectedClientRequest.addtags("uddrn").country("ie").endPointName("address").exclude("street")
				.include("posttown").format("json").identifier(identifier).lines(3).page("1").postCode("DUMMY_PCODE")
				.status(RequestStatus.RECEIVED);
	}

	@Test
	public void testBuildAndGetClientRequestDto() {
		ClientRequest actualClientRequest = DtoBuilder.buildAndGetClientRequestDto(
				"format=json,addtags=uddrn,exclude=street,include=posttown,lines=3,page=1", RequestStatus.RECEIVED,
				"address", "ie", "DUMMY_PCODE","localhost","clientLocalHost");
		assertEquals(expectedClientRequest, actualClientRequest);
	}

}
