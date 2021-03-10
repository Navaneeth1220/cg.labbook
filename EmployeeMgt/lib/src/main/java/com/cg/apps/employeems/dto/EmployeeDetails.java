package com.cg.apps.employeems.dto;

public class EmployeeDetails {
	private int id;
	private String name;
	
	public EmployeeDetails() {
		
	}
	
	public EmployeeDetails(int id,String name) {
		this.setId(id);
		this.setName(name);
	}

	public int getId() {
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


}
