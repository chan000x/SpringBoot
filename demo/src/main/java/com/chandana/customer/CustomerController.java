package com.chandana.customer;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//  This is the API Layer
@RestController  
public class CustomerController {

    private final CustomerService customerService;


    
  public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // @GetMapping("api/v1/customers") //this one and requestmapping is same.
    @RequestMapping(path = "api/v1/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }


    @GetMapping("api/v1/customers/{customerId}") 
    public Customer getCustomer(
        @PathVariable("customerId") Integer customerId){

         return customerService.getCustomer(customerId);
        }

}
