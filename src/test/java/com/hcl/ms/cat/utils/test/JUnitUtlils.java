package com.hcl.ms.cat.utils.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.ms.cat.entity.Catalogue;
import com.hcl.ms.cat.entity.Product;
import com.hcl.ms.cat.entity.User;
import com.hcl.ms.cat.model.PageModel;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.model.ObjectResponse;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.utils.AppConstant;

/**
 * @author SushilY
 *
 */
public class JUnitUtlils {

	

	/**
	 * @return
	 */
	public UserModel findUserModelWithUserId() {
		return new UserModel(findUser());

	}

	/**
	 * @return
	 */
	public UserModel findUserModelWithoutUserId() {
		return new UserModel("Sushil", "Yadav", "M", "test@gmail.com", 8130834214L, new Catalogue());
	}

	/**
	 * @return
	 */
	public UserModel findUserModelWithoutEmailId() {
		UserModel userModel = new UserModel("Sushil", "Yadav", "M", "", 8130834214L, new Catalogue());
		return userModel;
	}

	/**
	 * @return
	 */
	public UserModel findUserModelWithoutContact() {
		UserModel userModel = new UserModel("Sushil", "Yadav", "M", "test@gmail.com", 34214L, new Catalogue());
		return userModel;
	}

	/**
	 * @return
	 */
	public UserModel findUserModelWithoutFirstName() {
		UserModel userModel = new UserModel("", "Yadav", "M", "test@gmail.com", 8130834214L, new Catalogue());
		return userModel;
	}

	/**
	 * @return
	 */
	public PageModel findPageModelWithDetails() {
		PageModel pageModel = new PageModel();
		pageModel.setPageNumber(2);
		pageModel.setNoOfProducts(10);
		return pageModel;
	}

	/**
	 * @return
	 */
	public PageModel findPageModelWithoutDetail() {
		PageModel pageModel = new PageModel();
		pageModel.setNoOfProducts(10);
		return pageModel;
	}

	/**
	 * @return
	 */
	public ProductModel findProdModelWithId() {
		return new ProductModel(1, "MOTOROLLA", 455.55, "G5", "H", 1);
	}

	/**
	 * @return
	 */
	public ProductModel findProdModelWithoutCatId() {
		return new ProductModel(12, "Mi", 455.55, "Note5", "H", 0);
	}

	/**
	 * @return
	 */
	public ProductModel findProdModelWithoutProdId() {
		return new ProductModel(0, "Mi", 455.55, "Note5", "H", 1);
	}

	/**
	 * @return
	 */
	public ProductModel findProdModelWithoutName() {
		return new ProductModel(1, "", 455.55, "G5", "H", 1);
	}

	/**
	 * @return
	 */
	public ResponseEntity<Object> findResponseOnCatalogueIdBlank() {
		return new ResponseEntity<Object>(new ObjectResponse(true, AppConstant.CATALOGUE_ID_EMPTY), HttpStatus.OK);
	}

	/**
	 * @return
	 */
	public ResponseEntity<Object> findResponseOnSaveProduct() {
		return new ResponseEntity<Object>(new ObjectResponse(true, AppConstant.PRODUCT_ADDED_SUCCESSFULLY),
				HttpStatus.CREATED);
	}

	/**
	 * @return
	 */
	public ResponseEntity<Object> findProductResponse() {
		return new ResponseEntity<Object>(
				new ObjectResponse(true, AppConstant.PRODUCT_FIND_SUCCESSFULLY, findProdModelWithId()), HttpStatus.OK);
	}

	/**
	 * @return
	 */
	public ResponseEntity<Object> findAllPageModelResponse() {
		return new ResponseEntity<Object>(
				new ObjectResponse(true, AppConstant.PRODUCT_LIST_FIND_SUCCESSFULLY, findAllProducts()), HttpStatus.OK);
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

	/**
	 * @return
	 */
	public List<Product> findAllProducts() {
		List<Product> pModelList = new ArrayList<Product>();
		for (int i = 0; i <= 6; i++) {
			Product product = new Product();
			Catalogue catalogue = new Catalogue();
			catalogue.setCatId(1);

			product.setProdId(i);
			product.setName("name" + i);
			if (i % 2 == 0) {
				product.setAvailability("H");
				product.setDescription("HCL LUCKNOW");
				product.setPrice(1778.26 + i);
				catalogue.setName("testCatLog" + i);
			} else {
				product.setAvailability("L");
				product.setDescription("HCL NOIDA");
				product.setPrice(778.26 + i);
				catalogue.setName("testCatLog" + i);
			}
			product.setCatalogue(catalogue);
			pModelList.add(product);
		}
		return pModelList;
	}

	public Page<Product> findAllPageProducts() {
		Page<Product> pageList = new PageImpl<Product>(findAllProducts());

		return pageList;
	}

	/**
	 * @return
	 */
	public UserModel findUserModel() {
		UserModel userModel = new UserModel("Sushil", "Yadav", "M", "test@gmail.com", 8130834214L, new Catalogue());
		return userModel;

	}

	/**
	 * @return
	 */
	public UserModel findUserModelWithoutEmail() {
		UserModel userModel = new UserModel("Sushil", "Yadav", "M", "", 8130834214L, new Catalogue());
		return userModel;
	}

	/**
	 * @return
	 */
	public ResponseEntity<Object> findResponseWithoutEmail() {
		return new ResponseEntity<Object>(new ObjectResponse(true, AppConstant.ENTER_CORRECT_EMAIL), HttpStatus.OK);
	}

	/**
	 * @return
	 */
	public ResponseEntity<Object> findResponseOnSavedUser() {
		return new ResponseEntity<Object>(new ObjectResponse(true, AppConstant.USER_ADDED_SUCCESSFULLY),
				HttpStatus.CREATED);

	}

	/**
	 * @return
	 */
	public Product findProduct() {
		Product product = new Product();
		product.setProdId(1);
		product.setName("Test");
		product.setAvailability("H");
		product.setDescription("descript");
		product.setPrice(768.26);
		Catalogue catalogue = new Catalogue();
		catalogue.setCatId(1);
		catalogue.setName("testCatLog");
		product.setCatalogue(catalogue);
		return product;
	}

	/**
	 * @return
	 */
	public User findUser() {
		User user = new User();
		user.set_id(1);
		user.setContactNumber(4569825689L);
		user.setEmail("test@gmail.com");
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setGender("M");
		Catalogue catalogue = new Catalogue();
		catalogue.setCatId(1);
		catalogue.setName("testCatLog");
		user.setCatalogue(catalogue);
		return user;
	}

	/**
	 * @return
	 */
	public ProductModel findProdutModel() {
		ProductModel productModel = new ProductModel(1, "Lemon", 455.55, "dafkdasfadso", "H", 1);
		return productModel;
	}
}
