package com.hcl.ms.cat.controller.validatorImpl;

import com.hcl.ms.cat.controller.validator.IValidator;
import com.hcl.ms.cat.model.PageModel;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.utils.StringUtils;

/**
 * @author SushilY
 *
 */
public class BusinessValidator implements IValidator {

	@Override
	public String validateProduct(ProductModel productModel) {
		// TODO Auto-generated method stub
		if (StringUtils.isNullOrEmpty(String.valueOf(productModel.getProductName()))) {
			return "catlog id can not empty";
		} else if (productModel.getCatalogueId() == 0) {
			return "catlog id can not 0";
		} else if (StringUtils.isNullOrEmpty(productModel.getProductName())) {
			return "Product name can not blank";
		} else {
			return null;
		}
	}

	public boolean isValidId(long proId) {
		if (proId > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isValidPage(PageModel pageModel) {
		if (pageModel.getPageNumber() > 0 && pageModel.getNoOfProducts() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public String validUserDetails(UserModel userModel) {
		if (!StringUtils.isEmailPattern(userModel.getEmail())) {
			return "pleane enter correct email";
		} else if (String.valueOf(userModel.getContactNumber()).length() == 10) {
			return "Please enter 10 digit contact number";
		} else if (StringUtils.isNullOrEmpty(userModel.getFirstName())) {
			return "First name can not empty";
		} else {
			return null;
		}

	}

}
