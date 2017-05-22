/**
 * 
 */
package com.fexco.pcode.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fexco.pcode.dto.ClientRequest;
import com.fexco.pcode.util.Constants.RequestStatus;

/**
 * @author Sachin
 *
 */
public class KeyGeneratorTest {

	private ClientRequest clientRequest;
	String expectedKey ="address#ie#DUMMY_PCODE#uddrn";
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		clientRequest = new ClientRequest().addtags("uddrn").country("ie").endPointName("address").exclude("street")
				.include("posttown").format("json").identifier("identifier").lines(3).page("1").postCode("DUMMY_PCODE")
				.status(RequestStatus.RECEIVED);
	}

	@Test
	public void test() {
		String actualKey = AddressKeyGenerator.generateKey(clientRequest);
		assertEquals(expectedKey, actualKey);
	}

}
