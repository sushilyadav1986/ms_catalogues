package com.hcl.ms.cat.service;

import com.hcl.ms.cat.model.UserModel;

/**Create custom Interface
 *  Communicate between Controller and Service
 * @author SushilY
 *
 */
public interface UserService {
	
	
	/**
	 * @param userModel
	 * @return 
	 */
	public String saveUser(UserModel userModel);

}
