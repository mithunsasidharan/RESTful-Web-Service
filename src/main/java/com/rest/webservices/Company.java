package com.rest.webservices;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "company")  
public class Company {

	private String companyName;
	private long employeeStrength;
	private int foundingYear;
	private String headquarters;

	public Company(){
		// For XML conversions to take effect
	}
	public Company(String companyName, long empployeeStrength, int foundingYear, String headQuarters) {
		this.companyName = companyName;
		this.employeeStrength = empployeeStrength;
		this.foundingYear = foundingYear;
		this.headquarters = headQuarters;
	}

	public String getCompanyName() {
		return companyName;
	}

	@XmlElement  
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getEmployeeStrength() {
		return employeeStrength;
	}

	@XmlElement  
	public void setEmployeeStrength(long employeeStrength) {
		this.employeeStrength = employeeStrength;
	}

	public int getFoundingYear() {
		return foundingYear;
	}

	@XmlElement  
	public void setFoundingYear(int foundingYear) {
		this.foundingYear = foundingYear;
	}

	public String getHeadquarters() {
		return headquarters;
	}

	@XmlElement  
	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

}
