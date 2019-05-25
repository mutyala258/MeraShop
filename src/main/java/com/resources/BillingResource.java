package com.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.models.Bill;
import com.services.BillingService;
import com.services.DiscountService;
import com.services.UserService;

@RestController
public class BillingResource {

    
    @Autowired
    @Qualifier("discountService")
    DiscountService discountService;
    
    @Autowired
    BillingService billingService;
    
    @Autowired
    UserService userService; 
    

    @RequestMapping("/apply-discount")
    @ResponseBody
    public Bill getBill(@RequestParam(name="billNumber", required=false, defaultValue="Stranger") String billNumber) {
        
    	//based on bill number get user detail
    	   	
    	String userId = userService.getUserDetailsByBill(billNumber);
    	
    	//Get the discount, based on userId
    	double discount = discountService.getDiscount(userId);
    	
    	//Get final bill for the bill
    	Bill bill = billingService.getFinalBill(billNumber, discount);
    	    	
    	
    	return bill;
    }
    
    
    
    

}
