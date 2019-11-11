package com.hcl.ms.cat.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.ms.cat.entity.User;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.repository.CatalogueRepository;
import com.hcl.ms.cat.repository.UserRepository;
import com.hcl.ms.cat.service.UserService;

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

	@Autowired
	UserRepository userRepository;

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
		User user = userRepository.save(new User(userModel));
		return user;
	}
}
