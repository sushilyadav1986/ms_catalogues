package com.hcl.ms.cat.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.hcl.ms.cat.entity.Catalogue;
import com.hcl.ms.cat.entity.Product;
import com.hcl.ms.cat.model.ProductModel;

/**
 * Create ProductServiceImplUtils.class Helper for ProductServiceImpl
 * 
 * @author SushilY
 *
 */
public class ProductServiceImplUtils {

	/** Change ProductModel object into Product
	 * @param productModel
	 * @return Product
	 */
	public Product getProduct(ProductModel productModel) {
//		Product product = new Product(productModel);
		Product product = new Product();
		product.setProdId(productModel.getProductId());
		product.setAvailability(productModel.getProductAvailability());
		product.setDescription(productModel.getProductDescription());
		product.setName(productModel.getProductName());
		product.setPrice(productModel.getProductPrice());
		product.setCatalogue(new Catalogue());
		product.getCatalogue().setCatId(productModel.getCatalogueId());
		return product;
	}

	/** Change Product object into ProductModel
	 * @param product
	 * @return ProductModel
	 */
	public ProductModel getProductModel(Product product) {
		ProductModel productModel = new ProductModel(product.getProdId(), product.getName(), product.getPrice(),
				product.getDescription(), product.getAvailability(), product.getCatalogue().getCatId());
		return productModel;
	}
	/** Change Product list into ProductModel list
	 * 
	 * @param pageList
	 * @return List
	 */
	public List<ProductModel> getAllProdModel(List<Product> productList) {
		List<ProductModel> prodModelList = new ArrayList<>();
		if (productList != null && !productList.isEmpty()) {
			for (Product product : productList) {
				prodModelList.add(product.getModel());
			}
			return prodModelList;
		} else {
			return null;
		}
	}
	
	/** Change Product list into ProductModel list
	 * 
	 * @param pageList
	 * @return List
	 */
	public List<ProductModel> getAllProductByPageNumber(Page<Product> pageList){
		List<ProductModel> modelList= new ArrayList<ProductModel>();
		List<Product> noOfProdList = pageList.toList();
		if (noOfProdList != null && !noOfProdList.isEmpty()) {
			for (Product product : noOfProdList) {
				modelList.add(product.getModel());
			}
			return modelList;
		} else {
			return null;
		}
	}
}
