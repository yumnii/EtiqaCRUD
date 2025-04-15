package com.example.bookmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagerApplication.class, args);
		
		 // Lombok test
	    LombokTest test = new LombokTest();
	    test.setMessage("Lombok is working!");
	    System.out.println(test.getMessage());
	}
	
	

}
