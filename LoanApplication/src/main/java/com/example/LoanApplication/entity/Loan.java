package com.example.LoanApplication.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;


@Entity
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private double loanAmount;
	@CreationTimestamp
	private LocalDate tradeDate;
	private LocalDate loanStartDate; 
	private int maturityDate;
	private int paymentFrequency;
	private double intrestRate;
	private String paymentTerm;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="payId",referencedColumnName = "customerId")
	public List<Paymentschedule> schedule = new ArrayList<>();

   public Loan() {
	   
   }



public Loan(int customerId, double loanAmount, LocalDate tradeDate, LocalDate loanStartDate, int maturityDate,
		int paymentFrequency, double intrestRate, String paymentTerm, List<Paymentschedule> schedule) {
	super();
	this.customerId = customerId;
	this.loanAmount = loanAmount;
	this.tradeDate = tradeDate;
	this.loanStartDate = loanStartDate;
	this.maturityDate = maturityDate;
	this.paymentFrequency = paymentFrequency;
	this.intrestRate = intrestRate;
	this.paymentTerm = paymentTerm;
	this.schedule = schedule;
}



public List<Paymentschedule> getSchedule() {
	return schedule;
}

public void setSchedule(List<Paymentschedule> schedule) {
	this.schedule = schedule;
}

public int getCustomerId() {
	return customerId;
}

public void setCustomerId(int customerId) {
	this.customerId = customerId;
}

public String getPaymentTerm() {
	return paymentTerm;
}

public void setPaymentTerm(String paymentTerm) {
	this.paymentTerm = paymentTerm;
}

public Loan(String paymentTerm) {
	super();
	this.paymentTerm = paymentTerm;
}

public double getLoanAmount() {
	return loanAmount;
}

public void setLoanAmount(double loanAmount) {
	this.loanAmount = loanAmount;
}

public LocalDate getTradeDate() {
	return tradeDate;
}

public void setTradeDate(LocalDate tradeDate) {
	this.tradeDate = tradeDate;
}

public LocalDate getLoanStartDate() {
	return loanStartDate;
}

public void setLoanStartDate(LocalDate loanStartDate) {
	this.loanStartDate = loanStartDate;
}

public int getMaturityDate() {
	return maturityDate;
}

public void setMaturityDate(int maturityDate) {
	this.maturityDate = maturityDate;
}

public int getPaymentFrequency() {
	return paymentFrequency;
}

public void setPaymentFrequency(int paymentFrequency) {
	this.paymentFrequency = paymentFrequency;
}

public double getIntrestRate() {
	return intrestRate;
}

public void setIntrestRate(double intrestRate) {
	this.intrestRate = intrestRate;
}

@Override
public String toString() {
	return "Loan [CustomerId=" + customerId + ", LoanAmount=" + loanAmount + ", TradeDate=" + tradeDate
			+ ", LoanStartDate=" + loanStartDate + ", MaturityDate=" + maturityDate + ", PaymentFrequency="
			+ paymentFrequency + ", IntrestRate=" + intrestRate + ", PaymentTerm=" + paymentTerm + "]";
}
  
   
	
}
