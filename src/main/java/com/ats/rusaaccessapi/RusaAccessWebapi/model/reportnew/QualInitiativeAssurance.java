package com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class QualInitiativeAssurance {
	
	@Id
	private int qualityId;
	
	private Date qualityFromdt;
	
	private Date qualityTodt;
	
	private float qualityPcount;

	private String instituteName;
	
	private String academicYear;
	
	private String qualityInitiativeName;

	public int getQualityId() {
		return qualityId;
	}

	public void setQualityId(int qualityId) {
		this.qualityId = qualityId;
	}

	@JsonFormat(locale = "ENGLISH", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
 	public Date getQualityFromdt() {
		return qualityFromdt;
	}

	public void setQualityFromdt(Date qualityFromdt) {
		this.qualityFromdt = qualityFromdt;
	}
	
	@JsonFormat(locale = "ENGLISH", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
 	public Date getQualityTodt() {
		return qualityTodt;
	}

	public void setQualityTodt(Date qualityTodt) {
		this.qualityTodt = qualityTodt;
	}

	public float getQualityPcount() {
		return qualityPcount;
	}

	public void setQualityPcount(float qualityPcount) {
		this.qualityPcount = qualityPcount;
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

	public String getQualityInitiativeName() {
		return qualityInitiativeName;
	}

	public void setQualityInitiativeName(String qualityInitiativeName) {
		this.qualityInitiativeName = qualityInitiativeName;
	}

	@Override
	public String toString() {
		return "QualInitiativeAssurance [qualityId=" + qualityId + ", qualityFromdt=" + qualityFromdt + ", qualityTodt="
				+ qualityTodt + ", qualityPcount=" + qualityPcount + ", instituteName=" + instituteName
				+ ", academicYear=" + academicYear + ", qualityInitiativeName=" + qualityInitiativeName
				+ ", getQualityId()=" + getQualityId() + ", getQualityFromdt()=" + getQualityFromdt()
				+ ", getQualityTodt()=" + getQualityTodt() + ", getQualityPcount()=" + getQualityPcount()
				+ ", getInstituteName()=" + getInstituteName() + ", getAcademicYear()=" + getAcademicYear()
				+ ", getQualityInitiativeName()=" + getQualityInitiativeName() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	

	

}
