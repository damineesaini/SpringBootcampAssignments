package com.restApi2.RestfulWebServices2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;


import java.util.Locale;

@SpringBootApplication
public class RestfulWebServices2Application {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServices2Application.class, args);
	}

	@Bean
	public LocaleResolver localeResolver(){
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	/* Details about the questions structure
	* 	*Internationalization - Ques 1 and 2 done in Welcome package
	*	*Content Negotiation - Ques 3 and 4 done in ContentNegotiation package
	*	*Swagger - SwaggerConfig file, ques5 done in ContentNegotiation package UserController class.
	*	*Static and Dynamic filtering - Both questions done in Filtering package
	* 	*Versioning Restful APIs - both questions done in Versioning package
	* 	*HATEOAS - done in ContentNegotiation package in UserController class
	* */

}
