package com.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.common.annotations.Beta;

@Component
public class DiscountService {
	
	public DiscountService() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getDiscount(String userid) {
		
		//based on the user id get the appropriate discount no;
		//We have to have some user detail to be stored based on that get which category he falls.
		
		
		// Assuming he is an employee
			
		return 30;
		
	}

}
