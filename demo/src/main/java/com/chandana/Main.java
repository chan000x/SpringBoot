package com.chandana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(scanBasePackages = "com.chandana.customer")
public class Main {  
   
    public static void main(String[] args){
       // CustomerService customerService = new CustomerService(new CustomerDataAccessService());
       // CustomerController customerController = new CustomerController (customerService);
      ConfigurableApplicationContext applicationContext = 
            SpringApplication.run(Main.class, args);

        //printBeans(applicationContext);

    } 
// these functions are outside of the ApplicationContext.
// So we need to manage by our selves.
// For that we use annotation @Bean
    @Bean("foo") // to give a our own name to a our created bean.
    public Foo getFoo(){
        return new Foo("bar");
    }
     record Foo(String name) {
    }

    private static void printBeans(ConfigurableApplicationContext ctx){
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}  
