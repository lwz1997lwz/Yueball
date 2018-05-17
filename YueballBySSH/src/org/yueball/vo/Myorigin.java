 package org.yueball.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Myorigin entity. @author MyEclipse Persistence Tools
 */

public class Myorigin implements java.io.Serializable {

	// Fields

	private String mylogname;
	private Integer matchId;
	private Set ballmatchs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Myorigin() {
	}

	/** minimal constructor */
	public Myorigin(Integer matchId) {
		this.matchId = matchId;
	}

	/** full constructor */
	public Myorigin(Integer matchId, Set ballmatchs) {
		this.matchId = matchId;
		this.ballmatchs = ballmatchs;
	}

	// Property accessors

	public String getMylogname() {
		return this.mylogname;
	}

	public void setMylogname(String mylogname) {
		this.mylogname = mylogname;
	}

	public Integer getMatchId() {
		return this.matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public Set getBallmatchs() {
		return this.ballmatchs;
	}

	public void setBallmatchs(Set ballmatchs) {
		this.ballmatchs = ballmatchs;
	}

}