package com.hcl.ms.cat.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hcl.ms.cat.entity.Product;
import com.hcl.ms.cat.entity.User;
import com.hcl.ms.cat.exception.ProductNotFoundException;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.repository.ProductRepository;
import com.hcl.ms.cat.repository.UserRepository;
import com.hcl.ms.cat.service.ProductService;
import com.hcl.ms.cat.utils.AppConstant;

/**
 * Create Service class Single point of content for All product related
 * operations in DB
 * 
 * @author SushilY
 *
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	/**
	 * Added repository to operate Product related operation in DB
	 */
	@Autowired
	ProductRepository productRepository;
	/**
	 * Added repository to operate User related operation in DB
	 */
	@Autowired
	UserRepository userRepository;

	/**
	 * This function is used to save Product details
	 * 
	 * 
	 * @param product // Set Product Details
	 * @return String // Return Action on DB Exception // Exception If compiler goes
	 *         to catch()
	 */

	@Override
	public Product saveProduct(Product product) {
		Product savedProduct = null;
		savedProduct = productRepository.save(product);
		if (savedProduct == null) {
			throw new ProductNotFoundException(AppConstant.PRODUCT_ADDED_FAILED);
		}
		return savedProduct;
	}

	/**
	 * This function is used to fetch Product details using product id...
	 * 
	 * 
	 * @param Product id // Set Product id
	 * @return ProductModel // ProductModel Details
	 * @exception Exception // Exception If compiler goes to catch()
	 */
	@ResponseStatus()
	@Override
	public Product findProductDetails(long productId) {
		Product product = null;
		Optional<Product> productOptional = productRepository.findById(productId);
		if (!productOptional.isPresent()) {
			throw new ProductNotFoundException("Product id not Found" + productId);
		}
		product = productOptional.get();
		return product;
	}

	/**
	 * This function is used to fetch all Product details using user id...
	 * 
	 * @param User id // Set User id
	 * @return ProductModel // ProductModel List<Product>
	 * @exception Exception // Exception If compiler goes to catch()
	 */
	@Override
	public List<Product> findAllProductListByUserId(long userId) {
		User user = userRepository.findUserById(userId);
		if (user == null) {
			throw new ProductNotFoundException("User id not Found" + userId);
		} else {
			return productRepository.findByCatalogueCatIdOrderByNameAscPriceAsc(user.getCatalogue().getCatId());
		}
	}

	/**
	 * This function is used to update Product details...
	 * 
	 * @param ProductModel // Set ProductModel Details
	 * @return ProductModel // ProductModel String As action on DB
	 * @exception Exception // Exception If compiler goes to catch()
	 */
	@Override
	public String updateProductDetails(ProductModel productModel) {
		boolean isExist = productRepository.existsById(productModel.getProductId());
		if (!isExist) {
			throw new ProductNotFoundException(AppConstant.PRODUCT_UPDATED_FAILED);
		} else {
			productRepository.save(new Product(productModel));
			return AppConstant.PRODUCT_UPDATED_SUCCESSFULLY;
		}
	}

	/**
	 * This function is used to delete Product details using product id... /**
	 * 
	 * @param ProductModel id // Set ProductModel id
	 * @return ProductModel // ProductModel String As action on DB
	 * @exception Exception // Exception If compiler goes to catch()
	 */
	@Override
	public String deleteByProductId(long productId) {
		productRepository.deleteById(productId);
		boolean isExist = productRepository.existsById(productId);
		if (!isExist) {
			return AppConstant.PRODUCT_DELETED;
		} else {
			throw new ProductNotFoundException(AppConstant.PRODUCT_NOT_DELETED);
		}
	}

	/**
	 * This function is used to get All Product details in respect of number of
	 * Products ...
	 * 
	 * @param PageModel Details // Set ProductModel id
	 * @return Page<Product> // Page<Product>
	 * @exception Exception // Exception If compiler goes to catch()
	 */
	@Override
	public Page<Product> findAllProduct(int pageNumber, int noOfProducts) {
		Page<Product> pageList = null;
		Pageable pageable = PageRequest.of(pageNumber, noOfProducts);
		pageList = productRepository.findAll(pageable);
		if (pageList == null) {
			throw new ProductNotFoundException(AppConstant.PRODUCT_NOT_AVAILABLE);
		}
		return pageList;
	}

}
