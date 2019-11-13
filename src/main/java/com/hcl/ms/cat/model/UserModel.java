package com.hcl.ms.cat.model;

import com.hcl.ms.cat.entity.Catalogue;
import com.hcl.ms.cat.entity.User;

/**
 * Create Model class Set details from API
 * 
 * @author SushilY
 *
 */
public class UserModel {

	/**
	 * Default Constructor
	 */
	public UserModel() {}
	//Field Variable
	private long userId;
	//Field Variable
	private String firstName;
	//Field Variable
	private String lastName;
	//Field Variable
	private String gender;
	//Field Variable
	private String email;
	private long contactNumber;
	//Field Variable
	private Catalogue catalogue;

	
	/**
	 * return Catalog Obj
	 * @return 
	 */
	public Catalogue getCatalogue() {
		if (catalogue == null) {
			return new Catalogue();
		}
		return catalogue;
	}

	/**
	 * Copy catalog
	 */
	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

	/**
	 * Parameterized Constructor
	 * @param firstName 
	 * @param lastName 
	 * @param gender 
	 * @param email 
	 * @param contactNumber 
	 * @param catalogue 
	 */
	public UserModel(String firstName, 
			String lastName, String gender, String email, long contactNumber,Catalogue catalogue) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.contactNumber = contactNumber;
		this.catalogue=catalogue;
	}
	
	/**
	 * Copy Constructor
	 * @param user 
	 */
	public UserModel(User user) {
		this.userId=user.get_id();
		this.firstName=user.getFirstName();
		this.lastName=user.getLastName();
		this.gender=user.getGender();
		this.email=user.getEmail();
		this.contactNumber=user.getContactNumber();
		this.catalogue=user.getCatalogue();
		this.catalogue=user.getCatalogue();
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return
	 */
	public long getContactNumber() {
		return contactNumber;
	}

	/**
	 * @return
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param userId
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
}
