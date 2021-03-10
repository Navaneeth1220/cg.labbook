package com.cg.apps.departmentms.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.departmentms.dao.IDepartmentDao;
import com.cg.apps.departmentms.entities.Department;
import com.cg.apps.employeems.dao.IEmployeeDao;
import com.cg.apps.employeems.entities.Employee;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private IDepartmentDao deptDao;

	@Autowired
	IEmployeeDao empDao;

	@Transactional
	@Override
	public Department add(String name) {
		Department dept = new Department();
		dept.setName(name);
		dept = deptDao.add(dept);
		return dept;
	}

	@Transactional
	@Override
	public Department addEmpToDept(int deptId, int empId) {
		Department dept = findById(deptId);
		Set<Employee> employees = dept.getEmployees();

		if (employees == null) {
			employees = new HashSet<>();
			dept.setEmployees(employees);
		}

		Employee emp = empDao.findById(empId);
		employees.add(emp);
		dept = deptDao.update(dept);
		emp.setDepartment(dept);
		empDao.update(emp);

		return dept;
	}

	@Transactional
	@Override
	public Department removeEmpFromDept(int deptId, int empId) {
		
		Department dept = findById(deptId);
		Set<Employee> employees = dept.getEmployees();
		
		if (employees == null) {
			return dept;
		}

		Employee emp = empDao.findById(empId);
		employees.remove(emp);
		return dept;
	}

	@Override
	public Department findById(int deptId) {
		Department dept = deptDao.findById(deptId);
		return dept;
	}

}
