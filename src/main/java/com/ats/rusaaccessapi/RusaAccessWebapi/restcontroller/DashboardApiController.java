package com.ats.rusaaccessapi.RusaAccessWebapi.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.AcademicYear;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.SettingKeyValue;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.GetCountsForDash;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.QualityIniCountsForGraph;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.QualityIniGraphResponse;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.AcademicYearRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.SettingKeyValueRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb.DashBoardCountsRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb.QualityIniCountsForGraphRepo;

@RestController
public class DashboardApiController {

	@Autowired
	DashBoardCountsRepo dashBoardCountsRepo;

	@RequestMapping(value = { "/getInstituteCount" }, method = RequestMethod.GET)
	public @ResponseBody GetCountsForDash getInstituteCount() {

		GetCountsForDash instResp = null;

		try {

			instResp = dashBoardCountsRepo.getInstCountUsingRusaSw();

		} catch (Exception e) {
			System.err.println("Exce in saving saveLinkageMaster " + e.getMessage());
			e.printStackTrace();
		}

		return instResp;

	}

	@Autowired
	QualityIniCountsForGraphRepo qualityIniCountsForGraphRepo;

	@Autowired
	AcademicYearRepo academicYearRepo;

	@Autowired
	SettingKeyValueRepo settingKeyValueRepo;

	@RequestMapping(value = { "/getAllQualIniGraph1" }, method = RequestMethod.GET)
	public @ResponseBody QualityIniGraphResponse getAllQualIniGraph() {

		QualityIniGraphResponse res = new QualityIniGraphResponse();

		List<QualityIniCountsForGraph> qualityInitiative = new ArrayList<QualityIniCountsForGraph>();

		List<AcademicYear> acYrList = new ArrayList<>();
		SettingKeyValue setKey = new SettingKeyValue();
		int stkId = 0;
		 
		try {

			List<Integer> lastFiveYears = new ArrayList<>();

			acYrList = academicYearRepo.getLastFiveYears();

			for (int i = 0; i < acYrList.size(); i++) {
				lastFiveYears.add(acYrList.get(i).getYearId());
			}

			// For Naac
			// no_of_reg_inst-count1,no_of_naac_accr_inst-count2,0-count3

			setKey = settingKeyValueRepo.findBySettingKeyAndDelStatus("NAAC", 1);
			stkId = setKey.getIntValue();
			System.err.println("Id NAAC " + stkId);
			qualityInitiative = qualityIniCountsForGraphRepo.getGraphForNaac(stkId, lastFiveYears);
			System.err.println(stkId + "=" + qualityInitiative);
			res.setNaacRes(qualityInitiative);

			// for NBA
			// no_of_reg_inst-count1,no_of_nba_accr_inst-count2,no_of_nba_applicable_inst-count3

			setKey = settingKeyValueRepo.findBySettingKeyAndDelStatus("NBA", 1);
			stkId = setKey.getIntValue();
			System.err.println("Id NBA " + stkId);

			qualityInitiative = qualityIniCountsForGraphRepo.getGraphForNba(stkId, lastFiveYears);
			System.err.println(stkId + "=" + qualityInitiative);
			res.setNbaRes(qualityInitiative);

			// for THE
			// no_of_reg_inst-count1,no_of_the_accr_inst-count2,0-count3

			setKey = settingKeyValueRepo.findBySettingKeyAndDelStatus("THE", 1);
			stkId = setKey.getIntValue();
			System.err.println("Id THE" + stkId);
			qualityInitiative = qualityIniCountsForGraphRepo.getGraphForThe(stkId, lastFiveYears);
			System.err.println(stkId + "=" + qualityInitiative);
			res.setTheRes(qualityInitiative);

			// for NIRF
			// no_of_reg_inst-count1,no_of_nirf_accr_inst-count2,0-count3

			setKey = settingKeyValueRepo.findBySettingKeyAndDelStatus("NIRF", 1);
			stkId = setKey.getIntValue();
			System.err.println("Id NIRF " + stkId);
			qualityInitiative = qualityIniCountsForGraphRepo.getGraphForNirf(stkId, lastFiveYears);
			System.err.println(stkId + "=" + qualityInitiative);
			res.setNirfcRes(qualityInitiative);

			//for autonomous 
			// no_of_reg_inst-count1,no_of_auto_inst-count2,0-count3
			qualityInitiative = qualityIniCountsForGraphRepo.getGraphForAutonomous(lastFiveYears);
 			System.err.println("allQualGraph " +qualityInitiative.toString());
			res.setAutonomousRes(qualityInitiative);

		} catch (Exception e) {
 			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return res;

	}

}
