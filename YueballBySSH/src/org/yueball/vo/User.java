package org.yueball.vo;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String logname;
	private String password;
	private String phone;
	private String qq;
	private String school;
	private String realname;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String logname) {
		this.logname = logname;
	}

	/** full constructor */
	public User(String logname, String password, String phone, String qq, String school, String realname) {
		this.logname = logname;
		this.password = password;
		this.phone = phone;
		this.qq = qq;
		this.school = school;
		this.realname = realname;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getLogname() {
		return this.logname;
	}

	public void setLogname(String logname) {
		this.logname = logname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

}