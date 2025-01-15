package com.chandana;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
// @ComponentScan(basePackages = "com.chandana")
// @EnableAutoConfiguration
// @Configuration
// all these 3 inluded in @SpringBootApplication annotation
@RestController  // this mean any method has getmapping or setmapping postmapping will be eposed as rest endpoints that client able to call.
public class Main { 

    public static void main(String[] args){
       SpringApplication.run(Main.class, args);


    }
    @GetMapping("/greet")
    public GreetResponse greet(
        @RequestParam( value = "name",required = false ) String name ){
        
        String greetMessage = name == null || name.isBlank() ? "Hello ": "Hello " +  name;
            GreetResponse response =  new GreetResponse(
            greetMessage,
            List.of("java","python","C++"),
            new Person("Chandana",28,3000.00));

        return response;
    }

    record GreetResponse(
        String greet,
        List<String> favProgrammingLanguages,
        Person person){ }


    record Person(String name, int age, double savings){}

//   this class is same as greetResponse method in above.
//    class GreetResponse{
//     private final String greet;

//     public GreetResponse(String greet) {
//         this.greet = greet;
//     }

//     public String getGreet(){
//         return greet;
//     }

//     @Override
//     public String toString() {
//         return "greetResponse from class {greet=" + greet + "}";
//     }

//     @Override
//     public int hashCode() {
//         final int prime = 31;
//         int result = 1;
//         result = prime * result + getEnclosingInstance().hashCode();
//         result = prime * result + ((greet == null) ? 0 : greet.hashCode());
//         return result;
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj)
//             return true;
//         if (obj == null)
//             return false;
//         if (getClass() != obj.getClass())
//             return false;
//         greetResponse other = (greetResponse) obj;
//         if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
//             return false;
//         if (greet == null) {
//             if (other.greet != null)
//                 return false;
//         } else if (!greet.equals(other.greet))
//             return false;
//         return true;
//     }

//     private Main getEnclosingInstance() {
//         return Main.this;
//     }
    
//    }
}  
