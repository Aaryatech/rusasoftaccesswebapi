package com.ats.rusaaccessapi.RusaAccessWebapi.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.CurricularActivityCnts;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.FacultyResearchDetail;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.GrantRecivResrchReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.SubjectResrchReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.CurricularActivityCntsRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb.FacultyResearchDetailRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb.GrantRecivResrchReportRepo;
import com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb.SubjectResrchReportRepo;

@RestController
public class RusaAdReportApiContrl {
	@Autowired
	CurricularActivityCntsRepo curriCntRepo;
	@RequestMapping(value = { "/getCntCurriclarActivity" }, method = RequestMethod.POST)
		public List<CurricularActivityCnts> getCntCurriclarActivity(@RequestParam String yearId) {
			{
				List<CurricularActivityCnts> curriCntIntsList = new ArrayList<CurricularActivityCnts>();	
				 
			try {
				 curriCntIntsList = new ArrayList<CurricularActivityCnts>();
				 curriCntIntsList=curriCntRepo.getInstList();
				 System.out.println("Int List--------"+curriCntIntsList.toString());
				 
				 
				 List<CurricularActivityCnts> curriCntList = new ArrayList<CurricularActivityCnts>();
				 curriCntList=curriCntRepo.getCurriActCnt(yearId);
				 System.out.println("Curri List--------"+curriCntList.toString());
				 
				 List<CurricularActivityCnts> coCurriCntList = new ArrayList<CurricularActivityCnts>();
				 coCurriCntList=curriCntRepo.getCoCurriActCnt(yearId);
				 System.out.println("CoCurri List--------"+coCurriCntList.toString());
				 
				 List<CurricularActivityCnts> extraCurriCntList = new ArrayList<CurricularActivityCnts>();
				 extraCurriCntList=curriCntRepo.getExtraCoCurriActCnt(yearId);
				 System.out.println("CoCurri List--------"+extraCurriCntList.toString());
				 
				 
				 
				 for(int i=0 ; i < curriCntIntsList.size() ; i++) {
					 
					 for(int j=0 ; j < curriCntList.size() ; j++) {
						 
						 if(curriCntIntsList.get(i).getInstituteId()==curriCntList.get(j).getInstituteId()) {
										
							 curriCntIntsList.get(i).setCurriCnt(curriCntList.get(j).getCurriCnt());
							 
						 }
					 }
					 
					 for(int k=0; k<coCurriCntList.size() ; k++) {
						 if(curriCntIntsList.get(i).getInstituteId()==coCurriCntList.get(k).getInstituteId()) {
							 curriCntIntsList.get(i).setCoCurryCnt(coCurriCntList.get(k).getCoCurryCnt());
						 }
					 }
					 
					 for(int x=0 ; x<extraCurriCntList.size() ; x++) {
						 if(curriCntIntsList.get(i).getInstituteId()==extraCurriCntList.get(x).getInstituteId()) {
							 curriCntIntsList.get(i).setExtraCoCarryCnt(extraCurriCntList.get(x).getExtraCoCarryCnt());
						 }
					 }
					 System.out.println("Curri Cnt-------"+curriCntIntsList.get(i).getInstituteId()+"----------"+curriCntIntsList.get(i).getInstituteName()+"----"+curriCntIntsList.get(i).getCurriCnt()+"------"+curriCntIntsList.get(i).getCoCurryCnt()+"-------"+curriCntIntsList.get(i).getExtraCoCarryCnt());	 
				 } 
				 
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			return curriCntIntsList;
		}
	}
	
	@Autowired
	GrantRecivResrchReportRepo grntRecvRepo;
	@RequestMapping(value = { "/getGrantReceivReport" }, method = RequestMethod.POST)
		public List<GrantRecivResrchReport> getGrantReceivReport(@RequestParam String yearId) {
		
		List<GrantRecivResrchReport> grntRecvList = new ArrayList<GrantRecivResrchReport>();
		try {
			System.out.println("Hi");
			grntRecvList=grntRecvRepo.getGrantRecivedResrchReport(yearId);
			System.out.println("Lis-----"+grntRecvList.toString());
		}catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
			return grntRecvList;		
	}
	
	@Autowired
	SubjectResrchReportRepo subResrchRepo;
	@RequestMapping(value = { "/getSubjectResrchRep" }, method = RequestMethod.POST)
		public List<SubjectResrchReport> getSubjectResrchRep(@RequestParam int instId, @RequestParam String yearId) {
		
		List<SubjectResrchReport> subRsrchList=new ArrayList<SubjectResrchReport>();
		try {
			subRsrchList = subResrchRepo.getSubjectResrchReport(instId, yearId);
		}catch (Exception e) {
			// TODO: handle exception
		}
			return subRsrchList;
		
	}
	
	@Autowired
	FacultyResearchDetailRepo facResrchRepo;
	@RequestMapping(value = { "/getFacultyResrchRep" }, method = RequestMethod.POST)
		public List<FacultyResearchDetail> getFacultyResrchRep(@RequestParam int instId) {
		
		List<FacultyResearchDetail> facRsrchList=new ArrayList<FacultyResearchDetail>();
		try {
			facRsrchList = facResrchRepo.getFacultyResrchReport(instId);
		}catch (Exception e) {
			// TODO: handle exception
		}
			return facRsrchList;
		
	}
		
}
