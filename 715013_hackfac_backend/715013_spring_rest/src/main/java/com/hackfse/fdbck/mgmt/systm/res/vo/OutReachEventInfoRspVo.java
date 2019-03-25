package com.hackfse.fdbck.mgmt.systm.res.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

@Api
@ApiModel(value="outReachEventInfoRspVo")
@JsonInclude(value = Include.NON_EMPTY)
public class OutReachEventInfoRspVo implements Serializable{
	
	private static final long serialVersionUID = -2393424606888519684L;
	private String eventId;
	private String baseLocation;
	private String beneficiaryName;
	private String councilName;
	private String eventName;
	private String eventDescription;
	private String eventDate;
	private String empId;
	private String empName;
	private String volunteerHour;
	private String travleHoures;
	private String livesImpacted;
	private String businessUnit;
	private String status;
	private String iIEPCategory;

	public OutReachEventInfoRspVo() {
		super();
	}

	public OutReachEventInfoRspVo(String eventId, String baseLocation, String beneficiaryName, String councilName,
			String eventName, String eventDescription, String eventDate, String empId, String empName,
			String volunteerHour, String travleHoures, String livesImpacted, String businessUnit, String status,
			String iIEPCategory) {
		this.eventId = eventId;
		this.baseLocation = baseLocation;
		this.beneficiaryName = beneficiaryName;
		this.councilName = councilName;
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventDate = eventDate;
		this.empId = empId;
		this.empName = empName;
		this.volunteerHour = volunteerHour;
		this.travleHoures = travleHoures;
		this.livesImpacted = livesImpacted;
		this.businessUnit = businessUnit;
		this.status = status;
		this.iIEPCategory = iIEPCategory;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
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

	public String getCouncilName() {
		return councilName;
	}

	public void setCouncilName(String councilName) {
		this.councilName = councilName;
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

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getVolunteerHour() {
		return volunteerHour;
	}

	public void setVolunteerHour(String volunteerHour) {
		this.volunteerHour = volunteerHour;
	}

	public String getTravleHoures() {
		return travleHoures;
	}

	public void setTravleHoures(String travleHoures) {
		this.travleHoures = travleHoures;
	}

	public String getLivesImpacted() {
		return livesImpacted;
	}

	public void setLivesImpacted(String livesImpacted) {
		this.livesImpacted = livesImpacted;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIIEPCategory() {
		return iIEPCategory;
	}

	public void setIIEPCategory(String iIEPCategory) {
		this.iIEPCategory = iIEPCategory;
	}

	
}
