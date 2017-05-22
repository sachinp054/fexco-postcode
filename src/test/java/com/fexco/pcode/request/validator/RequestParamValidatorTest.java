/**
 * 
 */
package com.fexco.pcode.request.validator;

import org.junit.Before;
import org.junit.Test;

import com.fexco.pcode.dto.ClientRequest;
import com.fexco.pcode.exception.InvalidRequestException;
import com.fexco.pcode.util.Constants.RequestStatus;

/**
 * @author Sachin
 *
 */
public class RequestParamValidatorTest {

	ClientRequest  clientRequest1;
	ClientRequest  clientRequest2;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		 clientRequest1 = new ClientRequest().addtags("uddrn").country("ie").endPointName("address").exclude("street")
		.include("posttown").format("json").identifier("identifier").lines(3).page("1").postCode("DUMMY_PCODE")
		.status(RequestStatus.RECEIVED);
		 
		 clientRequest2 = new ClientRequest().addtags("uddrn").country("us").endPointName("address").exclude("street")
		.include("posttown").format("json").identifier("identifier").lines(3).page("1").postCode("DUMMY_PCODE")
		.status(RequestStatus.RECEIVED);
	}

	
	@Test
	public void testValidate() {
		RequestParamValidator paramValidator = new RequestParamValidator();
		paramValidator.validate(clientRequest1);
	}

	
	@Test(expected=InvalidRequestException.class)
	public void testValidateThrowsInvalidRequest() {
		RequestParamValidator paramValidator = new RequestParamValidator();
		paramValidator.validate(clientRequest2);
	}
}
