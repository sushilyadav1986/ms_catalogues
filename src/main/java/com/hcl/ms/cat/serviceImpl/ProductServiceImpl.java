package com.hcl.ms.cat.serviceImpl;

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
import com.hcl.ms.cat.utils.ProductServiceImplUtils;

/**Create Service class
 * Single point of content for All product related operations in DB
 * @author SushilY
 *
 */
@Service
@Transactional
public class ProductServiceImpl  implements ProductService {

	@Autowired(required = true)
	ProductServiceImplUtils productServiceImplUtils;
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserRepository userRepository;
	

	/**
	 * This function is used to save Product details
	 */
	@Override
	public String saveProduct(ProductModel productModel) {
		Product product=productRepository.save(productServiceImplUtils.getProduct(productModel));
		productModel=productServiceImplUtils.getProductModel(product);
		if(productModel.getProductId()>0) {
			return AppConstant.SUCCESS;
		}
		else {
			return null;
		}
	}

	/**
	 * This function is used to get Product details using product id...
	 */
	@Override
	public ProductModel findProductDetails(long productId) {
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
	}

	/**
	 * This function is used to get List of Product details using user id...
	 */
	@Override
	public List<ProductModel> findAllProductListByUserId(long userId) {
		User user = userRepository.findUserById(userId);
		if (user == null) {
			return null;
		} else {
			List<Product> pList = productRepository.findByCatalogueCatIdOrderByNameAscPriceAsc(user.getCatalogue().getCatId());
			return productServiceImplUtils.getAllProdModel(pList);
		}
	}

	/**
	 * This function is used to update Product details...
	 */
	@Override
	public String updateProductDetails(ProductModel productModel) {
		Optional<Product> productOptional = productRepository.findById(productModel.getProductId());
		if (!productOptional.isPresent()) {
			return AppConstant.PRODUCT_UPDATED_FAILED;
		} else {
			Product product = productOptional.get();
			product=productServiceImplUtils.getProduct(productModel);
			productRepository.save(product);
			return AppConstant.PRODUCT_UPDATED_SUCCESSFULLY;
		}
	}

	/**
	 * This function is used to delete Product details using product id...
	 */
	@Override
	public String deleteByProductId(long productId) {
		productRepository.deleteById(productId);
		Optional<Product> productOptional = productRepository.findById(productId);
		if (!productOptional.isPresent()) {
			return "Product successfully deleted";
		} else {
			return "Product can not delete. Please try again.";
		}
	}

	/**
	 * This function is used to get All Product details in respect of number of
	 * Products ...
	 */
	@Override
	public List<ProductModel> findAllProduct(int pageNumber, int noOfProducts) {
		Pageable pageable = PageRequest.of(pageNumber, noOfProducts);
		Page<Product> pageList = productRepository.findAll(pageable);
		return productServiceImplUtils.getAllProductByPageNumber(pageList);
	}

}
