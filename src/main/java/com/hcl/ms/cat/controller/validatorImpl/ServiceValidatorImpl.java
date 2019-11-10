package com.hcl.ms.cat.controller.validatorImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.hcl.ms.cat.controller.validator.ServiceValidator;
import com.hcl.ms.cat.entity.Product;
import com.hcl.ms.cat.model.ProductModel;

/**
 * Create Class ServiceValidatorImpl
 * Response as Utility for ServiceImpl classes
 * 
 * @author SushilY
 *
 */
public class ServiceValidatorImpl  implements ServiceValidator{

	
	/** Change Product list into ProductModel list
	 * 
	 * @param productList   // Set List of Product
	 * @return List			// Return List of ProductModel
	 */
	@Override
	public List<ProductModel> getAllProdModel(List<Product> productList) {
		List<ProductModel> prodModelList = new ArrayList<>();
		if (productList != null && !productList.isEmpty()) {
			for (Product product : productList) {
				prodModelList.add(new ProductModel(product));
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
	@Override
	public List<ProductModel> getAllProductByPageNumber(Page<Product> pageList){
		List<ProductModel> modelList= new ArrayList<ProductModel>();
		List<Product> noOfProdList = pageList.toList();
		if (noOfProdList != null && !noOfProdList.isEmpty()) {
			for (Product product : noOfProdList) {
				modelList.add(new ProductModel(product));
			}
			return modelList;
		} else {
			return null;
		}
	}
}
