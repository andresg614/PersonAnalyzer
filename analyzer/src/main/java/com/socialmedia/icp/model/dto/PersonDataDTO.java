package com.socialmedia.icp.model.dto;

public class PersonDataDTO {		 
	private String personId;
	private String name;
	private String lastName;
	private String currentRole;
	private String country;
	private String industry;
	private String numberRecommends;
	private String numberConnects;
	private double score;
	
	public PersonDataDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonDataDTO(String personId, String name, String lastName, String currentRole, String country,
			String industry, String numberRecommends, String numberConnects) {
		super();
		this.personId = personId;
		this.name = name;
		this.lastName = lastName;
		this.currentRole = currentRole;
		this.country = country;
		this.industry = industry;
		this.numberRecommends = numberRecommends;
		this.numberConnects = numberConnects;
	}

	/**
	 * @return the personId
	 */
	public String getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(String personId) {
		this.personId = personId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the currentRole
	 */
	public String getCurrentRole() {
		return currentRole;
	}

	/**
	 * @param currentRole the currentRole to set
	 */
	public void setCurrentRole(String currentRole) {
		this.currentRole = currentRole;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the industry
	 */
	public String getIndustry() {
		return industry;
	}

	/**
	 * @param industry the industry to set
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	/**
	 * @return the numberRecommends
	 */
	public String getNumberRecommends() {
		return numberRecommends;
	}

	/**
	 * @param numberRecommends the numberRecommends to set
	 */
	public void setNumberRecommends(String numberRecommends) {
		this.numberRecommends = numberRecommends;
	}

	/**
	 * @return the numberConnects
	 */
	public String getNumberConnects() {
		return numberConnects;
	}

	/**
	 * @param numberConnects the numberConnects to set
	 */
	public void setNumberConnects(String numberConnects) {
		this.numberConnects = numberConnects;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonDataDTO [personId=" + personId + ", name=" + name + ", lastName=" + lastName + ", currentRole="
				+ currentRole + ", country=" + country + ", industry=" + industry + ", numberRecommends="
				+ numberRecommends + ", numberConnects=" + numberConnects + ", score=" + score + "]";
	}
}