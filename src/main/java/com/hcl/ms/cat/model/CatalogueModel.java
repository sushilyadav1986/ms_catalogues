package com.hcl.ms.cat.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Create Model class Set details from API
 * 
 * @author SushilY
 *
 */
public class CatalogueModel {

	// Field Variable
	private long catId;
	// Field Variable
	private String name;
	// List of Field Variable
	private List<ProductModel> pList;
	// UserModel Object
	private UserModel userModel;

	/**
	 * @return long
	 */
	public long getCatId() {
		return catId;
	}

	/**
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return List<ProductModel>
	 */
	public List<ProductModel> getpList() {
		return pList;
	}

	/**
	 * @return UserModel
	 */
	public UserModel getUserModel() {
		return userModel;
	}

	/**
	 * Create Constructor to set value in variables
	 * 
	 * @param catId
	 * @param name
	 * @param pList
	 * @param userModel
	 */
	public CatalogueModel(long catId, String name, List<ProductModel> pList, UserModel userModel) {
		super();
		this.catId = catId;
		this.name = name;
		if (pList == null) {
			pList = new ArrayList<ProductModel>();
		}
		if (!pList.isEmpty()) {
			pList.clear();
		}
		this.pList.addAll(pList);
		this.userModel = userModel;
	}
}
