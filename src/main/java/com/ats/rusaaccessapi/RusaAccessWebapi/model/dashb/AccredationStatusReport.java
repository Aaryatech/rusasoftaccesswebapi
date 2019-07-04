package com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccredationStatusReport {

	@Id
	private int instituteId;

	private String instituteName;

	private Date quality_fromdt;

	private Date quality_todt;

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

	public Date getQuality_fromdt() {
		return quality_fromdt;
	}

	public void setQuality_fromdt(Date quality_fromdt) {
		this.quality_fromdt = quality_fromdt;
	}

	public Date getQuality_todt() {
		return quality_todt;
	}

	public void setQuality_todt(Date quality_todt) {
		this.quality_todt = quality_todt;
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

	@Override
	public String toString() {
		return "AccredationStatusReport [instituteId=" + instituteId + ", instituteName=" + instituteName
				+ ", quality_fromdt=" + quality_fromdt + ", quality_todt=" + quality_todt + ", aisheCode=" + aisheCode
				+ ", qualityInitiativeName=" + qualityInitiativeName + ", getInstituteId()=" + getInstituteId()
				+ ", getInstituteName()=" + getInstituteName() + ", getQuality_fromdt()=" + getQuality_fromdt()
				+ ", getQuality_todt()=" + getQuality_todt() + ", getAisheCode()=" + getAisheCode()
				+ ", getQualityInitiativeName()=" + getQualityInitiativeName() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
