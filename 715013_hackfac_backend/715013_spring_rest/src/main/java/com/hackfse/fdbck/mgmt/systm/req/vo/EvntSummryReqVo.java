package com.hackfse.fdbck.mgmt.systm.req.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class EvntSummryReqVo implements Serializable {

	private static final long serialVersionUID = -7521951021178985633L;
	
	private String evntId;
	private String month;
	private String baseLocatn;
	private String benefName;
	private String venueAddrss;
	private String councilNm;
	private String prjctNm;
	private String category;
	private String evntNm;
	private String eventDesc;
	private LocalDateTime evntDt;
	private int voluntrsCnt;
	private int voluntrHrs;
	private int trvlHrs;
	private int vluntrHrsSum;
	private int impctdLivs;
	private int actType;
	private String status;
	private int pocId;
	private String pocNm;
	private String pocCntctNum;
	
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
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * @return the baseLocatn
	 */
	public String getBaseLocatn() {
		return baseLocatn;
	}
	/**
	 * @param baseLocatn the baseLocatn to set
	 */
	public void setBaseLocatn(String baseLocatn) {
		this.baseLocatn = baseLocatn;
	}
	/**
	 * @return the benefName
	 */
	public String getBenefName() {
		return benefName;
	}
	/**
	 * @param benefName the benefName to set
	 */
	public void setBenefName(String benefName) {
		this.benefName = benefName;
	}
	/**
	 * @return the venueAddrss
	 */
	public String getVenueAddrss() {
		return venueAddrss;
	}
	/**
	 * @param venueAddrss the venueAddrss to set
	 */
	public void setVenueAddrss(String venueAddrss) {
		this.venueAddrss = venueAddrss;
	}
	/**
	 * @return the councilNm
	 */
	public String getCouncilNm() {
		return councilNm;
	}
	/**
	 * @param councilNm the councilNm to set
	 */
	public void setCouncilNm(String councilNm) {
		this.councilNm = councilNm;
	}
	/**
	 * @return the prjctNm
	 */
	public String getPrjctNm() {
		return prjctNm;
	}
	/**
	 * @param prjctNm the prjctNm to set
	 */
	public void setPrjctNm(String prjctNm) {
		this.prjctNm = prjctNm;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the evntNm
	 */
	public String getEvntNm() {
		return evntNm;
	}
	/**
	 * @param evntNm the evntNm to set
	 */
	public void setEvntNm(String evntNm) {
		this.evntNm = evntNm;
	}
	/**
	 * @return the eventDesc
	 */
	public String getEventDesc() {
		return eventDesc;
	}
	/**
	 * @param eventDesc the eventDesc to set
	 */
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	/**
	 * @return the evntDt
	 */
	public LocalDateTime getEvntDt() {
		return evntDt;
	}
	/**
	 * @param evntDt the evntDt to set
	 */
	public void setEvntDt(LocalDateTime evntDt) {
		this.evntDt = evntDt;
	}
	/**
	 * @return the voluntrsCnt
	 */
	public int getVoluntrsCnt() {
		return voluntrsCnt;
	}
	/**
	 * @param voluntrsCnt the voluntrsCnt to set
	 */
	public void setVoluntrsCnt(int voluntrsCnt) {
		this.voluntrsCnt = voluntrsCnt;
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
	 * @return the vluntrHrsSum
	 */
	public int getVluntrHrsSum() {
		return vluntrHrsSum;
	}
	/**
	 * @param vluntrHrsSum the vluntrHrsSum to set
	 */
	public void setVluntrHrsSum(int vluntrHrsSum) {
		this.vluntrHrsSum = vluntrHrsSum;
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
	 * @return the pocId
	 */
	public int getPocId() {
		return pocId;
	}
	/**
	 * @param pocId the pocId to set
	 */
	public void setPocId(int pocId) {
		this.pocId = pocId;
	}
	/**
	 * @return the pocNm
	 */
	public String getPocNm() {
		return pocNm;
	}
	/**
	 * @param pocNm the pocNm to set
	 */
	public void setPocNm(String pocNm) {
		this.pocNm = pocNm;
	}
	/**
	 * @return the pocCntctNum
	 */
	public String getPocCntctNum() {
		return pocCntctNum;
	}
	/**
	 * @param pocCntctNum the pocCntctNum to set
	 */
	public void setPocCntctNum(String pocCntctNum) {
		this.pocCntctNum = pocCntctNum;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EvntSummryReqVo [evntId=" + evntId + ", month=" + month + ", baseLocatn=" + baseLocatn + ", benefName="
				+ benefName + ", venueAddrss=" + venueAddrss + ", councilNm=" + councilNm + ", prjctNm=" + prjctNm
				+ ", category=" + category + ", evntNm=" + evntNm + ", eventDesc=" + eventDesc + ", evntDt=" + evntDt
				+ ", voluntrsCnt=" + voluntrsCnt + ", voluntrHrs=" + voluntrHrs + ", trvlHrs=" + trvlHrs
				+ ", vluntrHrsSum=" + vluntrHrsSum + ", impctdLivs=" + impctdLivs + ", actType=" + actType + ", status="
				+ status + ", pocId=" + pocId + ", pocNm=" + pocNm + ", pocCntctNum=" + pocCntctNum + "]";
	}
	
}
