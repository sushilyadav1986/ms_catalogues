
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

	public static final Contact DEFAULT_CONTACT = new Contact("Sushil Yadav", "http://www.hcl.com", "sushily@hcl.com");

	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Catalogue MS API",
			"Catalogue MS API for cleint implementation.", "1.0", "urn:tos", DEFAULT_CONTACT, "CatalogueV1.0",
			"http://www.hcl.com");

	public static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
			Arrays.asList("application/json"));

	public static final String USER_ADDED_SUCCESSFULLY = "User added successfully.";
	public static final String USER_DOES_NOT_ADDED = "User couldn't add. Please try again.";
	
	//public static final String SUCCESS = "Success";
	//public static final String FAILED = "Failed";
	public static final String CATALOGUE_HAS_NO_PRODUCT = "Catalogue has no product.";
	public static final String USER_DOES_NOT_EXIST = "User does not exist.";
	public static final String PRODUCT_UPDATED_SUCCESSFULLY = "Product details updated successfully.";
	public static final String PRODUCT_UPDATED_FAILED = "Please try again.";
	public static final String PRODUCT_DELETED_SUCCESSFULLY = "Product has deleted successfully.";
	public static final String PRODUCT_DELETED_FAILED = "Please try again.";
	public static final String PRODUCT_NOT_AVAILABLE = "Product not available";
	public static final String OBJ_CAN_NOT_NULL="Please fill details";

	
	public static final String PRODUCT_DOES_NOT_EXIST = "Product does not exist.";
	public static final String PROD_ID_NOT_EXIST="Product is not exist";
	public static final String USER_NOT_EXIST="User not exist";
	public static final String ENTER_CORRECT_EMAIL="Please enter correct email";
	public static final String ENTER_10_DIGIT_CONTACT_NUMBER="Please enter 10 digit contact number";
	public static final String FIRST_NAME_EMPTY="First name can not empty";
	public static final String ENTER_ID_0="Please enter id";
	public static final String ENTER_PROD_ID="Please enter product id";
	public static final String PAGE_AND_PROD_BLANK="Page number and number of product should be more than 0";
	public static final String CATALOGUE_ID_EMPTY="catlogue id can not empty";
	public static final String	CATALOGUE_ID_0="catlogue id can not 0";
	public static final String PROD_NAME_BLANK="Product name can not blank";
	public static final String PRODUCT_DELETED="Product successfully deleted";
	public static final String PRODUCT_NOT_DELETED=	"Product can not delete. Please try again.";
	public static final String PRODUCT_ADDED_SUCCESSFULLY = "Product added successfully.";
	public static final String PRODUCT_DOES_NOT_ADDED = "Product couldn't add. Please try again.";
	public static final String PRODUCT_FIND_SUCCESSFULLY = "Product find successfully.";
	public static final String PRODUCT_LIST_FIND_SUCCESSFULLY = "Product list find successfully.";
}
