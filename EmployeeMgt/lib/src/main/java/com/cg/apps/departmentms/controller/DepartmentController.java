package com.cg.apps.departmentms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.departmentms.dto.AddDepartmentRequest;
import com.cg.apps.departmentms.dto.AddEmpToDeptRequest;
import com.cg.apps.departmentms.dto.DepartmentDetails;
import com.cg.apps.departmentms.entities.Department;
import com.cg.apps.departmentms.service.IDepartmentService;
import com.cg.apps.departmentms.util.DepartmentUtil;

@RequestMapping("/departments")
@RestController
public class DepartmentController {
	
	@Autowired
	private IDepartmentService deptService;
	
	@Autowired
	private DepartmentUtil deptUtil;
	
	@PostMapping("/add}")
	public DepartmentDetails addDept(@RequestBody AddDepartmentRequest requestData) {
		Department dept=deptService.add(requestData.getName());
		DepartmentDetails details = deptUtil.toDepartmentDetails(dept);
		return details;
		
	}
	
	@GetMapping("/byid/{id}")
	public DepartmentDetails fetchDepartment(@PathVariable("id")int id) {
		Department dept=deptService.findById(id);
		DepartmentDetails details=deptUtil.toDepartmentDetails(dept);
		return details;
	}
	
	@PostMapping("/employees/add")
	public DepartmentDetails addEmpToDept(@RequestBody AddEmpToDeptRequest requestData) {
		Department dept=deptService.addEmpToDept(requestData.getDeptId(),requestData.getEmpId());
		DepartmentDetails details = deptUtil.toDepartmentDetails(dept);
		return details;
	}
	
}
