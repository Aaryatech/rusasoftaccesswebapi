package com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class TrainProgOrgnizedForTeach {

	@Id
	private int trainingId;
	
	private int yearId;
	
	private float totCount;
	 
	private String academicYear;
	
	private String trainingTitle;
	
	private Date trainingFromdt;
	
	private Date trainingTodt;
	
	private String instituteName;
	
	private String finSupportFrom;
	
	private String trainingPcount;

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

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

	 

	public String getTrainingTitle() {
		return trainingTitle;
	}

	public void setTrainingTitle(String trainingTitle) {
		this.trainingTitle = trainingTitle;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getTrainingFromdt() {
		return trainingFromdt;
	}

	public void setTrainingFromdt(Date trainingFromdt) {
		this.trainingFromdt = trainingFromdt;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getTrainingTodt() {
		return trainingTodt;
	}

	public void setTrainingTodt(Date trainingTodt) {
		this.trainingTodt = trainingTodt;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getFinSupportFrom() {
		return finSupportFrom;
	}

	public void setFinSupportFrom(String finSupportFrom) {
		this.finSupportFrom = finSupportFrom;
	}

	public String getTrainingPcount() {
		return trainingPcount;
	}

	public void setTrainingPcount(String trainingPcount) {
		this.trainingPcount = trainingPcount;
	}

	public float getTotCount() {
		return totCount;
	}

	public void setTotCount(float totCount) {
		this.totCount = totCount;
	}

	@Override
	public String toString() {
		return "TrainProgOrgnizedForTeach [trainingId=" + trainingId + ", yearId=" + yearId + ", totCount=" + totCount
				+ ", academicYear=" + academicYear + ", trainingTitle=" + trainingTitle + ", trainingFromdt="
				+ trainingFromdt + ", trainingTodt=" + trainingTodt + ", instituteName=" + instituteName
				+ ", finSupportFrom=" + finSupportFrom + ", trainingPcount=" + trainingPcount + ", getTrainingId()="
				+ getTrainingId() + ", getYearId()=" + getYearId() + ", getAcademicYear()=" + getAcademicYear()
				+ ", getTrainingTitle()=" + getTrainingTitle() + ", getTrainingFromdt()=" + getTrainingFromdt()
				+ ", getTrainingTodt()=" + getTrainingTodt() + ", getInstituteName()=" + getInstituteName()
				+ ", getFinSupportFrom()=" + getFinSupportFrom() + ", getTrainingPcount()=" + getTrainingPcount()
				+ ", getTotCount()=" + getTotCount() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	 
	
	
	
	
}
