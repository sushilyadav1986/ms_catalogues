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
import com.hcl.ms.cat.model.NoObjRespnseModel;
import com.hcl.ms.cat.model.PageModel;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.model.ResponseModel;
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
	public User findUser() {
		User user = new User();
		Catalogue catalogue = new Catalogue();
		user.set_id(1);
		user.setFirstName("Sushil");
		user.setLastName("Yadav");
		user.setGender("M");
		user.setEmail("test@gmail.com");
		user.setContactNumber(8130834214L);
		catalogue.setCatId(1);
		user.setCatalogue(catalogue);
		return user;
	}

	public UserModel findUserModelWithUserId() {
		return new UserModel(findUser());
		

	}

	public UserModel findUserModelWithoutUserId() {
		return new UserModel("Sushil", "Yadav", "M", "test@gmail.com", 8130834214L,new Catalogue());
	}

	public UserModel findUserModelWithoutEmailId() {
		UserModel userModel = new UserModel("Sushil", "Yadav", "M", "", 8130834214L,new Catalogue());
		return userModel;
	}

	public UserModel findUserModelWithoutContact() {
		UserModel userModel = new UserModel("Sushil", "Yadav", "M", "test@gmail.com", 34214L,new Catalogue());
		return userModel;
	}

	public UserModel findUserModelWithoutFirstName() {
		UserModel userModel = new UserModel("", "Yadav", "M", "test@gmail.com", 8130834214L,new Catalogue());
		return userModel;
	}

	public PageModel findPageModelWithDetails() {
		PageModel pageModel = new PageModel();
		pageModel.setPageNumber(2);
		pageModel.setNoOfProducts(10);
		return pageModel;
	}

	public PageModel findPageModelWithoutDetail() {
		PageModel pageModel = new PageModel();
		pageModel.setNoOfProducts(10);
		return pageModel;
	}

	public ProductModel findProdModelWithId() {
		return new ProductModel(1, "MOTOROLLA", 455.55, "G5", "H", 1);
	}

	public ProductModel findProdModelWithoutCatId() {
		return new ProductModel(12, "Mi", 455.55, "Note5", "H", 0);
	}

	public ProductModel findProdModelWithoutProdId() {
		return new ProductModel(0, "Mi", 455.55, "Note5", "H", 1);
	}

	public ProductModel findProdModelWithoutName() {
		return new ProductModel(1, "", 455.55, "G5", "H", 1);
	}

	public ResponseEntity<Object> findResponseOnCatalogueIdBlank() {
		return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.CATALOGUE_ID_EMPTY), HttpStatus.OK);
	}
	public ResponseEntity<Object> findResponseOnSaveProduct() {
		return new ResponseEntity<Object>(
				new NoObjRespnseModel(true, AppConstant.PRODUCT_ADDED_SUCCESSFULLY), HttpStatus.CREATED);
	}

	public ResponseEntity<Object> findProductResponse() {
		return new ResponseEntity<Object>(
				new ResponseModel(true, AppConstant.PRODUCT_FIND_SUCCESSFULLY, findProdModelWithId()), HttpStatus.OK);
	}

	public ResponseEntity<Object> findAllPageModelResponse() {
		return new ResponseEntity<Object>(
				new ResponseModel(true, AppConstant.PRODUCT_LIST_FIND_SUCCESSFULLY, findAllProducts()), HttpStatus.OK);
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

	public List<ProductModel> findAllProductModel() {
		List<ProductModel> pModelList = new ArrayList<ProductModel>();
		for (int i = 0; i <= 6; i++) {
			ProductModel productModel = new ProductModel();
			pModelList.add(productModel);
		}
		return pModelList;
	}
	
	public List<Product> findAllProducts() {
		List<Product> pModelList = new ArrayList<Product>();
		for (int i = 0; i <= 6; i++) {
			Product product = new Product();
			pModelList.add(product);
		}
		return pModelList;
	}
	public Page<Product> findAllPageProducts() {
		Page<Product>pageList=new PageImpl<Product>(findAllProducts());
		
		return pageList;
	}

	/**
	 * @return
	 */
	public UserModel findDummyUserModel() {
		UserModel userModel = new UserModel("Sushil", "Yadav", "M", "test@gmail.com", 8130834214L,new Catalogue());
		return userModel;

	}

	/**
	 * @return
	 */
	public UserModel findDummyUserModelWithoutEmail() {
		UserModel userModel = new UserModel("Sushil", "Yadav", "M", "", 8130834214L,new Catalogue());
		return userModel;
	}

	/**
	 * @return
	 */
	public ResponseEntity<Object> findResponseWithoutEmail() {
		return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.ENTER_CORRECT_EMAIL), HttpStatus.OK);
	}
	public ResponseEntity<Object> findResponseOnSavedUser() {
		return new ResponseEntity<Object>(
				new NoObjRespnseModel(true, AppConstant.USER_ADDED_SUCCESSFULLY), HttpStatus.CREATED);
	
	}

	public Product findDummyProduct() {
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

	public User findDummyUser() {
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
	public ProductModel findDummyProdutModel() {
		ProductModel productModel = new ProductModel(1, "Lemon", 455.55, "dafkdasfadso", "H", 1);
		return productModel;
	}
	
	public List<Product> findAllDummyProducts() {
		Catalogue catalogue = new Catalogue();
		catalogue.setCatId(1);
		catalogue.setName("testCatLog");

		Product product = new Product();
		product.setProdId(1);
		product.setName("Test");
		product.setAvailability("H");
		product.setDescription("descript");
		product.setPrice(778.26);
		product.setCatalogue(catalogue);

		Catalogue catalogue1 = new Catalogue();
		catalogue1.setCatId(1);
		catalogue1.setName("testCatLog");
		Product product1 = new Product();
		product1.setProdId(2);
		product1.setName("Est");
		product1.setAvailability("O");
		product1.setDescription("descript");
		product1.setPrice(798.26);
		product1.setCatalogue(catalogue1);

		Catalogue catalogue2 = new Catalogue();
		catalogue2.setCatId(3);
		catalogue2.setName("testCatLog");
		Product product2 = new Product();
		product2.setProdId(3);
		product2.setName("Test");
		product2.setAvailability("L");
		product2.setDescription("descript");
		product2.setPrice(768.26);
		product2.setCatalogue(catalogue2);

		List<Product> pList = new ArrayList<>();
		pList.add(product);
		pList.add(product1);
		pList.add(product2);
		return pList;
	}

}
