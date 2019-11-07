package com.hcl.ms.cat.model;

/**Create Model class
 * Set details from API
 * @author SushilY
 *
 */
public class NoObjRespnseModel {

	private Boolean status;
	private String message;

	/**
	 * @return
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @param status
	 * @param message
	 */
	public NoObjRespnseModel(Boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
}
