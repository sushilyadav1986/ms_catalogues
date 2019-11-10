package com.hcl.ms.cat.model;

import com.hcl.ms.cat.entity.Product;

/**
 * Create Model class for Product Set details from API
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
	 * 
	 * Parameterized Constructor
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
	 * 
	 * Copy Constructor
	 * Change Product Obj into ProductModel Obj
	 */
	public ProductModel(Product product) {
		this.productId = product.getProdId();
		this.productName = product.getName();
		this.productPrice = product.getPrice();
		this.productDescription = product.getDescription();
		this.productAvailability = product.getAvailability();
		this.catalogueId=product.getCatalogue().getCatId();
	}
}
