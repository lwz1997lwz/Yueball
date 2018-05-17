package org.yueball.vo;

/**
 * Ballmatch entity. @author MyEclipse Persistence Tools
 */

public class Ballmatch implements java.io.Serializable {

	// Fields

	private Integer matchId;
	private String matchType;
	private String matchDate;
	private String matchOriginator;
	private String matchDifficulty;
	private String matchLimit;
	private String matchAddress;
	private Integer matchJoinnum;
	private String matchMess;

	// Constructors

	/** default constructor */
	public Ballmatch() {
	}

	/** full constructor */
	public Ballmatch(String matchType, String matchDate, String matchOriginator, String matchDifficulty,
			String matchLimit, String matchAddress, Integer matchJoinnum, String matchMess) {
		this.matchType = matchType;
		this.matchDate = matchDate;
		this.matchOriginator = matchOriginator;
		this.matchDifficulty = matchDifficulty;
		this.matchLimit = matchLimit;
		this.matchAddress = matchAddress;
		this.matchJoinnum = matchJoinnum;
		this.matchMess = matchMess;
	}

	// Property accessors

	public Integer getMatchId() {
		return this.matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public String getMatchType() {
		return this.matchType;
	}

	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}

	public String getMatchDate() {
		return this.matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public String getMatchOriginator() {
		return this.matchOriginator;
	}

	public void setMatchOriginator(String matchOriginator) {
		this.matchOriginator = matchOriginator;
	}

	public String getMatchDifficulty() {
		return this.matchDifficulty;
	}

	public void setMatchDifficulty(String matchDifficulty) {
		this.matchDifficulty = matchDifficulty;
	}

	public String getMatchLimit() {
		return this.matchLimit;
	}

	public void setMatchLimit(String matchLimit) {
		this.matchLimit = matchLimit;
	}

	public String getMatchAddress() {
		return this.matchAddress;
	}

	public void setMatchAddress(String matchAddress) {
		this.matchAddress = matchAddress;
	}

	public Integer getMatchJoinnum() {
		return this.matchJoinnum;
	}

	public void setMatchJoinnum(Integer matchJoinnum) {
		this.matchJoinnum = matchJoinnum;
	}

	public String getMatchMess() {
		return this.matchMess;
	}

	public void setMatchMess(String matchMess) {
		this.matchMess = matchMess;
	}

}