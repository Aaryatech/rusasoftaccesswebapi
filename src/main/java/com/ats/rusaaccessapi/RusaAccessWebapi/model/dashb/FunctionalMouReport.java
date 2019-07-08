package com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FunctionalMouReport {
	
	@Id
	private int instituteId;
	
	private String  instituteName;
	
	private String  noOfMous;

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

	public String getNoOfMous() {
		return noOfMous;
	}

	public void setNoOfMous(String noOfMous) {
		this.noOfMous = noOfMous;
	}

	@Override
	public String toString() {
		return "FunctionalMouReport [instituteId=" + instituteId + ", instituteName=" + instituteName + ", noOfMous="
				+ noOfMous + "]";
	}
	
	

}
