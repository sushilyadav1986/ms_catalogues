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

import com.hcl.ms.cat.controller.validator.Validator;
import com.hcl.ms.cat.model.NoObjRespnseModel;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.service.IUserService;

/**
 * Create UserController class Single point of content for All User related
 * operations
 * 
 * @author SushilY
 *
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	IUserService iUserService;

	@Autowired(required = true)
	Validator businessValidator;

	/**
	 * @param userModel
	 * @return
	 */
	@PostMapping("/addUser")
	public ResponseEntity<Object> saveUser(@RequestBody UserModel userModel) {
		ResponseEntity<Object> responseEntity = businessValidator.validUserDetails(userModel);
		if (responseEntity == null) {
			try {
				String insertedUserModel = iUserService.saveUser(userModel);
				return new ResponseEntity<Object>(new NoObjRespnseModel(true, insertedUserModel), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Object>(new NoObjRespnseModel(false, e.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return responseEntity;
		}
	}
}
