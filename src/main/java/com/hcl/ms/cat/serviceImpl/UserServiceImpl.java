package com.hcl.ms.cat.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.ms.cat.entity.User;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.repository.CatalogueRepository;
import com.hcl.ms.cat.repository.UserRepository;
import com.hcl.ms.cat.service.IUserService;
import com.hcl.ms.cat.utils.UserServiceImplUtils;

/**Create Service class
 * Single point of content for All User related operations in DB
 * @author SushilY
 *
 */

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired(required=true)
	UserServiceImplUtils userServiceImplUtils;

	@Autowired
	CatalogueRepository catalogueRepository;

	/**
	 * This function is used to add User info in database...
	 */
	@Override
	public UserModel saveUser(UserModel userModel) {
		// TODO Auto-generated method stub
		User user = userServiceImplUtils.getUser(userModel);		
		user=userRepository.save(user);
		user.setCatalogue(catalogueRepository.save(user.getCatalogue()));
		user.getCatalogue().setName(user.getFirstName());
		
		userModel=user.getUserModel();
		return userModel;
	}
}
