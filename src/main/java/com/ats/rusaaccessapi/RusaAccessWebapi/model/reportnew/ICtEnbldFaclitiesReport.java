package com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ICtEnbldFaclitiesReport {
@Id
	private int ictEnbFacId;
	private int noClassromLcd;
	private int noClassroomWifi;
	private int ictSeminarHall;
	private String instituteName;
	private String academicYear;
	
	public String getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}
	private int instId;
	public int getIctEnbFacId() {
		return ictEnbFacId;
	}
	public void setIctEnbFacId(int ictEnbFacId) {
		this.ictEnbFacId = ictEnbFacId;
	}
	public int getNoClassromLcd() {
		return noClassromLcd;
	}
	public void setNoClassromLcd(int noClassromLcd) {
		this.noClassromLcd = noClassromLcd;
	}
	public int getNoClassroomWifi() {
		return noClassroomWifi;
	}
	public void setNoClassroomWifi(int noClassroomWifi) {
		this.noClassroomWifi = noClassroomWifi;
	}
	public int getIctSeminarHall() {
		return ictSeminarHall;
	}
	public void setIctSeminarHall(int ictSeminarHall) {
		this.ictSeminarHall = ictSeminarHall;
	}
	
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public int getInstId() {
		return instId;
	}
	public void setInstId(int instId) {
		this.instId = instId;
	}
	@Override
	public String toString() {
		return "ICtEnbldFaclitiesReport [ictEnbFacId=" + ictEnbFacId + ", noClassromLcd=" + noClassromLcd
				+ ", noClassroomWifi=" + noClassroomWifi + ", ictSeminarHall=" + ictSeminarHall + ", instituteName="
				+ instituteName + ", academicYear=" + academicYear + ", instId=" + instId + "]";
	}
	
	
}
