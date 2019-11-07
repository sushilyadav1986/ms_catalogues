package com.hcl.ms.cat.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ms.cat.controller.validator.IValidator;
import com.hcl.ms.cat.model.NoObjRespnseModel;
import com.hcl.ms.cat.model.PageModel;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.model.ResponseModel;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.service.IProductService;
import com.hcl.ms.cat.utils.AppConstant;

/**
 * Create Product class Single point of content for All product related
 * operations
 * 
 * @author SushilY
 *
 */
@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
	IProductService iProductService;
	@Autowired(required = true)
	IValidator businessValidator;

	/**
	 * @param productModel
	 * @return
	 */
	@PostMapping("/add_product")
	public ResponseEntity<Object> saveProduct(@Valid @RequestBody ProductModel productModel) {
		if (productModel != null) {
			String validateObj = businessValidator.validateProduct(productModel);
			if (validateObj != null) {
				try {
					ProductModel model = iProductService.saveProduct(productModel);
					if (model != null) {
						return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.SUCCESS, model),
								HttpStatus.CREATED);
					} else {
						return new ResponseEntity<Object>(
								new NoObjRespnseModel(true, AppConstant.PRODUCT_DOES_NOT_EXIST), HttpStatus.OK);
					}
				} catch (Exception e) {
					return new ResponseEntity<Object>(new NoObjRespnseModel(false, e.getMessage()),
							HttpStatus.INTERNAL_SERVER_ERROR);
				}
			} else {
				return new ResponseEntity<Object>(new ResponseModel(true, validateObj, null), HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.OBJ_CAN_NOT_NULL, null),
					HttpStatus.OK);
		}
	}

	/**
	 * @param productModel
	 * @return Object
	 */
	@PostMapping("/find_product_details")
	public ResponseEntity<Object> findProductDetails(@Valid @RequestBody ProductModel productModel) {
		if (productModel != null) {
			if (businessValidator.isValidId(productModel.getProductId())) {
				try {
					ProductModel model = iProductService.findProductDetails(productModel.getProductId());
					if (model != null) {
						return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.SUCCESS, model),
								HttpStatus.OK);
					} else {
						return new ResponseEntity<Object>(
								new NoObjRespnseModel(true, AppConstant.PRODUCT_DOES_NOT_EXIST), HttpStatus.OK);
					}
				} catch (Exception e) {
					return new ResponseEntity<Object>(new NoObjRespnseModel(false, e.getMessage()),
							HttpStatus.INTERNAL_SERVER_ERROR);
				}
			} else {
				return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.PROD_ID_NOT_EXIST),
						HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.OBJ_CAN_NOT_NULL), HttpStatus.OK);
		}

	}

	/**
	 * @param userModel
	 * @return List<ProductModel>
	 */
	@PostMapping("/find_all_product_by_user_id")
	public ResponseEntity<Object> findAllProductListByUserId(@Valid @RequestBody UserModel userModel) {
		if (userModel != null) {
			if (businessValidator.isValidId(userModel.getUserId())) {
				try {
					List<ProductModel> pModelList = iProductService.findAllProductListByUserId(userModel.getUserId());
					if (pModelList != null && !pModelList.isEmpty()) {
						if (!pModelList.isEmpty() && pModelList.size() > 0) {
							return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.SUCCESS, pModelList),
									HttpStatus.OK);
						} else {
							return new ResponseEntity<Object>(
									new NoObjRespnseModel(true, AppConstant.CATALOGUE_HAS_NO_PRODUCT), HttpStatus.OK);
						}
					} else {
						return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.USER_DOES_NOT_EXIST),
								HttpStatus.OK);
					}
				} catch (Exception e) {
					// TODO: handle exception
					return new ResponseEntity<Object>(new NoObjRespnseModel(false, e.getMessage()),
							HttpStatus.INTERNAL_SERVER_ERROR);
				}

			} else {
				return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.USER_NOT_EXIST),
						HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.OBJ_CAN_NOT_NULL), HttpStatus.OK);
		}

	}

	/**
	 * @param productModel
	 * @return boolean
	 */
	@PostMapping("/update_product_details")
	public ResponseEntity<Object> updateProductDetail(@Valid @RequestBody ProductModel productModel) {
		if (productModel != null) {
			String validateObj = businessValidator.validateProduct(productModel);
			if (validateObj != null) {
				try {
					boolean hasUpdated = iProductService.updateProductDetails(productModel);
					if (hasUpdated) {
						return new ResponseEntity<Object>(
								new NoObjRespnseModel(true, AppConstant.PRODUCT_UPDATED_SUCCESSFULLY), HttpStatus.OK);
					} else {
						return new ResponseEntity<Object>(
								new NoObjRespnseModel(true, AppConstant.PRODUCT_UPDATED_FAILED), HttpStatus.OK);
					}
				} catch (Exception e) {
					// TODO: handle exception
					return new ResponseEntity<Object>(new NoObjRespnseModel(false, e.getMessage()),
							HttpStatus.INTERNAL_SERVER_ERROR);
				}
			} else {
				return new ResponseEntity<Object>(new ResponseModel(true, validateObj, null), HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.OBJ_CAN_NOT_NULL), HttpStatus.OK);
		}

	}

	/**
	 * @param productModel
	 * @return boolean
	 */
	@PostMapping("/delete_by_product_id")
	public ResponseEntity<Object> deleteProductDetail(@Valid @RequestBody ProductModel productModel) {
		if (productModel != null) {
			if (businessValidator.isValidId(productModel.getProductId())) {
				try {
					boolean hasDeleted = iProductService.deleteByProductId(productModel.getProductId());
					if (hasDeleted) {
						return new ResponseEntity<Object>(
								new NoObjRespnseModel(true, AppConstant.PRODUCT_DELETED_SUCCESSFULLY), HttpStatus.OK);
					} else {
						return new ResponseEntity<Object>(
								new NoObjRespnseModel(true, AppConstant.PRODUCT_DELETED_FAILED), HttpStatus.OK);
					}
				} catch (Exception e) {
					// TODO: handle exception
					return new ResponseEntity<Object>(new NoObjRespnseModel(false, e.getMessage()), HttpStatus.OK);
				}
			} else {
				return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.PROD_ID_NOT_EXIST),
						HttpStatus.OK);
			}

		} else {
			return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.OBJ_CAN_NOT_NULL), HttpStatus.OK);
		}
	}

	/**
	 * @param pageModel
	 * @return
	 */
	@PostMapping("/get_by_pagination")
	public ResponseEntity<Object> getPagination(@Valid @RequestBody PageModel pageModel) {
		if (pageModel != null) {
			if (businessValidator.isValidPage(pageModel)) {

				try {
					List<ProductModel> pList = iProductService.findAllProduct(pageModel.getPageNumber(),
							pageModel.getNoOfProducts());
					if (pList != null && !pList.isEmpty()) {
						if (!pList.isEmpty() && pList.size() > 0) {
							return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.SUCCESS, pList),
									HttpStatus.OK);
						} else {
							return new ResponseEntity<Object>(
									new NoObjRespnseModel(true, AppConstant.PRODUCT_NOT_AVAILABLE), HttpStatus.OK);
						}
					} else {
						return new ResponseEntity<Object>(
								new NoObjRespnseModel(true, AppConstant.PRODUCT_NOT_AVAILABLE), HttpStatus.OK);
					}
				} catch (Exception e) {
					// TODO: handle exception
					return new ResponseEntity<Object>(new NoObjRespnseModel(false, e.getMessage()),
							HttpStatus.INTERNAL_SERVER_ERROR);
				}
			} else {
				return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.OBJ_CAN_NOT_NULL),
						HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.OBJ_CAN_NOT_NULL), HttpStatus.OK);
		}
	}

}
