package com.mttrbit.example;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class GreetingService {
    public String hello(String name) {
    	return "Hello, " + name + "!";
    }
}
