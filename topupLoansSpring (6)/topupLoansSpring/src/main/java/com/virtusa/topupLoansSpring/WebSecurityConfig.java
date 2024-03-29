package com.virtusa.topupLoansSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
	
      @Autowired	
	  private UserDetailsService userDetailsService;
      
      @Override
      protected void configure(AuthenticationManagerBuilder auth) throws Exception
      {
    	  auth.userDetailsService(userDetailsService).passwordEncoder(encodePWD());
      }
	
//	  @Bean
//	  public AuthenticationProvider authProvider()
//	  {
//		  DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
//		  provider.setUserDetailsService(userDetailsService);
//		  provider.setPasswordEncoder(new BCryptPasswordEncoder());
//		  return provider;
//	  }
	  @Override
	  protected void configure(HttpSecurity http) throws Exception{
		  http
		      .csrf().disable()
		      .authorizeRequests().antMatchers("/login").permitAll()
		      .and()
		      .formLogin()
		      .loginPage("/login").permitAll();		      
	  }
	  @Bean
	  public BCryptPasswordEncoder encodePWD(){
		  return new BCryptPasswordEncoder();
	  }
}
