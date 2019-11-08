package com.hcl.ms.cat.service;

import java.util.List;

import com.hcl.ms.cat.model.ProductModel;

/**Create custom Interface
 *  Communicate between Controller and Service
 * @author SushilY
 *
 */
public interface ProductService {

	
	/**
	 * @param productModel
	 * @return ProductModel
	 */
	String saveProduct(ProductModel productModel);
	/**
	 * @param productId
	 * @return
	 */
	ProductModel findProductDetails(long productId);

	/**
	 * @param userId
	 * @return
	 */
	List<ProductModel> findAllProductListByUserId(long userId);

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
	List<ProductModel> findAllProduct(int pageNumber, int noOfProducts);

}
