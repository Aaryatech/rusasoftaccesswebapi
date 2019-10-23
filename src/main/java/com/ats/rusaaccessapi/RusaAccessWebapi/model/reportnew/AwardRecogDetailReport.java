package com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AwardRecogDetailReport {
	
	@Id
	private int yearId;
	
	private float awardCount;
	
	private String academicYear;
	
	private String instituteName;
	
	private float  noOfFulltimeFaculty;

	public int getYearId() {
		return yearId;
	}

	public void setYearId(int yearId) {
		this.yearId = yearId;
	}

	public float getAwardCount() {
		return awardCount;
	}

	public void setAwardCount(float awardCount) {
		this.awardCount = awardCount;
	}
 
	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public float getNoOfFulltimeFaculty() {
		return noOfFulltimeFaculty;
	}

	public void setNoOfFulltimeFaculty(float noOfFulltimeFaculty) {
		this.noOfFulltimeFaculty = noOfFulltimeFaculty;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	@Override
	public String toString() {
		return "AwardRecogDetailReport [yearId=" + yearId + ", awardCount=" + awardCount + ", academicYear="
				+ academicYear + ", instituteName=" + instituteName + ", noOfFulltimeFaculty=" + noOfFulltimeFaculty
				+ ", getYearId()=" + getYearId() + ", getAwardCount()=" + getAwardCount() + ", getInstituteName()="
				+ getInstituteName() + ", getNoOfFulltimeFaculty()=" + getNoOfFulltimeFaculty() + ", getAcademicYear()="
				+ getAcademicYear() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
 
	
	

}
