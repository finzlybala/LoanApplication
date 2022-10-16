package com.example.LoanApplication.service;

import java.time.LocalDate;
import java.util.List;

import com.example.LoanApplication.Dao.LoanDao;
import com.example.LoanApplication.Dao.PaymentscheduleDao;
import com.example.LoanApplication.entity.Loan;
import com.example.LoanApplication.entity.Paymentschedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

	@Autowired
	private LoanDao loans;

	@Autowired
	private PaymentscheduleDao schedules;

	public String applyLoan(Loan loan) {
		List<Paymentschedule> schedules = loan.getSchedule();
		int paymentSchedule = loan.getMaturityDate() / loan.getPaymentFrequency();
		int years = loan.getMaturityDate() / 12;
		System.out.println(paymentSchedule);
		double paymentAmount;
		double tempLoanAmount = loan.getLoanAmount();
		LocalDate tempPaymentDate = loan.getLoanStartDate();
		for (int i = 0; i < paymentSchedule; i++) {
			Paymentschedule detials = new Paymentschedule();
			tempPaymentDate = tempPaymentDate.plusMonths(loan.getPaymentFrequency());
			detials.setPaymentDate(tempPaymentDate);
			if (loan.getPaymentTerm().equalsIgnoreCase("Even Principal")) {
				detials.setPrincipalamount(loan.getLoanAmount() / paymentSchedule);
				detials.setProjectedIntrest(tempLoanAmount / loan.getIntrestRate());
				tempLoanAmount = tempLoanAmount - detials.getPrincipalamount();
				detials.setPaymentAmount(detials.getProjectedIntrest() + detials.getPrincipalamount());
			} else {
				if(detials.getPaymentDate().equals(loan.getMaturityDate())) {
					detials.setPrincipalamount(loan.getLoanAmount());
					
				}
				else {
					detials.setPrincipalamount(0);
				}
				
				detials.setProjectedIntrest((loan.getLoanAmount() / loan.getIntrestRate()) / paymentSchedule * years);
				if (detials.getPaymentDate().equals(loan.getMaturityDate())) {
					paymentAmount = detials.getProjectedIntrest() + loan.getLoanAmount();
					
				} else {
					paymentAmount = detials.getProjectedIntrest();
				}
				detials.setPaymentAmount(paymentAmount);
			}
			if (detials.getPaymentDate().equals(LocalDate.now())) {
				detials.setPaymentStatus(" AwaitingPayment");
			} else if (detials.getPaymentDate().compareTo(LocalDate.now()) < 0) {
				detials.setPaymentStatus("Paid");
			}
			schedules.add(detials);
		}
		loan.setSchedule(schedules);
		loans.save(loan);
		return "Created";
	}

	public List<Loan> getAllDetails() {
		return loans.findAll();

	}

	public List<Paymentschedule> getLoansByCustomerId(int id) {
	Loan detials=loans.findById(id).get();
	for (Paymentschedule schedule :detials.getSchedule()) {
		if (schedule.getPaymentDate().equals(LocalDate.now())) {
			schedule.setPaymentStatus("AwaitingPayment");
		}
		else if (schedule.getPaymentDate().compareTo(LocalDate.now())<0) {
			schedule.setPaymentStatus("Paid");
		}
		schedules.save(schedule);
	} 
		return detials.getSchedule();
	}

}
