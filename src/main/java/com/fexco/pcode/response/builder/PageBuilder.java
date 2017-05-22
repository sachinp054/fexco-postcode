/**
 * 
 */
package com.fexco.pcode.response.builder;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.fexco.pcode.dto.Address;

/**
 * @author Sachin
 *
 */
public class PageBuilder {

	private Pageable pageable;
	private List<Address> addresses;
	
	private PageBuilder(List<Address> addresses){
		this.addresses = addresses;
	}
	
	public static PageBuilder forAddresses(List<Address> addresses){
		return new PageBuilder(addresses);
	}
	
	public PageBuilder withPageableInfo(Pageable pageable){
		this.pageable =pageable;
		return this;
	}
	
	public Page<Address> build(){
		return new PageImpl<>(this.addresses,this.pageable,0);
	}
}
