/**
 * 
 */
package com.hcl.ms.cat.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.hcl.ms.cat.entity.Catalogue;
import com.hcl.ms.cat.entity.User;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.repository.CatalogueRepository;
import com.hcl.ms.cat.repository.UserRepository;
import com.hcl.ms.cat.utils.UserServiceImplUtils;

/**
 * Create Test class for UserServiceImpl
 * 
 * @author SushilY
 *
 */
class UserServiceImplTest {

	@Mock
	UserServiceImplUtils userServiceImplUtils;

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Mock
	UserRepository userRepository;

	@Mock
	CatalogueRepository catalogueRepository;

	/**
	 * Initialize Mockito
	 */
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test method for
	 * {@link com.hcl.ms.cat.serviceImpl.UserServiceImpl#addUser(com.hcl.ms.cat.model.UserModel)}.
	 */

	@Test
	void testAddUser() {
		UserModel userModel = findDummyUserModel();
		User user = findDummyUser();
		Mockito.when(userServiceImplUtils.getUser(userModel)).thenReturn(user);
		Mockito.when(userRepository.save(user)).thenReturn(user);
		Mockito.when(catalogueRepository.save(user.getCatalogue())).thenReturn(user.getCatalogue());
		UserModel userModelResponse = userServiceImpl.saveUser(userModel);
		assertEquals(user.get_id(), userModelResponse.getUserId());
	}

	private UserModel findDummyUserModel() {
		UserModel userModel = new UserModel("umesh", "", "", "", 4465656L);
		return userModel;
	}

	private User findDummyUser() {
		User user = new User();
		Catalogue catalogue = new Catalogue();
		user.set_id(1);
		user.setFirstName("Test");
		catalogue.setCatId(1);
		user.setCatalogue(catalogue);
		return user;
	}

}
