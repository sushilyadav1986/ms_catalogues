package com.hcl.ms.cat.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.hcl.ms.cat.model.UserModel;

/**
 * Create User Table in DB 
 * Set One to One Relationship with Catalogue Table
 * Add Foreign Key cat_id in User Table
 * 
 * @author SushilY
 *
 */

@Entity
public class User {
	
	/**
	 * Default Constructor
	 */
	public User(){}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long _id;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private long contactNumber;
	@OneToOne
	@JoinColumn(name = "cat_id")
	private Catalogue catalogue;
	
	/** Create Constructor User
	 * @param UserModel  // Change UserModel object into User
	 * 
	 */
	public User (UserModel userModel) {	
		this._id=userModel.getUserId();
		this.firstName=userModel.getFirstName();
		this.lastName=userModel.getLastName();
		this.gender=userModel.getGender();
		this.email=userModel.getEmail();
		this.contactNumber=userModel.getContactNumber();
		this.catalogue=userModel.getCatalogue();
	}

	/**
	 * @param _id  // Set as Primary key in Table
	 */
	public void set_id(long _id) {
		this._id = _id;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param contactNumber
	 */
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return Catalogue
	 */
	public Catalogue getCatalogue() {
		if(catalogue==null) {
			catalogue=new Catalogue();
			catalogue.setName(getFirstName());
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
	 * @return long
	 */
	public long getId() {
		return _id;
	}

	/**
	 * @return long
	 */
	public long getContactNumber() {
		return contactNumber;
	}

	/**
	 * @return long
	 */
	public long get_id() {
		return _id;
	}

	/**
	 * @return String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return String
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	
}
