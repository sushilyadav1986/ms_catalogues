package com.hcl.ms.cat.service;

import com.hcl.ms.cat.entity.User;
import com.hcl.ms.cat.model.UserModel;

/**Create custom Interface
 * Communicate between Controller and Service
 * @author SushilY
 *
 */
public interface UserService {
	
	/**
	 * Saved User Details to respected Table
	 * @param userModel   // Set UserModel Details to save
	 * @return User		  // After saved return User from Table
	 * 
	 */
	public User saveUser(UserModel userModel);

}
