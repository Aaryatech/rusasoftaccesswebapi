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
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.AdmissionsAgainstCategory;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.AluminiAssoMeetReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.AluminiEngagement;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.AvgEnrollmentPrcnt;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.AwardRecogDetailReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.BookPublicationDetReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.CapabilityEnhancementDev;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.DistinguishedAlumini;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.EGovernenceOperation;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.ExtensionActivityReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.FacParticipationInBodies;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.FinancialSuppToProfMem;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.GenderEquityProg;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.GetAluminiEngagementReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.GetAvgStudYearwise;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.GetMissions;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.GetTeachersUsingICT;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.GetVisions;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.GovtScheme;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.IQACQualInititive;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.IniToEngageLocComm;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.LibAutoLMSInfo;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.LibSpecFacilities;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.NoFacultyFinSupp;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.NoOfBookReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.NoOfGenderEquityProg;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.NoOfMentorsAssignedStudent;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.NoOfPrograms;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.NoOfStudTeachLinkageReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.NoOfUniversalvalues;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.OtherThanGovtScheme;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.PhdGuideReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.PlagarismCodeEthicsReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.QualInitiativeAssurance;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.RareBookManuscriptSpec;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.ReaddressalOfStudGrievennce;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.ResearchProjNoPerTeacher;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.SportsCulturalActivityComp;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.StakeHolderFBReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.StudEnrooledForProgramReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.StudQualifyingExamReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.StudentPerformanceOutcome;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.TeacherStudUsingLib;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.TrainProgForTeacherStaff;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.TrainProgOrgnizedForTeach;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.UniversalValPromot;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.ValueAddedCoursesReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.AcademicYearRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.SettingKeyValueRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.AdmissionsAgainstCategoryRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.AluminiAssoMeetReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.AluminiEngagementRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.AvgEnrollmentPrcntRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.AwardRecogDetailReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.BookPublicationDetReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.CapabilityEnhancementDevRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.DistinguishedAluminiRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.EGovernenceOperationRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.ExtensionActivityReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.FacParticipationInBodiesRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.FinancialSuppToProfMemRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.GenderEquityProgRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.GetAluminiEngagementReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.GetAvgStudYearwiseRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.GetMissionsRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.GetTeachersUsingICTRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.GetVisionsRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.GovtSchemeRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.IQACQualInititiveRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.IniToEngageLocCommRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.LibAutoLMSInfoRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.LibSpecFacilitiesRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.NoFacultyFinSuppRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.NoOfBookReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.NoOfGenderEquityProgRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.NoOfMentorsAssignedStudentRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.NoOfProgramsRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.NoOfStudTeachLinkageReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.NoOfUniversalvaluesRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.OtherThanGovtSchemeRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.PhdGuideReportReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.PlagarismCodeEthicsReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.QualInitiativeAssuranceRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.RareBookManuscriptSpecRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.ReaddressalOfStudGrievennceRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.ResearchProjNoPerTeacherRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.SportsCulturalActivityCompRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.StakeHolderFBReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.StudEnrooledForProgramReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.StudQualifyingExamReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.StudentPerformanceOutcomeRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.TeacherStudUsingLibRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.TrainProgForTeacherStaffRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.TrainProgOrgnizedForTeachRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.UniversalValPromotRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew.ValueAddedCoursesReportRepo;
 

@RestController
public class ReportNewApiController {

	@Autowired
	SettingKeyValueRepo settingKeyValueRepo;

	@Autowired
	AcademicYearRepo academicYearRepo;

	@Autowired
	NoOfProgramsRepo getNoOfProgramsRepo;

	@Autowired
	FacParticipationInBodiesRepo getFacParticipationInBodiesRepo;

	@Autowired
	GetAvgStudYearwiseRepo getAvgStudYearwiseRepo;

	@Autowired
	AvgEnrollmentPrcntRepo avgEnrollmentPrcntRepo;

