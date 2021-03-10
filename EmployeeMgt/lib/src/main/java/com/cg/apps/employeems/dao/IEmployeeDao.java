package com.cg.apps.employeems.dao;

import com.cg.apps.employeems.entities.Employee;
import java.util.List;

public interface IEmployeeDao {
	
	void add(Employee emp);
	
	Employee findById(int id);
	
	List<Employee> findAll();
	
	Employee update(Employee employee);
	
	void deleteById(int id);

}
