package com.cg.apps.employeems.ui;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.cg.apps.employeems.entities.Employee;
import com.cg.apps.employeems.exceptions.InvalidIdException;
import com.cg.apps.employeems.exceptions.NameNotValidException;
import com.cg.apps.employeems.service.IEmployeeService;

import java.util.Collection;
import java.util.List;

@Component
public class EmployeeUI {

	@Autowired
	private IEmployeeService service;

	public void start() {
		try {
			Employee stew = service.addEmployee("Stewie");
			display(stew);

			Employee naf = service.addEmployee("Naf");
			display(naf);
			
			Employee fetchedEmployee = service.findById(stew.getId());
			display(fetchedEmployee);
			
			List<Employee> list = service.findAll();
			displayAll(list);
		} catch (InvalidIdException e) {
			System.out.println(e.getMessage());
		} catch (NameNotValidException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Something is wrong");
		}
	}

	void displayAll(Collection<Employee> employees) {
		for (Employee emp : employees) {
			display(emp);
		}
	}

	void display(Employee emp) {
		System.out.println(emp.getId() + " " + emp.getName());
	}
}
