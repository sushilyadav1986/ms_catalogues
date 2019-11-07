/**
 * 
 */
package com.hcl.ms.cat.utils;

import com.hcl.ms.cat.entity.Catalogue;
import com.hcl.ms.cat.entity.User;
import com.hcl.ms.cat.model.UserModel;

/**
 * Create UserServiceImplUtils.class Helper for UserServiceImpl
 * 
 * @author SushilY
 *
 */
public class UserServiceImplUtils {

	/**
	 * @param userModel
	 */
	public User getUser(UserModel userModel) {
		User user = new User();
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setGender(userModel.getGender());
		user.setContactNumber(userModel.getContactNumber());
		user.setEmail(userModel.getEmail());
		user.setCatalogue(new Catalogue());
		return user;
	}

}
