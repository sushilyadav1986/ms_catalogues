package com.hcl.ms.cat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.hcl.ms.cat.utils.AppConstant;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Create Class to run Application
 * Register Custom Bean
 * Enable Swagger
 * @author SushilY
 *
 */
@SpringBootApplication
@EnableSwagger2
public class CatalogueMsApplication {

	/**Main() need to call as first function for java compiler
	 * SpringApplication.run()will call first time to start Application
	 * Start CatalogMS Application  
	 * Initialize AnnotationConfigApplicationContext class to create bean
	 * Register Configuration classes
	 * Ignore warning if get at compile time using @SuppressWarnings()
	 * 
	 * @param args      //must not be {@literal null}.
	 */
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		SpringApplication.run(CatalogueMsApplication.class, args);
		AnnotationConfigApplicationContext annotationConfigAppC = new AnnotationConfigApplicationContext();
		annotationConfigAppC.register(AppConfig.class);
		annotationConfigAppC.refresh();
	}

	/**
	 * Create Swagger Set Details Using AppConstant class
	 * Use DocumentationType to set name and version and related Information
	 * @return Docket // Instance of Docket class
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(AppConstant.DEFAULT_API_INFO)
				.produces(AppConstant.DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(AppConstant.DEFAULT_PRODUCES_AND_CONSUMES);
	}

}
