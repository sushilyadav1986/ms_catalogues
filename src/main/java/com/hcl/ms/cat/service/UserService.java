package com.hcl.ms.cat.service;

import com.hcl.ms.cat.model.UserModel;

/**Create custom Interface
 *  Communicate between Controller and Service
 * @author SushilY
 *
 */
public interface UserService {
	
	
	/**
	 * Saved User Details to respected Table
	 */
	public String saveUser(UserModel userModel);

}
