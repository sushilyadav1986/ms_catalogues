/**
 * 
 */
package com.hcl.ms.cat.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.hcl.ms.cat.entity.Product;
import com.hcl.ms.cat.entity.User;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.repository.ProductRepository;
import com.hcl.ms.cat.repository.UserRepository;
import com.hcl.ms.cat.utils.ServiceImplUtils;
import com.hcl.ms.cat.utils.test.JUnitUtlils;

/**
 * Create Test class for ProductServiceImpl
 * 
 * @author SushilY
 *
 */
class ProductServiceImplTest extends JUnitUtlils {

	@InjectMocks
	ProductServiceImpl pServiceImpl;

	@Mock
	ProductRepository productRepository;

	@Mock
	UserRepository userRepository;
	@Mock
	ServiceImplUtils serviceImplUtils;
	@Captor
	ArgumentCaptor<User> userArg;

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
	void testSaveProductWhenSuccess() {
		Product product = findDummyProduct();
		userArg = ArgumentCaptor.forClass(User.class);
		verify(productRepository, times(10)).save(product);
		String hasSaved = pServiceImpl.saveProduct(new ProductModel(product));
		assertEquals("AA", hasSaved);
	}
	
	@Test
	void testSaveProductWhenFailure() {}

	/**
	 * Test method for
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#getProductDetails(long)}.
	 */

	@Test
	void testFindProductDetailsWhenSuccess() {
		Product product = findDummyProduct();
		Optional<Product> optional = Optional.of(product);
		Mockito.when(productRepository.findById(1L)).thenReturn(optional);
		ProductModel pModel = pServiceImpl.findProductDetails(1);
		assertEquals(product.getAvailability(), pModel.getProductAvailability());
	}
	
	@Test
	void testFindProductDetailsWhenFailure() {}

	/**
	 * Test method for
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#getProductListByUserId(long)}.
	 */

	@Test
	void testFindAllProductListByUserIdWhenSuccess() {
		User user = findDummyUser();
		List<Product> pList = findAllDummyProducts();
		List<ProductModel> pModelList = findAllDummyProdModel();
		Mockito.when(userRepository.findUserById(Mockito.anyLong())).thenReturn(user);
		Mockito.when(serviceImplUtils.getAllProdModel(pList)).thenReturn(pModelList);
		Mockito.when(productRepository.findByCatalogueCatIdOrderByNameAscPriceAsc(Mockito.anyLong())).thenReturn(pList);
		pModelList = pServiceImpl.findAllProductListByUserId(1);
		assertEquals(3, pModelList.size());
	}
	
	@Test
	void testFindAllProductListByUserIdWhenFailure() {}

	/**
	 * Test method for
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#updateProductDetails(com.hcl.ms.cat.model.ProductModel)}.
	 */

	@Test
	void testUpdateProductDetailsWhenSuccess() {
		Product product = findDummyProduct();
		Optional<Product> optional = Optional.of(product);

		Mockito.when(productRepository.findById(1L)).thenReturn(optional);
		Mockito.when(productRepository.save(product)).thenReturn(product);
		// ProductModel pModel = new ProductModel(1, "Test Value", 222,
		// "TestproductDescription", "H", 21);
		// TODO: test below line
		// boolean hasUpdated = pServiceImpl.updateProductDetails(pModel);
		// assertEquals(true, hasUpdated);
	}
	@Test
	void testUpdateProductDetailsWhenFailure() {}

	/**
	 * Test method for
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#deleteByProductId(long)}.
	 */
	@Test
	void testDeleteByProductIdWhenSuccess() {
		Mockito.when(productRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
		Mockito.doNothing().when(productRepository).deleteById(1L);
		// TODO: test below line
		// boolean hasDeleted = pServiceImpl.deleteByProductId(1L);
		// assertEquals(true, hasDeleted);
	}
	@Test
	void testDeleteByProductIdWhenFailure() {}

	/**
	 * Test method for
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#findAllProduct(int, int)}.
	 */
	@Test
	void testFindAllProductWhenSuccess() {
		List<Product> productList = findAllDummyProducts();
		Page<Product> pageList = new PageImpl<>(productList);
		Pageable pageable = PageRequest.of(2, 3);
		Mockito.when(productRepository.findAll(pageable)).thenReturn(pageList);
		List<ProductModel> productModels = pServiceImpl.findAllProduct(1, 2);
		assertEquals(0, productModels.size());

	}
	@Test
	void testFindAllProductWhenFailure() {}
	private List<ProductModel> findAllDummyProdModel() {
		List<Product> pList = findAllDummyProducts();
		List<ProductModel> pModelList = new ArrayList<>();
		if (!pList.isEmpty()) {
			for (Product product : pList) {
				ProductModel productModel = new ProductModel(product);
				pModelList.add(productModel);
			}
		}
		return pModelList;
	}

	
}
