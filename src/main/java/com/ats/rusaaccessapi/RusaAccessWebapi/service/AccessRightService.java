package com.ats.rusaaccessapi.RusaAccessWebapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.Info;
 


@Service
public interface AccessRightService {

	List<AccessRightModule> getAllModulAndSubModule();

	Info saveAssignRole(AssignRoleDetailList assignRoleDetailList);

	List<AssignRoleDetailList> getAllAccessRole();

	Info updateRoleIdByEmpId(int id, int roleId);

	//List<User> getAllUser();

	String getRoleJson(int userId);
	
	String getRoleJsonByRoleId(int roleId);
	
	

}
