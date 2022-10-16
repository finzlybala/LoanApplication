 package com.example.LoanApplication.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paymentschedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	private LocalDate paymentDate;
	private double principalamount;
	private double projectedIntrest;
	private String paymentStatus="projected";
	private double paymentAmount;
	

	public Paymentschedule() {
		super();
		
	}

	public Paymentschedule(int paymentId, LocalDate paymentDate, double principalamount, double projectedIntrest,
			String paymentStatus, double paymentAmount) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.principalamount = principalamount;
		this.projectedIntrest = projectedIntrest;
		this.paymentStatus = paymentStatus;
		this.paymentAmount = paymentAmount;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate tempPaymentDate) {
		paymentDate = tempPaymentDate;
	}

	public double getPrincipalamount() {
		return principalamount;
	}

	public void setPrincipalamount(double principalamount) {
		this.principalamount = principalamount;
	}

	public double getProjectedIntrest() {
		return projectedIntrest;
	}

	public void setProjectedIntrest(double projectedIntrest) {
		this.projectedIntrest = projectedIntrest;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	@Override
	public String toString() {
		return "Paymentschedule [paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", principalamount="
				+ principalamount + ", projectedIntrest=" + projectedIntrest + ", paymentStatus=" + paymentStatus
				+ ", paymentAmount=" + paymentAmount + "]";
	}

	
	

}
