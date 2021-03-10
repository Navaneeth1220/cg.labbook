package com.cg.apps.employeems.contollers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.employeems.dto.ChangeNameRequest;
import com.cg.apps.employeems.dto.CreateEmployeeRequest;
import com.cg.apps.employeems.dto.DeleteEmployeeRequest;
import com.cg.apps.employeems.dto.EmployeeDetails;
import com.cg.apps.employeems.entities.Employee;
import com.cg.apps.employeems.service.IEmployeeService;
import com.cg.apps.employeems.util.EmployeeUtil;

@RequestMapping("/employees")
@RestController
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeService service;
	
	@Autowired
	private EmployeeUtil employeeUtil;
	
	@GetMapping(value="/byid/{id}")
	public EmployeeDetails fetchEmployee(@PathVariable("id") int id)
	{
		Employee emp=service.findById(id);
		EmployeeDetails details=employeeUtil.toDetails(emp);
		return details;
	}
	
	@GetMapping
	public List<EmployeeDetails> allEmployees(){
		List<Employee> list=service.findAll();
		List<EmployeeDetails> detials=employeeUtil.toDetails(list);
		return detials;
		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public String addEmployee(@RequestBody CreateEmployeeRequest requestData) {
		Employee newEmp= service.addEmployee(requestData.getName());
		return "Created Employee with ID = "+newEmp.getId();
				
	}
	
	
	@PutMapping("/changename")
	public EmployeeDetails changeName(@RequestBody ChangeNameRequest change)
	{
		Employee emp = service.updateName(change.getId(),change.getName());
		EmployeeDetails changed = employeeUtil.toDetails(emp);
		return changed;
	}
	
	@DeleteMapping("/delete")
	public String deleteEmployee(@RequestBody DeleteEmployeeRequest delete ) {
		service.deleteById(delete.getId());
		return "Employee of ID = "+delete.getId()+"has been deleted";
	}
	
	
	
	
}
