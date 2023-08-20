//package org.vann.FourWheelerInsurance;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.transaction.annotation.Transactional;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@RunWith(SpringRunner.class)
//class FourWheelerInsuranceApplicationTests{
//	@Autowired
//    private MockMvc mockMvc;
//	@Test
//	@Transactional
//	void Add_User() throws Exception {
//		String newUser = "{\"name\":\"Test\",\"emailId\":\"test@gmail.com\",\"phoneNumber\":\"9600914721\",\"username\":\"test123\",\"password\":\"Test@123\",\"roles\":\"user\"}";
//        mockMvc.perform(MockMvcRequestBuilders.post("/signup")
//		.contentType(MediaType.APPLICATION_JSON)
//		.content(newUser)
//		.accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk())
//		.andReturn();
//	}
//	@Test
//	@Transactional
//	void Add_Policy() throws Exception {
//        String newPolicy = "{\"pid\":\"1\",\"policyName\":\"CarTest\",\"policyPrice\":\"1500\",\"numberOfYearPlan\":\"5\",\"ClainAmount\":\"2000\"}";
//        mockMvc.perform(MockMvcRequestBuilders.post("/admin/insertPolicy")
//		.contentType(MediaType.APPLICATION_JSON)
//		.content(newPolicy)
//		.accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk())
//		.andReturn();
//    }
//	@Test
//	@Transactional
//    void Get_All_Policy() throws Exception {
//	 	mockMvc.perform(MockMvcRequestBuilders.get("/policies")
//		.contentType(MediaType.APPLICATION_JSON)
//		.accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk())
//		.andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
//		.andReturn();
//    }
//
//	@Test
//	@Transactional
//    void Update_Policy() throws Exception {
//        String newPolicy = "{\"pid\":\"1\",\"policyName\":\"CarTest\",\"policyPrice\":\"3000\",\"numberOfYearPlan\":\"5\",\"ClainAmount\":\"2000\"}";
//        mockMvc.perform(MockMvcRequestBuilders.put("/admin/updatePolicy")
//		.param("pid","1")
//		.contentType(MediaType.APPLICATION_JSON)
//		.content(newPolicy)
//		.accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk())
//		.andReturn();
//    }
//
//}
