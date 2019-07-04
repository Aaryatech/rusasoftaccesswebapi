package com.ats.rusaaccessapi.RusaAccessWebapi.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.AccredationStatusReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.InstituteAccredationReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.InstituteAccredationReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb.AccredationStatusReportRepo;

 

@RestController
public class ReportApiController {
	
	@Autowired
	InstituteAccredationReportRepo instituteAccredationReportRepo;
	

	@RequestMapping(value = { "/getInstituteAccreReport" }, method = RequestMethod.GET)
	public @ResponseBody List<InstituteAccredationReport> getInstituteAccreReport() {

		List<InstituteAccredationReport> facPartInVarBodies = new ArrayList<>();
		 
		try {
 
			facPartInVarBodies = instituteAccredationReportRepo.getInstituteAccreDetail();
			//System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	 
	@Autowired
	AccredationStatusReportRepo accredationStatusReportRepo;
	
	@RequestMapping(value = { "/getAllAccredationStatusReport" }, method = RequestMethod.POST)
	public @ResponseBody List<AccredationStatusReport> getAllAccredationStatusReport(@RequestParam int qualId) {

		List<AccredationStatusReport> facPartInVarBodies = new ArrayList<>();
		 
		try {
 
			facPartInVarBodies = accredationStatusReportRepo.getAccredationStat(qualId);
			//System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	
}
