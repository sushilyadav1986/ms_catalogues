package com.hcl.ms.cat.controller.validatorImpl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.ms.cat.controller.validator.Validator;
import com.hcl.ms.cat.model.NoObjRespnseModel;
import com.hcl.ms.cat.model.PageModel;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.model.ResponseModel;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.utils.AppConstant;
import com.hcl.ms.cat.utils.StringUtils;

/**
 * @author SushilY
 *
 */
public class BusinessValidator implements Validator {
	@Override
	public ResponseEntity<Object> validateProduct(ProductModel productModel) {
		if (String.valueOf(productModel.getCatalogueId()) == null
				&& String.valueOf(productModel.getCatalogueId()).length() <1) {
			return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.CATALOGUE_ID_EMPTY), HttpStatus.OK);
		} else if (productModel.getCatalogueId() == 0) {
			return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.CATALOGUE_ID_0), HttpStatus.OK);
		} else if (StringUtils.isNullOrEmpty(productModel.getProductName())) {
			return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.PROD_NAME_BLANK), HttpStatus.OK);
		} else {
			return null;
		}
	}
	
	@Override
	public ResponseEntity<Object> validateProductWithProdId(ProductModel productModel) {
		if(!isIdValid(productModel.getProductId())) {
			return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.PROD_ID_0), HttpStatus.OK);
		}else if (String.valueOf(productModel.getCatalogueId()) == null
				&& String.valueOf(productModel.getCatalogueId()).length() <1) {
			return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.CATALOGUE_ID_EMPTY), HttpStatus.OK);
		} else if (!isIdValid(productModel.getCatalogueId())) {
			return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.CATALOGUE_ID_0), HttpStatus.OK);
		} else if (StringUtils.isNullOrEmpty(productModel.getProductName())) {
			return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.PROD_NAME_BLANK), HttpStatus.OK);
		} else {
			return null;
		}
		
	}

	private boolean isIdValid(long id) {
		if (id > 0) {
			return true;
		} else {
			return false;
		}
	}

	public ResponseEntity<Object> isIdEmpty(long proId) {
		if (!StringUtils.isNullOrEmpty(String.valueOf(proId))) {
			if (isIdValid(proId)) {
				return null;
			} else {
				return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.PROD_ID_0), HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.ENTER_PROD_ID), HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> isValidPage(PageModel pageModel) {
		if (pageModel.getPageNumber() > 0 && pageModel.getNoOfProducts() > 0) {
			return null;
		} else {
			return new ResponseEntity<Object>(
					new NoObjRespnseModel(true, AppConstant.PAGE_AND_PROD_BLANK),
					HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> validUserDetails(UserModel userModel) {
		if (!StringUtils.isEmailPattern(userModel.getEmail())) {
			return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.ENTER_CORRECT_EMAIL),
					HttpStatus.OK);
		} else if (String.valueOf(userModel.getContactNumber()).length() != 10) {
			return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.ENTER_10_DIGIT_CONTACT_NUMBER),
					HttpStatus.OK);
		} else if (StringUtils.isNullOrEmpty(userModel.getFirstName())) {
			return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.FIRST_NAME_EMPTY), HttpStatus.OK);
		} else {
			return null;
		}
	}

	public ResponseEntity<Object> isProdModelNull(ProductModel productModel) {
		if (productModel != null) {
			return new ResponseEntity<Object>(new ResponseModel(true, 
					AppConstant.PRODUCT_FIND_SUCCESSFULLY, productModel),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(new NoObjRespnseModel(true,
					AppConstant.PRODUCT_DOES_NOT_EXIST),
					HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> isProdModelListEmpty(List<ProductModel> pModelList) {
		if (!pModelList.isEmpty() && pModelList.size() > 0) {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.PRODUCT_LIST_FIND_SUCCESSFULLY, pModelList), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.PRODUCT_DOES_NOT_EXIST),
					HttpStatus.OK);
		}
	}

}
