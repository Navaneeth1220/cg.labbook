package com.cg.apps.departmentms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.apps.departmentms.dto.DepartmentDetails;
import com.cg.apps.departmentms.entities.Department;

@Component
public class DepartmentUtil {
	
	public DepartmentDetails toDepartmentDetails(Department dept) {
		
		DepartmentDetails deptDetails = new DepartmentDetails(dept.getDeptId(),dept.getName());
		return deptDetails;	
	}
	
	public List<DepartmentDetails> toDepartmentDetails(Collection<Department> departments){
		
		List<DepartmentDetails> desired=new ArrayList<>();
		
		for(Department dept:departments) {
			DepartmentDetails details = toDepartmentDetails(dept);
			desired.add(details);
		}
		return desired;
	}
	
}
