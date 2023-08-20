package org.vann.FourWheelerInsurance.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.vann.FourWheelerInsurance.entities.Cart;
import org.vann.FourWheelerInsurance.entities.FeedBack;
import org.vann.FourWheelerInsurance.entities.Policy;
import org.vann.FourWheelerInsurance.entities.Profile;
import org.vann.FourWheelerInsurance.repositories.CartRepository;
import org.vann.FourWheelerInsurance.repositories.FeedBackRepository;
import org.vann.FourWheelerInsurance.repositories.PolicyRepository;
import org.vann.FourWheelerInsurance.repositories.ProfileRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class HomeControllerTest {
	@Autowired
	ProfileRepository profRep;
	@Autowired
	FeedBackRepository feedBackRep;
	@Autowired
	PolicyRepository polRep;
	@Autowired
	CartRepository cartRep;

	@Test
	@Order(1)
	void testProfile() {
		Profile prof = new Profile(1, 1, "Test", "Test", 1, "01/11/1111", "TEST01", "TestModel");
		profRep.save(prof);
		assertNotNull(profRep.findById(1).get());
	}

	@Test
	@Order(2)
	void testReadAllProfile() {
		List<Profile> lst = profRep.findAll();
		assertThat(lst).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	void testReadProfile() {
		Profile prof = profRep.findById(1).get();
		assertEquals("Test", prof.getAplyname());
	}

	@Test
	@Order(4)
	void testUpdateProfile() {
		Profile prof = profRep.findById(1).get();
		prof.setAplydate("11/11/1111");
		;
		profRep.save(prof);
		assertNotEquals("10/10/1100", profRep.findById(1).get().getAplydate());
	}

	@Test
	@Order(5)
	void testDeleteProfile() {
		profRep.deleteById(1);
		assertThat(profRep.existsById(1)).isFalse();
	}

	@Test
	@Order(6)
	void testFeedback() {
		FeedBack feedBack = new FeedBack(1, 1, "TestFeedback", "Test@gmail.com", 987654310, "Good");
		feedBackRep.save(feedBack);
		assertNotNull(feedBackRep.findById(1).get());
	}

	@Test
	@Order(7)
	void testReadAllFeedback() {

		List<FeedBack> feedbacklist = feedBackRep.findAll();
		assertThat(feedbacklist).size().isGreaterThan(0);
	}

	@Test
	@Order(8)
	void testReadFeedback() {

		FeedBack feedBack = feedBackRep.findById(1).get();
		assertEquals("TestFeedback", feedBack.getName());

	}

	@Test
	@Order(9)
	void testPolicy() {
		Policy pol = new Policy(1, "Test", 2500, 5, "5000");
		polRep.save(pol);
		assertNotNull(polRep.findById(1).get());
	}

	@Test
	@Order(10)
	void testReadAllPolicy() {
		List<Policy> lst = polRep.findAll();
		assertThat(lst).size().isGreaterThan(0);
	}

	@Test
	@Order(11)
	void testReadPolicy() {
		Policy pol = polRep.findById(1).get();
		assertEquals("Test", pol.getPolicyName());
	}

	@Test
	@Order(12)
	void testUpdatePolicy() {
		Policy pol = polRep.findById(1).get();
		pol.setPolicyPrice(30000);
		polRep.save(pol);
		assertNotEquals(4000, polRep.findById(1).get().getPolicyPrice());
	}

	@Test
	@Order(13)
	void testDeletePolicy() {
		polRep.deleteById(1);
		assertThat(polRep.existsById(1)).isFalse();
	}
	@Test
	@Order(15)
	void testReadAllCart() {
		List<Cart> lst = cartRep.findAll();
		assertThat(lst).size().isGreaterThan(0);
	}

}