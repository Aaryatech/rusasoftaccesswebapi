package com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class AccredationStatusReport {

	@Id
	private int instituteId;

	private String instituteName;

	private Date qualityFromdt;

	private Date qualityTodt;

	private String aisheCode;

	private String qualityInitiativeName;

	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	 

	public String getAisheCode() {
		return aisheCode;
	}

	public void setAisheCode(String aisheCode) {
		this.aisheCode = aisheCode;
	}

	public String getQualityInitiativeName() {
		return qualityInitiativeName;
	}

	public void setQualityInitiativeName(String qualityInitiativeName) {
		this.qualityInitiativeName = qualityInitiativeName;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
 	public Date getQualityFromdt() {
		return qualityFromdt;
	}

	public void setQualityFromdt(Date qualityFromdt) {
		this.qualityFromdt = qualityFromdt;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
 	public Date getQualityTodt() {
		return qualityTodt;
	}

	public void setQualityTodt(Date qualityTodt) {
		this.qualityTodt = qualityTodt;
	}

	@Override
	public String toString() {
		return "AccredationStatusReport [instituteId=" + instituteId + ", instituteName=" + instituteName
				+ ", qualityFromdt=" + qualityFromdt + ", qualityTodt=" + qualityTodt + ", aisheCode=" + aisheCode
				+ ", qualityInitiativeName=" + qualityInitiativeName + "]";
	}
 
	
	

}
