package com.hcl.ms.cat.utils.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.ms.cat.model.NoObjRespnseModel;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.utils.AppConstant;

/**
 * JUnit Helper class for UserControllerTest
 *  
 * @author SushilY
 *
 */

public class UserControllerJUtils {
	
	/**
	 * @return
	 */
	public UserModel findDummyUserModel(){
		UserModel userModel=new UserModel("firstName", "lastName", "M", "test@gmail.com", 78940623145L);
		return userModel;
		
	}
	/**
	 * @return
	 */
	public UserModel findDummyUserModelWithoutEmail(){
		UserModel userModel=new UserModel("firstName", "lastName", "M", "", 78940623145L);
		return userModel;
	}
	
	/**
	 * @return
	 */
	public ResponseEntity<Object> findResponseWithoutEmail() {
		return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.ENTER_CORRECT_EMAIL),
				HttpStatus.OK);
	}
	
	/**
	 * @return
	 */
	public Throwable findException() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			throw new IllegalArgumentException("a message");
		});
		return exception;
	}
}
