package com.hackfse.fdbck.mgmt.systm.XL.model;

public class ReportFormat {
	private String eventId;
	private String empId;
	private String baseLocation;
	private String Project;
	public ReportFormat() {
		super();
	}
	public ReportFormat(String eventId,String empId,String baseLocation,String Project) {
		this.eventId=eventId;
		this.empId=empId;
		this.baseLocation=baseLocation;
		this.Project=Project;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getBaseLocation() {
		return baseLocation;
	}
	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}
	public String getProject() {
		return Project;
	}
	public void setProject(String project) {
		Project = project;
	}
	
}
