package com.hcl.ms.cat.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.hcl.ms.cat.model.ProductModel;

/**
 * Create Product Table in DB Set Many to One Relationship with Catalogue Table
 * Add Foreign Key catId in Product Table
 * 
 * @author SushilY
 *
 */
@Entity
public class Product {

	/**
	 * Default Constructor
	 */
	public Product() {
	}
	
	
	/**
	 * Create Primary Key in Table
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long prodId;
	/**
	 * Create Field in Table
	 */
	private String name;
	/**
	 * Create Field in Table
	 */
	private double price;
	/**
	 * Create Field in Table
	 */
	private String description;
	/**
	 * Create Field in Table
	 */
	private String availability;
	/**
	 * Set Mapping OneToOne Relationship With Catalogue Table
	 * Create As Foreign Key Id in User Table 
	 */
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Catalogue catalogue;

	

	protected Product(long prodId, String name, double price, String description, String availability,
			Catalogue catalogue) {
		this.prodId = prodId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.availability = availability;
		this.catalogue = catalogue;
	}

	/** Create Constructor Product
	 * @param productModel  // Pass productModel values into Product Obj
	 * 
	 */
	public Product(ProductModel productModel) {
		this.prodId = productModel.getProductId();
		this.name = productModel.getProductName();
		this.price = productModel.getProductPrice();
		this.description = productModel.getProductDescription();
		this.availability = productModel.getProductAvailability();
		if(catalogue==null) {
			catalogue=new Catalogue();
		}
		this.catalogue.setCatId(productModel.getCatalogueId());
	}

	/**
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return Catalogue
	 */
	public Catalogue getCatalogue() {
		return catalogue;
	}

	/**
	 * @param catalogue
	 */
	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

	/**
	 * @return long
	 */
	public long getProdId() {
		return prodId;
	}

	/**
	 * @param prodId
	 */
	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	/**
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return double
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return String
	 */
	public String getAvailability() {
		return availability;
	}

	/**
	 * @param availability
	 */
	public void setAvailability(String availability) {
		this.availability = availability;
	}
}
