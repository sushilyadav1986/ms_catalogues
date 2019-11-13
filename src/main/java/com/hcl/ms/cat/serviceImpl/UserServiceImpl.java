package com.hcl.ms.cat.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.ms.cat.entity.User;
import com.hcl.ms.cat.exception.UserNotFoundException;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.repository.CatalogueRepository;
import com.hcl.ms.cat.repository.UserRepository;
import com.hcl.ms.cat.service.UserService;
import com.hcl.ms.cat.utils.AppConstant;

/**
 * Create Service class Single point of content for All User related operations
 * in DB
 * 
 * @author SushilY
 *
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

	/**
	 * Added repository to operate User related operation in DB
	 */
	@Autowired
	UserRepository userRepository;
	/**
	 * Added repository to operate Catalogue related operation in DB
	 */
	@Autowired
	CatalogueRepository catalogueRepository;

	/**
	 * This function is used to add User info in database... /** This function is
	 * used to save User details
	 * 
	 * 
	 * @param userModel // Set Product Details
	 * @return User // Return Action on DB
	 * @exception Exception // Exception If compiler goes to catch()
	 */
	@Override
	public User saveUser(UserModel userModel) {
		User user = null;
		user = userRepository.save(new User(userModel));
		if (user == null) {
			throw new UserNotFoundException(AppConstant.USER_DOES_NOT_ADDED);
		}
		user.getCatalogue().setName(user.getFirstName());
		catalogueRepository.save(user.getCatalogue());
		return user;
	}
}
