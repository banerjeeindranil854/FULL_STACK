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
@ApiModel(value="OutReachXlRspVo")
@JsonInclude(value = Include.NON_EMPTY)
public class OutReachXlRspVo implements Serializable{
	
	private static final long serialVersionUID = -7349428574390084412L;
	private String path;

	public OutReachXlRspVo() {
		super();
	}

	public OutReachXlRspVo(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("path", this.path).toString();
	}

}
