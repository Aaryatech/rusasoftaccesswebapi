package com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.SubjectResrchReport;

public interface SubjectResrchReportRepo extends JpaRepository<SubjectResrchReport, Integer> {
	
	@Query(value="SELECT" + 
			"	UUID() AS id," + 
			"	m_institute.institute_name," + 
			"	institute_research_center.rc_faculty_name AS faculty_name," + 
			"   institute_research_center.rc_guide_count AS affiliated_guide," + 
			"   institute_research_center.rc_student_count AS student_reg ," + 
			"   m_academic_year.academic_year" + 
			"FROM institute_research_center, m_institute, m_academic_year " + 
			"WHERE " + 
			"	institute_research_center.del_status=1 AND" + 
			"	institute_research_center.is_active=1 AND" + 
			"   institute_research_center.institute_id=m_institute.institute_id AND" + 
			"   institute_research_center.year_id=m_academic_year.year_id AND" + 
			"   m_institute.institute_id=:instId AND" + 
			"   m_academic_year.year_id=:yearId",nativeQuery=true)
	List<SubjectResrchReport> getSubjectResrchReport(int instId, String yearId);
	

}
