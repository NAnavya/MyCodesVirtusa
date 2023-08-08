package com.virtusa.topupLoansSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

 

 

// It is must to add the mvc match pattern in properties.file
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket employeeApi() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("Employee Group")
                .select().apis(RequestHandlerSelectors.basePackage("com.virtusa.topupLoansSpring.controller"))
                .build();
        return docket;

    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Employee Api")
                .description("Employee Management Api")
                .termsOfServiceUrl("http://fakeapi.com")
                .contact(new Contact("Employee API", "http://fakeapi.com", "fake@gmail.com"))
                .license("Employee Licence")
                .licenseUrl("http://fakeapi.com")
                .build();
    }
}
