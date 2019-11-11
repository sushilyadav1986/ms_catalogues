package com.hcl.ms.cat.controller.validator;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.hcl.ms.cat.entity.Product;
import com.hcl.ms.cat.entity.User;
import com.hcl.ms.cat.model.PageModel;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.model.UserModel;

/**
 * Create interface Validator Implement on BusinessValidator class
 * 
 * Communicate between Controller and BusinessValidator Response as Utility for
 * Controller class
 * 
 * @author SushilY
 *
 */
public interface Validator {

	/**
	 * Validate in product details
	 * 
	 * @param productModel // Check Details of Product is null or not
	 * @return ResponseEntity<Object> Obj // Return null if Details are valid Using
	 *         Obj
	 */
	public ResponseEntity<Object> validateProduct(ProductModel productModel);

	/**
	 * Validate proId
	 * 
	 * @param proId // Check Id is Empty or less than 0
	 * @return ResponseEntity<Object> // Return null if Details are valid Using Obj
	 * 
	 */
	public ResponseEntity<Object> isIdEmpty(long proId);

	/**
	 * Validate PageModel Obj
	 * 
	 * @param PageModel // Provide all required variable in this Obj
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
	 * Validate ProductModel Obj And ProdId * Validate List Obj is null or Empty
	 * 
	 * @param List<ProductModel> // Provide all required variable in this Obj
	 * @return ResponseEntity<Object> // Check Obj is null or and Empty
	 * 
	 */
	ResponseEntity<Object> validateProductWithProdId(ProductModel productModel);

	/**
	 * Change ProductModel List into Response Entity
	 * 
	 * @param productList
	 * @return
	 */
	public ResponseEntity<Object> getAllProdModel(List<Product> productList);

	/**
	 * Change Page Product List into Response Entity using another function Validate
	 * List Obj is null or Empty
	 * 
	 * @param pageList
	 * @return Response Entity
	 */
	public ResponseEntity<Object> getAllProductByPageNumber(Page<Product> pageList);
	
	public ResponseEntity<Object> hasSavedUser(User user);
	
	public ResponseEntity<Object> hasSavedProduct(Product product);

}
