package com.cg.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.apps.employeems.ui.EmployeeUI;

@SpringBootApplication
public class EmployeeBoot {
	public static void main(String args[]) {

		ConfigurableApplicationContext context = SpringApplication.run(EmployeeBoot.class, args);
		EmployeeUI employeeUI = context.getBean(EmployeeUI.class);
		employeeUI.start();
	}

}
