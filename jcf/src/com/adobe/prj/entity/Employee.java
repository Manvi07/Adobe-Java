package com.adobe.prj.entity;

import com.adobe.prj.annotations.Column;
import com.adobe.prj.annotations.Table;

@Table(name="emp")
public class Employee {
	private int empId;
	private String email;
	
	@Column(name="EMP_ID", type="INTEGER")
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
