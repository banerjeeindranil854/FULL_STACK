package com.hackfse.fdbck.mgmt.systm.XL.model;

public class FeedbackResponse {
	private String eventId;
	private String empId;
	private String rating;
	private String description;
	public FeedbackResponse(String eventId,String empId,String rating,String description) {
		this.eventId=eventId;
		this.empId=empId;
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
