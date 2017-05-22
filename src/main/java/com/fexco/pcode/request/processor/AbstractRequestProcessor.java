/**
 * 
 */
package com.fexco.pcode.request.processor;

import com.fexco.pcode.service.chain.LookupChain;

/**
 * Abstract class to support multiple request processors. 
 * Currently it has only on e implementation ie. {@AddressRequestProcessor}. Same class can be extended for supporting other endpoints 
 * provided by third party API like addressgeo .
 * 
 * @author Sachin
 *
 */
public abstract class AbstractRequestProcessor<T, R> implements RequestProcessor<T, R> {

	@Override
	public final R process(T t) throws Exception{
			try{
				preProcess(t);
				R r = processInternal(t);
				r=  postProcess(t, r);
				return r;
			}catch(Exception e){
				handleException(t, e);
				throw e;
			}
	}

	/**
	 * @param t
	 * @return
	 */
	private  R processInternal(T t) {
		return getAddressLookupChain().chain(t);
	}
	
	protected  abstract LookupChain<T,R> getAddressLookupChain();
	/**
	 * protected method to handle exceptions
	 * Default implementation does nothing, if child class wants to handle exceptions in any specific way
	 * it can override this method
	 * 
	 * @param t
	 * @param e
	 */
	protected  void handleException(T t, Exception e){}

	/**
	 * Protected method to perform pre processing.
	 * Default implementation does nothing, if child class wants to perform some
	 * action it can do by overriding this method.
	 * 
	 * @param t
	 */
	protected void preProcess(T t) {
	}

	/**
	 * Protected method to perform post processing.
	 * Default implementation does nothing, if child class wants to perform some
	 * action it can do by overriding this method.
	 * 
	 * @param p
	 * @param t
	 * @param r
	 * @return
	 */
	protected R postProcess(T t, R r) {
		return r;
	}

}
