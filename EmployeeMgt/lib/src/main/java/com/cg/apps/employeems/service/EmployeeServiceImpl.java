package com.cg.apps.employeems.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.employeems.dao.IEmployeeDao;
import com.cg.apps.employeems.entities.Employee;
import com.cg.apps.employeems.exceptions.InvalidIdException;
import com.cg.apps.employeems.exceptions.NameNotValidException;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeDao dao;

	@Transactional
	public Employee addEmployee(String name) {
		validateName(name);
		Employee employee = new Employee(name);
		dao.add(employee);
		return employee;
	}

	public Employee findById(int id) {
		validateId(id);
		Employee emp;
		emp = dao.findById(id);
		return emp;
	}

	public List<Employee> findAll() {
		List<Employee> employees = dao.findAll();
		return employees;

	}
	
	@Transactional
	public Employee updateName(int id, String name) {
		Employee employee = findById(id);
		employee.setName(name);
		employee = dao.update(employee);
		return employee;

	}
	
	@Transactional
	public void deleteById(int id) {
		validateId(id);
		dao.deleteById(id);
	}


	void validateName(String name) {
		if (name == null || name.isEmpty() || name.trim().isEmpty()) {
			throw new NameNotValidException("name can't be null or empty");
		}
	}

	void validateId(int id) {
		if (id < 0) {
			throw new InvalidIdException("id should not be negative");
		}
	}

}