	@RequestMapping(value = { "/getNoOfProgramsList" }, method = RequestMethod.POST)
	public @ResponseBody List<NoOfPrograms> getNoOfProgramsList(@RequestParam int instId) {

		List<NoOfPrograms> progList = new ArrayList<>();
		SettingKeyValue setKey = new SettingKeyValue();
		try {
			setKey = settingKeyValueRepo.findBySettingKeyAndDelStatus("Report1", 1);
			System.err.println("stk ids :" + setKey.toString());
			String stkId = setKey.getStringValue();
			
			List<Integer> locIds = Stream.of(setKey.getStringValue().split(",")).map(Integer::parseInt)
					.collect(Collectors.toList());
			progList = getNoOfProgramsRepo.getNoOfPrograms(instId, locIds);
			System.err.println("List=" + progList);

		} catch (Exception e) {

			System.err.println("Exce in getNoOfProgramsList R1 " + e.getMessage());
			e.printStackTrace();

		}

		return progList;

	}

	@RequestMapping(value = { "/getFacParticipationInBodies" }, method = RequestMethod.POST)
	public @ResponseBody List<FacParticipationInBodies> getFacParticipationInBodies(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<FacParticipationInBodies> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {
			List<Integer> lastFiveYears = new ArrayList<>();

			if (acYearList.contains("-5")) {
				// System.err.println("in if ");
				// System.err.println("in -5");
				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {
					// acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

				// acYrList.remove(acYrList.size());
				// System.err.println("new id list" + acYearList.toString());
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			facPartInVarBodies = getFacParticipationInBodiesRepo.getFacParticipationInBodies(instId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@RequestMapping(value = { "/getAvgEnrollmentPrcnt" }, method = RequestMethod.POST)
	public @ResponseBody List<AvgEnrollmentPrcnt> getAvgEnrollmentPrcnt(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<AvgEnrollmentPrcnt> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {
				// System.err.println("in if ");
				// System.err.println("in -5");
				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {
					// acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

				// acYrList.remove(acYrList.size());
				// System.err.println("new id list" + acYearList.toString());
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}

			facPartInVarBodies = avgEnrollmentPrcntRepo.getAvgEnrollmentPrcnt(instId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@RequestMapping(value = { "/getAvgStudYearwiseLocWise" }, method = RequestMethod.POST)
	public @ResponseBody List<GetAvgStudYearwise> getAvgStudYearwiseLocWise(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<GetAvgStudYearwise> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			// List<Integer> locId=new ArrayList<>();
			if (acYearList.contains("-5")) {
				// System.err.println("in if ");
				// System.err.println("in -5");
				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {
					// acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

				// acYrList.remove(acYrList.size());
				// System.err.println("new id list" + acYearList.toString());
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}

			SettingKeyValue setKey = new SettingKeyValue();

			setKey = settingKeyValueRepo.findBySettingKeyAndDelStatus("Report10", 1);
			System.err.println("stk ids :" + setKey.toString());

			List<Integer> locIds = Stream.of(setKey.getStringValue().split(",")).map(Integer::parseInt)
					.collect(Collectors.toList());
			int acId1 = lastFiveYears.get(0);
			int acId2 = lastFiveYears.get(1);
			int acId3 = lastFiveYears.get(2);
			int acId4 = lastFiveYears.get(3);
			int acId5 = lastFiveYears.get(4);

			facPartInVarBodies = getAvgStudYearwiseRepo.getAvgStudYearwiseLocWise(instId, locIds, acId1, acId2, acId3,
					acId4, acId5);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	GetTeachersUsingICTRepo getTeachersUsingICTRepo;

	@RequestMapping(value = { "/getTeachersUsingICT" }, method = RequestMethod.POST)
	public @ResponseBody List<GetTeachersUsingICT> getTeachersUsingICT(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<GetTeachersUsingICT> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {
				// System.err.println("in if ");
				// System.err.println("in -5");
				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {
					// acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

				// acYrList.remove(acYrList.size());
				// System.err.println("new id list" + acYearList.toString());
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			facPartInVarBodies = getTeachersUsingICTRepo.getTeachersUsingICT(instId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	NoOfMentorsAssignedStudentRepo noOfMentorsAssignedStudentRepo;

	@RequestMapping(value = { "/getNoOfMentorsAssignedStudent" }, method = RequestMethod.POST)
	public @ResponseBody List<NoOfMentorsAssignedStudent> getNoOfMentorsAssignedStudentRepo(@RequestParam int instId,
			@RequestParam List<String> acYearList) {
		List<NoOfMentorsAssignedStudent> facPartInVarBodies = new ArrayList<>();
		try {

			facPartInVarBodies = noOfMentorsAssignedStudentRepo.getNoOfMentorsAssignedStudent(instId);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	StudentPerformanceOutcomeRepo studentPerformanceOutcomeRepo;

	@RequestMapping(value = { "/getStudPerformancePo" }, method = RequestMethod.POST)
	public @ResponseBody List<StudentPerformanceOutcome> getStudPerformancePo(@RequestParam int instId,
			@RequestParam int programId) {
		List<StudentPerformanceOutcome> facPartInVarBodies = new ArrayList<>();
		try {

			facPartInVarBodies = studentPerformanceOutcomeRepo.getStudPerformanceOutcome(instId, programId);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	AdmissionsAgainstCategoryRepo admissionsAgainstCategoryRepo;

	@RequestMapping(value = { "/getAdmisssionsAgainstCat" }, method = RequestMethod.POST)
	public @ResponseBody List<AdmissionsAgainstCategory> getAdmisssionsAgainstCat(@RequestParam int instId,
			@RequestParam int catId, @RequestParam List<String> acYearList) {

		List<AdmissionsAgainstCategory> facPartInVarBodies = new ArrayList<AdmissionsAgainstCategory>();
		List<AcademicYear> acYrList = new ArrayList<AcademicYear>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {
				// System.err.println("in if ");
				// System.err.println("in -5");
				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {
					// acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

				// acYrList.remove(acYrList.size());
				// System.err.println("new id list" + acYearList.toString());
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			facPartInVarBodies = admissionsAgainstCategoryRepo.getAdmissionsAgainstCat(instId, catId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	LibAutoLMSInfoRepo libAutoLMSInfoRepo;

	@RequestMapping(value = { "/getLibLMSInfo" }, method = RequestMethod.POST)
	public @ResponseBody List<LibAutoLMSInfo> getLibLMSInfo(@RequestParam int instId, @RequestParam int acadYear ) {
		List<LibAutoLMSInfo> facPartInVarBodies = new ArrayList<>();
		try {

			facPartInVarBodies = libAutoLMSInfoRepo.getLMSInfo(instId, acadYear);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	RareBookManuscriptSpecRepo rareBookManuscriptSpecRepo;

	@RequestMapping(value = { "/getRareBookManuscript" }, method = RequestMethod.POST)
	public @ResponseBody List<RareBookManuscriptSpec> getRareBookManuscript(@RequestParam int instId) {
		List<RareBookManuscriptSpec> facPartInVarBodies = new ArrayList<>();
		try {

			facPartInVarBodies = rareBookManuscriptSpecRepo.getRareBookInfo(instId);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	LibSpecFacilitiesRepo libSpecFacilitiesRepo;

	@RequestMapping(value = { "/getLibSpecFacilities" }, method = RequestMethod.POST)
	public @ResponseBody List<LibSpecFacilities> getLibSpecFacilities(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<LibSpecFacilities> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {
			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {
				// System.err.println("in if ");
				// System.err.println("in -5");
				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {
					// acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

				// acYrList.remove(acYrList.size());
				// System.err.println("new id list" + acYearList.toString());
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			facPartInVarBodies = libSpecFacilitiesRepo.getLibSpecialFacilities(instId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	TeacherStudUsingLibRepo teacherStudUsingLibRepo;

	@RequestMapping(value = { "/getTeachersStudUsingLib" }, method = RequestMethod.POST)
	public @ResponseBody List<TeacherStudUsingLib> getTeachersStudUsingLib(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<TeacherStudUsingLib> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		List<Integer> lastFiveYears = new ArrayList<>();
		try {

			if (acYearList.contains("-5")) {
				// System.err.println("in if ");
				// System.err.println("in -5");
				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {
					// acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

				// acYrList.remove(acYrList.size());
				// System.err.println("new id list" + acYearList.toString());
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			System.err.println("Last five " + lastFiveYears.toString());
			facPartInVarBodies = teacherStudUsingLibRepo.getTechStudUsingLib(instId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	TrainProgForTeacherStaffRepo trainProgForTeacherStaffRepo;

	@RequestMapping(value = { "/getTrainProgForTeachStaffDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<TrainProgForTeacherStaff> getTrainProgForTeachStaffDetail(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<TrainProgForTeacherStaff> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		List<Integer> lastFiveYears = new ArrayList<>();
		try {

			if (acYearList.contains("-5")) {
				// System.err.println("in if ");
				// System.err.println("in -5");
				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {
					// acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

				// acYrList.remove(acYrList.size());
				// System.err.println("new id list" + acYearList.toString());
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			System.err.println("Last five " + lastFiveYears.toString());
			facPartInVarBodies = trainProgForTeacherStaffRepo.getTrainProgForTeachStaff(instId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	EGovernenceOperationRepo eGovernenceOperationRepo;

	@RequestMapping(value = { "/geteGovernanceOpt" }, method = RequestMethod.POST)
	public @ResponseBody List<EGovernenceOperation> geteGovernanceOpt(@RequestParam int instId,
			@RequestParam List<String> acYearList, @RequestParam int typeId) {

		List<EGovernenceOperation> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			List<Integer> temp = new ArrayList<>();
			temp.add(19);
			temp.add(22);

			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {
					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			SettingKeyValue setKey = new SettingKeyValue();
			SettingKeyValue setKey1 = new SettingKeyValue();
			if (typeId == 1) {
				// for R66
				setKey = settingKeyValueRepo.findBySettingKeyAndDelStatus("KEYSEC", 1);
				setKey1 = settingKeyValueRepo.findBySettingKeyAndDelStatus("KEYCODE", 1);
			} else if (typeId == 2) {
				// for R78
				setKey = settingKeyValueRepo.findBySettingKeyAndDelStatus("KEYSEC1", 1);
				setKey1 = settingKeyValueRepo.findBySettingKeyAndDelStatus("KEYCODE1", 1);

			} else if (typeId == 3) {
				// for R79
				setKey = settingKeyValueRepo.findBySettingKeyAndDelStatus("KEYSEC2", 1);
				setKey1 = settingKeyValueRepo.findBySettingKeyAndDelStatus("KEYCODE2", 1);

			} else if (typeId == 4) {
				// for R79
				setKey = settingKeyValueRepo.findBySettingKeyAndDelStatus("KEYSEC2", 1);
				setKey1 = settingKeyValueRepo.findBySettingKeyAndDelStatus("KEYCODE2", 1);
				String seccode1 = setKey.getStringValue();

				String pagecode1 = setKey1.getStringValue();
				facPartInVarBodies = eGovernenceOperationRepo.getEGovernanceOpt4(instId, lastFiveYears, seccode1,
						pagecode1, temp);
			} else if (typeId == 5) {
				// for 85
				setKey = settingKeyValueRepo.findBySettingKeyAndDelStatus("KEYSEC3", 1);
				setKey1 = settingKeyValueRepo.findBySettingKeyAndDelStatus("KEYCODE3", 1);
				String seccode1 = setKey.getStringValue();

				String pagecode1 = setKey1.getStringValue();
				facPartInVarBodies = eGovernenceOperationRepo.getEGovernanceOpt(instId, lastFiveYears, seccode1,
						pagecode1);
			}

			String seccode = setKey.getStringValue();

			String pagecode = setKey1.getStringValue();

			facPartInVarBodies = eGovernenceOperationRepo.getEGovernanceOpt(instId, lastFiveYears, seccode, pagecode);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	FinancialSuppToProfMemRepo financialSuppToProfMemRepo;

	@RequestMapping(value = { "/getFinancialSuppToProfMemDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<FinancialSuppToProfMem> getFinancialSuppToProfMemDetail(@RequestParam int instId,
			@RequestParam List<String> acYearList, @RequestParam int typeId) {

		List<FinancialSuppToProfMem> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		List<Integer> lastFiveYears = new ArrayList<>();
		try {

			if (acYearList.contains("-5")) {
				// System.err.println("in if ");
				// System.err.println("in -5");
				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {
					// acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

				// acYrList.remove(acYrList.size());
				// System.err.println("new id list" + acYearList.toString());
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			System.err.println("Last five " + lastFiveYears.toString());
			SettingKeyValue setKey = new SettingKeyValue();
			setKey = settingKeyValueRepo.findBySettingKeyAndDelStatus("Inst", 1);
			String keyVal = setKey.getStringValue();
			if (typeId == 1) {
				facPartInVarBodies = financialSuppToProfMemRepo.getAllFinancialSuppToProfMemInst(instId, lastFiveYears,
						keyVal);

			} else if (typeId == 2) {
				facPartInVarBodies = financialSuppToProfMemRepo.getAllFinancialSuppToProfMem(instId, lastFiveYears,
						keyVal);

			}
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	NoFacultyFinSuppRepo noFacultyFinSuppRepo;

	@RequestMapping(value = { "/getNoFacultyFinSuppDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<NoFacultyFinSupp> getNoFacultyFinSuppDetail(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<NoFacultyFinSupp> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		List<Integer> lastFiveYears = new ArrayList<>();
		try {

			if (acYearList.contains("-5")) {
				// System.err.println("in if ");
				// System.err.println("in -5");
				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {
					// acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

				// acYrList.remove(acYrList.size());
				// System.err.println("new id list" + acYearList.toString());
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			System.err.println("Last five " + lastFiveYears.toString());
			facPartInVarBodies = noFacultyFinSuppRepo.getAllNoFacultyFinSupp(instId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	TrainProgOrgnizedForTeachRepo trainProgOrgnizedForTeachRepo;

	@RequestMapping(value = { "/getTrainProgOrgnizedForTeach" }, method = RequestMethod.POST)
	public @ResponseBody List<TrainProgOrgnizedForTeach> getTrainProgOrgnizedForTeach(@RequestParam int instId,
			@RequestParam List<String> acYearList, @RequestParam int typeId) {

		List<TrainProgOrgnizedForTeach> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		List<Integer> lastFiveYears = new ArrayList<>();
		try {

			if (acYearList.contains("-5")) {
				// System.err.println("in if ");
				// System.err.println("in -5");
				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {
					// acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

				// acYrList.remove(acYrList.size());
				// System.err.println("new id list" + acYearList.toString());
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			System.err.println("Last five " + lastFiveYears.toString());
			facPartInVarBodies = trainProgOrgnizedForTeachRepo.getAllTrainProgOrgnizedForTeach(instId, lastFiveYears,
					typeId);
			System.err.println("List=" + facPartInVarBodies);

			List<TeacherStudUsingLib> facPartInVarBodies1 = new ArrayList<>();
			facPartInVarBodies1 = teacherStudUsingLibRepo.getTechStudUsingLib(instId, lastFiveYears);

			facPartInVarBodies.get(0).setTotCount(facPartInVarBodies1.get(0).getNoOfFullTimeFaculty());
			System.err.println("List=" + facPartInVarBodies);
		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	GetVisionsRepo getVisionsRepo;

	@RequestMapping(value = { "/getInstVisionList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetVisions> getInstVisionList(@RequestParam int instId) {

		List<GetVisions> progList = new ArrayList<>();
		try {

			progList = getVisionsRepo.getInstVision(instId);
			System.err.println("List=" + progList);

		} catch (Exception e) {

			System.err.println("Exce in getNoOfProgramsList R1 " + e.getMessage());
			e.printStackTrace();

		}

		return progList;

	}

	@Autowired
	GetMissionsRepo getMissionsRepo;

	@RequestMapping(value = { "/getInstMissionList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMissions> getInstMissionList(@RequestParam int instId) {

		List<GetMissions> progList = new ArrayList<>();
		try {

			progList = getMissionsRepo.getInstMission(instId);
			System.err.println("List=" + progList);

		} catch (Exception e) {

			System.err.println("Exce in getNoOfProgramsList R1 " + e.getMessage());
			e.printStackTrace();

		}

		return progList;

	}

	@Autowired
	IQACQualInititiveRepo iQACQualInititiveRepo;

	@RequestMapping(value = { "/getQualInititiveList" }, method = RequestMethod.POST)
	public @ResponseBody List<IQACQualInititive> getQualInititiveList(@RequestParam int instId) {

		List<IQACQualInititive> progList = new ArrayList<>();
		try {

			progList = iQACQualInititiveRepo.getQualInitiative(instId);
			System.err.println("List=" + progList);

		} catch (Exception e) {

			System.err.println("Exce in getNoOfProgramsList R1 " + e.getMessage());
			e.printStackTrace();

		}

		return progList;

	}

	@Autowired
	QualInitiativeAssuranceRepo qualInitiativeAssuranceRepo;

	@RequestMapping(value = { "/getInstQualAssurance" }, method = RequestMethod.POST)
	public @ResponseBody List<QualInitiativeAssurance> getInstQualAssurance(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<QualInitiativeAssurance> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		List<Integer> lastFiveYears = new ArrayList<>();
		try {

			if (acYearList.contains("-5")) {
				// System.err.println("in if ");
				// System.err.println("in -5");
				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {
					// acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

				// acYrList.remove(acYrList.size());
				// System.err.println("new id list" + acYearList.toString());
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			System.err.println("Last five " + lastFiveYears.toString());
			facPartInVarBodies = qualInitiativeAssuranceRepo.getAllQualAssurance(instId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	GenderEquityProgRepo genderEquityProgRepo;

	@RequestMapping(value = { "/getGenderEquityProgDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<GenderEquityProg> getGenderEquityProgDetails(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<GenderEquityProg> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		List<Integer> lastFiveYears = new ArrayList<>();
		try {

			if (acYearList.contains("-5")) {
				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {
					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			System.err.println("Last five " + lastFiveYears.toString());
			facPartInVarBodies = genderEquityProgRepo.getAllGenderEquityInfo(instId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	NoOfGenderEquityProgRepo getNoOfGenderEquityProgRepo;

	@RequestMapping(value = { "/getNoOfGenderEquityProg" }, method = RequestMethod.POST)
	public @ResponseBody List<NoOfGenderEquityProg> getNoOfGenderEquityProg(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<NoOfGenderEquityProg> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {
				// System.err.println("in if ");
				// System.err.println("in -5");
				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {
					// acYearList.add(i, String.valueOf(acYrList.get(i).getYearId()));
					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

				// acYrList.remove(acYrList.size());
				// System.err.println("new id list" + acYearList.toString());
			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			facPartInVarBodies = getNoOfGenderEquityProgRepo.getAllNoOfGenderEquityProg(instId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	IniToEngageLocCommRepo iniToEngageLocCommRepo;

	@RequestMapping(value = { "/getInitiativeOfLocalCommunityProg" }, method = RequestMethod.POST)
	public @ResponseBody List<IniToEngageLocComm> getInitiativeOfLocalCommunityProg(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<IniToEngageLocComm> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			facPartInVarBodies = iniToEngageLocCommRepo.getIniToEngageLocCommunity(instId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	UniversalValPromotRepo universalValPromotRepo;

	@RequestMapping(value = { "/getUniversalValues" }, method = RequestMethod.POST)
	public @ResponseBody List<UniversalValPromot> getUniversalValues(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<UniversalValPromot> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			facPartInVarBodies = universalValPromotRepo.getAllUniversalVal(instId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	NoOfUniversalvaluesRepo noOfUniversalvaluesRepo;

	@RequestMapping(value = { "/getNoUniversalValues" }, method = RequestMethod.POST)
	public @ResponseBody List<NoOfUniversalvalues> getNoUniversalValues(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<NoOfUniversalvalues> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			facPartInVarBodies = noOfUniversalvaluesRepo.getNoOfUniversalValues(instId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	GovtSchemeRepo govtSchemeRepo;

	@RequestMapping(value = { "/getGovtScheme" }, method = RequestMethod.POST)
	public @ResponseBody List<GovtScheme> getGovtScheme(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<GovtScheme> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			facPartInVarBodies = govtSchemeRepo.getAllGovtScheme(instId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	OtherThanGovtSchemeRepo otherThanGovtSchemeRepo;

	@RequestMapping(value = { "/getOtherThanGovtScheme" }, method = RequestMethod.POST)
	public @ResponseBody List<OtherThanGovtScheme> getOtherThanGovtScheme(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<OtherThanGovtScheme> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			facPartInVarBodies = otherThanGovtSchemeRepo.getAllOtherThanGovtScheme(instId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	DistinguishedAluminiRepo distinguishedAluminiRepo;

	@RequestMapping(value = { "/getDistinctAlumini" }, method = RequestMethod.POST)
	public @ResponseBody List<DistinguishedAlumini> getDistinctAlumini(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<DistinguishedAlumini> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			facPartInVarBodies = distinguishedAluminiRepo.getAllDistinguishedAlumini(instId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	

	@Autowired
	SportsCulturalActivityCompRepo sportsCulturalActivityCompRepo;

	@RequestMapping(value = { "/getSportsActivityComp" }, method = RequestMethod.POST)
	public @ResponseBody List<SportsCulturalActivityComp> getSportsActivityComp(@RequestParam int instId,
			@RequestParam List<String> acYearList, @RequestParam int typeId) {

		List<SportsCulturalActivityComp> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			facPartInVarBodies = sportsCulturalActivityCompRepo.getAllSportsCulturalActivityComp(instId, lastFiveYears,
					typeId);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	CapabilityEnhancementDevRepo capabilityEnhancementDevRepo;

	@RequestMapping(value = { "/getCapabilityEnhancementDev" }, method = RequestMethod.POST)
	public @ResponseBody List<CapabilityEnhancementDev> getCapabilityEnhancementDev(@RequestParam int instId,
			@RequestParam List<String> acYearList, @RequestParam int typeId) {

		List<CapabilityEnhancementDev> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			if (typeId == 1) {
				facPartInVarBodies = capabilityEnhancementDevRepo.getAllCapabilityEnhancementDev(instId, lastFiveYears);

			} else if (typeId == 2) {
				facPartInVarBodies = capabilityEnhancementDevRepo.getAllCapabilityEnhancementDevVET(instId);

			}
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	StudQualifyingExamReportRepo studQualifyingExamReportRepo;

	@RequestMapping(value = { "/getStudQualifyingExam" }, method = RequestMethod.POST)
	public @ResponseBody List<StudQualifyingExamReport> getStudQualifyingExam(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<StudQualifyingExamReport> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}

			facPartInVarBodies = studQualifyingExamReportRepo.getAllStudQualifyingExam(instId, lastFiveYears);

			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	AluminiAssoMeetReportRepo aluminiAssoMeetReportRepo;

	@RequestMapping(value = { "/getAluminiAssoMeetDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<AluminiAssoMeetReport> getAluminiAssoMeetDetails(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<AluminiAssoMeetReport> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}

			facPartInVarBodies = aluminiAssoMeetReportRepo.getAllAluminiAsso(instId, lastFiveYears);

			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	ExtensionActivityReportRepo extensionActivityReportRepo;

	@RequestMapping(value = { "/getExtesionActivityDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<ExtensionActivityReport> getExtesionActivityDetails(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<ExtensionActivityReport> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}

			facPartInVarBodies = extensionActivityReportRepo.getAllExtensionActivity(instId, lastFiveYears);

			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	NoOfStudTeachLinkageReportRepo noOfStudTeachLinkageReportRepo;

	@RequestMapping(value = { "/getNoOfStudTeachLinkageDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<NoOfStudTeachLinkageReport> getNoOfStudTeachLinkageDetails(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<NoOfStudTeachLinkageReport> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}

			facPartInVarBodies = noOfStudTeachLinkageReportRepo.getAllNoOfStudTeachLinkage(instId, lastFiveYears);

			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	AwardRecogDetailReportRepo awardRecogDetailReportRepo;

	@RequestMapping(value = { "/getAwardRecogDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<AwardRecogDetailReport> getAwardRecogDetails(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<AwardRecogDetailReport> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					// System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}

			facPartInVarBodies = awardRecogDetailReportRepo.getAllAwardRecogDetailReport(instId, lastFiveYears);

			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	BookPublicationDetReportRepo bookPublicationDetReportRepo;

	@RequestMapping(value = { "/getBookPublicationDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<BookPublicationDetReport> getBookPublicationDetails(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<BookPublicationDetReport> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					// System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}

			facPartInVarBodies = bookPublicationDetReportRepo.getBookPublicationDetReport(instId, lastFiveYears);

			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	NoOfBookReportRepo noOfBookReportRepo;

	@RequestMapping(value = { "/getNoOfBookPaperDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<NoOfBookReport> getNoOfBookDetails(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<NoOfBookReport> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					// System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}

			facPartInVarBodies = noOfBookReportRepo.getAllNoOfBookReport(instId, lastFiveYears);

			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	PhdGuideReportReport phdGuideReportReport;

	@RequestMapping(value = { "/getPddGuideDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<PhdGuideReport> getPddGuideDetails(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<PhdGuideReport> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					// System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}

			facPartInVarBodies = phdGuideReportReport.getAllPhdGuideR(instId, lastFiveYears);

			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	PlagarismCodeEthicsReportRepo plagarismCodeEthicsReportRepo;

	@RequestMapping(value = { "/getPlagarismCodeEthicsDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<PlagarismCodeEthicsReport> getPlagarismCodeEthicsDetails(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<PlagarismCodeEthicsReport> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					// System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}

			facPartInVarBodies = plagarismCodeEthicsReportRepo.getAllPlagarismCodeEthicsReport(instId, lastFiveYears);

			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	StudEnrooledForProgramReportRepo studEnrooledForProgramReportRepo;

	@RequestMapping(value = { "/getStudEnrooledForProgram" }, method = RequestMethod.POST)
	public @ResponseBody List<StudEnrooledForProgramReport> studEnrooledForProgram(@RequestParam int instId,
			@RequestParam List<String> acYearList, @RequestParam int programId) {
		List<StudEnrooledForProgramReport> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					// System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}

			facPartInVarBodies = studEnrooledForProgramReportRepo.getStudEnrooledForProgramReport(instId, lastFiveYears,
					programId);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	ValueAddedCoursesReportRepo valueAddedCoursesReportRepo;

	@RequestMapping(value = { "/getValueAddedCoursesDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<ValueAddedCoursesReport> getValueAddedCoursesDetails(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<ValueAddedCoursesReport> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					// System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}

			facPartInVarBodies = valueAddedCoursesReportRepo.getAllValueAddedCoursesReport(instId, lastFiveYears);

			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}

	@Autowired
	StakeHolderFBReportRepo stakeHolderFBReportRepo;

	@RequestMapping(value = { "/getStakeHolderFBDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<StakeHolderFBReport> getStakeHolderFBDetails(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<StakeHolderFBReport> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					// System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}

			facPartInVarBodies = stakeHolderFBReportRepo.getAllStakeHolderFBReport(instId, lastFiveYears);

			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	
	
	@Autowired
	ResearchProjNoPerTeacherRepo researchProjNoPerTeacherRepo;

	@RequestMapping(value = { "/getResearchProjectnoDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<ResearchProjNoPerTeacher> getResearchProjectnoDetails(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<ResearchProjNoPerTeacher> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					// System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}

			facPartInVarBodies = researchProjNoPerTeacherRepo.getNoOfProjPerFaculty(instId, lastFiveYears);

			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	
	
	@Autowired
	ReaddressalOfStudGrievennceRepo readdressalOfStudGrievennceRepo;

	@RequestMapping(value = { "/getStudReaddressalGrievienceDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<ReaddressalOfStudGrievennce> getStudReaddressalGrievienceDetails(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<ReaddressalOfStudGrievennce> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					// System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}

			facPartInVarBodies = readdressalOfStudGrievennceRepo.getAllStudGrievanceReport(instId, lastFiveYears);

			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	
	@Autowired
	AluminiEngagementRepo aluminiEngagementRepo;

	@RequestMapping(value = { "/getAluminiEngg" }, method = RequestMethod.POST)
	public @ResponseBody List<AluminiEngagement> getAluminiEngg(@RequestParam int instId,
			@RequestParam List<String> acYearList) {

		List<AluminiEngagement> facPartInVarBodies = new ArrayList<>();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {

			List<Integer> lastFiveYears = new ArrayList<>();
			if (acYearList.contains("-5")) {

				acYrList = academicYearRepo.getLastFiveYears();

				for (int i = 0; i < acYrList.size(); i++) {

					System.err.println("acYrList" + acYrList.get(i).toString());
					lastFiveYears.add(acYrList.get(i).getYearId());
				}

			} else {
				System.err.println("in else ");
				lastFiveYears.add(Integer.parseInt((acYearList.get(0))));

			}
			facPartInVarBodies = aluminiEngagementRepo.getAllAluminiEngg(instId, lastFiveYears);
			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	
	@Autowired
	GetAluminiEngagementReportRepo getAluminiEngagementReportRepo;
	
	@RequestMapping(value = { "/getAluminiEngagementDetails" }, method = RequestMethod.POST)
	public @ResponseBody  GetAluminiEngagementReport getAluminiEngagementDetails(@RequestParam int instId
			 ) {

	GetAluminiEngagementReport facPartInVarBodies = new GetAluminiEngagementReport();
		List<AcademicYear> acYrList = new ArrayList<>();

		try {
 			facPartInVarBodies = getAluminiEngagementReportRepo.getAllAluminiEnggReportDetails(instId);

			System.err.println("List=" + facPartInVarBodies);

		} catch (Exception e) {

			System.err.println("Exce in facPartInVarBodies R2 " + e.getMessage());
			e.printStackTrace();

		}

		return facPartInVarBodies;

	}
	
	
	
	

	
}
