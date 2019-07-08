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
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.CompetitiveExamReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.FunctionalMouReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.InstituteAccredationReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.MaleFemaleRatioResponse;
 import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.PlacementUgPgStud;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.StudPartInNssNcc;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.StudentParticipatedInSports;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.ValueAddedCourseReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.AcademicYearRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.InstituteAccredationReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.SettingKeyValueRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb.AccredationStatusReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb.AntiRaggingHarresmentReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb.CompetitiveExamReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb.FunctionalMouReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb.MaleFemaleRatioResponseRepo;
 import com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb.PlacementUgPgStudRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb.StudPartInNssNccRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb.StudentParticipatedInSportsRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb.ValueAddedCourseReportRepo;

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
	public @ResponseBody List<AccredationStatusReport> getAllAccredationStatusReport(@RequestParam String qualId) {

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
		// System.err.println("stk ids :" + setKey.toString());

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

	@Autowired
	CompetitiveExamReportRepo competitiveExamReportRepo;

	@RequestMapping(value = { "/getCompetitiveExamReport" }, method = RequestMethod.POST)
	public @ResponseBody List<CompetitiveExamReport> getCompetitiveExamReport(@RequestParam String yearId) {

		List<CompetitiveExamReport> facPartInVarBodies = new ArrayList<>();

		try {

			facPartInVarBodies = competitiveExamReportRepo.getCompetitiveExamDet(yearId);
			// System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	ValueAddedCourseReportRepo valueAddedCourseReportRepo;

	@RequestMapping(value = { "/getvalueAddedCourseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<ValueAddedCourseReport> getvalueAddedCourseReport(@RequestParam List<String> instList,
			@RequestParam int yearId) {

		List<ValueAddedCourseReport> facPartInVarBodies = new ArrayList<>();

		try {

			List<Integer> institutesList = new ArrayList<>();

			for (int i = 0; i < instList.size(); i++) {

				institutesList.add(Integer.parseInt(instList.get(i)));
			}
			// System.err.println("Inst List=" + institutesList.toString());
			facPartInVarBodies = valueAddedCourseReportRepo.getvalueAddedCoursesDet(institutesList, yearId);
			// System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	
	// Look into this
	@Autowired
	MaleFemaleRatioResponseRepo maleFemaleRatioResponseRepo;

	@RequestMapping(value = { "/getMaleFemaleRatioReport" }, method = RequestMethod.POST)
	public @ResponseBody List<MaleFemaleRatioResponse> getMaleFemaleRatioReport(
			@RequestParam int yearId) {

		List<MaleFemaleRatioResponse> instRes = new ArrayList<>();
		
		//fac
		List<MaleFemaleRatioResponse> listMale = new ArrayList<>();
		List<MaleFemaleRatioResponse> listFeMale = new ArrayList<>();
		List<MaleFemaleRatioResponse> listTrans = new ArrayList<>();
		instRes = maleFemaleRatioResponseRepo.getInstList();
		listMale = maleFemaleRatioResponseRepo.getFacultyList(0);
		listFeMale = maleFemaleRatioResponseRepo.getFacultyList(1);
		listTrans = maleFemaleRatioResponseRepo.getFacultyList(2);

		List<MaleFemaleRatioResponse> listStud = new ArrayList<>();
		listStud = maleFemaleRatioResponseRepo.getStudentList(yearId);
		
		try {
			for (int i = 0; i < instRes.size(); i++) {

				for (int j = 0; j < listMale.size(); j++) {
					if (instRes.get(i).getInstituteId() == listMale.get(j).getInstituteId()) {

						instRes.get(i).setMaleFaculty(listMale.get(j).getMaleFaculty());
						break;
					}

				} // end of male for
			
			
			

				for (int j = 0; j < listFeMale.size(); j++) {
					if (instRes.get(i).getInstituteId() == listFeMale.get(j).getInstituteId()) {

						instRes.get(i).setFemaleFaculty(listFeMale.get(j).getMaleFaculty());
						break;
					}

				} // end of female for
			

			
		

				for (int j = 0; j < listTrans.size(); j++) {
					if (instRes.get(i).getInstituteId() == listTrans.get(j).getInstituteId()) {

						instRes.get(i).setTransFaculty(listTrans.get(j).getMaleFaculty());
						break;
					}

				} // end of trans for
		
			//
			
			
		
			
				for (int j = 0; j < listStud.size(); j++) {
					if (instRes.get(i).getInstituteId() == listStud.get(j).getInstituteId()) {

						instRes.get(i).setFemaleStudent(listStud.get(j).getFemaleStudent());
						instRes.get(i).setMaleStudent(listStud.get(j).getMaleStudent());
						instRes.get(i).setTransStudent(listStud.get(j).getTransStudent());

						break;
					}

				} // end of trans for
			}
			
			
			

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return instRes;

	}
	
	@Autowired
	StudentParticipatedInSportsRepo studentParticipatedInSportsRepo;

	@RequestMapping(value = { "/getStudentParticipatedReport" }, method = RequestMethod.POST)
	public @ResponseBody List<StudentParticipatedInSports> getStudentParticipatedReport(@RequestParam int yearId) {

		List<StudentParticipatedInSports> facPartInVarBodies = new ArrayList<>();

		try { 
			facPartInVarBodies = studentParticipatedInSportsRepo.getStudentParDet( yearId);
			// System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in getStudentParticipatedReport R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	StudPartInNssNccRepo studPartInNssNccRepo;
	
	
	@RequestMapping(value = { "/getStudentParticipatedNssNccReport" }, method = RequestMethod.POST)
	public @ResponseBody List<StudPartInNssNcc> getStudentParticipatedNssNccReport(@RequestParam int yearId) {

		List<StudPartInNssNcc> facPartInVarBodies = new ArrayList<>();

		try { 
			facPartInVarBodies = studPartInNssNccRepo.getStudPartNssNccDetList( yearId);
			// System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in getStudentParticipatedReport R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	FunctionalMouReportRepo functionalMouReportRepo;

	
	@RequestMapping(value = { "/getFunctionalMousReport" }, method = RequestMethod.POST)
	public @ResponseBody List<FunctionalMouReport> getFunctionalMousReport(@RequestParam int yearId) {

		List<FunctionalMouReport> facPartInVarBodies = new ArrayList<>();

		try { 
			facPartInVarBodies = functionalMouReportRepo.getFunctionalMouDet(yearId);
			// System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in getStudentParticipatedReport R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	
}
