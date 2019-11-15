package com.hcl.ms.cat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hcl.ms.cat.validator.Validator;
import com.hcl.ms.cat.validatorImpl.BusinessValidator;


/**Create AppConfig class
 * Create Bean
 * @author SushilY
 *
 */
@Configuration
public class AppConfig {

	
	/**
	 * Creates a new instance of {@bean BusinessValidator}.
	 */
	@Bean
	Validator validator() {
		return new BusinessValidator();
	}
	
}
