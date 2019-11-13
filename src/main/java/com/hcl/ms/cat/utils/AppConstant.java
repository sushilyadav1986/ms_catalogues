
package com.hcl.ms.cat.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;


/**Added Constant Variables
 * @author SushilY
 *
 */
public class AppConstant {

	/**
	 * Use in Swagger API
	 * Set Contacted Email and Official Email
	 */
	public static final Contact DEFAULT_CONTACT = new Contact("Sushil Yadav", "http://www.hcl.com", "sushily@hcl.com");

	/**
	 * Use in Swagger API
	 * Set App Version And Subject And Header
	 */
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Catalogue MS API",
			"Catalogue MS API for cleint implementation.", "1.0", "urn:tos", DEFAULT_CONTACT, "CatalogueV1.0",
			"http://www.hcl.com");

	/**
	 * Use in Swagger API
	 * Set Content type of APIs
	 */
	public static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
			Arrays.asList("application/json"));

	/**
	 * Return When User saved successfully in DB 
	 */
	public static final String USER_ADDED_SUCCESSFULLY = "User added successfully.";
	
	/**
	 *  Return When User does not saved in DB
	 */
	public static final String USER_DOES_NOT_ADDED = "User couldn't add. Please try again.";
	
	/**
	 * Return When Catalogue does not have Product
	 */
	public static final String CATALOGUE_HAS_NO_PRODUCT = "Catalogue has no product.";
	
	/**
	 * Return When User does not exist in DB
	 */
	public static final String USER_DOES_NOT_EXIST = "User does not exist.";
	
	/**
	 * Return When Product details updated successfully in DB
	 */
	public static final String PRODUCT_UPDATED_SUCCESSFULLY = "Product details updated successfully.";
	/**
	 * Return When Product details does not update in DB
	 */
	public static final String PRODUCT_UPDATED_FAILED = "Please try again.";
	
	/**
	 * Return When Product delete successfully in DB
	 */
	public static final String PRODUCT_DELETED_SUCCESSFULLY = "Product has deleted successfully.";
	
	/**
	 * Return When Product does not delete from DB
	 */
	public static final String PRODUCT_DELETED_FAILED = "Please try again.";
	/**
	 * Return When Product does not add from DB
	 */
	public static final String PRODUCT_ADDED_FAILED = "Please try again.";
	
	/**
	 * Return When PRoduct does not available in DB
	 */
	public static final String PRODUCT_NOT_AVAILABLE = "Product not available";
	
	/**
	 * Return When Object has null values
	 */
	public static final String OBJ_CAN_NOT_NULL="Please fill details";

	
	/**
	 * * Return When Product does not exist in DB
	 */
	public static final String PRODUCT_DOES_NOT_EXIST = "Product does not exist";
	
	/**
	 * Return When Product Id does not exist in DB
	 */
	public static final String PROD_ID_NOT_EXIST="Product is not exist";
	
	/**
	 * * Return When User does not exist in DB
	 */
	public static final String USER_NOT_EXIST="User not exist";
	
	/**
	 * Return When Email format not proper
	 */
	public static final String ENTER_CORRECT_EMAIL="Please enter correct email";
	
	/**
	 * Return When Contact Number not have 10 digits
	 */
	public static final String ENTER_10_DIGIT_CONTACT_NUMBER="Please enter 10 digit contact number";
	/**
	 * Return When First Name is Empty
	 */
	public static final String FIRST_NAME_EMPTY="First name can not empty";
	
	/**
	 * Return When Id is null or 0
	 */
	public static final String ENTER_ID_0="Please enter id";
	
	/**
	 * Return When Id is null
	 */
	public static final String ENTER_PROD_ID="Please enter product id";
	
	/**
	 * Return When Page Number or Number of Product is 0 or null
	 */
	public static final String PAGE_AND_PROD_BLANK="Page number and number of product should be more than 0";
	
	/**
	 * Return When Catalogue Id is null
	 */
	public static final String CATALOGUE_ID_EMPTY="catlogue id can not empty";
	
	/**
	 * Return When Catalogue Id is 0
	 */
	public static final String	CATALOGUE_ID_0="catlogue id can not 0";
	
	/**
	 * Return When Product name is null
	 */
	public static final String PROD_NAME_BLANK="Product name can not blank";
	
	/**
	 * Return When Product has deleted successfully in DB
	 */
	public static final String PRODUCT_DELETED="Product successfully deleted";
	
	/**
	 * Return When Product not have deleted in DB
	 */
	public static final String PRODUCT_NOT_DELETED=	"Product can not delete. Please try again.";
	
	/**
	 * Return When Product has saved successfully in DB
	 */
	public static final String PRODUCT_ADDED_SUCCESSFULLY = "Product added successfully";
	/**
	 * Return When Product does not add in DB
	 */
	public static final String PRODUCT_DOES_NOT_ADDED = "Product couldn't add. Please try again";
	/**
	 * Return When Product find successfully from DB
	 */
	public static final String PRODUCT_FIND_SUCCESSFULLY = "Product find successfully";
	/**
	 * Return When Product list find successfully from DB
	 */
	public static final String PRODUCT_LIST_FIND_SUCCESSFULLY = "Product list find successfully";
}
