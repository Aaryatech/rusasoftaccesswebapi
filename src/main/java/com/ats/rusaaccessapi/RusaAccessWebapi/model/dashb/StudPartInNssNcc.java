package com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudPartInNssNcc {
	
	
	@Id
	private int instituteId;
	
	private String  instituteName;
	
	private String  academicYear;
	
	private String  nssCount;
	
	
	private String  nccCount;


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


	public String getAcademicYear() {
		return academicYear;
	}


	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}


	public String getNssCount() {
		return nssCount;
	}


	public void setNssCount(String nssCount) {
		this.nssCount = nssCount;
	}


	public String getNccCount() {
		return nccCount;
	}


	public void setNccCount(String nccCount) {
		this.nccCount = nccCount;
	}

	
	

}
