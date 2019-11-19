/**
 * 
 */
package com.hcl.ms.cat.serviceImpl;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
import com.hcl.ms.cat.exception.ProductNotFoundException;
import com.hcl.ms.cat.exception.UserNotFoundException;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.repository.ProductRepository;
import com.hcl.ms.cat.repository.UserRepository;
import com.hcl.ms.cat.utils.AppConstant;
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
	@Captor
	ArgumentCaptor<User> userArg;

	/**
	 * Initialize Mocked
	 */
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test Function on save Product in Table If Product save, will return Obj
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#saveProduct(com.hcl.ms.cat.model.ProductModel)}.
	 */
	@Test
	void testSaveProductWhenSuccess() {
		ProductModel productModel = findProdutModel();
		Product product = new Product(productModel);
		Mockito.when(productRepository.save(product)).thenReturn(product);
		Product hasSaved = pServiceImpl.saveProduct(product);
		assertEquals(product, hasSaved);
	}

	/**
	 * Test Function on save Product in Table If Product not save, will return
	 * exception
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#saveProduct(com.hcl.ms.cat.model.ProductModel)}.
	 */
	@Test
	void testSaveProductWhenFailure() {
		ProductModel productModel = findProdutModel();
		Product product = new Product(productModel);
		Mockito.when(productRepository.save(product)).thenReturn(null);
		Throwable exception = assertThrows(ProductNotFoundException.class, () -> {
			pServiceImpl.saveProduct(product);
		});
		assertEquals(AppConstant.PRODUCT_ADDED_FAILED, exception.getMessage());
	}

	/**
	 * Test method for FindProductDetails() When successfully execute
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#findProductDetails(long)}.
	 */

	@Test
	void testFindProductDetailsWhenSuccess() {
		Product product = findProduct();
		Optional<Product> optional = Optional.of(product);
		Mockito.when(productRepository.findById(1L)).thenReturn(optional);
		Product pModel = pServiceImpl.findProductDetails(1);
		assertEquals(product.getAvailability(), pModel.getAvailability());
	}

	/**
	 * Test method for FindProductDetails() When object not get will return null
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#findProductDetails(long)}.
	 */
	@Test
	void testFindProductDetailsWhenFailure() {
		Optional<Product> optional = Optional.empty();
		Mockito.when(productRepository.findById(1L)).thenReturn(optional);
		Throwable exception = assertThrows(ProductNotFoundException.class, () -> {
			pServiceImpl.findProductDetails(1);
		});
		assertEquals("Product id 1 not Found", exception.getMessage());
	}

	/**
	 * Test method for findAllProductListByUserI() When user id get will return
	 * product list
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#getProductListByUserId(long)}.
	 */

	@Test
	void testFindAllProductListByUserIdWhenSuccess() {
		User user = findUser();
		List<Product> pList = findAllProducts();
		Mockito.when(userRepository.findUserById(Mockito.anyLong())).thenReturn(user);
		Mockito.when(productRepository.findByCatalogueCatIdOrderByNameAscPriceDesc(Mockito.anyLong()))
				.thenReturn(pList);
		pList = pServiceImpl.findAllProductListByUserId(1);
		assertEquals(7, pList.size());
	}

	/**
	 * Test method for findAllProductListByUserI() When user id get will return null
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#getProductListByUserId(long)}.
	 */
	@Test
	void testFindAllProductListByUserIdWhenFailure() {
		User user = findUser();
		List<Product> pList = findAllProducts();
		Mockito.when(userRepository.findUserById(Mockito.anyLong())).thenReturn(user);
		Mockito.when(productRepository.findByCatalogueCatIdOrderByNameAscPriceDesc(Mockito.anyLong())).thenReturn(null);
		pList = pServiceImpl.findAllProductListByUserId(1);
		assertNull(pList);
		Throwable exception = assertThrows(UserNotFoundException.class, () -> {
			Mockito.when(userRepository.findUserById(1L)).thenReturn(null);
			pServiceImpl.findAllProductListByUserId(1);
		});
		assertEquals("User id "+1+" not Found" , exception.getMessage());
	}

	/**
	 * Test method for UpdateProductDetails() When product details get will return
	 * obj
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#updateProductDetails(long)}.
	 */
	@Test
	void testUpdateProductDetailsWhenSuccess() {
		Product product = findProduct();
		ProductModel productModel = findProdModelWithId();
		Mockito.when(productRepository.existsById(1L)).thenReturn(true);
		Mockito.when(productRepository.save(new Product(productModel))).thenReturn(product);
		String hasUpdated = pServiceImpl.updateProductDetails(productModel);
		assertEquals(AppConstant.PRODUCT_UPDATED_SUCCESSFULLY, hasUpdated);
	}

	/**
	 * Test method for UpdateProductDetails() When product details get will return
	 * failed string
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#updateProductDetails(long)}.
	 */
	@Test
	void testUpdateProductDetailsWhenFailure() {
		ProductModel productModel = findProdModelWithId();
		Mockito.when(productRepository.existsById(1L)).thenReturn(false);
		Throwable exception = assertThrows(ProductNotFoundException.class, () -> {
			pServiceImpl.updateProductDetails(productModel);
		});
		assertEquals(AppConstant.PRODUCT_UPDATED_FAILED, exception.getMessage());
	}

	/**
	 * Test method for DeleteByProductId() When product details get will return
	 * failed string
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#deleteByProductI(long)}.
	 */
	@Test
	void testDeleteByProductIdWhenSuccess() {
		Mockito.when(productRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
		Mockito.doNothing().when(productRepository).deleteById(1L);
		Mockito.when(productRepository.existsById(1L)).thenReturn(false);
		String hasDeleted = pServiceImpl.deleteByProductId(1L);
		assertEquals(AppConstant.PRODUCT_DELETED, hasDeleted);
	}

	/**
	 * Test method for DeleteByProductId() When product details get will return
	 * failed string
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#deleteByProductI(long)}.
	 */
	@Test
	void testDeleteByProductIdWhenFailure() {
		Mockito.when(productRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
		Mockito.doNothing().when(productRepository).deleteById(1L);
		Mockito.when(productRepository.existsById(1L)).thenReturn(true);
		Throwable exception = assertThrows(ProductNotFoundException.class, () -> {
			pServiceImpl.deleteByProductId(1L);
		});
		assertEquals(AppConstant.PRODUCT_NOT_DELETED, exception.getMessage());
	}

	/**
	 * Test method for FindAllProduct() When product details get will return page
	 * list
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#findAllProduct(int, int)}.
	 */
	@Test
	void testFindAllProductWhenSuccess() {
		 List<Product> productList = findAllProducts();
		 Page<Product> pageList = new PageImpl<>(productList);
		 Mockito.mock(PageRequest.class);
		 Pageable pageable = PageRequest.of(1, 7);
		 Mockito.when(productRepository.findAll(pageable)).thenReturn(pageList);
		 pageList = pServiceImpl.findAllProduct(1, 7);
		 assertEquals(7, pageList.getContent().size());
	}

	/**
	 * Test method for FindAllProduct() When product details get will return null
	 * list
	 * {@link com.hcl.ms.cat.serviceImpl.ProductServiceImpl#findAllProduct(int, int)}.
	 */
	@Test
	void testFindAllProductWhenFailure() {
		Mockito.mock(PageRequest.class);
		Pageable pageable = PageRequest.of(1, 7);
		Mockito.when(productRepository.findAll(pageable)).thenReturn(null);
		Throwable exception = assertThrows(ProductNotFoundException.class, () -> {
			pServiceImpl.findAllProduct(1, 7);
		});
		assertEquals(AppConstant.PRODUCT_NOT_AVAILABLE, exception.getMessage());
	}
}
