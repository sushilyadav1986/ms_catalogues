package com.hcl.ms.cat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ms.cat.entity.Product;
import com.hcl.ms.cat.model.PageModel;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.model.ResponseModel;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.service.ProductService;
import com.hcl.ms.cat.validator.Validator;

/**
 * Product controller class containing end-points for general product operations
 * like add, UPDATE, DELETE, FETCH
 * 
 * @author SushilY
 *
 */
@RestController
@RequestMapping(path = "/product")
public class ProductController {

	/**
	 * Initialize Obj to call service function to use data from DB
	 */
	@Autowired
	ProductService productService;
	
	/**
	 * Initialize Obj to validate data
	 */
	@Autowired(required = true)
	Validator businessValidator;

	/**
	 * This method is saving product in DB
	 * => validateProduct is return ResponseEntity<Object> Obj if any variable is missing in Obj
	 * =>
	 * 
	 * @param productModel sample product JSON
	 * @return ResponseEntity<Object> // Return 
 	 * Exception // Exception If JsonObject not proper
	 */
	
	@PostMapping("/addProduct")
	public ResponseEntity<Object> saveProduct(@RequestBody ProductModel productModel) {
		ResponseEntity<Object> responseEntity = businessValidator.validateProduct(productModel);
		if (responseEntity == null) {
			try {
				Product hasSaved = productService.saveProduct(businessValidator.fromProductModel(productModel));
				ResponseEntity<Object> savedEntity = businessValidator.hasSavedProduct(hasSaved);
				return savedEntity;
			} catch (Exception e) {
				return new ResponseEntity<Object>(new ResponseModel(false, e.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return responseEntity;
		}
	}

	/**
	 * Fetch Product Details in respect of Product Id
	 * 
	 * @param productModel // Find all details from product model
	 * @return ResponseEntity // Return Product details
	 * Exception // Exception If JsonObject not proper
	 */
	@PostMapping("/findProductDetails")
	public ResponseEntity<Object> findProductDetails(@RequestBody ProductModel productModel) {
		ResponseEntity<Object> responseEntity = businessValidator.isIdEmpty(productModel.getProductId());
		if (responseEntity == null) {
			try {
				Product model = productService.findProductDetails(productModel.getProductId());
				return businessValidator.isProductNull(model);
			} catch (Exception e) {
				return new ResponseEntity<Object>(new ResponseModel(false, e.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return responseEntity;
		}
	}

	/**
	 * Fetch All Products Details in respect of User Id
	 * 
	 * @param userModel // Find all details from product model
	 * @return ResponseEntity // Return List<Product> details
	 * Exception // Exception If JsonObject not proper
	 */
	@PostMapping("/findAllProductByUserId")
	public ResponseEntity<Object> findAllProductListByUserId(@RequestBody UserModel userModel) {
		ResponseEntity<Object> responseEntity = businessValidator.isIdEmpty(userModel.getUserId());
		if (responseEntity == null) {
			try {
				List<Product> productList = productService.findAllProductListByUserId(userModel.getUserId());
				ResponseEntity<Object> pModelListEntity = businessValidator.getAllProdModel(productList);
				return pModelListEntity;
			} catch (Exception e) {
				return new ResponseEntity<Object>(new ResponseModel(true, e.getMessage()),HttpStatus.BAD_REQUEST);
			}
		} else {
			return responseEntity;
		}
	}

	/**
	 * Update Product Details in respect of Product Id
	 * 
	 * @param productModel // Update details in product
	 * @return ResponseEntity // Return Product details
	 * Exception // Exception If JsonObject not proper
	 */
	@PostMapping("/updateProductDetails")
	public ResponseEntity<Object> updateProductDetail(@RequestBody ProductModel productModel) {
		ResponseEntity<Object> responseEntity = businessValidator.validateProductWithProdId(productModel);
		if (responseEntity == null) {
			try {
				String hasUpdated = productService.updateProductDetails(productModel);
				return new ResponseEntity<Object>(new ResponseModel(true, hasUpdated), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Object>(new ResponseModel(false, e.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return responseEntity;
		}
	}

	/**
	 * Delete Product Details in respect of Product Id
	 * 
	 * @param productModel // Delete Product
	 * @return ResponseEntity // Return String as Action
	 * Exception // Exception If JsonObject not proper
	 */
	@PostMapping("/deleteByProductId")
	public ResponseEntity<Object> deleteProductDetail(@RequestBody ProductModel productModel) {
		ResponseEntity<Object> responseEntity = businessValidator.isIdEmpty(productModel.getProductId());
		if (responseEntity == null) {
			try {
				String hasDeleted = productService.deleteByProductId(productModel.getProductId());
				return new ResponseEntity<Object>(new ResponseModel(true, hasDeleted), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Object>(new ResponseModel(false, e.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return responseEntity;
		}
	}

	/**
	 * Fetch All Product Details using sorting in respect of Product Id
	 * 
	 * @param pageModel // Set Details of Paging
	 * @return ResponseEntity // Return List<Product>
	 * Exception // Exception If JsonObject not proper
	 */
	@PostMapping("/getByPagination")
	public ResponseEntity<Object> findAllProductByPagination(@RequestBody PageModel pageModel) {
		ResponseEntity<Object> responseEntity = businessValidator.isValidPage(pageModel);
		if (responseEntity == null) {
			try {
				Page<Product> pageList = productService.findAllProduct(pageModel.getPageNumber(),
						pageModel.getNoOfProducts());
				ResponseEntity<Object> pModelListEntity = businessValidator.getAllProductByPageNumber(pageList);
				return pModelListEntity;
			} catch (Exception e) {
				return new ResponseEntity<Object>(new ResponseModel(false, e.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return responseEntity;
		}
	}
}
