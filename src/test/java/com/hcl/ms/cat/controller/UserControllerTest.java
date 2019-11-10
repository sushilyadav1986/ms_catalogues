package com.hcl.ms.cat.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.hcl.ms.cat.CatalogueMsApplication;
import com.hcl.ms.cat.controller.validator.Validator;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.service.UserService;
import com.hcl.ms.cat.utils.AppConstant;
import com.hcl.ms.cat.utils.test.JUnitUtlils;

/**
 * Create UserControllerTest.class Test here UserController's function
 * 
 * @author SushilY
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = CatalogueMsApplication.class)
class UserControllerTest extends JUnitUtlils {

	@Mock
	UserService userService;
	
	@Mock
	Validator businessValidator;
	
	@InjectMocks
	UserController userController;

	/**
	 * Test User Details on saveUser() in Controller On success function will retrun
	 * 200 status
	 */
	@Test
	void testSaveUserWhenSuccess() {
		UserModel userModel = findDummyUserModel();
		Mockito.when(businessValidator.validUserDetails(userModel)).thenReturn(null);
		Mockito.when(userService.saveUser(userModel)).thenReturn(AppConstant.USER_ADDED_SUCCESSFULLY);
		ResponseEntity<Object> responseEntity=userController.saveUser(userModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
	}

	/**
	 * Test User Details on saveUser() in Controller On failure function will retrun
	 * 406 status
	 */
	@Test
	void testSaveUserWhenFailure() {
		ResponseEntity<Object> responseEntity=findResponseWithoutEmail();
		UserModel userModel = findDummyUserModelWithoutEmail();
		Mockito.when(businessValidator.validUserDetails(userModel)).thenReturn(responseEntity);
		ResponseEntity<Object> entity=userController.saveUser(userModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	void testSaveUserWhenException() {
		Throwable throwable=findException();
		UserModel userModel = findDummyUserModel();
		Mockito.when(businessValidator.validUserDetails(userModel)).thenReturn(null);
		Mockito.when(userService.saveUser(userModel)).thenThrow(throwable);
		ResponseEntity<Object> responseEntity=userController.saveUser(userModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
	}
}
