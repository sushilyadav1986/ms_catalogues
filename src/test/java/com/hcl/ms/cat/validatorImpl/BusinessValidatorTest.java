package com.hcl.ms.cat.validatorImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.hcl.ms.cat.CatalogueMsApplication;
import com.hcl.ms.cat.entity.Product;
import com.hcl.ms.cat.model.PageModel;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.utils.test.JUnitUtlils;
import com.hcl.ms.cat.validatorImpl.BusinessValidator;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = CatalogueMsApplication.class)
class BusinessValidatorTest extends JUnitUtlils {

	@InjectMocks
	BusinessValidator businessValidator;

	@Test
	void testValidateProductWhenSuccess() {
		ProductModel productModel = findProdModelWithId();
		ResponseEntity<Object> responseEntity = businessValidator.validateProduct(productModel);
		assertNull(responseEntity);
	}

	@Test
	void testValidateProductWhenFailure() {
		ProductModel productModel = findProdModelWithoutCatId();
		ResponseEntity<Object> responseEntity = findResponseOnCatalogueIdBlank();
		responseEntity = businessValidator.validateProduct(productModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		productModel = findProdModelWithoutName();
		responseEntity = businessValidator.validateProduct(productModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		productModel = new ProductModel();
		responseEntity = businessValidator.validateProduct(productModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	void testValidateProductWithProdIdWhenSuccess() {
		ProductModel productModel = findProdModelWithId();
		ResponseEntity<Object> responseEntity = businessValidator.validateProductWithProdId(productModel);
		assertNull(responseEntity);
	}

	@Test
	void testValidateProductWithProdIdWhenFailure() {
		ProductModel productModel = findProdModelWithoutProdId();
		ResponseEntity<Object> responseEntity = businessValidator.validateProductWithProdId(productModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}

	@Test
	void testIsIdEmptyWhenSuccess() {
		ResponseEntity<Object> responseEntity = businessValidator.isIdEmpty(1);
		assertNull(responseEntity);
	}

	@Test
	void testIsIdEmptyWhenFailure() {
		ResponseEntity<Object> responseEntity = businessValidator.isIdEmpty(0);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	void testIsValidPageWhenSuccess() {
		PageModel pageModel= findPageModelWithDetails();
		ResponseEntity<Object> responseEntity = businessValidator.isValidPage(pageModel);
		assertNull(responseEntity);
	}
	
	@Test
	void testIsValidPageWhenFailure() {
		PageModel pageModel= findPageModelWithoutDetail();
		ResponseEntity<Object> responseEntity = businessValidator.isValidPage(pageModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	void testValidUserDetailsWhenSuccess() {
		UserModel userModel=findUserModelWithoutUserId();
		ResponseEntity<Object> responseEntity = businessValidator.validUserDetails(userModel);
		assertNull(responseEntity);
	}

	@Test
	void testValidUserDetailsWhenFailure() {
		UserModel userModel=findUserModelWithoutEmailId();
		ResponseEntity<Object> responseEntity = businessValidator.validUserDetails(userModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		userModel=findUserModelWithoutContact();
		responseEntity = businessValidator.validUserDetails(userModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		userModel=findUserModelWithoutFirstName();
		responseEntity = businessValidator.validUserDetails(userModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	void testIsProductNullWhenSuccess() {
		Product product=findProduct();
		ResponseEntity<Object> responseEntity = businessValidator.isProductNull(product);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}


	@Test
	void testIsProductNullWhenFailure() {
		Product product=null;
		ResponseEntity<Object> responseEntity = businessValidator.isProductNull(product);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	void testIsProdModelListEmptyWhenSuccess() {
		List<ProductModel>pModelList=new ArrayList<ProductModel>();
		pModelList.add(findProdModelWithId());
		ResponseEntity<Object> responseEntity = businessValidator.isProdModelListEmpty(pModelList);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}


	@Test
	void testIsProdModelListEmptyWhenFailure() {
		List<ProductModel>pModelList=new ArrayList<ProductModel>();
		ResponseEntity<Object> responseEntity = businessValidator.isProdModelListEmpty(pModelList);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}

}
