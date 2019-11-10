package com.hcl.ms.cat.controller.validator;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hcl.ms.cat.entity.Product;
import com.hcl.ms.cat.model.ProductModel;

public interface ServiceValidator {
	
	public List<ProductModel> getAllProdModel(List<Product> productList);
	
	public List<ProductModel> getAllProductByPageNumber(Page<Product> pageList);

}
