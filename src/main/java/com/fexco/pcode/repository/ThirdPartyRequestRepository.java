package com.fexco.pcode.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fexco.pcode.dto.ThirdPartyRequest;

public interface ThirdPartyRequestRepository extends CrudRepository<ThirdPartyRequest, String> {
	public ThirdPartyRequest findRequestByRequestId(String requestId);
	public ThirdPartyRequest findRequestByKey(String key);
	public List<ThirdPartyRequest> findRequestByStatus(String status);		
}
