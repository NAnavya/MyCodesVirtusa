package org.vann.FourWheelerInsurance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.vann.FourWheelerInsurance.entities.Customer;
import org.vann.FourWheelerInsurance.exceptions.CustomerNotFoundException;
import org.vann.FourWheelerInsurance.model.ForgotPassword;
import org.vann.FourWheelerInsurance.repositories.CustomerRepository;

@Service
@Transactional
public class CustomerService
{

final private static org.apache.log4j.Logger log = org.apache.log4j.LogManager.getLogger(CustomerService.class);

@Autowired
private CustomerRepository customerRepo;

@Autowired
private PasswordEncoder passwordEncoder;

public Customer getCustomerById(int customerId) {
return customerRepo.findById(customerId).orElseThrow(()-> new CustomerNotFoundException("No customer found"));
}

public Customer getCustomerByUserName(String username) {
return customerRepo.findByUsername(username).orElseThrow(()-> new CustomerNotFoundException("customer Not found"));
}

public List<Customer> getCustomers(){
return customerRepo.findAll();
}

public void deleteCustomerById(int customerId) {
customerRepo.deleteById(customerId);
log.info("Customer with id"+customerId+"deleted Successfully");
}


public void updateCustomer(int id,Customer cust) {
Customer cust_temp = customerRepo.findById(id).orElseThrow(()-> new CustomerNotFoundException("Customer Has Not Found"));
cust_temp.setName(cust.getName());
cust_temp.setEmailId(cust.getEmailId());
cust_temp.setPhoneNumber(cust.getPhoneNumber());
cust_temp.setPassword(cust.getPassword());
//customerRepo.updateRoles(id, null);
customerRepo.save(cust_temp);
log.info(cust_temp.getUsername()+" Details Updated Successfully");
}

public void saveCustomer(Customer customer) {
customerRepo.save(customer);
log.info("Customer details saved successfully "+customer.getUsername());
}

public boolean verifyCustomerEmail(String emailId) {
Customer customer = customerRepo.findByEmailId(emailId);
if(customer != null) {
return true;
}
else {
return false;
}
}

public boolean resetPassword(ForgotPassword forgotPassword) {
Customer customer = this.getCustomerByUserName(forgotPassword.getUsername());
if(customer != null) {
customer.setPassword(passwordEncoder.encode(forgotPassword.getNewPassword()));
customerRepo.save(customer);
return true;
}
return false;
}
}