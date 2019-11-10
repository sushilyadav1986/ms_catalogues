package com.hcl.ms.cat.model;

/**Create Model class
 * Set details from API
 * Use in Controller to return response in API
 * Don't need to set error code 
 * Don't need to set data Obj
 * @author SushilY
 *
 */
public class NoObjRespnseModel {
	//Field Variable
	private Boolean status;
	//Field Variable
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
