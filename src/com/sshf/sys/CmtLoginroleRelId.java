package com.sshf.sys;

/**
 * CmtLoginroleRelId entity. @author MyEclipse Persistence Tools
 */

public class CmtLoginroleRelId implements java.io.Serializable {

	// Fields

	private String loginNo;
	private Long roleId;

	// Constructors

	/** default constructor */
	public CmtLoginroleRelId() {
	}

	/** full constructor */
	public CmtLoginroleRelId(String loginNo, Long roleId) {
		this.loginNo = loginNo;
		this.roleId = roleId;
	}

	// Property accessors

	public String getLoginNo() {
		return this.loginNo;
	}

	public void setLoginNo(String loginNo) {
		this.loginNo = loginNo;
	}

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CmtLoginroleRelId))
			return false;
		CmtLoginroleRelId castOther = (CmtLoginroleRelId) other;

		return ((this.getLoginNo() == castOther.getLoginNo()) || (this
				.getLoginNo() != null && castOther.getLoginNo() != null && this
				.getLoginNo().equals(castOther.getLoginNo())))
				&& ((this.getRoleId() == castOther.getRoleId()) || (this
						.getRoleId() != null && castOther.getRoleId() != null && this
						.getRoleId().equals(castOther.getRoleId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getLoginNo() == null ? 0 : this.getLoginNo().hashCode());
		result = 37 * result
				+ (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		return result;
	}

}