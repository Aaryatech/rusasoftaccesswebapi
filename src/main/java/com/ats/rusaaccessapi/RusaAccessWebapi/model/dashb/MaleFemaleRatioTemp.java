package com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MaleFemaleRatioTemp {
	
	@Id
	private int instituteId;
	
	private int facNo;

	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}

	public int getFacNo() {
		return facNo;
	}

	public void setFacNo(int facNo) {
		this.facNo = facNo;
	}

	@Override
	public String toString() {
		return "MaleFemaleRatioTemp [instituteId=" + instituteId + ", facNo=" + facNo + ", getInstituteId()="
				+ getInstituteId() + ", getFacNo()=" + getFacNo() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	

}
