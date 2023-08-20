package org.vann.FourWheelerInsurance.controller;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.vann.FourWheelerInsurance.entities.Cart;
import org.vann.FourWheelerInsurance.entities.Customer;
import org.vann.FourWheelerInsurance.entities.Document;
import org.vann.FourWheelerInsurance.entities.FeedBack;
import org.vann.FourWheelerInsurance.entities.Orderitems;
import org.vann.FourWheelerInsurance.entities.Policy;
import org.vann.FourWheelerInsurance.entities.Profile;
import org.vann.FourWheelerInsurance.model.CartRequestModel;
import org.vann.FourWheelerInsurance.model.CustomerRequest;
import org.vann.FourWheelerInsurance.model.CustomerRequestSingin;
import org.vann.FourWheelerInsurance.model.CustomerResponse;
import org.vann.FourWheelerInsurance.model.DocRequestModel;
import org.vann.FourWheelerInsurance.model.FeedbackModel;
import org.vann.FourWheelerInsurance.model.ForgotPassword;
import org.vann.FourWheelerInsurance.model.PolicyRequestModel;
import org.vann.FourWheelerInsurance.model.ProfileModel;
import org.vann.FourWheelerInsurance.model.SuccessResponse;
import org.vann.FourWheelerInsurance.services.CartService;
import org.vann.FourWheelerInsurance.services.CustomerAuthenticationService;
import org.vann.FourWheelerInsurance.services.CustomerService;
import org.vann.FourWheelerInsurance.services.DocService;
import org.vann.FourWheelerInsurance.services.FeedBackService;
import org.vann.FourWheelerInsurance.services.OrderService;
import org.vann.FourWheelerInsurance.services.PolicyService;
import org.vann.FourWheelerInsurance.services.ProfileService;
import org.vann.FourWheelerInsurance.util.JwtUtil;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/")
@SuppressWarnings("rawtypes")

public class HomeController {

