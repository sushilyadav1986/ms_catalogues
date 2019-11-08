/**
 * 
 */
package com.hcl.ms.cat.utils.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.ms.cat.model.NoObjRespnseModel;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.model.ResponseModel;
import com.hcl.ms.cat.utils.AppConstant;

/**
 * JUnit Helper class for ProductControllerTest Initialize MockMvc
 * 
 * @author SushilY
 *
 */

public class ProdControllerJUtils {

	public ProductModel findProdModelWithId() {
		return new ProductModel(1, "MOTOROLLA", 455.55, "G5", "H", 1);
	}

	public ProductModel findProdModelWithoutCatId() {
		return new ProductModel(12, "Mi", 455.55, "Note5", "H", 0);
	}

	public ProductModel findProdModelWithoutProdId() {
		return new ProductModel(0, "Mi", 455.55, "Note5", "H", 1);
	}

	public ResponseEntity<Object> findResponseOnCatalogueIdBlank() {
		return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.CATALOGUE_ID_EMPTY), HttpStatus.OK);
	}
	
	public ResponseEntity<Object> findProductResponse() {
		return new ResponseEntity<Object>(new ResponseModel(true, 
				AppConstant.PRODUCT_FIND_SUCCESSFULLY, findProdModelWithId()),
				HttpStatus.OK);
	}

	/**
	 * @return
	 */
	public Throwable findException() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			throw new IllegalArgumentException("a message");
		});
		return exception;
	}
}
