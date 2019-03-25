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
@ApiModel(value="OutReachStatusRspVo")
@JsonInclude(value = Include.NON_EMPTY)
public class OutReachStatusRspVo implements Serializable{
	
	private static final long serialVersionUID = -7349428574390084412L;
	private String eventId;
	private String empId;
	private String rating;
	private String description;

	public OutReachStatusRspVo() {
		super();
	}

	public OutReachStatusRspVo(String eventId,String empId,String rating,String description) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("eventId", this.eventId).append("empId", this.empId).append("rating", this.rating).append("description", this.description).toString();
	}

}
