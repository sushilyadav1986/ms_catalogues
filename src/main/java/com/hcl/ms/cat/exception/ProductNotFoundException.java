package com.hcl.ms.cat.exception;

/**
 * Create Custom Exception type class
 * 
 * @author SushilY
 *
 */
public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1454654L;

	/**
	 * Create default Constructor
	 * 
	 * @param message
	 */
	protected ProductNotFoundException() {
		super();
	}
	/**
	 * Create parameterized Constructor Set argument if get Exception message in
	 * String and Throws exception obj
	 * 
	 * @param message
	 */
	protected ProductNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	/**
	 * Create parameterized Constructor Set argument if get Exception message in
	 * String and Throws exception obj
	 * 
	 * @param message
	 */
	protected ProductNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Create parameterized Constructor Set argument if get Exception message in
	 * String
	 * 
	 * @param message
	 */
	public ProductNotFoundException(String message) {
		super(message);
	}

	protected ProductNotFoundException(Throwable cause) {
		super(cause);
	}

}
