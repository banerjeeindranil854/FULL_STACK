package com.hackfse.fdbck.mgmt.systm.res.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

@Api
@ApiModel(value="outReachEventSummeryRspVo")
@JsonInclude(value = Include.NON_EMPTY)
public class OutReachEventSummeryRspVo implements Serializable{

	private static final long serialVersionUID = -478281577225231054L;
	private String eventId;
	private String month;
	private String baseLocation;
	private String beneficiaryName;
	private String venueAddress;
	private String councilName;
	private String project;
	private String category;
	private String eventName;
	private String eventDescription;
	private String eventDate;
	private String totalVolunteer;
	private String totalVolunteerHour;
	private String totalTravleHoures;
	private String overallVolunteerHours;

	public OutReachEventSummeryRspVo() {
		super();
	}

	public OutReachEventSummeryRspVo(String eventId, String month, String baseLocation, String beneficiaryName,
			String venueAddress, String councilName, String project, String category, String eventName,
			String eventDescription, String eventDate, String totalVolunteer,String totalVolunteerHour, String totalTravleHoures,
			String overallVolunteerHours) {
		this.eventId = eventId;
		this.month = month;
		this.baseLocation = baseLocation;
		this.beneficiaryName = beneficiaryName;
		this.venueAddress = venueAddress;
		this.councilName = councilName;
		this.totalVolunteerHour=totalVolunteerHour;
		this.project = project;
		this.category = category;
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventDate = eventDate;
		this.totalVolunteer = totalVolunteer;
		this.totalTravleHoures = totalTravleHoures;
		this.overallVolunteerHours = overallVolunteerHours;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getVenueAddress() {
		return venueAddress;
	}

	public void setVenueAddress(String venueAddress) {
		this.venueAddress = venueAddress;
	}

	public String getCouncilName() {
		return councilName;
	}

	public void setCouncilName(String councilName) {
		this.councilName = councilName;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getTotalVolunteer() {
		return totalVolunteer;
	}

	public void setTotalVolunteer(String totalVolunteer) {
		this.totalVolunteer = totalVolunteer;
	}

	public String getTotalVolunteerHour() {
		return totalVolunteerHour;
	}

	public void setTotalVolunteerHour(String totalVolunteerHour) {
		this.totalVolunteerHour = totalVolunteerHour;
	}

	public String getTotalTravleHoures() {
		return totalTravleHoures;
	}

	public void setTotalTravleHoures(String totalTravleHoures) {
		this.totalTravleHoures = totalTravleHoures;
	}

	public String getOverallVolunteerHours() {
		return overallVolunteerHours;
	}

	public void setOverallVolunteerHours(String overallVolunteerHours) {
		this.overallVolunteerHours = overallVolunteerHours;
	}
}
