package com.ats.rusaaccessapi.RusaAccessWebapi.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusaaccessapi.RusaAccessWebapi.accessrepo.AssignRoleDetailListRepository;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.CreatedRoleList;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.Info;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.UserList;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.UserListRepository;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.UserService;
import com.ats.rusaaccessapi.RusaAccessWebapi.service.AccessRightModule;
import com.ats.rusaaccessapi.RusaAccessWebapi.service.AccessRightModuleList;
import com.ats.rusaaccessapi.RusaAccessWebapi.service.AccessRightService;
import com.ats.rusaaccessapi.RusaAccessWebapi.service.AssignRoleDetailList;
 
@RestController
public class AccessRightApiController {
 
	@Autowired
	AccessRightService accessRightService;

//	@Autowired
	//GetUserDetailRepo userDetail;// 22 MArch

	@Autowired
	AssignRoleDetailListRepository assignRoleDetailListRepository;

	 @Autowired
 	private UserListRepository userListRepository;
	 
	  @Autowired 
	 UserService userServices; 
 
	
	@RequestMapping(value = { "/deleteRole" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteRole(@RequestParam int roleId) {

		int isDeleted = assignRoleDetailListRepository.deleteRole(roleId);
		Info info = new Info();
		if (isDeleted == 1) {
			info.setError(false);
			info.setMessage("Role  Deleted");
		} else {
			info.setError(true);
			info.setMessage("Role Deletion Failed");
		}
		return info;
	}

	

	@RequestMapping(value = { "/getAllModuleAndSubModule" }, method = RequestMethod.GET)
	public @ResponseBody AccessRightModuleList getAllModuleAndSubModule() {

		AccessRightModuleList accessRightModuleList = new AccessRightModuleList();

		List<AccessRightModule> accessRightModule = accessRightService.getAllModulAndSubModule();

		Info info = new Info();
		if (accessRightModule != null && !accessRightModule.isEmpty()) {
			accessRightModuleList.setAccessRightModuleList(accessRightModule);
			info.setError(false);
			info.setMessage("Success");
		} else {

			info.setError(true);
			info.setMessage("failed");
		}
		accessRightModuleList.setInfo(info);
		return accessRightModuleList;
	}

	@RequestMapping(value = { "/saveAssignRole" }, method = RequestMethod.POST)
	public @ResponseBody Info saveAssignRole(@RequestBody AssignRoleDetailList assignRoleDetailList) {

		// System.out.println(assignRoleDetailList.toString());

		Info info = accessRightService.saveAssignRole(assignRoleDetailList);

		return new Info();
	} 

	@RequestMapping(value = { "/getAllAccessRole" }, method = RequestMethod.GET)
	public @ResponseBody CreatedRoleList getAllAccessRole() {

		CreatedRoleList createdRoleList = new CreatedRoleList();

		List<AssignRoleDetailList> assignRoleDetailList = accessRightService.getAllAccessRole();

		Info info = new Info();
		if (assignRoleDetailList != null && !assignRoleDetailList.isEmpty()) {
			createdRoleList.setAssignRoleDetailList(assignRoleDetailList);
			info.setError(false);
			info.setMessage("Success");
		} else {

			info.setError(true);
			info.setMessage("failed");
		}
		createdRoleList.setInfo(info);
		return createdRoleList;
	}

	/*@RequestMapping(value = { "/updateEmpRole" }, method = RequestMethod.POST)
	@ResponseBody
	public Info updateEmpRole(@RequestParam("id") int id, @RequestParam("roleId") int roleId) {
		return accessRightService.updateRoleIdByEmpId(id, roleId);
	}*/

	/*@RequestMapping(value = { "/getAllUser" }, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUser() {

		List<User> userList = accessRightService.getAllUser();

		return userList;
	}
*/
	@RequestMapping(value = { "/getRoleJson" }, method = RequestMethod.POST)
	@ResponseBody
	public String getRoleJson(@RequestParam("userId") int userId) {

		return accessRightService.getRoleJson(userId);
	}
	
	//11 April..Sachin
	@RequestMapping(value = { "/getRoleJsonByRoleId" }, method = RequestMethod.POST)
	@ResponseBody
	public String getRoleJsonByRoleId(@RequestParam int roleId) {

		return accessRightService.getRoleJsonByRoleId(roleId);
		
	}
	
	 @RequestMapping(value = { "/getAllUserList" }, method = RequestMethod.GET)
	public @ResponseBody List<UserList> getAllUserList() {
		
		List<UserList> userlist = new ArrayList<>();
		
		try {
			
			userlist= userListRepository.getuserList();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userlist;
 
		 
	} 
	
	 @RequestMapping(value = { "/updateRoleOfUser" }, method = RequestMethod.POST)
	@ResponseBody
	public Info updateRoleOfUser(@RequestParam("id") int id,@RequestParam("roleId") int roleId) {

		Info info = new Info();
		try {
			
			int update =userServices.updateRoleId(roleId,id);
			info.setError(false);
			info.setMessage("update");
		 
			
		}catch(Exception e) {
			
			e.printStackTrace();
			info.setError(true);
			info.setMessage("failed");
		}
		return info;
		
	} 
	
	@RequestMapping(value = { "/getRoleByRoleId" }, method = RequestMethod.POST)
	@ResponseBody
	public AssignRoleDetailList getRoleByRoleId( @RequestParam("roleId") int roleId) {

		AssignRoleDetailList role = new AssignRoleDetailList();
		try {
			
			role =assignRoleDetailListRepository.findByRoleId(roleId);
			 
		 
			
		}catch(Exception e) {
			
			e.printStackTrace();
			 
		}
		return role;
		
	}
	
	/*@RequestMapping(value = { "/sendMsg" }, method = RequestMethod.GET)
	public @ResponseBody Info sendMsg() {

		Info info = null;
		
		 try {
			 
			 info = EmailUtility.sendMsg("akshay", "@ksh@y", "7588519473");
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return info;
	}*/
	
	//assignRoleDetailListRepository;
	
		//10 April
	
	@RequestMapping(value = { "/getRoleIdsByRoleNameList" }, method = RequestMethod.POST)
	@ResponseBody
	public List<AssignRoleDetailList> getRoleIdsByRoleNameList(@RequestParam List<String> roleNameList) {

		List<AssignRoleDetailList> roleNameListRes = new ArrayList<>();
		
		try {
			roleNameListRes =assignRoleDetailListRepository.findByDelStatusAndRoleNameIn(0, roleNameList);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return roleNameListRes;
	}
}
