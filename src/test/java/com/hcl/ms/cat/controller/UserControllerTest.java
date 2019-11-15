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
import com.hcl.ms.cat.entity.User;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.service.UserService;
import com.hcl.ms.cat.utils.test.JUnitUtlils;
import com.hcl.ms.cat.validator.Validator;

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
	 * Test User Details on saveUser() in Controller On save function will retrun
	 * 201 status if get success
	 */
	@Test
	void testSaveUserWhenSuccess() {
		UserModel userModel = findUserModel();
		ResponseEntity<Object> responseEntity=findResponseOnSavedUser();
		User user=findUser();
		Mockito.when(businessValidator.hasSavedUser(user)).thenReturn(responseEntity);
		Mockito.when(businessValidator.validUserDetails(userModel)).thenReturn(null);
		Mockito.when(userService.saveUser(userModel)).thenReturn(user);
		responseEntity=userController.saveUser(userModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
	}

	/**
	 * Test User Details on saveUser() in Controller On save function will return
	 * 200 status if get failure
	 * 
	 */
	@Test
	void testSaveUserWhenFailure() {
		ResponseEntity<Object> responseEntity=findResponseWithoutEmail();
		UserModel userModel = findUserModelWithoutEmail();
		Mockito.when(businessValidator.validUserDetails(userModel)).thenReturn(responseEntity);
		ResponseEntity<Object> entity=userController.saveUser(userModel);
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}
	/**
	 * Test User Details on saveUser() in Controller On save function will return
	 * 500 status if get any exception
	 * 
	 */
	@Test
	void testSaveUserWhenException() {
		Throwable throwable=findException();
		UserModel userModel = findUserModel();
		ResponseEntity<Object> responseEntity=findResponseOnSavedUser();
		Mockito.when(businessValidator.validUserDetails(userModel)).thenReturn(null);
		Mockito.when(userService.saveUser(userModel)).thenThrow(throwable);
		responseEntity=userController.saveUser(userModel);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
	}
}
