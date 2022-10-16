package com.example.LoanApplication.Dao;

import com.example.LoanApplication.entity.Paymentschedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository
public interface PaymentscheduleDao extends JpaRepository<Paymentschedule , Integer > {

}
