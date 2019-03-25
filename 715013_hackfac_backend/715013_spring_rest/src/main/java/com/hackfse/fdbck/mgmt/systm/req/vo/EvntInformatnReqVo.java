package com.hackfse.fdbck.mgmt.systm.req.vo;

import java.io.Serializable;

public class EvntInformatnReqVo implements Serializable {

	private static final long serialVersionUID = -5832690923075420170L;

	private String evntId;
	private int voluntrHrs;
	private int trvlHrs;
	private int impctdLivs;
	private int actType;
	private String status;
	private int emplId;
	private String emplNm;
	private String bizUnitNm;
	private String catgry;

	/**
	 * @return the evntId
	 */
	public String getEvntId() {
		return evntId;
	}

	/**
	 * @param evntId the evntId to set
	 */
	public void setEvntId(String evntId) {
		this.evntId = evntId;
	}

	/**
	 * @return the voluntrHrs
	 */
	public int getVoluntrHrs() {
		return voluntrHrs;
	}

	/**
	 * @param voluntrHrs the voluntrHrs to set
	 */
	public void setVoluntrHrs(int voluntrHrs) {
		this.voluntrHrs = voluntrHrs;
	}

	/**
	 * @return the trvlHrs
	 */
	public int getTrvlHrs() {
		return trvlHrs;
	}

	/**
	 * @param trvlHrs the trvlHrs to set
	 */
	public void setTrvlHrs(int trvlHrs) {
		this.trvlHrs = trvlHrs;
	}

	/**
	 * @return the impctdLivs
	 */
	public int getImpctdLivs() {
		return impctdLivs;
	}

	/**
	 * @param impctdLivs the impctdLivs to set
	 */
	public void setImpctdLivs(int impctdLivs) {
		this.impctdLivs = impctdLivs;
	}

	/**
	 * @return the actType
	 */
	public int getActType() {
		return actType;
	}

	/**
	 * @param actType the actType to set
	 */
	public void setActType(int actType) {
		this.actType = actType;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the emplId
	 */
	public int getEmplId() {
		return emplId;
	}

	/**
	 * @param emplId the emplId to set
	 */
	public void setEmplId(int emplId) {
		this.emplId = emplId;
	}

	/**
	 * @return the emplNm
	 */
	public String getEmplNm() {
		return emplNm;
	}

	/**
	 * @param emplNm the emplNm to set
	 */
	public void setEmplNm(String emplNm) {
		this.emplNm = emplNm;
	}

	/**
	 * @return the bizUnitNm
	 */
	public String getBizUnitNm() {
		return bizUnitNm;
	}

	/**
	 * @param bizUnitNm the bizUnitNm to set
	 */
	public void setBizUnitNm(String bizUnitNm) {
		this.bizUnitNm = bizUnitNm;
	}

	/**
	 * @return the catgry
	 */
	public String getCatgry() {
		return catgry;
	}

	/**
	 * @param catgry the catgry to set
	 */
	public void setCatgry(String catgry) {
		this.catgry = catgry;
	}

	@Override
	public String toString() {
		return "EvntInformatnReqVo [evntId=" + evntId + ", voluntrHrs=" + voluntrHrs + ", trvlHrs=" + trvlHrs
				+ ", impctdLivs=" + impctdLivs + ", actType=" + actType + ", status=" + status + ", emplId=" + emplId
				+ ", emplNm=" + emplNm + ", bizUnitNm=" + bizUnitNm + ", catgry=" + catgry + "]";
	}

}
