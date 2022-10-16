package com.example.LoanApplication.Dao;

import com.example.LoanApplication.entity.Loan;
import com.example.LoanApplication.entity.Paymentschedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanDao extends JpaRepository<Loan ,Integer> {
	

}
