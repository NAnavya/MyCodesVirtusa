package org.virtusa.custmerapiprac1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 //first add swagger2 ,swagger-ui maven dependency
public class SwaggerConfig {

	//Docket bean is a class which is used to provide documentation for RestAPI
	@Bean
	public Docket customerApi() {
		Docket docket=new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.select().apis(RequestHandlerSelectors.basePackage("org.virtusa.custmerapiprac1.controller"))
				.build();
		return docket;
	}
	private ApiInfo apiInfo() {
		ApiInfo apiInfo=new ApiInfoBuilder().description("Customer Api")
				.contact(new Contact("Customer Api","http://www.customerapi.com","customerapi@gmail.com"))
	            .license("Customer License").licenseUrl("http://www.customerapi.com")
	            .build();
		return apiInfo;
	}
}
