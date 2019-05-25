package com.services;

import org.springframework.stereotype.Service;

import com.models.Bill;

@Service
public class BillingService {
	
	
	public Bill getFinalBill (String billNumber, double discount) {
		
		//based on billNumber get the amount from the database;
		
		//Since Dao layer is not implemented assuming bill amount is 1000
		
		Bill bill = new Bill();
		
		bill.setAmount(1000);
		bill.setBillNo(billNumber);
		bill.setDiscountPercentage(discount);
		bill.setDiscountAmount( (1000 * discount/100));
		
		return bill;
		
		
	}

}
