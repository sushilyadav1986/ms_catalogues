package com.hcl.ms.cat.validatorImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.ms.cat.entity.Product;
import com.hcl.ms.cat.entity.User;
import com.hcl.ms.cat.model.PageModel;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.model.ResponseModel;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.utils.AppConstant;
import com.hcl.ms.cat.utils.StringUtils;
import com.hcl.ms.cat.validator.Validator;

/**
 * Create Class BusinessValidator
 * 
 * @author SushilY
 *
 */
public class BusinessValidator implements Validator {
	/**
	 * Validate in ProductModel details
	 * 
	 * @param productModel // Check Details of Product is null or not
	 * @return ResponseEntity<Object> Obj // Return null if Details are valid Using
	 *         Obj
	 */
	@Override
	public ResponseEntity<Object> validateProduct(ProductModel productModel) {
		if (!isIdValid(productModel.getCatalogueId())) {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.CATALOGUE_ID_EMPTY),
					HttpStatus.OK);
		} else if (StringUtils.isNullOrEmpty(productModel.getProductName())) {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.PROD_NAME_BLANK), HttpStatus.OK);
		} else {
			return null;
		}
	}

	/**
	 * Validate ProductModel 
	 * 
	 * @param productModel // Provide all required variable in this Obj
	 * @return ResponseEntity<Object> // Check Obj is null or and Id is greater that
	 *         0
	 * 
	 */
	@Override
	public ResponseEntity<Object> validateProductWithProdId(ProductModel productModel) {
		if (!isIdValid(productModel.getProductId())) {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.ENTER_ID_0), HttpStatus.OK);
		} else {
			return null;
		}
	}

	/**
	 * Validate id
	 * 
	 * @param id // Set long Argument in param
	 * @return // Return true if param is greater that 0
	 */
	private boolean isIdValid(long id) {
		if (id > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Validate Id 
	 * 
	 * @param proId // Check Id is Empty or less than 0
	 * @return ResponseEntity<Object> // Return null if Details are valid Using Obj
	 * 
	 */
	public ResponseEntity<Object> isIdEmpty(long proId) {
		if (isIdValid(proId)) {
			return null;
		} else {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.ENTER_ID_0), HttpStatus.OK);
		}
	}

	/**
	 * Validate PageModel Obj
	 * 
	 * @param pageModel // Provide all required variable in this Obj
	 * @return ResponseEntity<Object> // Return null If Obj is Valid
	 * 
	 */
	public ResponseEntity<Object> isValidPage(PageModel pageModel) {
		if (pageModel.getPageNumber() > 0 && pageModel.getNoOfProducts() > 0) {
			return null;
		} else {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.PAGE_AND_PROD_BLANK),
					HttpStatus.OK);
		}
	}

	/**
	 * Validate UserModel Obj
	 * 
	 * @param userModel // Provide all required variable in this Obj
	 * @return ResponseEntity<Object> // Return null if Obj is valid
	 * 
	 */
	public ResponseEntity<Object> validUserDetails(UserModel userModel) {
		if (!StringUtils.isEmailPattern(userModel.getEmail())) {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.ENTER_CORRECT_EMAIL),
					HttpStatus.OK);
		} else if (String.valueOf(userModel.getContactNumber()).length() != 10) {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.ENTER_10_DIGIT_CONTACT_NUMBER),
					HttpStatus.OK);
		} else if (StringUtils.isNullOrEmpty(userModel.getFirstName())) {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.FIRST_NAME_EMPTY), HttpStatus.OK);
		} else {
			return null;
		}
	}

	/**
	 * Validate Product Obj
	 * 
	 * @param product // Provide all required variable in this Obj
	 * @return ResponseEntity<Object> // Return null if Obj is null
	 * 
	 */
	public ResponseEntity<Object> isProductNull(Product product) {
		if (product != null) {
			return new ResponseEntity<Object>(
					new ResponseModel(true, AppConstant.PRODUCT_FIND_SUCCESSFULLY, new ProductModel(product)),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.PRODUCT_DOES_NOT_EXIST),
					HttpStatus.OK);
		}
	}

	/**
	 * Validate List<ProductModel> Obj
	 * 
	 * @param pModelList // Provide all required variable in this
	 *                                     Obj
	 * @return ResponseEntity<Object> // Check List is empty or not and return
	 *         values
	 * 
	 */
	public ResponseEntity<Object> isProdModelListEmpty(List<ProductModel> pModelList) {
		if (!pModelList.isEmpty() && pModelList.size() > 0) {
			return new ResponseEntity<Object>(
					new ResponseModel(true, AppConstant.PRODUCT_LIST_FIND_SUCCESSFULLY, pModelList), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.PRODUCT_DOES_NOT_EXIST),
					HttpStatus.OK);
		}
	}

	/**
	 * Change Product list into ProductModel list
	 * 
	 * @param productList // Set List of Product
	 * @return List // Return List of ProductModel
	 */
	@Override
	public ResponseEntity<Object> getAllProdModel(List<Product> productList) {
		if (productList != null && !productList.isEmpty()) {
			List<ProductModel> prodModelList = new ArrayList<>();
			for (Product product : productList) {
				prodModelList.add(new ProductModel(product));
			}
			return new ResponseEntity<Object>(
					new ResponseModel(true, AppConstant.PRODUCT_LIST_FIND_SUCCESSFULLY, prodModelList), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.PRODUCT_DOES_NOT_EXIST),
					HttpStatus.OK);
		}
	}

	/**
	 * Change Product list into ProductModel list
	 * 
	 * @param pageList
	 * @return List
	 */
	@Override
	public ResponseEntity<Object> getAllProductByPageNumber(Page<Product> pageList) {
		List<Product> noOfProdList = new ArrayList<Product>();
		if (noOfProdList != null && !noOfProdList.isEmpty()) {
			noOfProdList = pageList.toList();
		}
		return getAllProdModel(noOfProdList);
	}

	/**
	 * Check User obj is not null and has id
	 * 
	 * @param user   // Set Argument User Obj
	 * @return ResponseEntity<Object>  // Set string as per condition of Obj and return response
	 */
	@Override
	public ResponseEntity<Object> hasSavedUser(User user) {
		if (user != null && user.get_id() > 0) {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.USER_ADDED_SUCCESSFULLY,user),
					HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.USER_DOES_NOT_ADDED),
					HttpStatus.OK);

		}
	}

	/**
	 * Check Product is not null and has id
	 * 
	 * @param product   // Set Argument Product Obj
	 * @return ResponseEntity<Object>  // Set string as per condition of Obj and return response
	 */
	@Override
	public ResponseEntity<Object> hasSavedProduct(Product product) {
		if (product != null && product.getProdId() > 0) {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.PRODUCT_ADDED_SUCCESSFULLY,product),
					HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.PRODUCT_DOES_NOT_ADDED),
					HttpStatus.OK);
		}
	}
	/**
	 * Change ProductModel Model into Product Obj
	 * @param productModel
	 * @return Product Obj
	 */
	@Override
	public Product fromProductModel(ProductModel productModel) {
		return new Product(productModel);
	}
}
