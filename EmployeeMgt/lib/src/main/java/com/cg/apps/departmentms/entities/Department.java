package com.cg.apps.departmentms.entities;

import com.cg.apps.employeems.entities.Employee;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@GeneratedValue
	@Id
	private Integer deptId;

	private String name;

	@OneToMany(mappedBy = "department")
	private Set<Employee> employees;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public String toString() {
		return "Department [deptId=" + deptId + ", name=" + name + ", employees=" + employees + "]";
	}


}
