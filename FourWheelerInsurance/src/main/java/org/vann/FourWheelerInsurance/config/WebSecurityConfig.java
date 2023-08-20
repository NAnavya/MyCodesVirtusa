package org.vann.FourWheelerInsurance.config;

 

import java.util.Arrays;
import java.util.Collections;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.RegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.vann.FourWheelerInsurance.filter.JwtAuthenticationFilter;
import org.vann.FourWheelerInsurance.services.CustomerAuthenticationService;

 

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

 

//implementation class of UserDetailsService which get the user details from database.
    @Autowired
    private CustomerAuthenticationService customerAuthenticationService;

 

//JwtAuthentication Filter class is used to validate the customer request and by validating the token.
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

 

//this method used to configure the userDetailsService and also PasswordEncoder for the Authentication Manager
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerAuthenticationService).passwordEncoder(passwordEncoder());
    }

 

//BCryptPasswordEncoder object is returned by this method.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

 

//Authentication Manager object is created and returned by this method which is used to perform authentication.
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

 

//This  Method is used to configure security for the Httprequest i.e URLs
//This method is also adds JwtAuthenticationFilter to this application.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests().antMatchers("/signup", "/signin","/swagger-ui/**").permitAll()
                .anyRequest().authenticated();
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

 

//This method is used to ignore the below signup and signin URLS from moving into filters and security layer
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/signup", "/signin", "/verify-customer-email", "/reset-password","/swagger-ui/**");
    }

 

//used to register the filter
    @Bean
    public RegistrationBean jwtAuthFilterRegister(JwtAuthenticationFilter filter) {
        FilterRegistrationBean<JwtAuthenticationFilter> registrationBean = new FilterRegistrationBean<JwtAuthenticationFilter>(
                filter);
        registrationBean.setEnabled(false);
        return registrationBean;
    }

 

//used to enable cross origin Request
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Jwt-Token", "Authorization", "Origin,Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token",
                "Authorization", "Access-Control-Allow-Origin2", "Access-Control-Allow-Origin3",
                "Access-Controll-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}