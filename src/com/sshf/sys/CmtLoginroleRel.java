package com.sshf.sys;

/**
 * CmtLoginroleRel entity. @author MyEclipse Persistence Tools
 */

public class CmtLoginroleRel implements java.io.Serializable {

	// Fields

	private CmtLoginroleRelId id;

	// Constructors

	/** default constructor */
	public CmtLoginroleRel() {
	}

	/** full constructor */
	public CmtLoginroleRel(CmtLoginroleRelId id) {
		this.id = id;
	}

	// Property accessors

	public CmtLoginroleRelId getId() {
		return this.id;
	}

	public void setId(CmtLoginroleRelId id) {
		this.id = id;
	}

}