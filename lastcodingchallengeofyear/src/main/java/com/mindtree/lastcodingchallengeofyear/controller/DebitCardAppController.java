package com.mindtree.lastcodingchallengeofyear.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.lastcodingchallengeofyear.entity.Customer;
import com.mindtree.lastcodingchallengeofyear.entity.DebitCard;
import com.mindtree.lastcodingchallengeofyear.service.CustomerDebitCardService;

@Controller
public class DebitCardAppController {

	@Autowired
	private CustomerDebitCardService customerDebitCardService;
	DebitCard card = new DebitCard();

	@GetMapping("/")
	public String index0() {
		return "index";
	}

	@GetMapping("/form1")
	public String index1() {
		return "customer";
	}

	@RequestMapping("/addCustomer")
	public String addCustomerDetails(@ModelAttribute("customer") Customer customer) {

		customerDebitCardService.registerCustomerDetails(customer);
		return "index";
	}

	@GetMapping("/form2")
	public String index1(Model model) {
		List<Customer> customers = customerDebitCardService.getAllCustomersFromDataBase();
		model.addAttribute("customers", customers);
		return "debitcard";
	}

	@RequestMapping("/addDebitCard")
	public String addDebitCardDetailsToFlight(@RequestParam("customerId") int customerId,
			@ModelAttribute("debitCard") DebitCard debitCard) {

		customerDebitCardService.addDebitCardDetails(customerId, debitCard);
		return "index";
	}

	@RequestMapping("/viewData")
	public String getAllDataFromDataBaseByCards(Model model) {
		List<Customer> customers = customerDebitCardService.getAllCustomerDetailsFromDataBase();
		model.addAttribute("customers", customers);
		return "view";
	}

	@GetMapping("/update/{debitcardId}")
	public String updateCardDetails(Model model, @PathVariable int debitcardId) {
		DebitCard debitCard = customerDebitCardService.updateCustomerDebitCardData(debitcardId);
		card = debitCard;
		model.addAttribute("debitCard", debitCard);
		return "update";
	}

	@RequestMapping("/updatedate")
	public String updateExpiryDate(@RequestParam("expiryDate") Date expiryDate) {
		customerDebitCardService.updateDateOfExpireOfCard(card, expiryDate);
		return "view";
	}

}
