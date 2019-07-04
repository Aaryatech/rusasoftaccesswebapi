package com.ats.rusaaccessapi.RusaAccessWebapi.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.AcademicYear;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.SettingKeyValue;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.AccredationStatusReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.AntiRaggingHarresmentReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.InstituteAccredationReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.PlacementUgPgStud;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.AcademicYearRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.InstituteAccredationReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.SettingKeyValueRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb.AccredationStatusReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb.AntiRaggingHarresmentReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb.PlacementUgPgStudRepo;
 
@RestController
public class ReportApiController {

	@Autowired
	InstituteAccredationReportRepo instituteAccredationReportRepo;

	@Autowired
	SettingKeyValueRepo settingKeyValueRepo;

	@RequestMapping(value = { "/getInstituteAccreReport" }, method = RequestMethod.GET)
	public @ResponseBody List<InstituteAccredationReport> getInstituteAccreReport() {

		List<InstituteAccredationReport> facPartInVarBodies = new ArrayList<>();
		SettingKeyValue setKey = new SettingKeyValue();
		int stkIdNacc = 0;
		int stkIdNba = 0;
		int stkIdNirf = 0;
		int stkIdThe = 0;
		try {

			setKey = settingKeyValueRepo.findBySettingKeyAndDelStatus("NAAC", 1);
			stkIdNacc = setKey.getIntValue();
			setKey = settingKeyValueRepo.findBySettingKeyAndDelStatus("NBA", 1);
			stkIdNba = setKey.getIntValue();
			setKey = settingKeyValueRepo.findBySettingKeyAndDelStatus("NIRF", 1);
			stkIdNirf = setKey.getIntValue();
			setKey = settingKeyValueRepo.findBySettingKeyAndDelStatus("THE", 1);
			stkIdThe = setKey.getIntValue();

			facPartInVarBodies = instituteAccredationReportRepo.getInstituteAccreDetail(stkIdNacc, stkIdNba, stkIdNirf,
					stkIdThe);
			// System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	AccredationStatusReportRepo accredationStatusReportRepo;

	@RequestMapping(value = { "/getAllAccredationStatusReport" }, method = RequestMethod.POST)
	public @ResponseBody List<AccredationStatusReport> getAllAccredationStatusReport(@RequestParam String  qualId) {

		List<AccredationStatusReport> facPartInVarBodies = new ArrayList<>();

		try {
			SettingKeyValue setKey = new SettingKeyValue();
			int stkIdNacc = 0;
			setKey = settingKeyValueRepo.findBySettingKeyAndDelStatus(qualId, 1);
			stkIdNacc = setKey.getIntValue();
		 
		 
			facPartInVarBodies = accredationStatusReportRepo.getAccredationStat(stkIdNacc);
			// System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	PlacementUgPgStudRepo placementUgPgStudRepo;

	@RequestMapping(value = { "/getStudUgPgReport" }, method = RequestMethod.GET)
	public @ResponseBody List<PlacementUgPgStud> getStudUgPgReport() {

		List<PlacementUgPgStud> facPartInVarBodies = new ArrayList<>();
		SettingKeyValue setKey = new SettingKeyValue();

		setKey = settingKeyValueRepo.findBySettingKeyAndDelStatus("ReportUGPG", 1);
		System.err.println("stk ids :" + setKey.toString());
		 
		try {

			 
			List<Integer> typeIds = Stream.of(setKey.getStringValue().split(",")).map(Integer::parseInt)
					.collect(Collectors.toList());
			facPartInVarBodies = placementUgPgStudRepo.getUgpgRep(typeIds);
			// System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	
	
	@Autowired
	AntiRaggingHarresmentReportRepo antiRaggingHarresmentReportRepo;

	@RequestMapping(value = { "/getAntiRaggingHaressmentReport" }, method = RequestMethod.POST)
	public @ResponseBody List<AntiRaggingHarresmentReport> getAntiRaggingHaressmentReport(@RequestParam int yearId) {

		List<AntiRaggingHarresmentReport> facPartInVarBodies = new ArrayList<>();

		try {

			facPartInVarBodies = antiRaggingHarresmentReportRepo.getAntiRaggingRep(yearId);
			// System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	
	@Autowired
	AcademicYearRepo yearRepo;

	@RequestMapping(value = { "/getAcademicYearListByTypeId" }, method = RequestMethod.POST)
	public @ResponseBody List<AcademicYear> getQuolificationList(@RequestParam int type) {

		List<AcademicYear> yearList = new ArrayList<>();

		try {
			yearList = yearRepo.findByTypeAndDelStatusOrderByYearIdDesc(type, 1);

		} catch (Exception e) {
			System.err.println("Exce in getAllYearList  " + e.getMessage());
			e.printStackTrace();
		}

		return yearList;

	}
	

}
