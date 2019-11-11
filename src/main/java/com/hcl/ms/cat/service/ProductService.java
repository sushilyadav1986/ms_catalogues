package com.hcl.ms.cat.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hcl.ms.cat.entity.Product;
import com.hcl.ms.cat.model.ProductModel;

/**Create custom Interface
 *  Communicate between Controller and Service
 * @author SushilY
 *
 */
public interface ProductService {

	
	/**
	 * @param productModel
	 * @return Product
	 */
	Product saveProduct(ProductModel productModel);
	/**
	 * @param productId
	 * @return
	 */
	ProductModel findProductDetails(long productId);

	/**
	 * @param userId
	 * @return
	 */
	List<Product> findAllProductListByUserId(long userId);

	/**
	 * @param productModel
	 * @return
	 */
	String updateProductDetails(ProductModel productModel);

	/**
	 * @param productId
	 * @return
	 */
	String deleteByProductId(long productId);

	/**
	 * @param pageNumber
	 * @param noOfProducts
	 * @return
	 */
	Page<Product> findAllProduct(int pageNumber, int noOfProducts);

}
