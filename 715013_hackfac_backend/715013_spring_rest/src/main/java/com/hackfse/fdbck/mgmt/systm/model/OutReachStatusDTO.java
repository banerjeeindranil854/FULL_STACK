package com.hackfse.fdbck.mgmt.systm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "outreach_feedback_status")
public class OutReachStatusDTO {
	
	@Column(name = "event_id")
	private String eventId;

	@Id
	@Column(name = "emp_id")
	private String empId;

	@Column(name = "rating")
	private String rating;
	
	@Column(name = "description")
	private String description;

	public OutReachStatusDTO() {
		super();
	}

	public OutReachStatusDTO(String eventId, String empId, String rating, String description) {
		this.eventId = eventId;
		this.empId = empId;
		this.rating=rating;
		this.description=description;
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

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
