package com.ats.rusaaccessapi.RusaAccessWebapi.model;

import java.util.List;

import com.ats.rusaaccessapi.RusaAccessWebapi.service.AssignRoleDetailList;
 
public class CreatedRoleList {

	List<AssignRoleDetailList> assignRoleDetailList;

	Info info;

	public List<AssignRoleDetailList> getAssignRoleDetailList() {
		return assignRoleDetailList;
	}

	public void setAssignRoleDetailList(List<AssignRoleDetailList> assignRoleDetailList) {
		this.assignRoleDetailList = assignRoleDetailList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "CreatedRoleList [assignRoleDetailList=" + assignRoleDetailList + ", info=" + info + "]";
	}

}
