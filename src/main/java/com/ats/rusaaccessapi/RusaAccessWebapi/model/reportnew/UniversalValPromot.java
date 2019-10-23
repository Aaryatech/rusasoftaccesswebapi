package com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class UniversalValPromot {
	
	@Id
	private int actCndctId;
	
	private String ttleProgrmAct;	
	
	private Date fromDate;
	
	private Date toDate;
	
	private int noOfParticipant;
	
	private String yearId;
	
	private String instituteName;
	
	private String academicYear;

	public int getActCndctId() {
		return actCndctId;
	}

	public void setActCndctId(int actCndctId) {
		this.actCndctId = actCndctId;
	}

	public String getTtleProgrmAct() {
		return ttleProgrmAct;
	}

	public void setTtleProgrmAct(String ttleProgrmAct) {
		this.ttleProgrmAct = ttleProgrmAct;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
 	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
 	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public int getNoOfParticipant() {
		return noOfParticipant;
	}

	public void setNoOfParticipant(int noOfParticipant) {
		this.noOfParticipant = noOfParticipant;
	}

	public String getYearId() {
		return yearId;
	}

	public void setYearId(String yearId) {
		this.yearId = yearId;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	@Override
	public String toString() {
		return "UniversalValPromot [actCndctId=" + actCndctId + ", ttleProgrmAct=" + ttleProgrmAct + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", noOfParticipant=" + noOfParticipant + ", yearId=" + yearId
				+ ", instituteName=" + instituteName + ", academicYear=" + academicYear + ", getActCndctId()="
				+ getActCndctId() + ", getTtleProgrmAct()=" + getTtleProgrmAct() + ", getFromDate()=" + getFromDate()
				+ ", getToDate()=" + getToDate() + ", getNoOfParticipant()=" + getNoOfParticipant() + ", getYearId()="
				+ getYearId() + ", getInstituteName()=" + getInstituteName() + ", getAcademicYear()="
				+ getAcademicYear() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
}
