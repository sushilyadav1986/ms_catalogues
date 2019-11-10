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

	public UserModel() {}
	private long userId;

	private String firstName;

	private String lastName;

	private String gender;

	private String email;
	private long contactNumber;

	private Catalogue catalogue;

	public Catalogue getCatalogue() {
		if (catalogue == null) {
			return new Catalogue();
		}
		return catalogue;
	}

	/**
	 * @param catalogue
	 */
	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param email
	 * @param contactNumber
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
