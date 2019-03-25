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
@ApiModel(value="OutReachEventPmoRspVo")
@JsonInclude(value = Include.NON_EMPTY)
public class OutReachEventPmoRspVo implements Serializable{
	
	private static final long serialVersionUID = -7349428574390084412L;
	private String eventId;
	private String empId;

	public OutReachEventPmoRspVo() {
		super();
	}

	public OutReachEventPmoRspVo(String eventId,String empId) {
		this.eventId = eventId;
		this.empId = empId;
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

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("eventId", this.eventId).append("empId", this.empId).toString();
	}

}
