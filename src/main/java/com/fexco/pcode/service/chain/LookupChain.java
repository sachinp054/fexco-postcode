/**
 * 
 */
package com.fexco.pcode.service.chain;

/**
 * @author Sachin
 * @param <T>
 *
 */
public interface LookupChain<T,R> {
	public R chain(T t );
}
