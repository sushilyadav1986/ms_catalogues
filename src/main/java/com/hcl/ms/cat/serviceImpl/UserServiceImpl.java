package com.hcl.ms.cat.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.ms.cat.entity.User;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.repository.CatalogueRepository;
import com.hcl.ms.cat.repository.UserRepository;
import com.hcl.ms.cat.service.UserService;
import com.hcl.ms.cat.utils.AppConstant;
import com.hcl.ms.cat.utils.ServiceImplUtils;

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

	@Autowired(required = true)
	ServiceImplUtils serviceImplUtils;

	@Autowired
	CatalogueRepository catalogueRepository;

	/**
	 * This function is used to add User info in database... /** This function is
	 * used to save User details
	 * 
	 * 
	 * @param ProductModel // Set Product Details
	 * @return String // Return Action on DB
	 * @exception Exception // Exception If compiler goes to catch()
	 */
	@Override
	public String saveUser(UserModel userModel) {
		// User user = new User(userModel);
		User user = userRepository.save(new User(userModel));
		if (user.get_id() > 0) {
			user.setCatalogue(catalogueRepository.save(user.getCatalogue()));
			user.getCatalogue().setName(user.getFirstName());
			return AppConstant.USER_ADDED_SUCCESSFULLY;
		} else {
			return AppConstant.USER_DOES_NOT_ADDED;
		}
	}
}
