package com.fexco.pcode.repository;

import org.springframework.data.repository.CrudRepository;

import com.fexco.pcode.dto.ThirdPartyResponse;

public interface ThirdPartyResponseRepository extends CrudRepository<ThirdPartyResponse, String>{
	
	public ThirdPartyResponse findThirdPartyResponseByRequestId(String requestId);
	public ThirdPartyResponse findThirdPartyResponseByKey(String key);
	
}
