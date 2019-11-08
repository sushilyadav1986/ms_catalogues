package com.hcl.ms.cat.controller.validator;

import com.hcl.ms.cat.model.PageModel;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.model.UserModel;

/**
 * @author SushilY
 *
 */
public interface IValidator {
	
	/**
	 * Validate in product details
	 * 
	 * @param productModel
	 * @return
	 */
	public String validateProduct(ProductModel productModel);

	/**Validate Id from Obj 
	 * @param proId
	 * @return boolean true If id is greater than 0
	 * else false 
	 */
	public boolean isValidId(long proId);
	
	public boolean isValidPage(PageModel pageModel);
	
	
	public String validUserDetails(UserModel userModel);

}
