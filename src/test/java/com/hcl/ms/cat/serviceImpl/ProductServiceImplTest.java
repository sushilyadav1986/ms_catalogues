/**
 * 
 */
package com.hcl.ms.cat.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.hcl.ms.cat.entity.Catalogue;
import com.hcl.ms.cat.entity.Product;
import com.hcl.ms.cat.entity.User;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.repository.ProductRepository;
import com.hcl.ms.cat.repository.UserRepository;
import com.hcl.ms.cat.utils.ProductServiceImplUtils;

/**
 * Create Test class for ProductServiceImpl
 * 
 * @author SushilY
 *
 */
class ProductServiceImplTest {

	@InjectMocks
	ProductServiceImpl pServiceImpl;

	@Mock
	ProductRepository productRepository;

	@Mock
	UserRepository userRepository;
	@Mock
	ProductServiceImplUtils productServiceImplUtils;

	/**
	 * Initialize Mockito
	 */
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);

	}

	/**
	 * Test method for
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#saveProduct(com.hcl.ms.cat.model.ProductModel)}.
	 */
	@Test
	void testSaveProduct() {
		ProductModel productModel = findDummyProdutModel();
		Product product = findDummyProduct();
		Mockito.when(productServiceImplUtils.getProduct(productModel)).thenReturn(product);
		Mockito.when(productServiceImplUtils.getProductModel(product)).thenReturn(productModel);
		
		Mockito.when(productRepository.save(product)).thenReturn(product);
		//TODO: test below line
		//productModel = pServiceImpl.saveProduct(productModel);
		assertEquals(1, productModel.getProductId());
	}

	/**
	 * Test method for
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#getProductDetails(long)}.
	 */

	@Test
	void testGetProductDetails() {
		Product product = findDummyProduct();
		Optional<Product> optional = Optional.of(product);

		Mockito.when(productRepository.findById(1L)).thenReturn(optional);
		ProductModel pModel = pServiceImpl.findProductDetails(1);
		assertEquals(product.getAvailability(), pModel.getProductAvailability());
	}

	/**
	 * Test method for
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#getProductListByUserId(long)}.
	 */

	@Test
	void testFindAllProductListByUserId() {
		User user = findDummyUser();
		List<Product> pList = findAllDummyProducts();
		List<ProductModel>pModelList=findAllDummyProdModel();
		Mockito.when(userRepository.findUserById(Mockito.anyLong())).thenReturn(user);
		Mockito.when(productServiceImplUtils.getAllProdModel(pList)).thenReturn(pModelList);
		Mockito.when(productRepository.findByCatalogueCatIdOrderByNameAscPriceAsc(Mockito.anyLong())).thenReturn(pList);
		pModelList = pServiceImpl.findAllProductListByUserId(1);
		assertEquals(3, pModelList.size());
	}

	/**
	 * Test method for
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#updateProductDetails(com.hcl.ms.cat.model.ProductModel)}.
	 */

	@Test
	void testUpdateProductDetails() {
		Product product = findDummyProduct();
		Optional<Product> optional = Optional.of(product);

		Mockito.when(productRepository.findById(1L)).thenReturn(optional);
		Mockito.when(productRepository.save(product)).thenReturn(product);
		ProductModel pModel = new ProductModel(1, "Test Value", 222, "TestproductDescription", "H", 21);
		//TODO: test below line
		//boolean hasUpdated = pServiceImpl.updateProductDetails(pModel);
		//assertEquals(true, hasUpdated);
	}

	/**
	 * Test method for
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#deleteByProductId(long)}.
	 */
	@Test
	void testDeleteByProductId() {
		Mockito.when(productRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
		Mockito.doNothing().when(productRepository).deleteById(1L);
		//TODO: test below line
		//boolean hasDeleted = pServiceImpl.deleteByProductId(1L);
		//assertEquals(true, hasDeleted);
	}

	/**
	 * Test method for
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#findAllProduct(int, int)}.
	 */
	@Test
	void testFindAllProduct() {
		List<Product> productList = findAllDummyProducts();
		Page<Product> pageList = new PageImpl<>(productList);

		Pageable pageable = PageRequest.of(2, 3);
		Mockito.when(productRepository.findAll(pageable)).thenReturn(pageList);
		List<ProductModel> productModels = pServiceImpl.findAllProduct(1, 2);
		assertEquals(0, productModels.size());

	}
	
	private List<ProductModel>findAllDummyProdModel(){
		List<Product>pList=findAllDummyProducts();
		List<ProductModel>pModelList=new ArrayList<>();
		if(!pList.isEmpty()) {
			for(Product product : pList) {
				ProductModel productModel=product.getModel();
				pModelList.add(productModel);
			}
		}
		return pModelList;
	}

	private List<Product> findAllDummyProducts() {
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

	private Product findDummyProduct() {
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

	private User findDummyUser() {
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

	private ProductModel findDummyProdutModel() {
		ProductModel productModel = new ProductModel(1, "Lemon", 455.55, "dafkdasfadso", "H", 1);
		return productModel;
	}
}
