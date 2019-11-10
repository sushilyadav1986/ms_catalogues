/**
 * 
 */
package com.hcl.ms.cat.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.ms.cat.CatalogueMsApplication;
import com.hcl.ms.cat.entity.User;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.repository.CatalogueRepository;
import com.hcl.ms.cat.repository.UserRepository;
import com.hcl.ms.cat.utils.AppConstant;
import com.hcl.ms.cat.utils.ServiceImplUtils;
import com.hcl.ms.cat.utils.test.JUnitUtlils;

/**
 * Create Test class for UserServiceImpl
 * 
 * @author SushilY
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = CatalogueMsApplication.class)
class UserServiceImplTest extends JUnitUtlils {

	@InjectMocks
	ServiceImplUtils serviceImplUtils;

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
	void testSaveUser() {
		User user = findUser();
		UserModel userModel=findUserModelWithUserId();
		Mockito.when(userRepository.save(user)).thenReturn(user);
		Mockito.when(catalogueRepository.save(user.getCatalogue())).
		thenReturn(user.getCatalogue());
		Mockito.when( userServiceImpl.saveUser(userModel)).
		thenReturn(AppConstant.USER_ADDED_SUCCESSFULLY);
		String response = userServiceImpl.saveUser(userModel);
		assertEquals(AppConstant.USER_ADDED_SUCCESSFULLY,response);
	}
}
