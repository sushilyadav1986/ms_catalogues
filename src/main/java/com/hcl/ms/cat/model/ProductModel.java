package com.hcl.ms.cat.model;

/**Create Model class for Product
 * Set details from API
 * @author SushilY
 *
 */
public class ProductModel {
	
	private long productId;	
	private String productName;
	
	
	private double productPrice;
	
	private String productDescription;
	
	private String productAvailability;
	
	
	private long catalogueId;
	
	/**
	 * @return
	 */
	public long getCatalogueId() {
		return catalogueId;
	}
	/**
	 * @return
	 */
	public long getProductId() {
		return productId;
	}
	/**
	 * @return
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @return
	 */
	public double getProductPrice() {
		return productPrice;
	}
	/**
	 * @return
	 */
	public String getProductDescription() {
		return productDescription;
	}
	/**
	 * @return
	 */
	public String getProductAvailability() {
		return productAvailability;
	}
	
	/**
	 * @param productId
	 * @param productName
	 * @param productPrice
	 * @param productDescription
	 * @param productAvailability
	 * @param catalogueId
	 */
	public ProductModel(long productId, String productName, double productPrice, 
			String productDescription,
			String productAvailability,long catalogueId) {
		super();		
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productAvailability = productAvailability;
		this.catalogueId=catalogueId;
	}
}
