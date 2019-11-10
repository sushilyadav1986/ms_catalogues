package com.hcl.ms.cat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hcl.ms.cat.controller.validator.ServiceValidator;
import com.hcl.ms.cat.controller.validator.Validator;
import com.hcl.ms.cat.controller.validatorImpl.BusinessValidator;
import com.hcl.ms.cat.controller.validatorImpl.ServiceValidatorImpl;


/**Create AppConfig class
 * Create Bean
 * @author SushilY
 *
 */
@Configuration
public class AppConfig {

	/**
	 * Creates a new instance of {@bean ServiceValidatorImpl}.
	 */
	@Bean
	ServiceValidator serviceValidator() {
		return new ServiceValidatorImpl();
	}
	/**
	 * Creates a new instance of {@bean BusinessValidator}.
	 */
	@Bean
	Validator validator() {
		return new BusinessValidator();
	}
	
}
