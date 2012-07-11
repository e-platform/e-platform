package com.sshf.sys;

import java.sql.Timestamp;

/**
 * CmtLoginmsgDict entity. @author MyEclipse Persistence Tools
 */

public class CmtLoginmsgDict implements java.io.Serializable {

	// Fields

	private String loginNo;
	private String teamId;
	private String loginName;
	private String loginPwd;
	private String loginPhone;
	private Timestamp createTime;
	private String loginDesc;

	// Constructors

	/** default constructor */
	public CmtLoginmsgDict() {
	}

	/** full constructor */
	public CmtLoginmsgDict(String teamId, String loginName, String loginPwd,
			String loginPhone, Timestamp createTime, String loginDesc) {
		this.teamId = teamId;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.loginPhone = loginPhone;
		this.createTime = createTime;
		this.loginDesc = loginDesc;
	}

	// Property accessors

	public String getLoginNo() {
		return this.loginNo;
	}

	public void setLoginNo(String loginNo) {
		this.loginNo = loginNo;
	}

	public String getTeamId() {
		return this.teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getLoginPhone() {
		return this.loginPhone;
	}

	public void setLoginPhone(String loginPhone) {
		this.loginPhone = loginPhone;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getLoginDesc() {
		return this.loginDesc;
	}

	public void setLoginDesc(String loginDesc) {
		this.loginDesc = loginDesc;
	}

}