package com.fexco.pcode.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fexco.pcode.dto.ClientRequest;
import com.fexco.pcode.util.Constants.RequestStatus;

public interface ClientRequestRepository extends MongoRepository<ClientRequest, String> {
	
	public ClientRequest findClientRequestByRequestId(String requestId);

	public List<ClientRequest> findClientRequestByStatus(RequestStatus status);
	
}
