package com.chandana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.chandana.customer")
public class Main { 
   
    public static void main(String[] args){
       // CustomerService customerService = new CustomerService(new CustomerDataAccessService());
       // CustomerController customerController = new CustomerController (customerService);
       SpringApplication.run(Main.class, args);
    } 
}  
