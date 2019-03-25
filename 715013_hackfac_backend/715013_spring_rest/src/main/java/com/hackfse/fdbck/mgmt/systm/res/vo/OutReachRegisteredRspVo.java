package com.hackfse.fdbck.mgmt.systm.res.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

/**
 * Contains the information of a single anime
 *
 * @author Michael C Good michaelcgood.com
 */

@Api
@ApiModel(value="outReachRegisteredRspVo")
@JsonInclude(value = Include.NON_EMPTY)
public class OutReachRegisteredRspVo implements Serializable{
	
	private static final long serialVersionUID = -7349428574390084412L;
	private String eventId;
	private String eventName;
	private String beneficiaryName;
	private String baseLocation;
	private String eventDate;
	private String empId;

	public OutReachRegisteredRspVo() {
		super();
	}

	public OutReachRegisteredRspVo(String eventId, String eventName, String beneficiaryName, String baseLocation,
			String eventDate, String empId) {
		this.eventId = eventId;
		this.beneficiaryName = beneficiaryName;
		this.baseLocation = baseLocation;
		this.eventDate = eventDate;
		this.empId = empId;
		this.eventName=eventName;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
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

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("eventId", this.eventId).append("beneficiaryName", this.beneficiaryName)
				.append("baseLocation", this.baseLocation).append("eventDate", this.eventDate).append("empId", this.empId).toString();
	}

}
