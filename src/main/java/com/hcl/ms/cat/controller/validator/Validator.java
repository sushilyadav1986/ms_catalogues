package com.hcl.ms.cat.controller.validator;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hcl.ms.cat.model.PageModel;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.model.UserModel;

/**Create interface Validator
 * Implement on BusinessValidator class
 * 
 * Communicate between Controller and BusinessValidator
 * Response as Utility for Controller class
 * @author SushilY
 *
 */
public interface Validator {
	
	/**
	 * Validate in product details
	 * 
	 * @param productModel // Check Details of Product is null or not
	 * @return ResponseEntity<Object> Obj // Return null if Details are valid Using Obj
	 */
	public ResponseEntity<Object> validateProduct(ProductModel productModel);

	/**Validate proId  
	 * @param proId   // Check Id is Empty or less than 0
	 * @return ResponseEntity<Object>  // Return null if Details are valid Using Obj
	 * 
	 */
	public ResponseEntity<Object> isIdEmpty(long proId);
	
	/**Validate PageModel Obj  
	 * @param PageModel   // Provide all required variable in this Obj  
	 * @return ResponseEntity<Object> // Return null If Obj is Valid
	 * 
	 */
	public ResponseEntity<Object> isValidPage(PageModel pageModel);
	
	/**
	 * Validate UserModel Obj
	 * 
	 * @param UserModel // Provide all required variable in this Obj
	 * @return ResponseEntity<Object> // Return null if Obj is valid
	 * 
	 */
	public ResponseEntity<Object> validUserDetails(UserModel userModel);
	
	/**
	 * Validate ProductModel Obj
	 * 
	 * @param Product // Provide all required variable in this Obj
	 * @return ResponseEntity<Object> // Return null if Obj is null
	 * 
	 */
	public ResponseEntity<Object> isProdModelNull(ProductModel productModel);
	
	/**
	 * Validate List<ProductModel> Obj
	 * 
	 * @param List<ProductModel> // Provide all required variable in this Obj
	 * @return ResponseEntity<Object> // Check List is empty or not and return
	 *         values
	 * 
	 */
	public ResponseEntity<Object> isProdModelListEmpty(List<ProductModel> pModelList);

	/**
	 * Validate ProductModel Obj And ProdId
	 * 
	 * @param List<ProductModel> // Provide all required variable in this Obj
	 * @return ResponseEntity<Object> // Check Obj is null or and Id is greater that
	 *         0
	 * 
	 */
	ResponseEntity<Object> validateProductWithProdId(ProductModel productModel);
	

}
