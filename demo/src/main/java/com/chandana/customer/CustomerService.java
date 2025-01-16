package com.chandana.customer;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chandana.exception.ResourceNotFound;


// Business Layer

  @Service
public class CustomerService {

    private final CustomerDao customerDao;

    
   // @Autowired // this anotation used to dependancy inject in previous springboot version and no longer need it.
    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    public List<Customer> getAllCustomers(){
        return customerDao.selectAllCustomers();
    }

    public Customer getCustomer(Integer id){
        return customerDao.selectCustomerById(id)
        .orElseThrow(
            ()-> new ResourceNotFound("customer with id [$s] not found ".formatted(id)
            ));
    }

}
