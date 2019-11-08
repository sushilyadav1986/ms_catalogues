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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hcl.ms.cat.CatalogueMsApplication;
import com.hcl.ms.cat.controller.validator.Validator;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.service.ProductService;


/**Create ProductControllerTest.class
 * Test here ProductController's function
 * @author SushilY
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = CatalogueMsApplication.class)
class ProductControllerTest {

	@Mock
	ProductService productService;
	
	@InjectMocks
	ProductController productController; 
	
	@Mock
	Validator businessValidator;
	
	/**Test SaveProduct() function on success
	 * On success function will retrun 200 status
	 * 
	 */
	@Test
	void testOnSuccessSaveProduct() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ProductModel productModel = new ProductModel(12, "Lemon", 455.55, "dafkdasfadso", "H", 21);
        //TODO: test below line
       // Mockito.when(productService.saveProduct(productModel)).thenReturn(productModel);
        Mockito.when(businessValidator.validateProduct(productModel)).thenReturn(null);
        ResponseEntity<Object> responseEntity = productController.saveProduct(productModel);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
	}
	
	/**Test SaveProduct() function on failure
	 * If details not fill complete. status will 200	 *  
	 * 
	 */
	@Test
	void testOnFailureSaveProduct() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ProductModel productModel = new ProductModel(12, "Lemon", 455.55, "dafkdasfadso", "H", 21);
        //TODO: test below line
        //Mockito.when(productService.saveProduct(productModel)).thenReturn(productModel);
        Mockito.when(businessValidator.validateProduct(productModel)).thenReturn(null);
        ResponseEntity<Object> responseEntity = productController.saveProduct(productModel);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	void testFindProductDetails() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testFindAllProductListByUserId() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testUpdateProductDetail() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testDeleteProductDetail() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetPagination() {
		fail("Not yet implemented"); // TODO
	}

}
