package com.sshf.sys;

import java.sql.Timestamp;

/**
 * CmtRoleDict entity. @author MyEclipse Persistence Tools
 */

public class CmtRoleDict implements java.io.Serializable {

	// Fields

	private Long roleId;
	private String roleName;
	private Timestamp createTime;
	private String roleDesc;

	// Constructors

	/** default constructor */
	public CmtRoleDict() {
	}

	/** full constructor */
	public CmtRoleDict(String roleName, Timestamp createTime, String roleDesc) {
		this.roleName = roleName;
		this.createTime = createTime;
		this.roleDesc = roleDesc;
	}

	// Property accessors

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

}