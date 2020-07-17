package com.ats.rusaaccessapi.RusaAccessWebapi.restcontroller;

import org.apache.commons.lang3.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;

import com.ats.rusaaccessapi.RusaAccessWebapi.accessrepo.InstituteRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.Institute;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.InstituteMaster;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.InstituteMasterRepo;

@RestController
public class MhInstMasterController {

	// Author: Sachin
	// Created on 17-06-2020

	@Autowired
	InstituteRepo instituteRepo;

	@Autowired
	InstituteMasterRepo instituteMasterRepo;

	@RequestMapping(value = { "/checkAisheCodeDuplication" }, method = RequestMethod.POST)
	public @ResponseBody String checkAisheCodeDuplication(@RequestParam String aisheCode) {
		String response = null;
		Institute insResp = new Institute();
		try {
			// asds
			insResp = instituteRepo.findByAisheCode(aisheCode);
			// System.err.println("Inst with aishe " +insResp.toString());
			if (insResp == null) {
				response = "unique";
			} else {
				response = "	";
			}
		} catch (Exception e) {
			System.err.println("Exc at checkAisheCodeDuplication @MhInstMasterController");

		}
		// System.err.println("Inst with aishe " +insResp.toString());

		return response;
	}

	@RequestMapping(value = { "/getInstituteMasterByAishe" }, method = RequestMethod.POST)
	public @ResponseBody InstituteMaster getInstituteMasterByAishe(@RequestParam String aisheCode) {

		InstituteMaster instMaster = new InstituteMaster();

		try {
			instMaster = instituteMasterRepo.findByAisheCode(aisheCode);

		} catch (Exception e) {
			System.err.println("Exce in getting  getInstituteMasterByAishe @ MhInstMasterController " + e.getMessage());
			e.printStackTrace();

		}
		return instMaster;
	}

	@RequestMapping(value = { "/saveInstituteMaster" }, method = RequestMethod.POST)
	public @ResponseBody InstituteMaster saveInstituteMaster(@RequestBody InstituteMaster requestMaster) {

		InstituteMaster instMaster = new InstituteMaster();

		try {
				
				String response = null;
				Institute insResp = new Institute();
				try {
					insResp = instituteRepo.findByAisheCode(requestMaster.getAisheCode().trim());
					if (insResp == null) {
						response = "OK";
					} else {
						response = "	";
					}
				} catch (Exception e) {
					System.err.println("Exc at checkAisheCodeDuplication @MhInstMasterController");

				}
				if(response.equals("OK")) {
						instMaster = instituteMasterRepo.save(requestMaster);
					}
			
		} catch (Exception e) {
			System.err.println("Exce in getting  saveInstituteMaster @ MhInstMasterController " + e.getMessage());
			e.printStackTrace();

		}
		return instMaster;
	}

	// JavaScriptUtils ju=new JavaScriptUtils();

	@RequestMapping(value = { "/testJS" }, method = RequestMethod.POST)
	public @ResponseBody String testJS(@RequestParam String inputStr, @RequestParam int option) {
		String s = null;
		String escH4 = null;
		String escH4Dec = null;
		sendMe(inputStr);
		// System.err.println("In MEthod");
		String input = null;
		try {
			switch (option) {
			case 1:
				System.err.println("In case one");
				input = inputStr;
				break;

			case 2:
				System.err.println("In case two");
				// input = "<script type=text/javascript>function sayHello(){ var a=10;
				// call();}</script>";

				input = "<script>$(document).ready(function(){$(\"button\").click(function(){$(\"p\").slideToggle()})});</script>";
				break;

			default:
				break;

			}

			s = JavaScriptUtils.javaScriptEscape(input);
			System.err.println("string output" + s);

			String hs = HtmlUtils.htmlEscape(input);

			String hs1 = Jsoup.parse(input).text();

			escH4 = StringEscapeUtils.escapeHtml4(input);
			System.err.println("Html escH4" + escH4);

			escH4Dec = StringEscapeUtils.unescapeHtml4(escH4);
			System.err.println("Html escH4 decoide" + escH4Dec);

			String hs2 = Jsoup.clean(input, Whitelist.basic());
			// System.err.println("Html Escape2" + hs2);
			// System.err.println("Html Escape1" + hs1);
			// System.err.println("Html Escape" + hs);
		} catch (Exception e) {
			System.err.println("ex" + e.getMessage().toString());
		}
		/*
		 * System.err.println(
		 * "s\\u003Cscript\\u003Ealert(\\'10\\')\\u003C\\/script\\u003E\n" + "");
		 */
		return escH4Dec;
	}

	public String sendMe(String str) {
		System.err.println("In sendMe for " + str + "is " + JavaScriptUtils.javaScriptEscape(str));
		return JavaScriptUtils.javaScriptEscape(str);
	}

	public static String html2text(String html) {
		return Jsoup.parse(html).text();
	}

}
