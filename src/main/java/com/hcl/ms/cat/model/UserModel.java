package com.hcl.ms.cat.model;

/**Create Model class
 * Set details from API
 * @author SushilY
 *
 */
public class UserModel {

	private long userId;
	
	private String firstName;
	
	private String lastName;
	
	private String gender;
	
	private String email;
	private long contactNumber;
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param email
	 * @param contactNumber
	 */
	public UserModel(String firstName, String lastName, String gender, 
			String email, long contactNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.contactNumber = contactNumber;
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
