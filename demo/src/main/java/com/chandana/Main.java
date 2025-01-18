package com.chandana;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.chandana.customer.Customer;
import com.chandana.customer.CustomerRepository;


@SpringBootApplication(scanBasePackages = "com.chandana.customer")
public class Main {  
   
    public static void main(String[] args){
            SpringApplication.run(Main.class, args);
 

    } 

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository){
        return args ->{
        Customer alex = new Customer(
            "Alex",
            "Alex@gmail.com",
            21
        );
        Customer jamila = new Customer(
            "Jamila",
            "Jamila@gmail.com",
            19
        );
        List<Customer> customers = List.of(alex,jamila);
        customerRepository.saveAll(customers);
        };
    }
}  
