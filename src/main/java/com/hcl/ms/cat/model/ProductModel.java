package com.hcl.ms.cat.model;

import com.hcl.ms.cat.entity.Product;

/**
 * Create Model class for Product 
 * Set details from API
 * 
 * @author SushilY
 *
 */
public class ProductModel {

	/**
	 * Default Constructor
	 */
	public ProductModel() {
	}
	//Field Variable
	private long productId;
	//Field Variable
	private String productName;
	//Field Variable
	private double productPrice;
	//Field Variable
	private String productDescription;
	//Field Variable
	private String productAvailability;
	//Field Variable
	private long catalogueId;

	/**
	 * @return catalogueId
	 */
	public long getCatalogueId() {
		return catalogueId;
	}

	/**
	 * @return productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * @return productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @return productPrice
	 */
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * @return productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * @return productAvailability
	 */
	public String getProductAvailability() {
		return productAvailability;
	}

	/**Parameterized Constructor
	 * 
	 * @param productId 
	 * @param productName 
	 * @param productPrice 
	 * @param productDescription 
	 * @param productAvailability 
	 * @param catalogueId 
	 */
	public ProductModel(long productId, String productName, double productPrice, String productDescription,
			String productAvailability, long catalogueId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productAvailability = productAvailability;
		this.catalogueId = catalogueId;
	}

	/**
	 * Copy Constructor
	 * 
	 * Change Product Obj into ProductModel Obj
	 * 
	 * @param product
	 */
	public ProductModel(Product product) {
		this.productId = product.getProdId();
		this.productName = product.getName();
		this.productPrice = product.getPrice();
		this.productDescription = product.getDescription();
		this.productAvailability = product.getAvailability();
		this.catalogueId = product.getCatalogue().getCatId();
	}
}
