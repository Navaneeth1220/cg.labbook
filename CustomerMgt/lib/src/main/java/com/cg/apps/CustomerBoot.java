package com.cg.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.apps.customerms.ui.CustomerUI;

@SpringBootApplication
public class CustomerBoot {
	
	public static void main(String args[]) {
	
	ConfigurableApplicationContext context = SpringApplication.run(CustomerBoot.class, args);
	CustomerUI customer = context.getBean(CustomerUI.class);
	customer.start();
	}
}
