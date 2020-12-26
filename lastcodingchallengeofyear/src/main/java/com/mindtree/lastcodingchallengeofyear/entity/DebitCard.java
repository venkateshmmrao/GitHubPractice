package com.mindtree.lastcodingchallengeofyear.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DebitCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int debitcardId;
	private long debitcardNumber;
	private Date expiryDate;
	private String cardType;
	private double amount;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Customer customer;

	public DebitCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DebitCard(int debitcardId, long debitcardNumber, Date expiryDate, String cardType, double amount,
			Customer customer) {
		super();
		this.debitcardId = debitcardId;
		this.debitcardNumber = debitcardNumber;
		this.expiryDate = expiryDate;
		this.cardType = cardType;
		this.amount = amount;
		this.customer = customer;
	}

	public int getDebitcardId() {
		return debitcardId;
	}

	public void setDebitcardId(int debitcardId) {
		this.debitcardId = debitcardId;
	}

	public long getDebitcardNumber() {
		return debitcardNumber;
	}

	public void setDebitcardNumber(long debitcardNumber) {
		this.debitcardNumber = debitcardNumber;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
