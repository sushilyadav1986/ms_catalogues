/**
 * 
 */
package com.hcl.ms.cat.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.ms.cat.CatalogueMsApplication;
import com.hcl.ms.cat.entity.Catalogue;
import com.hcl.ms.cat.entity.User;
import com.hcl.ms.cat.exception.UserNotFoundException;
import com.hcl.ms.cat.repository.CatalogueRepository;
import com.hcl.ms.cat.repository.UserRepository;
import com.hcl.ms.cat.utils.AppConstant;
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
		Catalogue catalogue=new Catalogue();
		Mockito.when(userRepository.save(user)).thenReturn(user);
		Mockito.when(catalogueRepository.save(catalogue)).thenReturn(user.getCatalogue());
		User user2= userServiceImpl.saveUser(user);
		assertEquals(user,user2);
	}
	
	@Test
	void testSaveUserWhenFailure() {
		User user = findUser();
		Mockito.when(userRepository.save(user)).thenReturn(null);
		Mockito.when(catalogueRepository.save(user.getCatalogue())).thenReturn(user.getCatalogue());
		Throwable exception = assertThrows(UserNotFoundException.class, () -> {
			userServiceImpl.saveUser(user);
		});
		assertEquals(AppConstant.USER_DOES_NOT_ADDED, exception.getMessage());
	}
}
