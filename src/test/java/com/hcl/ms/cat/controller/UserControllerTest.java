package com.hcl.ms.cat.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.service.IUserService;
import com.hcl.ms.cat.utils.test.UserControllerJUnit;

/**
 * Create UserControllerTest.class Test here UserController's function
 * 
 * @author SushilY
 *
 */
class UserControllerTest extends UserControllerJUnit {

	@Mock
	IUserService iUserService;

	@BeforeEach
	public void init() {
		super.init();
		
	}

	/**
	 * Test User Details on saveUser() in Controller On success function will retrun
	 * 200 status
	 */
	@Test
	void testOnSuccessSaveUser() {
		String uri = "/user/add_user";
		UserModel userModel = findDummyUserModel();
		userModel.setUserId(1);
		Mockito.when(iUserService.saveUser(userModel)).thenReturn(userModel);
		try {
			String inputJson = mapToJson(userModel);
			int status = callApi(inputJson, uri);
			assertEquals(200, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test User Details on saveUser() in Controller On failure function will retrun
	 * 406 status
	 */
	@Test
	void testOnFailureSaveUser() {
		String uri = "/user/add_user";
		UserModel userModel=findDummyUserModel();
		UserModel userEmptyModel = findDummyEmptyUserModel();
		Mockito.when(iUserService.saveUser(userModel)).thenReturn(userEmptyModel);
		try {
			String inputJson = mapToJson(userEmptyModel);
			int status = callApi(inputJson, uri);
			assertEquals(200, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int callApi(String inputJson, String url) {
		int status = 0;
		try {
			MvcResult mvcResult = mvc.perform(
					MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
					.andReturn();
			status = mvcResult.getResponse().getStatus();
			return status;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return status;
		}
	}
}
