package com.hcl.ms.cat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hcl.ms.cat.controller.validator.Validator;
import com.hcl.ms.cat.controller.validatorImpl.BusinessValidator;
import com.hcl.ms.cat.utils.ServiceImplUtils;


/**Create AppConfig class
 * Create Bean
 * @author SushilY
 *
 */
@Configuration
public class AppConfig {

	/**
	 * Creates a new instance of {@bean ServiceImplUtils}.
	 */
	@Bean
	ServiceImplUtils findServiceImplUtils() {
		return new ServiceImplUtils();
	}
	/**
	 * Creates a new instance of {@bean BusinessValidator}.
	 */
	@Bean
	Validator findIValidator() {
		return new BusinessValidator();
	}
	
}
