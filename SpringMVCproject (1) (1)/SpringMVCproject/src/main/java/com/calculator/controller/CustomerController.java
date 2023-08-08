package com.calculator.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.calculator.model.CustomerModel;
import com.calculator.model.LoginModel;
import com.calculator.service.CustomerService;
import com.calculator.dto.CustomerDto;

@Controller
public class CustomerController {

	private static final String COMMAND = "command";
	Logger logger = Logger.getLogger(CustomerController.class.getName());

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/")
	public String home() {
		return "start";
	}

	@RequestMapping("/signup")
	public String showform(Model m) {
		m.addAttribute(COMMAND, new CustomerDto());
		return "signup";
	}

	@RequestMapping("/login")
	public String loginform(Model m) {
		m.addAttribute(COMMAND, new LoginModel());
		return "login";
	}

	@RequestMapping("/signuperror")
	public String showerrorform() {

		return "signuperror";
	}

	@RequestMapping("/viewpolicies")
	public String adminhome() {
		return "viewPolicy";
	}

	@RequestMapping("/customer/viewCustomerpolicies")
	public String returnhome() {
		return "viewPolicyCustomer";
	}

	@PostMapping("/savecustomer")
	public String saveLaptop(@ModelAttribute("c1") CustomerDto customer,
			@RequestParam("customerEmail") String customerEmail,
			@RequestParam("customerPassword") String customerPassword) {

		CustomerModel user = customerService.findbyemail(customerEmail);
		if (user != null) {

			logger.info("User email already present");
			return "redirect:/signuperror";
		}

		else {

			customerService.saveCustomer(customer);
			logger.info("Customer Added");
			return "redirect:/customer/viewCustomerpolicies";
		}

	}

	@GetMapping("/viewcustomers")
	public ModelAndView viewPolicies() {
		List<CustomerModel> c1 = customerService.viewCustomers();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewCustomer");
		mv.addObject("list", c1);
		return mv;
	}

	@RequestMapping("/loginerror")
	public String logincradentials() {

		return "loginerror";
	}

	@RequestMapping("/credentials")
	public String isUserPresent(@RequestParam("customerEmail") String customerEmail,
			@RequestParam("customerPassword") String customerPassword) {
		CustomerModel user = customerService.findbyEmailandPassword(customerEmail, customerPassword);

		if (user != null) {
			if (user.getRole().equals("user")) {
				logger.info("it is user");
				return "redirect:/customer/viewCustomerpolicies";

			} else {
				logger.info("it is admin");
				return "redirect:/viewpolicies";
			}
		} else {

			return "redirect:/loginerror";
		}

	}

	@RequestMapping("/addAdmin")
	public String addadmin(Model m) {
		m.addAttribute(COMMAND, new CustomerModel());
		return "addAdmin";
	}

	@RequestMapping("/AlreadyAdminExisists")
	public String alreadyAdminExisistsform() {

		return "AlreadyAdminExisists";
	}

	@PostMapping("/saveadmin")
	public String saveAdmin(@ModelAttribute("a1") CustomerDto customer,

			@RequestParam("customerEmail") String customerEmail,

			@RequestParam("customerPassword") String customerPassword) {

		CustomerModel user = customerService.findbyemail(customerEmail);
		if (user != null) {

			return "redirect:/AlreadyAdminExisists";
		}

		else {

			customerService.saveCustomer(customer);
			logger.info("Customer Added");
			return "redirect:/viewcustomers";
		}

	}

}
