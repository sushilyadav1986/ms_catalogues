/**
 * 
 */
package com.hcl.ms.cat.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ms.cat.controller.validator.IValidator;
import com.hcl.ms.cat.model.NoObjRespnseModel;
import com.hcl.ms.cat.model.ResponseModel;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.service.IUserService;
import com.hcl.ms.cat.utils.AppConstant;

/**Create UserController class
 * Single point of content for All User related operations
 * @author SushilY
 *
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	IUserService iUserService; 
	
	@Autowired(required = true)
	IValidator businessValidator;
	
	/**
	 * @param userModel
	 * @return
	 */
	@PostMapping("/add_user")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody UserModel userModel) {
		try {
			
			UserModel insertedUserModel=iUserService.saveUser(userModel);
			if (insertedUserModel.getUserId()>0) {
				return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.USER_ADDED_SUCCESSFULLY, insertedUserModel), HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(new NoObjRespnseModel(true, AppConstant.USER_DOES_NOT_ADDED),
						HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(new NoObjRespnseModel(false, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
