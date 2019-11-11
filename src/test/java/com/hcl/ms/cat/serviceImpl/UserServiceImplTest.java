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
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.ms.cat.CatalogueMsApplication;
import com.hcl.ms.cat.entity.User;
import com.hcl.ms.cat.model.UserModel;
import com.hcl.ms.cat.repository.CatalogueRepository;
import com.hcl.ms.cat.repository.UserRepository;
import com.hcl.ms.cat.utils.test.JUnitUtlils;

/**
 * Create Test class for UserServiceImpl
 * 
 * @author SushilY
 *
 */
//@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = CatalogueMsApplication.class)
class UserServiceImplTest extends JUnitUtlils {

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
	void testSaveUserWhenSuccess() {
		User user = findUser();
		UserModel userModel=findUserModelWithUserId();		
		//Mockito.when(userRepository.save(user)).thenReturn(user);
		Mockito.when(catalogueRepository.save(user.getCatalogue())).thenReturn(user.getCatalogue());
		User user2= userServiceImpl.saveUser(userModel);
		assertEquals(user,user2);
	}
	
	@Test
	void testSaveUserWhenFailure() {
		User user = findUser();
		UserModel userModel=findUserModelWithUserId();		
		//Mockito.when(userRepository.save(user)).thenReturn(user);
		Mockito.when(catalogueRepository.save(user.getCatalogue())).thenReturn(user.getCatalogue());
		User user2 = userServiceImpl.saveUser(userModel);
		assertEquals(user,user2);
	}
}
