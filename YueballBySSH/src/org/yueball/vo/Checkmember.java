package org.yueball.vo;

/**
 * Checkmember entity. @author MyEclipse Persistence Tools
 */

public class Checkmember implements java.io.Serializable {

	// Fields

	private Integer checkId;
	private Ballmatch ballmatch;
	private String checkLogname;
	private String checker;

	// Constructors

	/** default constructor */
	public Checkmember() {
	}

	/** full constructor */
	public Checkmember(Ballmatch ballmatch, String checkLogname, String checker) {
		this.ballmatch = ballmatch;
		this.checkLogname = checkLogname;
		this.checker = checker;
	}

	// Property accessors

	public Integer getCheckId() {
		return this.checkId;
	}

	public void setCheckId(Integer checkId) {
		this.checkId = checkId;
	}

	public Ballmatch getBallmatch() {
		return this.ballmatch;
	}

	public void setBallmatch(Ballmatch ballmatch) {
		this.ballmatch = ballmatch;
	}

	public String getCheckLogname() {
		return this.checkLogname;
	}

	public void setCheckLogname(String checkLogname) {
		this.checkLogname = checkLogname;
	}

	public String getChecker() {
		return this.checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

}