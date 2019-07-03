package com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb;

import java.util.List;

 
public class QualityIniGraphResponse {
	
	
	List<QualityIniCountsForGraph> naacRes;
	
	List<QualityIniCountsForGraph> nbaRes;
	
	List<QualityIniCountsForGraph> nirfcRes;
	
	List<QualityIniCountsForGraph> theRes;

	public List<QualityIniCountsForGraph> getNaacRes() {
		return naacRes;
	}

	public void setNaacRes(List<QualityIniCountsForGraph> naacRes) {
		this.naacRes = naacRes;
	}

	public List<QualityIniCountsForGraph> getNbaRes() {
		return nbaRes;
	}

	public void setNbaRes(List<QualityIniCountsForGraph> nbaRes) {
		this.nbaRes = nbaRes;
	}

	public List<QualityIniCountsForGraph> getNirfcRes() {
		return nirfcRes;
	}

	public void setNirfcRes(List<QualityIniCountsForGraph> nirfcRes) {
		this.nirfcRes = nirfcRes;
	}

	public List<QualityIniCountsForGraph> getTheRes() {
		return theRes;
	}

	public void setTheRes(List<QualityIniCountsForGraph> theRes) {
		this.theRes = theRes;
	}

	@Override
	public String toString() {
		return "QualityIniGraphResponse [naacRes=" + naacRes + ", nbaRes=" + nbaRes + ", nirfcRes=" + nirfcRes
				+ ", theRes=" + theRes + ", getNaacRes()=" + getNaacRes() + ", getNbaRes()=" + getNbaRes()
				+ ", getNirfcRes()=" + getNirfcRes() + ", getTheRes()=" + getTheRes() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	 

}
