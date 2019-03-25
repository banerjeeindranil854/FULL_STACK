/**
 * 
 */
package com.hackfse.fdbck.mgmt.systm.res.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

/**
 * @author Admin
 *
 */

@Api
@ApiModel(value = "outReachAllEvtRprtRspVo")
@JsonInclude(value = Include.NON_EMPTY)
public class OutReachReportFormat implements Serializable {

	private static final long serialVersionUID = 3302398578987585363L;

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
	@JsonProperty("evtAttendedSummry")
	private List<OutReachEventInfoRspVo> eventInfoRspVo = new ArrayList<>();
	@JsonProperty("evtNotRgstrdSummry")
	private List<OutReachNotRegisteredRspVo> notRegisteredRspVo = new ArrayList<>();
	@JsonProperty("evtRgstrdUnAtndedSummry")
	private List<OutReachRegisteredRspVo> outReachRegisteredRspVo = new ArrayList<>();

	/**
	 * @return the eventId
	 */
	public String getEventId() {
		return eventId;
	}

	/**
	 * @param eventId
	 *            the eventId to set
	 */
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return the baseLocation
	 */
	public String getBaseLocation() {
		return baseLocation;
	}

	/**
	 * @param baseLocation
	 *            the baseLocation to set
	 */
	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}

	/**
	 * @return the beneficiaryName
	 */
	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	/**
	 * @param beneficiaryName
	 *            the beneficiaryName to set
	 */
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	/**
	 * @return the venueAddress
	 */
	public String getVenueAddress() {
		return venueAddress;
	}

	/**
	 * @param venueAddress
	 *            the venueAddress to set
	 */
	public void setVenueAddress(String venueAddress) {
		this.venueAddress = venueAddress;
	}

	/**
	 * @return the councilName
	 */
	public String getCouncilName() {
		return councilName;
	}

	/**
	 * @param councilName
	 *            the councilName to set
	 */
	public void setCouncilName(String councilName) {
		this.councilName = councilName;
	}

	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName
	 *            the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return the eventDescription
	 */
	public String getEventDescription() {
		return eventDescription;
	}

	/**
	 * @param eventDescription
	 *            the eventDescription to set
	 */
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	/**
	 * @return the eventDate
	 */
	public String getEventDate() {
		return eventDate;
	}

	/**
	 * @param eventDate
	 *            the eventDate to set
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	/**
	 * @return the totalVolunteer
	 */
	public String getTotalVolunteer() {
		return totalVolunteer;
	}

	/**
	 * @param totalVolunteer
	 *            the totalVolunteer to set
	 */
	public void setTotalVolunteer(String totalVolunteer) {
		this.totalVolunteer = totalVolunteer;
	}

	/**
	 * @return the totalVolunteerHour
	 */
	public String getTotalVolunteerHour() {
		return totalVolunteerHour;
	}

	/**
	 * @param totalVolunteerHour
	 *            the totalVolunteerHour to set
	 */
	public void setTotalVolunteerHour(String totalVolunteerHour) {
		this.totalVolunteerHour = totalVolunteerHour;
	}

	/**
	 * @return the totalTravleHoures
	 */
	public String getTotalTravleHoures() {
		return totalTravleHoures;
	}

	/**
	 * @param totalTravleHoures
	 *            the totalTravleHoures to set
	 */
	public void setTotalTravleHoures(String totalTravleHoures) {
		this.totalTravleHoures = totalTravleHoures;
	}

	/**
	 * @return the overallVolunteerHours
	 */
	public String getOverallVolunteerHours() {
		return overallVolunteerHours;
	}

	/**
	 * @param overallVolunteerHours
	 *            the overallVolunteerHours to set
	 */
	public void setOverallVolunteerHours(String overallVolunteerHours) {
		this.overallVolunteerHours = overallVolunteerHours;
	}

	/**
	 * @return the eventInfoRspVo
	 */
	public List<OutReachEventInfoRspVo> getEventInfoRspVo() {
		return eventInfoRspVo;
	}

	/**
	 * @param eventInfoRspVo the eventInfoRspVo to set
	 */
	public void setEventInfoRspVo(List<OutReachEventInfoRspVo> eventInfoRspVo) {
		this.eventInfoRspVo = eventInfoRspVo;
	}

	/**
	 * @return the notRegisteredRspVo
	 */
	public List<OutReachNotRegisteredRspVo> getNotRegisteredRspVo() {
		return notRegisteredRspVo;
	}

	/**
	 * @param notRegisteredRspVo the notRegisteredRspVo to set
	 */
	public void setNotRegisteredRspVo(List<OutReachNotRegisteredRspVo> notRegisteredRspVo) {
		this.notRegisteredRspVo = notRegisteredRspVo;
	}

	/**
	 * @return the outReachRegisteredRspVo
	 */
	public List<OutReachRegisteredRspVo> getOutReachRegisteredRspVo() {
		return outReachRegisteredRspVo;
	}

	/**
	 * @param outReachRegisteredRspVo the outReachRegisteredRspVo to set
	 */
	public void setOutReachRegisteredRspVo(List<OutReachRegisteredRspVo> outReachRegisteredRspVo) {
		this.outReachRegisteredRspVo = outReachRegisteredRspVo;
	}
}
