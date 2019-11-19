package com.hcl.ms.cat.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.hcl.ms.cat.CatalogueMsApplication;
import com.hcl.ms.cat.entity.Product;
import com.hcl.ms.cat.model.PageModel;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.service.ProductService;
import com.hcl.ms.cat.service.UserService;
import com.hcl.ms.cat.utils.AppConstant;
import com.hcl.ms.cat.utils.test.JUnitUtlils;
import com.hcl.ms.cat.validator.Validator;

/**
 * Create ProductControllerTest.class Test here ProductController's function
 * 
 * @author SushilY
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = CatalogueMsApplication.class)
class ProductControllerTest extends JUnitUtlils {

	@Mock
	ProductService productService;

	@Mock
	UserService userService;

	@InjectMocks
	ProductController productController;

	@Mock
	Validator businessValidator;

	/**
	 * Test SaveProduct() function on success On save function will return 201
	 * status
	 * 
	 */
	@Test
	void testSaveProductWhenSuccess() {
		ProductModel productModel = findProdModelWithId();
		Product product = findProduct();
		ResponseEntity<Object> responseEntity = findResponseOnSaveProduct();
		Mockito.when(businessValidator.hasSavedProduct(product)).thenReturn(responseEntity);
		Mockito.when(businessValidator.fromProductModel(productModel)).thenReturn(product);
		Mockito.when(businessValidator.validateProduct(productModel)).thenReturn(null);
		Mockito.when(productService.saveProduct(product)).thenReturn(product);
		ResponseEntity<Object> entity = productController.saveProduct(productModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(201);
	}

	/**
	 * Test SaveProduct() function on failure If details not fill complete. status
	 * will 200 *
	 * 
	 */
	@Test
	void testSaveProductWhenFailure() {
		ProductModel productModel = findProdModelWithoutCatId();
		ResponseEntity<Object> responseEntity = findResponseOnCatalogueIdBlank();
		Mockito.when(businessValidator.validateProduct(productModel)).thenReturn(responseEntity);
		ResponseEntity<Object> entity = productController.saveProduct(productModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}

	/**
	 * Test SaveProduct() function on Exception If details not fill complete. status
	 * will 500 
	 * 
	 */
	@Test
	void testSaveProductWhenException() {
		ProductModel productModel = findProdModelWithId();
		Throwable exception = findException();
		Product product = findProduct();
		Mockito.when(businessValidator.validateProduct(productModel)).thenReturn(null);
		Mockito.when(businessValidator.fromProductModel(productModel)).thenReturn(product);
		Mockito.when(productService.saveProduct(new Product(productModel))).thenThrow(exception);
		ResponseEntity<Object> responseEntity = productController.saveProduct(productModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
	}
	/**
	 * Test findProductDetails() function on success status will 200 
	 * 
	 */
	@Test
	void testFindProductDetailsWhenSuccess() {
		ProductModel productModel = findProdModelWithId();
		Product product=new Product(productModel);
		ResponseEntity<Object> responseEntity = findProductResponse();
		Mockito.when(businessValidator.isIdEmpty(productModel.getProductId())).thenReturn(null);
		Mockito.when(businessValidator.isProductNull(product)).thenReturn(responseEntity);
		Mockito.when(productService.findProductDetails(productModel.getProductId())).thenReturn(product);
		ResponseEntity<Object> entity = productController.findProductDetails(productModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}
	/**
	 * Test findProductDetails() function on Failure If product id not provided. status
	 * will 200 
	 * 
	 */
	@Test
	void testFindProductDetailsWhenFailure() {
		ProductModel productModel = findProdModelWithId();
		ResponseEntity<Object> responseEntity = findResponseOnCatalogueIdBlank();
		Mockito.when(businessValidator.isIdEmpty(productModel.getProductId())).thenReturn(responseEntity);
		ResponseEntity<Object> entity = productController.findProductDetails(productModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}
	/**
	 * Test findProductDetails() function on Exception If get any Exception. status
	 * will 500 
	 * 
	 */
	@Test
	void testFindProductDetailsWhenException() {
		ProductModel productModel = findProdModelWithId();
		Throwable exception = findException();
		Mockito.when(businessValidator.isIdEmpty(productModel.getProductId())).thenReturn(null);
		Mockito.when(productService.findProductDetails(productModel.getProductId())).thenThrow(exception);
		ResponseEntity<Object> responseEntity = productController.findProductDetails(productModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
	}
	/**
	 * Test findAllProductListByUserId() function on Success If user id provided. status
	 * will 200 
	 * 
	 */
	@Test
	void testFindAllProductListByUserIdWhenSuccess() {
		UserModel userModel = findUserModelWithUserId();
		List<Product> pList = findAllProducts();
		ResponseEntity<Object> responseEntity = findProductResponse();
		Mockito.when(businessValidator.isIdEmpty(userModel.getUserId())).thenReturn(null);
		Mockito.when(businessValidator.findAllProdModel(pList)).thenReturn(responseEntity);
		Mockito.when(productService.findAllProductListByUserId(userModel.getUserId())).thenReturn(pList);
		ResponseEntity<Object> entity = productController.findAllProductListByUserId(userModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}
	/**
	 * Test findAllProductListByUserId() function on Failure If user id not provided. status
	 * will 200 
	 * 
	 */
	@Test
	void testFindAllProductListByUserIdWhenFailure() {
		UserModel userModel = findUserModelWithoutUserId();
		ResponseEntity<Object> responseEntity = findResponseOnCatalogueIdBlank();
		Mockito.when(businessValidator.isIdEmpty(userModel.getUserId())).thenReturn(responseEntity);
		ResponseEntity<Object> entity = productController.findAllProductListByUserId(userModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}

	/**
	 * Test findAllProductListByUserId() function on Exception If get any exception. status
	 * will 500 
	 * 
	 */
	@Test
	void testFindAllProductListByUserIdWhenException() {
		UserModel userModel = findUserModelWithUserId();
		Throwable exception = findException();
		Mockito.when(businessValidator.isIdEmpty(userModel.getUserId())).thenReturn(null);
		Mockito.when(productService.findAllProductListByUserId(userModel.getUserId())).thenThrow(exception);
		ResponseEntity<Object> responseEntity = productController.findAllProductListByUserId(userModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(400);
	}
	/**
	 * Test updateProductDetail() function on Success If provide product details with product id. status
	 * will 200 
	 * 
	 */
	@Test
	void testUpdateProductDetailWhenSuccess() {
		ProductModel productModel = findProdModelWithId();
		Mockito.when(businessValidator.validateProductWithProdId(productModel)).thenReturn(null);
		Mockito.when(productService.updateProductDetails(productModel))
				.thenReturn(AppConstant.PRODUCT_UPDATED_SUCCESSFULLY);
		ResponseEntity<Object> responseEntity = productController.updateProductDetail(productModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}
	/**
	 * Test updateProductDetail() function on Failure If not provide product details with product id. status
	 * will 200 
	 * 
	 */
	@Test
	void testUpdateProductDetailWhenFailure() {
		ProductModel productModel = findProdModelWithoutCatId();
		ResponseEntity<Object> responseEntity = findResponseOnCatalogueIdBlank();
		Mockito.when(businessValidator.validateProductWithProdId(productModel)).thenReturn(responseEntity);
		ResponseEntity<Object> entity = productController.updateProductDetail(productModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}
	/**
	 * Test updateProductDetail() function on Exception If get ANy exception. status
	 * will 500 
	 * 
	 */
	@Test
	void testUpdateProductDetailWhenException() {
		ProductModel productModel = findProdModelWithId();
		Throwable exception = findException();
		Mockito.when(businessValidator.validateProductWithProdId(productModel)).thenReturn(null);
		Mockito.when(productService.updateProductDetails(productModel)).thenThrow(exception);
		ResponseEntity<Object> responseEntity = productController.updateProductDetail(productModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
	}
	/**
	 * Test deleteProduct() function on Success If provide product id. status
	 * will 200 
	 * 
	 */
	@Test
	void testDeleteProductDetailWhenSuccess() {
		ProductModel productModel = findProdModelWithId();
		Mockito.when(businessValidator.isIdEmpty(productModel.getProductId())).thenReturn(null);
		Mockito.when(productService.deleteByProductId(productModel.getProductId()))
				.thenReturn(AppConstant.PRODUCT_DELETED_SUCCESSFULLY);
		ResponseEntity<Object> responseEntity = productController.deleteProductDetail(productModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}
	/**
	 * Test deleteProduct() function on Failure If not provide product id. status
	 * will 200 
	 * 
	 */
	@Test
	void testDeleteProductDetailWhenFailure() {
		ProductModel productModel = findProdModelWithoutProdId();
		ResponseEntity<Object> responseEntity = findResponseOnCatalogueIdBlank();
		Mockito.when(businessValidator.isIdEmpty(productModel.getProductId())).thenReturn(responseEntity);
		ResponseEntity<Object> entity = productController.deleteProductDetail(productModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}
	/**
	 * Test deleteProduct() function on Exception If get any Exception. status
	 * will 500 
	 * 
	 */
	@Test
	void testDeleteProductDetailWhenException() {
		ProductModel productModel = findProdModelWithId();
		Throwable exception = findException();
		Mockito.when(businessValidator.isIdEmpty(productModel.getProductId())).thenReturn(null);
		Mockito.when(productService.deleteByProductId(productModel.getProductId())).thenThrow(exception);
		ResponseEntity<Object> responseEntity = productController.deleteProductDetail(productModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
	}
	/**
	 * Test findAllProductByPagination() function on Success If provide page number and number of Products. status
	 * will 200 
	 * 
	 */
	@Test
	void testfindAllProductByPaginationWhenSuccess() {
		PageModel pageModel = findPageModelWithDetails();
		Page<Product> pageList = findAllPageProducts();
		ResponseEntity<Object> responseEntity = findAllPageModelResponse();
		Mockito.when(businessValidator.isValidPage(pageModel)).thenReturn(null);
		Mockito.when(businessValidator.findAllProductByPageNumber(pageList)).thenReturn(responseEntity);
		Mockito.when(productService.findAllProduct(pageModel.getPageNumber(), pageModel.getNoOfProducts()))
				.thenReturn(pageList);
		ResponseEntity<Object> entity = productController.findAllProductByPagination(pageModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}
	/**
	 * Test findAllProductByPagination() function on Failure If not provide page number and number of Products. status
	 * will 200 
	 * 
	 */
	@Test
	void testfindAllProductByPaginationWhenFailure() {
		PageModel pageModel = findPageModelWithoutDetail();
		ResponseEntity<Object> responseEntity = findResponseOnCatalogueIdBlank();
		Mockito.when(businessValidator.isValidPage(pageModel)).thenReturn(responseEntity);
		ResponseEntity<Object> entity = productController.findAllProductByPagination(pageModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}
	/**
	 * Test findAllProductByPagination() function on Exception If get any Exception. status
	 * will 500 
	 * 
	 */
	@Test
	void testfindAllProductByPaginationWhenException() {
		PageModel pageModel = findPageModelWithDetails();
		Throwable exception = findException();
		Mockito.when(businessValidator.isValidPage(pageModel)).thenReturn(null);
		Mockito.when(productService.findAllProduct(pageModel.getPageNumber(), pageModel.getNoOfProducts()))
				.thenThrow(exception);
		ResponseEntity<Object> entity = productController.findAllProductByPagination(pageModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(500);
	}

}
