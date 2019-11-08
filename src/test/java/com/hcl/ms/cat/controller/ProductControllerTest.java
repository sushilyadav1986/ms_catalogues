package com.hcl.ms.cat.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

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
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.service.ProductService;
import com.hcl.ms.cat.utils.AppConstant;
import com.hcl.ms.cat.utils.test.ProdControllerJUtils;

/**
 * Create ProductControllerTest.class Test here ProductController's function
 * 
 * @author SushilY
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = CatalogueMsApplication.class)
class ProductControllerTest extends ProdControllerJUtils {

	@Mock
	ProductService productService;

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
		Mockito.when(productService.saveProduct(productModel)).thenReturn(AppConstant.PRODUCT_UPDATED_SUCCESSFULLY);
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
		ProductModel productModel = findProdModelWithoutCatId();
		ResponseEntity<Object> responseEntity = findResponseOnCatalogueIdBlank();
		
		Mockito.when(businessValidator.isIdEmpty(productModel.getProductId())).thenReturn(responseEntity);
		ResponseEntity<Object> entity = productController.findProductDetails(productModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);

	}

	@Test
	void testFindProductDetailsWhenException() {
		ProductModel productModel = new ProductModel(12, "Lemon", 455.55, "dafkdasfadso", "H", 21);
		Throwable exception = findException();
		Mockito.when(businessValidator.isIdEmpty(productModel.getProductId())).thenReturn(null);
		Mockito.when(productService.saveProduct(productModel)).thenThrow(exception);
		ResponseEntity<Object> responseEntity = productController.findProductDetails(productModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
	}

	@Test
	void testFindAllProductListByUserIdWhenSuccess() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testFindAllProductListByUserIdWhenFailure() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testFindAllProductListByUserIdWhenException() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testUpdateProductDetailWhenSuccess() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testUpdateProductDetailWhenFailure() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testUpdateProductDetailWhenException() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testDeleteProductDetailWhenSuccess() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testDeleteProductDetailWhenFailure() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testDeleteProductDetailWhenException() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetPaginationWhenSuccess() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetPaginationWhenFailure() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetPaginationWhenException() {
		fail("Not yet implemented"); // TODO
	}

}
