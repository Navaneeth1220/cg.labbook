package com.cg.apps.employeems.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.cg.apps.departmentms.entities.Department;

public class Employee {
	@GeneratedValue
	@Id
	private Integer id;
	private String name;
	
	@ManyToOne
	private Department dept;

	public Employee() {
	}

	public Employee(String name) {
		this.setName(name);
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public void setDepartment(Department dept) {
		this.dept=dept;
		
	}
	public Department getDepartment() {
		return dept;
	}

}
