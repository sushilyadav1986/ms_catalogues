package com.hcl.ms.cat.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Entity for Table Catalogue in DB
 * Set One to One Relationship with User Table
 * Set One to Many Relationship with Product Table
 * @author SushilY
 *
 */
@Entity
public class Catalogue {

	/**
	 * Create Primary Key in Table
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long catId;
	/**
	 * Create Field in Table
	 */
	private String name;
	
	/**
	 * Set Mapping OneToOne Relationship With User Table
	 * Provide Responsibility to User Table
	 */
	@OneToOne(mappedBy = "catalogue", cascade = CascadeType.ALL)
	private User user;
	
	/**
	 * Set Mapping OnTOMany Relationship With Product Table
	 */
	@OneToMany(mappedBy = "catalogue", cascade = CascadeType.ALL)
	private List<Product> productList;
	
	public long getCatId() {
		return catId;
	}

	public void setCatId(long catId) {
		this.catId = catId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return
	 */
	public List<Product> getProductList() {
		return productList;
	}

	/**
	 * @param productList
	 */
	public void setProductList(List<Product> productList) {
		this.productList.addAll(productList);
	}

}
