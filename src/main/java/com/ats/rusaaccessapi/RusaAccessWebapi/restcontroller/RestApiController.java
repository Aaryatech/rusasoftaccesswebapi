package com.ats.rusaaccessapi.RusaAccessWebapi.restcontroller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusaaccessapi.RusaAccessWebapi.accessrepo.GetInstituteListRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.accessrepo.InstituteRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.accessrepo.PrincipalRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.AdminLoginLog;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.GetChangePrincipalDetails;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.GetInstituteList;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.Info;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.Institute;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.Principal;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.Staff;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.UserList;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.UserLogin;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.AdminLoginLogRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.GetChangePrincipalDetailsRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.StaffRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.UserListRepository;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.UserService;
import com.ats.rusaaccessapi.RusaAccessWebapi.service.EmailUtility;

@RestController
public class RestApiController {

	@Autowired
	UserListRepository userListRepository;

	@Autowired
	GetInstituteListRepo getInstituteListRepo;

	@Autowired
	InstituteRepo instituteRepo;

	@Autowired
	PrincipalRepo pincipalRepo;

	@Autowired
	UserService userServiceRepo;

	@Autowired
	StaffRepo staffRepo;

	@Autowired
	GetInstituteListRepo getGetInstituteListRepo;

	@Autowired
	AdminLoginLogRepo adminLoginLogRepo;
	
	@Autowired
	GetChangePrincipalDetailsRepo getChangePrincipalDetailsRepo;
	
	@RequestMapping(value = { "/getAllRequestForChangePrincipal" }, method = RequestMethod.GET)
	public @ResponseBody List<GetChangePrincipalDetails> getAllRequestForChangePrincipal() {

		List<GetChangePrincipalDetails> insResp = new ArrayList<>();

		try {
			insResp = getChangePrincipalDetailsRepo.getChangePrinciRequest();

		} catch (Exception e) {
			System.err.println("Exce in getAllInstitutes Institute " + e.getMessage());
			e.printStackTrace();
		}

		return insResp;

	}
	
