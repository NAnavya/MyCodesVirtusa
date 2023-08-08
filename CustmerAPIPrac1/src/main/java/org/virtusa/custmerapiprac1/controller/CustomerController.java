package org.virtusa.custmerapiprac1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.virtusa.custmerapiprac1.entities.Customer;
import org.virtusa.custmerapiprac1.service.CustomerService;


//Optional datatype helps to handle the nullpointerexception and avoid abnormaltermination 
@RestController // It is the combination of controller and responsebody
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	//ResponseEntity is used to send the ressponse with the statuscode and payload
	@PostMapping(name="/customers")
	public ResponseEntity<?> insertCustomer(@RequestBody Customer customer){
		customerService.insertCustomer(customer);
		return new ResponseEntity<String>("Inserted Successfully",HttpStatus.CREATED);				
	}
	 @GetMapping("/customers")
	 public ResponseEntity<List<Customer>> getCustomers(){
		 List<Customer> customers=customerService.getCustomers();
		 return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	 }
	 @DeleteMapping(name="/customers/{cid}")
	 public ResponseEntity<?> deleteCustomer(@PathVariable("cid") int cid){
		 customerService.deleteCustomer(cid);
		 return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	 }
	 @PutMapping("/{cid}")
	 public ResponseEntity<?> updateCustomer(@RequestBody Customer customer,@PathVariable("cid") int cid ){
		 customerService.updateCustomer(cid, customer);
		 return new ResponseEntity<String>("Updated Successfully",HttpStatus.OK);
	 }
    @GetMapping("/customer/{cid}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("cid") int cid){
    	Customer customer=customerService.getCustomer(cid);
    	return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }
}
