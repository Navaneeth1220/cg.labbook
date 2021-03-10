package com.cg.apps.employeems.service;

import java.util.List;


import com.cg.apps.employeems.entities.Employee;

public interface IEmployeeService {

	Employee addEmployee(String name);

	Employee findById(int id);

	List<Employee> findAll();

	Employee updateName(int id, String name);

	void deleteById(int id);
}
