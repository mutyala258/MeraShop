package com.resources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//  -- http://localhost:9000/apply-discount?billNumber=www

@SpringBootApplication(scanBasePackages={
		"com.*"})
public class MeraShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeraShopApplication.class, args);
	}

}
