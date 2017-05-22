/**
 * 
 */
package com.fexco.pcode.request.processor;

/**
 * An interface defining contract for all the request processors.
 * 
 * @author Sachin
 *
 */
public interface RequestProcessor<T, R> {
	/**
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public R process (T t) throws Exception;
	
}
