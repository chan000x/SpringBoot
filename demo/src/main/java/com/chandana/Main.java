package com.chandana;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@SpringBootApplication
@RestController  
public class Main { 
    // db for now
    private static List<Customer> customers;
    static{
        customers = new ArrayList<>();
        Customer alex = new Customer(
            1,
            "Alex",
            "Alex@gmail.com",
            21
        );
        Customer jamila = new Customer(
            2,
            "Jamila",
            "Jamila@gmail.com",
            19
        );
        customers.add(alex);
        customers.add(jamila);
    }
    public static void main(String[] args){
       SpringApplication.run(Main.class, args);
    }

    public String requestMethodName(@RequestParam String param) {
        return new String();
    }
    
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

   // @GetMapping("api/v1/customers") //this one and requestmapping is same.
    @RequestMapping(path = "api/v1/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers(){
        return customers;
    }
    @GetMapping("api/v1/customers/{id}") 
    public Customer getCustomer(@PathVariable("id") int customerId){
        return customers.stream()
        .filter(customer -> customer.id.equals(customerId))
        .findFirst()
        .orElseThrow(
            ()-> new IllegalArgumentException("customer %s".formatted(customerId)));
    }

    static class Customer{
        private Integer id;
        private String name;
        private String email;
        private Integer age;

        
        public Customer() {
        }
        public Customer(Integer id, String name, String email, Integer age) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.age = age;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public void setAge(Integer age) {
            this.age = age;
        }
        public Integer getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public String getEmail() {
            return email;
        }
        public Integer getAge() {
            return age;
        }
        @Override
        public String toString() {
            return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + "]";
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getEnclosingInstance().hashCode();
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + ((email == null) ? 0 : email.hashCode());
            result = prime * result + ((age == null) ? 0 : age.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Customer other = (Customer) obj;
            if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
                return false;
            if (id == null) {
                if (other.id != null)
                    return false;
            } else if (!id.equals(other.id))
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            if (email == null) {
                if (other.email != null)
                    return false;
            } else if (!email.equals(other.email))
                return false;
            if (age == null) {
                if (other.age != null)
                    return false;
            } else if (!age.equals(other.age))
                return false;
            return true;
        }
        private Customer getEnclosingInstance() {
            return Customer.this;
        }

        

    }


}  
