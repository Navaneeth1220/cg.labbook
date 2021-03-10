package com.cg.apps.departmentms.service;

import com.cg.apps.departmentms.entities.Department;

public interface IDepartmentService {
	
	Department add(String name);
	
	Department addEmpToDept(int deptId,int empId);
	
	Department removeEmpFromDept(int deptId,int empId);
	
	Department findById(int deptId);
}
