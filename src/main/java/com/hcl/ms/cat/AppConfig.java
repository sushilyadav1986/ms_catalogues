package com.hcl.ms.cat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hcl.ms.cat.controller.validator.IValidator;
import com.hcl.ms.cat.controller.validatorImpl.BusinessValidator;
import com.hcl.ms.cat.utils.ProductServiceImplUtils;
import com.hcl.ms.cat.utils.UserServiceImplUtils;


/** Create AppConfig class
 * Create Bean
 * @author SushilY
 *
 */
@Configuration
public class AppConfig {

	/**
	 * create UserServiceImplUtils bean
	 * @return
	 */
	@Bean
	UserServiceImplUtils findUserServiceImplUtils() {
		return new UserServiceImplUtils();
	}
	
	/**
	 * create ProductServiceImplUtils bean
	 * @return
	 */
	@Bean
	ProductServiceImplUtils findProductServiceImplUtils() {
		return new ProductServiceImplUtils();
	}
	
	@Bean
	IValidator findIValidator() {
		return new BusinessValidator();
	}
	
}
