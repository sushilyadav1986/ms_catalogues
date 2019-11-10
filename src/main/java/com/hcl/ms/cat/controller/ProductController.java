package com.hcl.ms.cat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ms.cat.controller.validator.Validator;
import com.hcl.ms.cat.model.NoObjRespnseModel;
import com.hcl.ms.cat.model.PageModel;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.service.ProductService;

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
	ProductService productService;
	@Autowired(required = true)
	Validator businessValidator;

	/**
	 * Save Product Details
	 * 
	 * @param productModel       // Find all details from product model
	 * @return List<Product>     // Return Product List details
	 * @exception  Exception     // Exception If JsonObject not proper
	 */
	@PostMapping("/addProduct")
	public ResponseEntity<Object> saveProduct(@RequestBody ProductModel productModel) {
		ResponseEntity<Object> responseEntity = businessValidator.validateProduct(productModel);
		if (responseEntity == null) {
			try {
				String hasSaved = productService.saveProduct(productModel);
				return new ResponseEntity<Object>(new NoObjRespnseModel(true, hasSaved), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<Object>(new NoObjRespnseModel(false, e.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return responseEntity;
		}
	}

	/**
	 * Fetch Product Details in respect of Product Id
	 * 
	 * @param productModel       	// Find all details from product model
	 * @return ResponseEntity     			// Return Product details
	 * @exception  Exception     	// Exception If JsonObject not proper
	 */
	@PostMapping("/findProductDetails")
	public ResponseEntity<Object> findProductDetails(@RequestBody ProductModel productModel) {
		ResponseEntity<Object> responseEntity = businessValidator.isIdEmpty(productModel.getProductId());
		if (responseEntity == null) {
			try {
				ProductModel model = productService.findProductDetails(productModel.getProductId());
				return businessValidator.isProdModelNull(model);
			} catch (Exception e) {
				return new ResponseEntity<Object>(new NoObjRespnseModel(false, e.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return responseEntity;
		}
	}

	/**
	 * Fetch All Products Details in respect of User Id
	 * 
	 * @param UserModel         	// Find all details from product model
	 * @return ResponseEntity     	// Return List<Product> details
	 * @exception  Exception     	// Exception If JsonObject not proper
	 */
	@PostMapping("/findAllProductByUserId")
	public ResponseEntity<Object> findAllProductListByUserId(@RequestBody UserModel userModel) {
		ResponseEntity<Object> responseEntity = businessValidator.isIdEmpty(userModel.getUserId());
		if (responseEntity == null) {
			try {
				List<ProductModel> pModelList = productService.findAllProductListByUserId(userModel.getUserId());
				ResponseEntity<Object> pModelListEntity = businessValidator.isProdModelListEmpty(pModelList);
				return pModelListEntity;
			} catch (Exception e) {
				return new ResponseEntity<Object>(new NoObjRespnseModel(false, e.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return responseEntity;
		}
	}

	/**
	 * Update Product Details in respect of Product Id
	 * 
	 * @param productModel       	// Update details in product
	 * @return ResponseEntity     	// Return Product details
	 * @exception  Exception     	// Exception If JsonObject not proper
	 */
	@PostMapping("/updateProductDetails")
	public ResponseEntity<Object> updateProductDetail(@RequestBody ProductModel productModel) {
		ResponseEntity<Object> responseEntity = businessValidator.validateProductWithProdId(productModel);
		if (responseEntity == null) {
			try {
				String hasUpdated = productService.updateProductDetails(productModel);
				return new ResponseEntity<Object>(new NoObjRespnseModel(true, hasUpdated), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Object>(new NoObjRespnseModel(false, e.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return responseEntity;
		}
	}

	/**
	 * Update Product Details in respect of Product Id
	 * 
	 * @param productModel       	// Delete Product
	 * @return ResponseEntity     	// Return String as Action
	 * @exception  Exception     	// Exception If JsonObject not proper
	 */
	@PostMapping("/deleteByProductId")
	public ResponseEntity<Object> deleteProductDetail(@RequestBody ProductModel productModel) {
		ResponseEntity<Object> responseEntity = businessValidator.isIdEmpty(productModel.getProductId());
		if (responseEntity == null) {
			try {
				String hasDeleted = productService.deleteByProductId(productModel.getProductId());
				return new ResponseEntity<Object>(new NoObjRespnseModel(true, hasDeleted), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Object>(new NoObjRespnseModel(false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return responseEntity;
		}
	}

	/**
	 * Fetch All  Product Details using sorting in respect of Product Id
	 * 
	 * @param PageModel       		// Set Details of Paging
	 * @return ResponseEntity     	// Return List<Product> 
	 * @exception  Exception     	// Exception If JsonObject not proper
	 */
	@PostMapping("/getByPagination")
	public ResponseEntity<Object> findAllProductByPagination(@RequestBody PageModel pageModel) {
		ResponseEntity<Object> responseEntity = businessValidator.isValidPage(pageModel);
		if (responseEntity == null) {
			try {
				List<ProductModel> pModelList = productService.findAllProduct(pageModel.getPageNumber(),
						pageModel.getNoOfProducts());
				ResponseEntity<Object> pModelListEntity = businessValidator.isProdModelListEmpty(pModelList);
				return pModelListEntity;
			} catch (Exception e) {
				return new ResponseEntity<Object>(new NoObjRespnseModel(false, e.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return responseEntity;
		}
	}
}
