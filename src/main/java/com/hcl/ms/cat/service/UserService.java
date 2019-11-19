package com.hcl.ms.cat.service;

import com.hcl.ms.cat.entity.User;

/**
 * Create custom Interface Communicate between Controller and Service
 * 
 * @author SushilY
 *
 */
public interface UserService {

	/**
	 * Saved User Details to respected Table
	 * 
	 * @param user // Set User Details to save
	 * @return User // After saved return User from Table
	 * 
	 */
	public User saveUser(User user);

}
