package com.hcl.ms.cat.model;

/**Create Model class
 * Set details from API
 * @author SushilY
 *
 */
public class PageModel {
	
	private int pageNumber;
	private int noOfProducts;
	
	/**
	 * @return
	 */
	public int getPageNumber() {
		return pageNumber;
	}
	/**
	 * @param pageNumber
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	/**
	 * @return
	 */
	public int getNoOfProducts() {
		return noOfProducts;
	}
	/**
	 * @param noOfProducts
	 */
	public void setNoOfProducts(int noOfProducts) {
		this.noOfProducts = noOfProducts;
	}
	

}
