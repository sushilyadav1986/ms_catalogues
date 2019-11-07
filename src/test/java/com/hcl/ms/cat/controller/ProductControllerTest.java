/**
 * 
 */
package com.hcl.ms.cat.controller;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.hcl.ms.cat.model.PageModel;
import com.hcl.ms.cat.model.ProductModel;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.service.IProductService;
import com.hcl.ms.cat.utils.test.ProdControllerJUtil;

/**Create ProductControllerTest.class
 * Test here ProductController's function
 * @author SushilY
 *
 */
class ProductControllerTest extends ProdControllerJUtil{
	@Mock
	IProductService iProductService;

	@BeforeEach
	public void init() {
		super.init();
	}
	/**Save Product Details
	 * On success function will retrun 200 status
	 * Test method for {@link com.hcl.ms.cat.controller.ProductController#saveProduct(com.hcl.ms.cat.model.ProductModel)}.
	 */
	@Test
	void testSaveProduct() {
		String uri = "/product/add_product";
		ProductModel productModel = new ProductModel(12, "Lemon", 455.55, "dafkdasfadso", "H", 21);
		Mockito.when(iProductService.findProductDetails(Mockito.anyLong())).thenReturn(productModel);
		try {
			String inputJson = mapToJson(productModel);
			int status = callApi(inputJson, uri);
			assertEquals(200, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.hcl.ms.cat.controller.ProductController#findProductDetails(com.hcl.ms.cat.model.ProductModel)}.
	 */
	@Test
	void testFindProductDetails() {
		String uri = "/product/find_product_details";
		ProductModel productModel = new ProductModel(12, "Lemon", 455.55, "dafkdasfadso", "H", 21);
		Mockito.when(iProductService.findProductDetails(Mockito.anyLong())).thenReturn(productModel);
		try {
			String inputJson = mapToJson(productModel);
			int status = callApi(inputJson, uri);
			assertEquals(200, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.hcl.ms.cat.controller.ProductController#findAllProductListByUserId(com.hcl.ms.cat.model.UserModel)}.
	 */
	@Test
	void testFindAllProductListByUserId() {
		String uri = "/product/find_all_product_by_user_id";
		UserModel userModel=new UserModel("firstName", "lastName", "M", "test@gmail.com", 78940623145L);
		userModel.setUserId(1);
		ProductModel productModel = new ProductModel(12, "Lemon", 455.55, "dafkdasfadso", "H", 21);
		List<ProductModel>pModelList=new ArrayList<ProductModel>();
		pModelList.add(productModel);
		Mockito.when(iProductService.findAllProductListByUserId(Mockito.anyLong())).thenReturn(pModelList);
		try {
			String inputJson = mapToJson(userModel);
			int status = callApi(inputJson, uri);
			assertEquals(200, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.hcl.ms.cat.controller.ProductController#updateProductDetail(com.hcl.ms.cat.model.ProductModel)}.
	 */
	@Test
	void testUpdateProductDetail() {
		String uri = "/product/update_product_details";
		ProductModel productModel = new ProductModel(12, "Lemon", 455.55, "dafkdasfadso", "H", 21);
		Mockito.when(iProductService.updateProductDetails(productModel)).thenReturn(true);
		try {
			String inputJson = mapToJson(productModel);
			int status = callApi(inputJson, uri);
			assertEquals(200, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.hcl.ms.cat.controller.ProductController#deleteProductDetail(com.hcl.ms.cat.model.ProductModel)}.
	 */
	@Test
	void testDeleteProductDetail() {
		String uri = "/product/delete_by_product_id";
		ProductModel productModel = new ProductModel(12, "Lemon", 455.55, "dafkdasfadso", "H", 21);
		Mockito.when(iProductService.deleteByProductId(Mockito.anyLong())).thenReturn(true);
		try {
			String inputJson = mapToJson(productModel);
			int status = callApi(inputJson, uri);
			assertEquals(200, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.hcl.ms.cat.controller.ProductController#getPagination(com.hcl.ms.cat.model.PageModel)}.
	 */
	@Test
	void testGetPagination() {
		String uri = "/product/get_by_pagination";
		PageModel pageModel=new PageModel();
		pageModel.setPageNumber(1);
		pageModel.setNoOfProducts(3);
		ProductModel productModel1 = new ProductModel(13, "Lemon", 454.56, "description", "H", 20);
		ProductModel productModel2 = new ProductModel(14, "Lemon1", 456.68, "description1", "L", 21);
		ProductModel productModel3 = new ProductModel(15, "Lemon2", 985.55, "description2", "O", 22);
		List<ProductModel>pModelList=new ArrayList<>();
		pModelList.add(productModel1);
		pModelList.add(productModel2);
		pModelList.add(productModel3);
		Mockito.when(iProductService.findAllProduct(Mockito.anyInt(),Mockito.anyInt())).thenReturn(pModelList);
		try {
			String inputJson = mapToJson(pageModel);
			int status = callApi(inputJson, uri);
			assertEquals(200, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
