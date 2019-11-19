/**
 * 
 */
package com.hcl.ms.cat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ms.cat.entity.User;
import com.hcl.ms.cat.model.ObjectResponse;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.service.UserService;
import com.hcl.ms.cat.validator.Validator;

/**
 * UserController class containing end-points for general product operations
 * like add, UPDATE, DELETE, FETCH
 * 
 * @author SushilY
 *
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {
	/**
	 * Initialize Obj to call service function to use data from DB
	 */
	@Autowired
	UserService userService;

	/**
	 * Initialize Obj to validate data  
	 */
	@Autowired(required = true)
	Validator businessValidator;

	/**
	 * Save User Details 
	 * 
	 * @param userModel 			// Set User Details
	 * @return ResponseEntity     	// Return String as action on DB 
	 * Exception     	// Exception If JsonObject not proper
	 */
	@PostMapping("/addUser")
	public ResponseEntity<Object> saveUser(@RequestBody UserModel userModel) {
		ResponseEntity<Object> responseEntity = businessValidator.validUserDetails(userModel);
		if (responseEntity == null) {
			try {
				User savedUser = userService.saveUser(businessValidator.fromUserModel(userModel));
				ResponseEntity<Object> isSavedEntity=businessValidator.hasSavedUser(savedUser);
				return isSavedEntity;
			} catch (Exception e) {
				return new ResponseEntity<Object>(new ObjectResponse(false, e.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return responseEntity;
		}
	}
}
