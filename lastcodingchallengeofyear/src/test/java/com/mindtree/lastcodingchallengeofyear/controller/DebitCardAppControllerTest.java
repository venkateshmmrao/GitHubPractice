package com.mindtree.lastcodingchallengeofyear.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mindtree.lastcodingchallengeofyear.entity.Customer;
import com.mindtree.lastcodingchallengeofyear.service.serviceimpl.CustomerDebitCardServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(DebitCardAppController.class)
@AutoConfigureMockMvc
public class DebitCardAppControllerTest {

	@InjectMocks
	private DebitCardAppController appController;

	@Mock
	private CustomerDebitCardServiceImpl customerDebitCardServiceImpl;
	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(appController).build();
	}

	@Test
	public void testAddCustomerDetails() {
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("Madhu");
		customer.setAge(21);
		customer.setDebitCards(null);
		/*
		 * Customer customer2 = new Customer(); customer2 = customer;
		 */
		when(customerDebitCardServiceImpl.registerCustomerDetails(customer)).thenReturn(customer);
		assertEquals(appController.addCustomerDetails(customer), customer);

	}

}
