package com.cg.apps.employeems.dao;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.apps.employeems.entities.Employee;
import com.cg.apps.employeems.exceptions.EmployeeNotFoundException;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private EntityManager entity;

	@Override
	public void add(Employee emp) {
		entity.persist(emp);

	}

	@Override
	public Employee findById(int id) {
		Employee emp = entity.find(Employee.class,id);
		if(emp==null) {
			throw new EmployeeNotFoundException("Employee does not exists for id ="+id);
		}
		return emp;

	}

	@Override
	public List<Employee> findAll() {
		String st="from Employee";
		TypedQuery<Employee> query = entity.createQuery(st, Employee.class);
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee update(Employee employee) {
		employee = entity.merge(employee);
		return employee;
	}

	@Override
	public void deleteById(int id) {
		Employee emp=findById(id);
		entity.remove(emp);

	}

}