	@RequestMapping(value = { "/changePrincipal" }, method = RequestMethod.POST)
	public @ResponseBody Info changePrincipal(@RequestParam int facultyId) {

		Info info = new Info();
		try {
			int res = staffRepo.updateFaulty(facultyId);
			if (res > 0) {
				info.setError(false);
			 

			} else {
				info.setError(true);
			 

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteHods  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
		 
		}

		return info;

	}

	
	@RequestMapping(value = { "/blockPrevPrincipal" }, method = RequestMethod.POST)
	public @ResponseBody Info blockPrevPrincipal(@RequestParam int instituteId) {

		Info info = new Info();
		try {
			Staff sp=new Staff();
			sp=staffRepo.getPrevPrinci(instituteId);
			
			
			int res = staffRepo.updateBlockPrinci(sp.getFacultyId());
			if (res > 0) {
				info.setError(false);
			 

			} else {
				info.setError(true);
			 

			}
		} catch (Exception e) {

			System.err.println("Exce in deleteHods  " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
		 
		}

		return info;

	}




	@RequestMapping(value = { "/rusaLoginLog" }, method = RequestMethod.POST)
	public @ResponseBody AdminLoginLog rusaLoginLog(@RequestBody AdminLoginLog userLogin) {

		AdminLoginLog instiData = new AdminLoginLog();

		try {

			instiData = adminLoginLogRepo.save(userLogin);

		} catch (Exception e) {

		}

		return instiData;

	}

	@RequestMapping(value = { "/rusaUserRegistration" }, method = RequestMethod.POST)
	public @ResponseBody UserLogin rusaUserRegistration(@RequestBody UserLogin userLogin) {

		UserLogin instiData = new UserLogin();

		try {

			instiData = userServiceRepo.save(userLogin);

		} catch (Exception e) {

		}

		return instiData;

	}

	@RequestMapping(value = { "/deleteRusaUserRegistration" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteRusaUserRegistration(@RequestParam("userId") int userId) {

		Info info = new Info();

		try {

			int delete = userServiceRepo.deleteuser(userId);

			if (delete > 0) {
				info.setError(false);
				info.setMessage("deleted");

			} else {
				info.setError(true);
				info.setMessage("filed to deleted");
			}

		} catch (Exception e) {
			info.setError(true);
			info.setMessage("filed to deleted");
		}

		return info;

	}

	@RequestMapping(value = { "/updatePassword" }, method = RequestMethod.POST)
	public @ResponseBody Info updatePassword(@RequestParam("userId") int userId,
			@RequestParam("userName") String userName, @RequestParam("userPass") String userPass) {

		Info info = new Info();

		try {

			int updatePassword = userServiceRepo.updatePassword(userId, userName, userPass);

			if (updatePassword > 0) {
				info.setError(false);
				info.setMessage("updated");

			} else {
				info.setError(true);
				info.setMessage("filed to updated");
			}

		} catch (Exception e) {
			info.setError(true);
			info.setMessage("filed to updated");
		}

		return info;

	}

	@RequestMapping(value = { "/rusaUserbyId" }, method = RequestMethod.POST)
	public @ResponseBody UserList rusaUserbyId(@RequestParam("userId") int userId) {

		UserList info = new UserList();

		try {

			info = userListRepository.rusaUserbyId(userId);

		} catch (Exception e) {

		}

		return info;

	}

	@RequestMapping(value = { "/checkUserNameExist" }, method = RequestMethod.POST)
	public @ResponseBody Info checkUserNameExist(@RequestParam("username") String userName) {

		Info info = new Info();

		try {

			UserList checkUserNameExist = userListRepository.checkUserNameExist(userName);

			if (checkUserNameExist == null) {

				info.setError(false);
				info.setMessage("Available");
			} else {

				info.setError(true);
				info.setMessage("Not Available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			info.setError(true);
			info.setMessage("Not Available");
		}

		return info;

	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public @ResponseBody UserList loginUser(@RequestParam("username") String userName,
			@RequestParam("password") String pass, @RequestParam("isBlock") int isBlock) {

		UserList login = new UserList();

		try {

			login = userListRepository.loginProcess(userName, pass, isBlock);

			if (login == null) {
				login = new UserList();
				login.setIsError(true);
			} else {
				login.setIsError(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return login;

	}

	@RequestMapping(value = { "/getAllInstitutes" }, method = RequestMethod.GET)
	public @ResponseBody List<GetInstituteList> getAllInstitutes() {

		List<GetInstituteList> insResp = new ArrayList<>();

		try {
			insResp = getGetInstituteListRepo.getAllInstituteList();

		} catch (Exception e) {
			System.err.println("Exce in getAllInstitutes Institute " + e.getMessage());
			e.printStackTrace();
		}

		return insResp;

	}

	@RequestMapping(value = { "/getAllPendingInstitutes" }, method = RequestMethod.GET)
	public @ResponseBody List<GetInstituteList> getAllPendingInstitutes() {

		List<GetInstituteList> insResp = new ArrayList<>();

		try {

			insResp = getInstituteListRepo.getAllPendingInstituteList();

		} catch (Exception e) {

			System.err.println("Exce in getAllPendingInstitutes Institute " + e.getMessage());
			e.printStackTrace();

		}

		return insResp;
	}

	@RequestMapping(value = { "/showInstituteData" }, method = RequestMethod.POST)
	public @ResponseBody Institute approveInstitutes(@RequestParam("instId") int instId) {

		Institute instiData = null;
		try {

			instiData = instituteRepo.findByInstituteId(instId);

		} catch (Exception e) {

		}

		return instiData;

	}

	//static String senderEmail = "atsinfosoft@gmail.com";
	//static String senderPassword = "atsinfosoft@123";
	
	static String senderEmail ="techrusa1@gmail.com";// "atsinfosoft@gmail.com";
	static String senderPassword ="@Rusamah";// "atsinfosoft@123";
	static String mailsubject = " RUSA Software Login Credentials ";

	@RequestMapping(value = { "/approveInstitutes" }, method = RequestMethod.POST)
	public @ResponseBody Info approveInstitutes(@RequestParam List<Integer> instIdList, @RequestParam int aprUserId) {

		Info info = new Info();
		try {
			int res = 0;

			for (int i = 0; i < instIdList.size(); i++) {

				// UserLogin user = new UserLogin();

				String userName = getAlphaNumericString(7);
				String pass = getAlphaNumericString(7);
				System.err.println("username  " + userName + "\n  pass  " + pass);

				/*
				 * user.setExInt1(0); user.setExInt2(0); user.setExVar1("Na");
				 * user.setExVar2("Na"); user.setIsBlock(1); user.setPass(pass);
				 * 
				 * Principal princi = pincipalRepo.findByInstituteId(instIdList.get(i));
				 * 
				 * user.setRegPrimaryKey(princi.getPrincipalId());// principla primary key
				 * System.err.println("prinId----------"+princi);
				 * 
				 * user.setExInt2(instIdList.get(i)); // user.setRoleId(2);// 2 for Principal
				 * user.setUserName(princi.getEmail()); user.setUserType(1);// 2 for Principal
				 * user Default
				 * 
				 * UserLogin userRes = userServiceRepo.save(user);
				 * 
				 */
				Institute insResp = null;

				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String curDateTime = dateFormat.format(cal.getTime());

				Staff staff = staffRepo.findByDelStatusAndIsActiveAndIsBlockedAndInstituteId(1, 1, 0,
						instIdList.get(i));
				System.out.println("Pass==" + staff + "-------------" + pass);
				staff.setPassword(getAlphaNumericString(7));
				staffRepo.save(staff);

				insResp = instituteRepo.findByInstituteId(instIdList.get(i));

				insResp.setCheckerUserId(aprUserId);
				insResp.setCheckerDatetime(curDateTime);
				insResp.setExInt2(1); // is approved
				instituteRepo.save(insResp);

				// Info emailRes = EmailUtility.sendEmail(senderEmail, senderPassword,
				// princi.getEmail(), mailsubject,
				// princi.getEmail(), userRes.getPass());

				// Info smsRes = EmailUtility.sendMsg(princi.getEmail(), userRes.getPass(),
				// princi.getPhoneNo());

				Info emailRes = EmailUtility.sendEmail(senderEmail, senderPassword, staff.getEmail(), mailsubject,
						staff.getEmail(), staff.getPassword());

				Info smsRes = EmailUtility.sendMsg(staff.getEmail(), staff.getPassword(), staff.getContactNo());

				/*
				 * final String emailSMTPserver = "smtp.gmail.com"; final String emailSMTPPort =
				 * "587"; final String mailStoreType = "imaps"; final String username =
				 * "atsinfosoft@gmail.com"; final String password = "atsinfosoft@123";
				 * 
				 * // System.out.println("username" + username); //
				 * System.out.println("password" + password);
				 * 
				 * Properties props = new Properties(); props.put("mail.smtp.host",
				 * "smtp.gmail.com"); props.put("mail.smtp.socketFactory.port", "465");
				 * props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				 * props.put("mail.smtp.auth", "true"); props.put("mail.smtp.port", "587");
				 * 
				 * Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				 * protected PasswordAuthentication getPasswordAuthentication() { return new
				 * PasswordAuthentication(username, password); } });
				 * 
				 * try { Store mailStore = session.getStore(mailStoreType);
				 * mailStore.connect(emailSMTPserver, username, password);
				 * 
				 * String mes = " Hello Sir/Madam ";
				 * 
				 * String address = "atsinfosoft@gmail.com";// address of to
				 * 
				 * String subject = " Login Credentials For RUSA Login  ";
				 * 
				 * Message mimeMessage = new MimeMessage(session); mimeMessage.setFrom(new
				 * InternetAddress(username));
				 * mimeMessage.setRecipients(Message.RecipientType.TO,
				 * InternetAddress.parse(address)); mimeMessage.setSubject(subject);
				 * mimeMessage.setText(mes); mimeMessage.setText(" User Name " +
				 * staff.getEmail() + "\n Password " + staff.getPassword());
				 * 
				 * // Transport.send(mimeMessage); } catch (Exception e) { e.printStackTrace();
				 * }
				 */

			}

			if (res > 0) {
				info.setError(false);
				info.setMessage("success");

			} else {
				info.setError(true);
				info.setMessage("failed");

			}
		} catch (Exception e) {

			System.err.println("Exce in approveInstitutes RestApiController " + e.getMessage());
			e.printStackTrace();
			info.setError(true);
			info.setMessage("excep");
		}

		return info;

	}

	static String getAlphaNumericString(int n) {

		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	@RequestMapping(value = { "/deleteInstituteById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteByIqacById(@RequestParam("instId") int instId) {
		int isDelete = 0;
		isDelete = instituteRepo.delPendingInst(instId);
		Info inf = new Info();
		if (isDelete > 0) {
			inf.setError(false);
			inf.setMessage("Sucessfully Deleted");
		} else {
			inf.setError(true);
			inf.setMessage("Fail");
		}
		return inf;
	}

}
