package org.vann.FourWheelerInsurance.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.vann.FourWheelerInsurance.entities.Customer;
import org.vann.FourWheelerInsurance.entities.Role;
import org.vann.FourWheelerInsurance.exceptions.CustomerAllReadyExistException;
import org.vann.FourWheelerInsurance.exceptions.CustomerNotFoundException;
import org.vann.FourWheelerInsurance.model.CustomerRequest;
import org.vann.FourWheelerInsurance.repositories.CustomerRepository;


@Service
@Transactional
public class CustomerAuthenticationService implements UserDetailsService
{

final private static org.apache.log4j.Logger log = org.apache.log4j.LogManager.getLogger(CustomerAuthenticationService.class);

@Autowired
private CustomerRepository customerRepo;

@Autowired
private PasswordEncoder passwordEncoder;

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

Customer customer = customerRepo.findByUsername(username).
orElseThrow(()-> new CustomerNotFoundException("Customer Not Found with the username "+username));
List<Role> roles = customer.getRoles()
.stream().toList();
List<GrantedAuthority> grantedAuthorities = roles.stream()
.map(role->{return new SimpleGrantedAuthority(role.getRoleName());
}).collect(Collectors.toCollection(ArrayList::new));
UserDetails userDetails = new User(username,customer.getPassword(),grantedAuthorities);
log.info("Customer with "+username+"is present");
return userDetails;
}

public void registerUser(CustomerRequest customerRequest) {
Optional<Customer> customer = customerRepo.findByUsername(customerRequest.getUsername());
if(customer.isPresent()) {
log.error("Customer with "+customerRequest.getUsername()+"Already Exist by Trying to Signup again");
throw new CustomerAllReadyExistException("User Already Exist");
}
Customer customer_temp = new Customer();
customer_temp.setName(customerRequest.getName());
customer_temp.setEmailId(customerRequest.getEmailId());
customer_temp.setPhoneNumber(customerRequest.getPhoneNumber());
customer_temp.setUsername(customerRequest.getUsername());
customer_temp.setPassword(passwordEncoder.encode(customerRequest.getPassword()));
customer_temp.setRoles(customerRequest.getRoles().stream().map(role->{
Role role_temp = new Role();
role_temp.setRoleName(role);
role_temp.setCustomer(customer_temp);
return role_temp;
}).collect(Collectors.toSet()));
log.info("Customer "+ customerRequest.getUsername()+"Registration is in progress");
customerRepo.save(customer_temp);
log.info(customer_temp.getUsername()+" Registered Successfully");
}
}