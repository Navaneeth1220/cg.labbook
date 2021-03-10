package com.cg.apps.employeems.util;

import java.util.ArrayList;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.cg.apps.employeems.dto.EmployeeDetails;
import com.cg.apps.employeems.entities.Employee;
import java.util.List;

@Component
public class EmployeeUtil {

	public EmployeeDetails toDetails(Employee emp) {
		EmployeeDetails detials = new EmployeeDetails(emp.getId(), emp.getName());
		return detials;
	}

	public List<EmployeeDetails> toDetails(Collection<Employee> employees) {

		List<EmployeeDetails> list = new ArrayList<>();

		for (Employee emp : employees) {
			EmployeeDetails details = toDetails(emp);
			list.add(details);
		}
		return list;
	}
}
