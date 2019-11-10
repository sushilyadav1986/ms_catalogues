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
import com.hcl.ms.cat.utils.ServiceImplUtils;

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

	@Autowired(required = true)
	ServiceImplUtils serviceImplUtils;
	@Autowired
	ProductRepository productRepository;

	@Autowired
	UserRepository userRepository;

	/**
	 * This function is used to save Product details
	 */
	@Override
	public String saveProduct(ProductModel productModel) {
		try {
			Product product = productRepository.save(serviceImplUtils.getProduct(productModel));
			productModel = serviceImplUtils.getProductModel(product);
			if (productModel.getProductId() > 0) {
				return AppConstant.PRODUCT_ADDED_SUCCESSFULLY;
			} else {
				return AppConstant.PRODUCT_DOES_NOT_ADDED;
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * This function is used to get Product details using product id...
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
				return product.getModel();
			} else {
				return null;
			}

		} catch (Exception e) {
			return new ProductModel();
		}
	}

	/**
	 * This function is used to get List of Product details using user id...
	 */
	@Override
	public List<ProductModel> findAllProductListByUserId(long userId) {
		List<Product> pList = new ArrayList<Product>();
		try {
			User user = userRepository.findUserById(userId);
			if (user == null) {
				return null;
			} else {
				pList = productRepository.findByCatalogueCatIdOrderByNameAscPriceAsc(user.getCatalogue().getCatId());
				return serviceImplUtils.getAllProdModel(pList);
			}
		} catch (Exception e) {
			return new ArrayList<ProductModel>();
		}
	}

	/**
	 * This function is used to update Product details...
	 */
	@Override
	public String updateProductDetails(ProductModel productModel) {
		try {
			Optional<Product> productOptional = productRepository.findById(productModel.getProductId());
			if (!productOptional.isPresent()) {
				return AppConstant.PRODUCT_UPDATED_FAILED;
			} else {
				Product product = productOptional.get();
				product = serviceImplUtils.getProduct(productModel);
				productRepository.save(product);
				return AppConstant.PRODUCT_UPDATED_SUCCESSFULLY;
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * This function is used to delete Product details using product id...
	 */
	@Override
	public String deleteByProductId(long productId) {
		try {
			productRepository.deleteById(productId);
			Optional<Product> productOptional = productRepository.findById(productId);
			if (!productOptional.isPresent()) {
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
	 */
	@Override
	public List<ProductModel> findAllProduct(int pageNumber, int noOfProducts) {
		try {
			Pageable pageable = PageRequest.of(pageNumber, noOfProducts);
			Page<Product> pageList = productRepository.findAll(pageable);
			return serviceImplUtils.getAllProductByPageNumber(pageList);
		} catch (Exception e) {
			return new ArrayList<ProductModel>();
		}
	}

}
