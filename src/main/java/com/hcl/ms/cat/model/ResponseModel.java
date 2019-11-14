package com.hcl.ms.cat.model;

/**Create Model class
 * Set details from API
 * Use in Controller to return response in API
 * Need to set Data Obj
 * @author SushilY
 *
 */
public class ResponseModel {
	
	private Boolean status;
	private String message;
	private Object productDetails;

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
	 * @return
	 */
	public Object getData() {
		return productDetails;
	}

	/**
	 * @param productDetails
	 */
	public void setData(Object productDetails) {
		this.productDetails = productDetails;
	}
	
	/**
	 * @param status
	 * @param message
	 * @param productDetails
	 */
	public ResponseModel(Boolean status, String message, Object productDetails) {
		super();
		this.status = status;
		this.message = message;
		this.productDetails = productDetails;
	}
	/**
	 * @param status
	 * @param message
	 */
	public ResponseModel(Boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
}
