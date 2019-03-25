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
@ApiModel(value="OutReachEventRoleRspVo")
@JsonInclude(value = Include.NON_EMPTY)
public class OutReachEventRoleRspVo implements Serializable{
	
	private static final long serialVersionUID = -7349428574390084412L;
	
	private String empId;
	private String empRole;
	public OutReachEventRoleRspVo() {
		super();
	}

	public OutReachEventRoleRspVo(String empRole,String empId) {
		this.empRole = empRole;
		this.empId = empId;
	}
	
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("empRole", this.empRole).append("empId", this.empId).toString();
	}

}
