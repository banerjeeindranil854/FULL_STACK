package com.hackfse.fdbck.mgmt.systm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "outreach_event_role")
public class OutReachEventRoleDTO {
	
	@Id
	@Column(name = "emp_id")
	private String empId;
	
	@Column(name = "emp_role")
	private String empRole;

	public OutReachEventRoleDTO() {
		super();
	}

	public OutReachEventRoleDTO(String empId, String empRole) {
		this.empRole = empRole;
		this.empId = empId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	

}