package org.yueball.vo;

import java.sql.Blob;

/**
 * Touxiang entity. @author MyEclipse Persistence Tools
 */

public class Touxiang implements java.io.Serializable {

	// Fields

	private Integer touxiangId;
	private String touxiangLogname;
	private Blob touxiangImage;

	// Constructors

	/** default constructor */
	public Touxiang() {
	}

	/** minimal constructor */
	public Touxiang(String touxiangLogname) {
		this.touxiangLogname = touxiangLogname;
	}

	/** full constructor */
	public Touxiang(String touxiangLogname, Blob touxiangImage) {
		this.touxiangLogname = touxiangLogname;
		this.touxiangImage = touxiangImage;
	}

	// Property accessors

	public Integer getTouxiangId() {
		return this.touxiangId;
	}

	public void setTouxiangId(Integer touxiangId) {
		this.touxiangId = touxiangId;
	}

	public String getTouxiangLogname() {
		return this.touxiangLogname;
	}

	public void setTouxiangLogname(String touxiangLogname) {
		this.touxiangLogname = touxiangLogname;
	}

	public Blob getTouxiangImage() {
		return this.touxiangImage;
	}

	public void setTouxiangImage(Blob touxiangImage) {
		this.touxiangImage = touxiangImage;
	}

}