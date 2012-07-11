package com.sshf.sys;

/**
 * CmtRolepopedomRelId entity. @author MyEclipse Persistence Tools
 */

public class CmtRolepopedomRelId implements java.io.Serializable {

	// Fields

	private Long roleId;
	private Long modId;

	// Constructors

	/** default constructor */
	public CmtRolepopedomRelId() {
	}

	/** full constructor */
	public CmtRolepopedomRelId(Long roleId, Long modId) {
		this.roleId = roleId;
		this.modId = modId;
	}

	// Property accessors

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getModId() {
		return this.modId;
	}

	public void setModId(Long modId) {
		this.modId = modId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CmtRolepopedomRelId))
			return false;
		CmtRolepopedomRelId castOther = (CmtRolepopedomRelId) other;

		return ((this.getRoleId() == castOther.getRoleId()) || (this
				.getRoleId() != null && castOther.getRoleId() != null && this
				.getRoleId().equals(castOther.getRoleId())))
				&& ((this.getModId() == castOther.getModId()) || (this
						.getModId() != null && castOther.getModId() != null && this
						.getModId().equals(castOther.getModId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		result = 37 * result
				+ (getModId() == null ? 0 : this.getModId().hashCode());
		return result;
	}

}