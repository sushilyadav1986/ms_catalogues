package com.hcl.ms.cat.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.ms.cat.entity.Product;
import com.hcl.ms.cat.entity.User;
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

	@Autowired
	ProductRepository productRepository;

	@Autowired
	UserRepository userRepository;

	/**
	 * This function is used to save Product details
	 * 
	 * 
	 * @param ProductModel // Set Product Details
	 * @return String // Return Action on DB
	 * @exception Exception // Exception If compiler goes to catch()
	 */

	@Override
	public Product saveProduct(ProductModel productModel) {
		Product product = new Product();
		try {
			product = productRepository.save(new Product(productModel));
			return product;
		} catch (Exception e) {
			e.getMessage();
			return product;
		}
	}

	/**
	 * This function is used to fetch Product details using product id...
	 * 
	 * 
	 * @param Product id // Set Product id
	 * @return ProductModel // ProductModel Details
	 * @exception Exception // Exception If compiler goes to catch()
	 */
	@Override
	public ProductModel findProductDetails(long productId) {
		try {
			Optional<Product> productOptional = productRepository.findById(productId);
			if (!productOptional.isPresent()) {
				return null;
			}
			Product product = productOptional.get();
			if (product != null) {
				return new ProductModel(product);
			} else {
				return null;
			}
		} catch (Exception e) {
			return new ProductModel();
		}
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
		try {
			User user = userRepository.findUserById(userId);
			if (user == null) {
				return null;
			} else {
				return productRepository.findByCatalogueCatIdOrderByNameAscPriceAsc(user.getCatalogue().getCatId());
				// serviceValidator.getAllProdModel();
			}
		} catch (Exception e) {
			return new ArrayList<Product>();
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
		try {
			boolean isExist = productRepository.existsById(productModel.getProductId());
			if (!isExist) {
				return AppConstant.PRODUCT_UPDATED_FAILED;
			} else {
				productRepository.save(new Product(productModel));
				return AppConstant.PRODUCT_UPDATED_SUCCESSFULLY;
			}
		} catch (Exception e) {
			return e.getMessage();
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
		try {
			productRepository.deleteById(productId);
			boolean isExist = productRepository.existsById(productId);
			if (!isExist) {
				return AppConstant.PRODUCT_DELETED;
			} else {
				return AppConstant.PRODUCT_NOT_DELETED;
			}
		} catch (Exception e) {
			return e.getMessage();
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
		try {
			Pageable pageable = PageRequest.of(pageNumber, noOfProducts);
			pageList = productRepository.findAll(pageable);
			return pageList;// serviceValidator.getAllProductByPageNumber(pageList);
		} catch (Exception e) {
			return pageList;
		}
	}

}
