package com.cg.apps.departmentms.dao;

import com.cg.apps.departmentms.entities.Department;

public interface IDepartmentDao {
	
	Department add(Department dept);
	
	Department findById(int deptId);
	
	Department update(Department dept);

}
