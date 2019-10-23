package com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NoOfGenderEquityProg {
	
	@Id
	private int yearId;
	
	private String academicYear;
	
	private String instituteName;
 	
	private String noOfProg;

	public int getYearId() {
		return yearId;
	}

	public void setYearId(int yearId) {
		this.yearId = yearId;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getNoOfProg() {
		return noOfProg;
	}

	public void setNoOfProg(String noOfProg) {
		this.noOfProg = noOfProg;
	}

	@Override
	public String toString() {
		return "NoOfGenderEquityProg [yearId=" + yearId + ", academicYear=" + academicYear + ", instituteName="
				+ instituteName + ", noOfProg=" + noOfProg + ", getYearId()=" + getYearId() + ", getAcademicYear()="
				+ getAcademicYear() + ", getInstituteName()=" + getInstituteName() + ", getNoOfProg()=" + getNoOfProg()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	 

}
