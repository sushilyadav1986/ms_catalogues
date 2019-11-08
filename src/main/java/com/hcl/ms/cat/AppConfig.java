package com.hcl.ms.cat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hcl.ms.cat.controller.validator.Validator;
import com.hcl.ms.cat.controller.validatorImpl.BusinessValidator;
import com.hcl.ms.cat.utils.ProductServiceImplUtils;
import com.hcl.ms.cat.utils.UserServiceImplUtils;


/**Create AppConfig class
 * Create Bean
 * @author SushilY
 *
 */
@Configuration
public class AppConfig {

	/**
	 * Creates a new instance of {@bean UserServiceImplUtils}.
	 */
	@Bean
	UserServiceImplUtils findUserServiceImplUtils() {
		return new UserServiceImplUtils();
	}
	
	/**
	 * Creates a new instance of {@bean ProductServiceImplUtils}.
	 */
	@Bean
	ProductServiceImplUtils findProductServiceImplUtils() {
		return new ProductServiceImplUtils();
	}
	/**
	 * Creates a new instance of {@bean BusinessValidator}.
	 */
	@Bean
	Validator findIValidator() {
		return new BusinessValidator();
	}
	
}
