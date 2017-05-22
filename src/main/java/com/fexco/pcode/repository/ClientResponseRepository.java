package com.fexco.pcode.repository;

import org.springframework.data.repository.CrudRepository;

import com.fexco.pcode.dto.ClientResponse;

public interface ClientResponseRepository extends CrudRepository<ClientResponse, String>{
	
	public ClientResponse findClientResponsetByRequestId(String requestId);

}
