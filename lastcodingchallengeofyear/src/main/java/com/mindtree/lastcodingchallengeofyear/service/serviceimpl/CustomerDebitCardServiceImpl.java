package com.mindtree.lastcodingchallengeofyear.service.serviceimpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.lastcodingchallengeofyear.entity.Customer;
import com.mindtree.lastcodingchallengeofyear.entity.DebitCard;
import com.mindtree.lastcodingchallengeofyear.repository.CustomerRepository;
import com.mindtree.lastcodingchallengeofyear.repository.DebitCardRepository;
import com.mindtree.lastcodingchallengeofyear.service.CustomerDebitCardService;

@Service
public class CustomerDebitCardServiceImpl implements CustomerDebitCardService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private DebitCardRepository debitCardRepository;

	@Override
	public Customer registerCustomerDetails(Customer customer) {

		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomersFromDataBase() {

		return customerRepository.findAll();
	}

	@Override
	public DebitCard addDebitCardDetails(int customerId, DebitCard debitCard) {
		Customer customer = customerRepository.findById(customerId).get();
		debitCard.setCustomer(customer);
		return debitCardRepository.save(debitCard);
	}

	@Override
	public List<Customer> getAllCustomerDetailsFromDataBase() {
		List<Customer> customers = new ArrayList<Customer>();
		for (Customer customer : customerRepository.findAll()) {

			List<DebitCard> cards = new ArrayList<DebitCard>();
			for (DebitCard debitCard : customer.getDebitCards()) {
				cards.add(debitCard);
			}
			Collections.sort(cards, new Comparator<DebitCard>() {

				@Override
				public int compare(DebitCard arg0, DebitCard arg1) {
					return (int) (arg1.getAmount() - arg0.getAmount());
				}
			});
			customer.setDebitCards(cards);
			customers.add(customer);
		}
		Collections.sort(customers);
		return customers;

	}

	@Override
	public DebitCard updateCustomerDebitCardData(int debitcardId) {

		return debitCardRepository.findById(debitcardId).get();
	}

	@Override
	public void updateDateOfExpireOfCard(DebitCard card, Date expiryDate) {
		card.setExpiryDate(expiryDate);
		debitCardRepository.save(card);
	}

}
