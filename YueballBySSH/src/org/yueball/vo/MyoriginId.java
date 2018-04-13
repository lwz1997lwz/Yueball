package org.yueball.vo;

/**
 * MyoriginId entity. @author MyEclipse Persistence Tools
 */

public class MyoriginId implements java.io.Serializable {

	// Fields

	private String mylogname;
	private Integer matchId;

	// Constructors

	/** default constructor */
	public MyoriginId() {
	}

	/** full constructor */
	public MyoriginId(String mylogname, Integer matchId) {
		this.mylogname = mylogname;
		this.matchId = matchId;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MyoriginId))
			return false;
		MyoriginId castOther = (MyoriginId) other;

		return ((this.getMylogname() == castOther.getMylogname()) || (this.getMylogname() != null
				&& castOther.getMylogname() != null && this.getMylogname().equals(castOther.getMylogname())))
				&& ((this.getMatchId() == castOther.getMatchId()) || (this.getMatchId() != null
						&& castOther.getMatchId() != null && this.getMatchId().equals(castOther.getMatchId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getMylogname() == null ? 0 : this.getMylogname().hashCode());
		result = 37 * result + (getMatchId() == null ? 0 : this.getMatchId().hashCode());
		return result;
	}

}