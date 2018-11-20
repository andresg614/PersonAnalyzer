package com.socialmedia.icp.model.dto;

public class RulePropertyDTO {
	private String value;
	private double score;
	
	public RulePropertyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RulePropertyDTO(String value, double score) {
		super();
		this.value = value;
		this.score = score;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the score
	 */
	public double getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(double score) {
		this.score = score;
	}
}