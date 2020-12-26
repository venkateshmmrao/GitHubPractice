package com.mindtree.lastcodingchallengeofyear.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.lastcodingchallengeofyear.entity.Customer;
import com.mindtree.lastcodingchallengeofyear.entity.DebitCard;

@Service
public interface CustomerDebitCardService {

	public Customer registerCustomerDetails(Customer customer);

	public List<Customer> getAllCustomersFromDataBase();

	public DebitCard addDebitCardDetails(int customerId, DebitCard debitCard);

	public List<Customer> getAllCustomerDetailsFromDataBase();

	public DebitCard updateCustomerDebitCardData(int debitcardId);

	public void updateDateOfExpireOfCard(DebitCard card, Date expiryDate);

}
