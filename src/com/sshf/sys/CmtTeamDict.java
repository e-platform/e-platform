package com.sshf.sys;

/**
 * CmtTeamDict entity. @author MyEclipse Persistence Tools
 */

public class CmtTeamDict implements java.io.Serializable {

	// Fields

	private String teamId;
	private String parTeamid;
	private String teamName;
	private String leaderLogin;

	// Constructors

	/** default constructor */
	public CmtTeamDict() {
	}

	/** full constructor */
	public CmtTeamDict(String parTeamid, String teamName, String leaderLogin) {
		this.parTeamid = parTeamid;
		this.teamName = teamName;
		this.leaderLogin = leaderLogin;
	}

	// Property accessors

	public String getTeamId() {
		return this.teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getParTeamid() {
		return this.parTeamid;
	}

	public void setParTeamid(String parTeamid) {
		this.parTeamid = parTeamid;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getLeaderLogin() {
		return this.leaderLogin;
	}

	public void setLeaderLogin(String leaderLogin) {
		this.leaderLogin = leaderLogin;
	}

}