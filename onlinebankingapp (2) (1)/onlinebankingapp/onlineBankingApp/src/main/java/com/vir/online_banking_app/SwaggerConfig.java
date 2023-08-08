package com.vir.online_banking_app;

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
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket employeeApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("OnlineBanking").select()
				.apis(RequestHandlerSelectors.basePackage("com.vir.online_banking_app.controller")).build();
	}

	private ApiInfo apiInfo() {
		String s = "http://fakeapi.com";
		return new ApiInfoBuilder().title("Online Banking Api").description("Online Banking Api").termsOfServiceUrl(s)
				.contact(new Contact("Online Banking API", s, "fake@gmail.com")).license("Online Banking Licence")
				.licenseUrl(s).build();
	}
}
