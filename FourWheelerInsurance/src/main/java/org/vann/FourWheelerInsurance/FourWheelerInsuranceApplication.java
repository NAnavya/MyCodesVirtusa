package org.vann.FourWheelerInsurance;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.vann.FourWheelerInsurance.entities.Role;
import org.springframework.stereotype.Component;
import org.vann.FourWheelerInsurance.entities.Customer;
import org.vann.FourWheelerInsurance.repositories.CustomerRepository;


@SpringBootApplication
public class FourWheelerInsuranceApplication {
	@Bean
	ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

	final private static org.apache.log4j.Logger log = org.apache.log4j.LogManager
			.getLogger(FourWheelerInsuranceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FourWheelerInsuranceApplication.class, args);
		log.info("Application Started Successfully");
	}

}
@Component

class AdminCreate implements CommandLineRunner{
  @Autowired private CustomerRepository custrep;
  @Autowired private PasswordEncoder passwordEncoder;
  @Override
  public void run(String... args)throws Exception
  {        Set<Role> a=new HashSet<Role>();
         
	  Customer first=new Customer();
	  first.setId(1);
	  first.setName("Admin");
	  first.setPassword(passwordEncoder.encode("Admin@123"));
	  first.setEmailId("Admin@gmail.com");
	  first.setPhoneNumber(987589545);
	  first.setRoles(a);
	  first.setUsername("Admin");
	  
      Role frole=new Role(1,"ADMIN",first);
      
      a.add(frole);

     
      custrep.save(first);
     
  }}

