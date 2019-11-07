package com.hcl.ms.cat.service;

import java.util.List;

import com.hcl.ms.cat.model.ProductModel;

/**Create custom Interface
 *  Communicate between Controller and Service
 * @author SushilY
 *
 */
public interface IProductService {

	
	/**
	 * @param productModel
	 * @return ProductModel
	 */
	ProductModel saveProduct(ProductModel productModel);
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
	boolean updateProductDetails(ProductModel productModel);

	/**
	 * @param productId
	 * @return
	 */
	boolean deleteByProductId(long productId);

	/**
	 * @param pageNumber
	 * @param noOfProducts
	 * @return
	 */
	List<ProductModel> findAllProduct(int pageNumber, int noOfProducts);

}
