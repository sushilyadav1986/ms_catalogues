package com.hcl.ms.cat.exception;

/**CReate Exception Handler Class
 * @author SushilY
 *
 */
public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1454654L;

	/**
	 * Create default Constructor
	 * 
	 * @param message
	 */
	protected UserNotFoundException() {
		super();
	}
	/**
	 * Create parameterized Constructor Set argument if get Exception message in
	 * String and Throws exception obj
	 * 
	 * @param message
	 */
	protected UserNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	/**
	 * Create parameterized Constructor Set argument if get Exception message in
	 * String and Throws exception obj
	 * 
	 * @param message
	 */
	protected UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Create parameterized Constructor Set argument if get Exception message in
	 * String
	 * 
	 * @param message
	 */
	public UserNotFoundException(String message) {
		super(message);
	}

	protected UserNotFoundException(Throwable cause) {
		super(cause);
	}

}
