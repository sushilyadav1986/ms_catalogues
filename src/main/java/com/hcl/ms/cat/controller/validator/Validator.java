package com.hcl.ms.cat.controller.validator;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hcl.ms.cat.model.PageModel;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.model.UserModel;

/**
 * @author SushilY
 *
 */
public interface Validator {
	
	/**
	 * Validate in product details
	 * 
	 * @param productModel
	 * @return
	 */
	public ResponseEntity<Object> validateProduct(ProductModel productModel);

	/**Validate Id from Obj 
	 * @param proId
	 * @return boolean true If id is greater than 0
	 * else false 
	 */
	public ResponseEntity<Object> isIdEmpty(long proId);
	
	public ResponseEntity<Object> isValidPage(PageModel pageModel);
	
	public ResponseEntity<Object> validUserDetails(UserModel userModel);
	
	public ResponseEntity<Object> isProdModelNull(ProductModel productModel);
	
	public ResponseEntity<Object> isProdModelListEmpty(List<ProductModel> pModelList);

	ResponseEntity<Object> validateProductWithProdId(ProductModel productModel);
	

}
