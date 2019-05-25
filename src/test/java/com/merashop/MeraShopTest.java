/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.merashop;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.models.Bill;
import com.resources.BillingResource;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})


//  http://localhost:9000/apply-discount?billNumber=adi
public class MeraShopTest {

	@LocalServerPort
	private int port;

	@Value("${local.management.port}")
	private int mgt;

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	
	//This method is test the Billing amount
	 @Test
	    public void testBillingAmount() {
	        BillingResource homeController = new BillingResource();
	        Bill result = homeController.getBill("ddd");
	        
	        System.out.println("result" + result.getAmount());
	        assertEquals(result.getAmount(), 100);
	    }
	 
	 
	 //This metod is test  discount
	 @Test
	    public void testDiscount() {
	        BillingResource homeController = new BillingResource();
	        Bill result = homeController.getBill("ddd");
	        
	        System.out.println("result" + result.getDiscountAmount());
	        assertEquals(result.getDiscountPercentage(), 300);
	    }
	 
	 //This method is to test discount percentage
	 @Test
	    public void testDiscountPercentage() {
	        BillingResource homeController = new BillingResource();
	        Bill result = homeController.getBill("ddd");
	        
	        //System.out.println("result" + result.getDiscountPercentage());
	        assertEquals(result.getDiscountPercentage(),  30);
	       
	    }



}
