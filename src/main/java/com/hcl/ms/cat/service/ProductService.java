package com.hcl.ms.cat.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hcl.ms.cat.entity.Product;
import com.hcl.ms.cat.model.ProductModel;

/**Create custom Interface
 * Communicate between Controller and Service
 * 
 * @author SushilY
 *
 */
public interface ProductService {

	
	/**Save Product Details
	 * 
	 * @param product   // Get Product Details From Controller
	 * @return Product	// Return Product Details From DB
	 */
	Product saveProduct(Product product);
	
	/**Find Product Details using productId
	 * @param productId
	 * @return Product
	 */
	Product findProductDetails(long productId);

	/**Find Product Details List using userId
	 * @param userId
	 * @return List<Product>
	 */
	List<Product> findAllProductListByUserId(long userId);

	/**Update Product Details
	 * @param productModel
	 * @return String
	 */
	String updateProductDetails(ProductModel productModel);

	/**Delete Product Details using productId
	 * @param productId
	 * @return String
	 */
	String deleteByProductId(long productId);

	/**Find Product Details List in respect of Page number
	 * @param pageNumber
	 * @param noOfProducts
	 * @return Page<Product>
	 */
	Page<Product> findAllProduct(int pageNumber, int noOfProducts);

}
