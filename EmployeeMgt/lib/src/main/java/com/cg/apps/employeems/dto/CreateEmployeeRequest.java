package com.cg.apps.employeems.dto;

public class CreateEmployeeRequest {
	private String name;
	private int deptId;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
}
