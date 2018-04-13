package org.yueball.vo;

/**
 * Myorigin entity. @author MyEclipse Persistence Tools
 */

public class Myorigin implements java.io.Serializable {

	// Fields

	private MyoriginId id;

	// Constructors

	/** default constructor */
	public Myorigin() {
	}

	/** full constructor */
	public Myorigin(MyoriginId id) {
		this.id = id;
	}

	// Property accessors

	public MyoriginId getId() {
		return this.id;
	}

	public void setId(MyoriginId id) {
		this.id = id;
	}

}