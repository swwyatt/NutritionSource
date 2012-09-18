package org.unutrition.util;

/**
 * A process interface
 * @author steve
 *
 * @param <T>
 */
public interface Processor<T> {

	public void process(T data) throws Exception;
}
