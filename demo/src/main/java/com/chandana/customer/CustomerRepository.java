package com.chandana.customer;

import org.springframework.data.jpa.repository.JpaRepository;

// @Repository, no need to add this annotation because by default it added.
public interface CustomerRepository 
        extends JpaRepository<Customer,Integer> {


}
