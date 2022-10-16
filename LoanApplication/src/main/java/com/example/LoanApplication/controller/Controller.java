package com.example.LoanApplication.controller;

import java.util.List;

import com.example.LoanApplication.Dao.LoanDao;
import com.example.LoanApplication.entity.Loan;
import com.example.LoanApplication.entity.Paymentschedule;
import com.example.LoanApplication.service.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")  
public class Controller {
	
	@Autowired
	private LoanService service;
	
	@GetMapping("/print")
	public List<Loan> loans() {
		return service.getAllDetails();
	}
		
	@PostMapping("/create")
	public String createLoan(@RequestBody Loan loan) {
		System.out.println(loan);
		return service.applyLoan(loan);
	}	
	
	@GetMapping("format")
	public Loan print(){
		return new Loan();
	}
	@GetMapping("customer/{id}")
     public Object print(@PathVariable int id) {
		return service.getLoansByCustomerId(id);
		}
	@PutMapping("customer/payment/{id}")
    public Object payment(@PathVariable int id) {
         return service.PaymentChanger(id);
           }
 
}