	final private static org.apache.log4j.Logger log = org.apache.log4j.LogManager.getLogger(HomeController.class);
	@Autowired
    private ProfileService profileService;
	@Autowired
	private CustomerService custService;
	@Autowired
	private PolicyService policyService;
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderServices;
	@Autowired
	private CustomerAuthenticationService customerAuthService;
	@Autowired
	private FeedBackService feedBackService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private DocService docService;
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/signin")
	public ResponseEntity<CustomerResponse> singIn(@RequestBody CustomerRequestSingin customerRequestSingin) {

		Authentication authentication = null;
		try {
			authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					customerRequestSingin.getUsername(), customerRequestSingin.getPassword()));
		} catch (BadCredentialsException e) {
			log.error("Customer" + customerRequestSingin.getUsername() + "Has entered Invalid Password");
			throw new BadCredentialsException("Invalid Credentials");
		}
		String token = jwtUtil.generateToken(authentication);
		User user = (User) authentication.getPrincipal();
		List<String> roles = user.getAuthorities().stream().map(authority -> authority.getAuthority()).toList();
		CustomerResponse customerResponse = new CustomerResponse();
		customerResponse.setToken(token);
		customerResponse.setRoles(roles);
		customerResponse.setCustomerId(custService.getCustomerByUserName(user.getUsername()).getId());
		log.info("customer" + user.getUsername() + "authenticated Successfully");
		return ResponseEntity.ok(customerResponse);
	}

	@PostMapping("/signup")
	public ResponseEntity<SuccessResponse> signUp(@RequestBody CustomerRequest customerRequest) {
		customerAuthService.registerUser(customerRequest);
		log.info(customerRequest.getUsername() + " " + "registered Successfully");
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setSuccessMessage("User Registered Successfully");
		return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.CREATED);
	}

	@PostMapping("/verify-customer-email")
	public ResponseEntity<Boolean> verifyEmail(@RequestBody String emailId) {
		Boolean result = custService.verifyCustomerEmail(emailId);
		if (result) {
			return new ResponseEntity<Boolean>(result, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Boolean>(result, HttpStatus.NOT_FOUND);
	}

	@PostMapping("/reset-password")
	public ResponseEntity resetPassword(@RequestBody ForgotPassword forgotPassword) {
		boolean result = custService.resetPassword(forgotPassword);
		if (result) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_MODIFIED);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers() {
		List<Customer> customers = custService.getCustomers();
		return new ResponseEntity(customers, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") int customerId) {
		Customer customer = custService.getCustomerById(customerId);
		return new ResponseEntity(customer, HttpStatus.OK);
	}

//used by admin to delete the customer details.
	@DeleteMapping("/customers/{id}")
	public ResponseEntity deleteCustomer(@PathVariable("id") int customerId) {
		custService.deleteCustomerById(customerId);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping("/customers/update")
	public ResponseEntity updateCustomer(@RequestBody CustomerRequest customerRequest) {
		Customer customer = new Customer(customerRequest);
		custService.updateCustomer(customer.getId(), customer);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping("/feed-back")
	public ResponseEntity saveFeedBack(@RequestBody FeedbackModel feedBackModel) {
		FeedBack feedbackRequest = modelMapper.map(feedBackModel, FeedBack.class);
		feedBackService.saveFeedBack(feedbackRequest);
		modelMapper.map(feedbackRequest, FeedbackModel.class);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

	@PostMapping("/cart")
	public ResponseEntity addToCart(@RequestBody CartRequestModel cartRequestModel) {
		Cart cartRequest = modelMapper.map(cartRequestModel, Cart.class);
		cartService.addToCart(cartRequest);
		modelMapper.map(cartRequest, CartRequestModel.class);
		return new ResponseEntity(HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/cart/{custid}")
	public ResponseEntity getCartData(@PathVariable("custid") int customerId) {
		List<Cart> cartdata = cartService.getByCustomerId(customerId);
		return new ResponseEntity(cartdata, HttpStatus.OK);
	}

	@PostMapping("/cart/update/{custid}")
	public ResponseEntity updateCartProduct(@PathVariable("custid") int custid,
			@RequestBody CartRequestModel cartRequestModel) {
		Cart cartRequest = modelMapper.map(cartRequestModel, Cart.class);
		cartService.updateCartData(cartRequest, custid);
		modelMapper.map(cartRequest, CartRequestModel.class);
		return new ResponseEntity(HttpStatus.OK);
	}

	@DeleteMapping("/cart/delete/{id}")
	public ResponseEntity deleteCartProduct(@PathVariable("id") int id) {
		cartService.deleteFromCart(id);
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping("/orders")
	@SuppressWarnings("unchecked")
	public ResponseEntity getOrders() {
		List<Orderitems> orderItems = orderServices.getOrders();
		return new ResponseEntity(orderItems, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/myOrders/{id}")
	public ResponseEntity getMyOrders(@PathVariable("id") int id) {
		List<Orderitems> orderItems = orderServices.getOrderByCustomerId(id);
		return new ResponseEntity(orderItems, HttpStatus.OK);
	}

	@PostMapping("/order")
	public ResponseEntity saveOrder(@RequestBody List<Orderitems> orderItems) {
		orderServices.saveOrders(orderItems);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/policies")
	public ResponseEntity<List<Policy>> getPolicies() {
		List<Policy> products = policyService.getPolicies();
		return new ResponseEntity(products, HttpStatus.OK);
	}

	@PostMapping("/admin/insertPolicy")
	public ResponseEntity insertpolicy(@RequestBody PolicyRequestModel policyRequestModel) {
		Policy polRequest = modelMapper.map(policyRequestModel, Policy.class);
		policyService.insertpolicy(polRequest);
		modelMapper.map(polRequest, PolicyRequestModel.class);

		return new ResponseEntity(HttpStatus.CREATED);
	}

	@PostMapping("/admin/updatePolicy")
	public ResponseEntity updatePolicy(@RequestBody PolicyRequestModel policyRequestModel) {
		Policy polRequest = modelMapper.map(policyRequestModel, Policy.class);

		policyService.updatePolicy(polRequest.getId(), polRequest);
		modelMapper.map(polRequest, PolicyRequestModel.class);
		return new ResponseEntity(HttpStatus.OK);
	}

	@DeleteMapping("/delete-policy/{id}")
	public ResponseEntity<String> deletePolicy(@PathVariable("id") int id) {
		policyService.deletePolicy(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
	@DeleteMapping("/delete-order/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable("id") int id) {
		orderServices.deleteOrder(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}

	@GetMapping("/allfeedBack")
	public ResponseEntity<List<FeedBack>> getAllFeedBack() {
		List<FeedBack> feedBacks = feedBackService.getAllFeedBack();
		return new ResponseEntity(feedBacks, HttpStatus.OK);
	}

	@PostMapping("/user/document")
	public String addDocuments(@RequestBody DocRequestModel docRequestModel) {
		Document document = new Document(docRequestModel);
		docService.saveDetails(document);
		return "user documents added";
	}

	@GetMapping("/user/document/{aplyname}")
	public List<Document> getByName(@PathVariable String name) {
		return docService.getUserDocs(name);

	}

	@PostMapping("/user/document1")
	public ResponseEntity saveDocument(@RequestBody DocRequestModel docRequestModel) {
		Document document = new Document(docRequestModel);
		docService.saveDocument(document);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

	@PutMapping("/user/updateDocs")
	public Document updatePlan(@RequestBody DocRequestModel docRequestModel,
			@PathVariable("aplyname") String aplyname) {
		Document document = new Document(docRequestModel);
		return docService.savePlan(document);
	}

	@DeleteMapping("/user/deleteDocs/{aplyname}")
	public String deleteDoc(@PathVariable String aplyname) {
		return docService.deleteDocs(aplyname);

	}

	public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/uploads/";

	@PostMapping("/upload")
	public ResponseEntity<List<String>> uploadFiles(@RequestParam("files") List<MultipartFile> multipartFiles)
			throws IOException {

		List<String> filenames = new ArrayList<>();

		for (MultipartFile file : multipartFiles) {
			String filename = file.getOriginalFilename();
			Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
			copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
			filenames.add(filename);
		}
		return ResponseEntity.ok().body(filenames);
	}

	@GetMapping("download/{filename}")
	public ResponseEntity<Resource> downloadFiles(@PathVariable("filename") String filename) throws IOException {
		Path filePath = get(DIRECTORY).toAbsolutePath().normalize().resolve(filename);
		if (!Files.exists(filePath)) {
			throw new FileNotFoundException(filename + " was not found on the server");
		}
		Resource resource = new UrlResource(filePath.toUri());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("File-Name", filename);
		httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
				.headers(httpHeaders).body(resource);
	}
	@PostMapping("/profile")
    public ResponseEntity saveProfile(@RequestBody ProfileModel profileModel) {
        Profile profileRequest = modelMapper.map(profileModel, Profile.class);
        profileService.saveProfile(profileRequest);
        modelMapper.map(profileRequest, ProfileModel.class);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
	@SuppressWarnings("unchecked")
    @GetMapping("/allprofile")
    public ResponseEntity<List<Profile>> getAllProfile() {
        List<Profile> profiles = profileService.getAllProfile();
        return new ResponseEntity(profiles, HttpStatus.OK);
    }

}