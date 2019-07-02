package com.ats.rusaaccessapi.RusaAccessWebapi.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.UserList;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.UserListRepository;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.UserService;
 
@RestController
public class RestApiController {

	
	 @Autowired
	 UserListRepository userListRepository;
	
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)

	public @ResponseBody UserList loginUser(@RequestParam("username") String userName,
			@RequestParam("password") String pass, @RequestParam("isBlock") int isBlock) {

		UserList login = new UserList();
		
		 try {
			 
			 login= userListRepository.loginProcess(userName,pass,isBlock);
			 
			 if(login==null) {
				 login = new UserList();
				 login.setIsError(true);
			 }else {
				 login.setIsError(false);
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		  
		return login;

	}

}
