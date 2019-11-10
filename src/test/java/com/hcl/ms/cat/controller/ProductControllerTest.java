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
import org.springframework.http.ResponseEntity;

import com.hcl.ms.cat.CatalogueMsApplication;
import com.hcl.ms.cat.controller.validator.Validator;
import com.hcl.ms.cat.model.PageModel;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.service.ProductService;
import com.hcl.ms.cat.service.UserService;
import com.hcl.ms.cat.utils.AppConstant;
import com.hcl.ms.cat.utils.test.JUnitUtlils;

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
	 * Test SaveProduct() function on success On success function will retrun 200
	 * status
	 * 
	 */
	@Test
	void testSaveProductWhenSuccess() {
		ProductModel productModel = findProdModelWithId();
		Mockito.when(businessValidator.validateProduct(productModel)).thenReturn(null);
		Mockito.when(productService.saveProduct(productModel)).thenReturn(AppConstant.PRODUCT_ADDED_SUCCESSFULLY);
		ResponseEntity<Object> responseEntity = productController.saveProduct(productModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
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

	@Test
	void testSaveProductWhenException() {
		ProductModel productModel = new ProductModel(12, "Lemon", 455.55, "dafkdasfadso", "H", 21);
		Throwable exception = findException();
		Mockito.when(businessValidator.validateProduct(productModel)).thenReturn(null);
		Mockito.when(productService.saveProduct(productModel)).thenThrow(exception);
		ResponseEntity<Object> responseEntity = productController.saveProduct(productModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
	}

	@Test
	void testFindProductDetailsWhenSuccess() {
		ProductModel productModel = findProdModelWithId();
		ResponseEntity<Object> responseEntity=findProductResponse() ;
		Mockito.when(businessValidator.isIdEmpty(productModel.getProductId())).thenReturn(null);
		Mockito.when(businessValidator.isProdModelNull(productModel)).thenReturn(responseEntity);
		Mockito.when(productService.findProductDetails(productModel.getProductId())).thenReturn(productModel);
		ResponseEntity<Object> entity = productController.findProductDetails(productModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	void testFindProductDetailsWhenFailure() {
		ProductModel productModel = findProdModelWithId();
		ResponseEntity<Object> responseEntity = findResponseOnCatalogueIdBlank();
		Mockito.when(businessValidator.isIdEmpty(productModel.getProductId())).thenReturn(responseEntity);
		ResponseEntity<Object> entity = productController.findProductDetails(productModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	void testFindProductDetailsWhenException() {
		ProductModel productModel = findProdModelWithId();
		Throwable exception = findException();
		Mockito.when(businessValidator.isIdEmpty(productModel.getProductId())).thenReturn(null);
		Mockito.when(productService.findProductDetails(productModel.getProductId())).thenThrow(exception);
		ResponseEntity<Object> responseEntity = productController.findProductDetails(productModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
	}

	@Test
	void testFindAllProductListByUserIdWhenSuccess() {
		UserModel userModel=findUserModelWithUserId();
		List<ProductModel>pModelList=findAllProducts();
		ResponseEntity<Object> responseEntity=findProductResponse() ;
		Mockito.when(businessValidator.isIdEmpty(userModel.getUserId())).thenReturn(null);
		Mockito.when(businessValidator.isProdModelListEmpty(pModelList)).thenReturn(responseEntity);
		Mockito.when(productService.findAllProductListByUserId(userModel.getUserId())).thenReturn(pModelList);
		ResponseEntity<Object> entity = productController.findAllProductListByUserId(userModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	void testFindAllProductListByUserIdWhenFailure() {
		UserModel userModel=findUserModelWithoutUserId();
		ResponseEntity<Object> responseEntity = findResponseOnCatalogueIdBlank();
		Mockito.when(businessValidator.isIdEmpty(userModel.getUserId())).thenReturn(responseEntity);
		ResponseEntity<Object> entity = productController.findAllProductListByUserId(userModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	void testFindAllProductListByUserIdWhenException() {
		UserModel userModel=findUserModelWithUserId();
		Throwable exception = findException();
		Mockito.when(businessValidator.isIdEmpty(userModel.getUserId())).thenReturn(null);
		Mockito.when(productService.findAllProductListByUserId(userModel.getUserId())).thenThrow(exception);
		ResponseEntity<Object> responseEntity = productController.findAllProductListByUserId(userModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
	}

	@Test
	void testUpdateProductDetailWhenSuccess() {
		ProductModel productModel = findProdModelWithId();
		Mockito.when(businessValidator.validateProductWithProdId(productModel)).thenReturn(null);
		Mockito.when(productService.updateProductDetails(productModel)).thenReturn(AppConstant.PRODUCT_UPDATED_SUCCESSFULLY);
		ResponseEntity<Object> responseEntity = productController.updateProductDetail(productModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	void testUpdateProductDetailWhenFailure() {
		ProductModel productModel = findProdModelWithoutCatId();
		ResponseEntity<Object> responseEntity = findResponseOnCatalogueIdBlank();
		Mockito.when(businessValidator.validateProductWithProdId(productModel)).thenReturn(responseEntity);
		ResponseEntity<Object> entity = productController.updateProductDetail(productModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	void testUpdateProductDetailWhenException() {
		ProductModel productModel = findProdModelWithId();
		Throwable exception = findException();
		Mockito.when(businessValidator.validateProductWithProdId(productModel)).thenReturn(null);
		Mockito.when(productService.updateProductDetails(productModel)).thenThrow(exception);
		ResponseEntity<Object> responseEntity = productController.updateProductDetail(productModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
	}

	@Test
	void testDeleteProductDetailWhenSuccess() {
		ProductModel productModel = findProdModelWithId();
		Mockito.when(businessValidator.isIdEmpty(productModel.getProductId())).thenReturn(null);
		Mockito.when(productService.deleteByProductId(productModel.getProductId())).thenReturn(AppConstant.PRODUCT_DELETED_SUCCESSFULLY);
		ResponseEntity<Object> responseEntity = productController.deleteProductDetail(productModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	void testDeleteProductDetailWhenFailure() {
		ProductModel productModel = findProdModelWithoutProdId();
		ResponseEntity<Object> responseEntity = findResponseOnCatalogueIdBlank();
		Mockito.when(businessValidator.isIdEmpty(productModel.getProductId())).thenReturn(responseEntity);
		ResponseEntity<Object> entity = productController.deleteProductDetail(productModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	void testDeleteProductDetailWhenException() {
		ProductModel productModel = findProdModelWithId();
		Throwable exception = findException();
		Mockito.when(businessValidator.isIdEmpty(productModel.getProductId())).thenReturn(null);
		Mockito.when(productService.deleteByProductId(productModel.getProductId())).thenThrow(exception);
		ResponseEntity<Object> responseEntity = productController.deleteProductDetail(productModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
	}

	@Test
	void testfindAllProductByPaginationWhenSuccess() {
		PageModel pageModel=findPageModelWithDetails();
		List<ProductModel> pModelList=findAllProducts();
		ResponseEntity<Object> responseEntity =findAllPageModelResponse();
		Mockito.when(businessValidator.isValidPage(pageModel)).thenReturn(null);
		Mockito.when(businessValidator.isProdModelListEmpty(pModelList)).thenReturn(responseEntity);
		Mockito.when(productService.findAllProduct(pageModel.getPageNumber(),
				pageModel.getNoOfProducts())).thenReturn(pModelList);
		ResponseEntity<Object> entity = productController.findAllProductByPagination(pageModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	void testfindAllProductByPaginationWhenFailure() {
		PageModel pageModel=findPageModelWithoutDetail();
		ResponseEntity<Object> responseEntity = findResponseOnCatalogueIdBlank();
		Mockito.when(businessValidator.isValidPage(pageModel)).thenReturn(responseEntity);
		ResponseEntity<Object> entity = productController.findAllProductByPagination(pageModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	void testfindAllProductByPaginationWhenException() {
		PageModel pageModel=findPageModelWithDetails();
		Throwable exception = findException();
		Mockito.when(businessValidator.isValidPage(pageModel)).thenReturn(null);
		Mockito.when(productService.findAllProduct(pageModel.getPageNumber(),
				pageModel.getNoOfProducts())).thenThrow(exception);
		ResponseEntity<Object> entity = productController.findAllProductByPagination(pageModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(500);
	}

}
