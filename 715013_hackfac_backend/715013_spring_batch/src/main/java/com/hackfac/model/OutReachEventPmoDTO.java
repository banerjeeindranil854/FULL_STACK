package com.hackfac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "outreach_event_pmo")
public class OutReachEventPmoDTO {
	
	@Column(name = "event_id")
	private String eventId;
	@Id
	@Column(name = "emp_id")
	private String empId;

	public OutReachEventPmoDTO() {
		super();
	}

	public OutReachEventPmoDTO(String eventId, String empId) {
		this.eventId = eventId;
		this.empId=empId;	
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

}