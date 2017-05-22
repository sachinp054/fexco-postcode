/**
 * 
 */
package com.fexco.pcode.request.validator;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.fexco.pcode.dto.ClientRequest;
import com.fexco.pcode.exception.InvalidRequestException;

/**
 * Class to valid request parameters
 * 
 * @author Sachin
 *
 */
@Service
public class RequestParamValidator implements Validator{

	private final String validCountriesForLinesParam = "uk,ie";
	private final String validCountriesForIncludeParam = "uk,ie";
	private final String validCountriesForExcludeParam = "uk,ie";
	
	/* (non-Javadoc)
	 * @see com.fexco.pcode.request.validator.Validator#validate(com.fexco.pcode.dto.ClientRequest)
	 */
	@Override
	public void validate(ClientRequest clientRequest) throws InvalidRequestException {
		/*Check if lines or include or exclude parameters are present then country code is - "ie' or "uk"
		*Currently this implementation is specific to "ie' and "uk" but later on when it is extended this check will stand true
		*
		*/ 
		String exceptionMessage = null;
		if(Objects.nonNull(clientRequest.getLines()) && !validCountriesForLinesParam.contains(clientRequest.getCountry())){
			exceptionMessage = "Lines param is only valid for 'UK' and 'IE' addresses";
		}else if(Objects.nonNull(clientRequest.getInclude()) && !validCountriesForIncludeParam.contains(clientRequest.getCountry())){
			exceptionMessage = "Include param is only valid for 'UK' and 'IE' addresses";
		}else if(Objects.nonNull(clientRequest.getExclude()) && !validCountriesForExcludeParam.contains(clientRequest.getCountry())){
			exceptionMessage = "Exclude param is only valid for 'UK' and 'IE' addresses";
		}
		
		if(Objects.nonNull(exceptionMessage)){
			throw new InvalidRequestException(exceptionMessage);
		}
	}

}
