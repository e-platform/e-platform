package com.sshf.sys;

import java.sql.Timestamp;

/**
 * CmtLoginoprRd entity. @author MyEclipse Persistence Tools
 */

public class CmtLoginoprRd implements java.io.Serializable {

	// Fields

	private Long logId;
	private Timestamp opTime;
	private String loginNo;
	private String opContent;

	// Constructors

	/** default constructor */
	public CmtLoginoprRd() {
	}

	/** minimal constructor */
	public CmtLoginoprRd(Timestamp opTime, String loginNo) {
		this.opTime = opTime;
		this.loginNo = loginNo;
	}

	/** full constructor */
	public CmtLoginoprRd(Timestamp opTime, String loginNo, String opContent) {
		this.opTime = opTime;
		this.loginNo = loginNo;
		this.opContent = opContent;
	}

	// Property accessors

	public Long getLogId() {
		return this.logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public Timestamp getOpTime() {
		return this.opTime;
	}

	public void setOpTime(Timestamp opTime) {
		this.opTime = opTime;
	}

	public String getLoginNo() {
		return this.loginNo;
	}

	public void setLoginNo(String loginNo) {
		this.loginNo = loginNo;
	}

	public String getOpContent() {
		return this.opContent;
	}

	public void setOpContent(String opContent) {
		this.opContent = opContent;
	}

}