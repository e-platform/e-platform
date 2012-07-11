package com.sshf.sys;

/**
 * CmtPopedomDict entity. @author MyEclipse Persistence Tools
 */

public class CmtPopedomDict implements java.io.Serializable {

	// Fields

	private Long modId;
	private String modName;
	private String modPath;
	private String modDesc;

	// Constructors

	/** default constructor */
	public CmtPopedomDict() {
	}

	/** full constructor */
	public CmtPopedomDict(String modName, String modPath, String modDesc) {
		this.modName = modName;
		this.modPath = modPath;
		this.modDesc = modDesc;
	}

	// Property accessors

	public Long getModId() {
		return this.modId;
	}

	public void setModId(Long modId) {
		this.modId = modId;
	}

	public String getModName() {
		return this.modName;
	}

	public void setModName(String modName) {
		this.modName = modName;
	}

	public String getModPath() {
		return this.modPath;
	}

	public void setModPath(String modPath) {
		this.modPath = modPath;
	}

	public String getModDesc() {
		return this.modDesc;
	}

	public void setModDesc(String modDesc) {
		this.modDesc = modDesc;
	}

}