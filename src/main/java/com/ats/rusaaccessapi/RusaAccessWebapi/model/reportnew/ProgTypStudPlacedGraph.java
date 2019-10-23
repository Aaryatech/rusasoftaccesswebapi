package com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class ProgTypStudPlacedGraph {
	@Id
	private int programId;
	private String progTypeName;
	private String programName;
	private int noStudentPlaced;
	private int noStudPass;
	public int getProgramId() {
		return programId;
	}
	public String getProgTypeName() {
		return progTypeName;
	}
	public String getProgramName() {
		return programName;
	}
	public int getNoStudentPlaced() {
		return noStudentPlaced;
	}
	public int getNoStudPass() {
		return noStudPass;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public void setProgTypeName(String progTypeName) {
		this.progTypeName = progTypeName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public void setNoStudentPlaced(int noStudentPlaced) {
		this.noStudentPlaced = noStudentPlaced;
	}
	public void setNoStudPass(int noStudPass) {
		this.noStudPass = noStudPass;
	}
	@Override
	public String toString() {
		return "ProgTypStudPlacedGraph [programId=" + programId + ", progTypeName=" + progTypeName + ", programName="
				+ programName + ", noStudentPlaced=" + noStudentPlaced + ", noStudPass=" + noStudPass + "]";
	}
	
	
}
