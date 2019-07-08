package com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.CompetitiveExamReport;

public interface CompetitiveExamReportRepo extends JpaRepository<CompetitiveExamReport, Integer> {

	
	
	@Query(value = "SELECT m_institute.institute_id,m_institute.institute_name,m_academic_year.academic_year, \n" + 
			"\n" + 
			"COALESCE((SELECT SUM(stud_qualifying_exam.no_stud_appeared) FROM stud_qualifying_exam WHERE stud_qualifying_exam.inst_id=m_institute.institute_id AND stud_qualifying_exam.ac_year_id=m_academic_year.year_id AND stud_qualifying_exam.del_status=1 AND stud_qualifying_exam.is_active=1 AND  stud_qualifying_exam.level_exam='State'),0) as state_level_appear,\n" + 
			"\n" + 
			"COALESCE((SELECT SUM(stud_qualifying_exam.no_stud_appeared) FROM stud_qualifying_exam WHERE stud_qualifying_exam.inst_id=m_institute.institute_id AND stud_qualifying_exam.ac_year_id=m_academic_year.year_id AND stud_qualifying_exam.del_status=1 AND stud_qualifying_exam.is_active=1 AND  stud_qualifying_exam.level_exam='National'),0) as national_level_appear,\n" + 
			"\n" + 
			"COALESCE((SELECT SUM(stud_qualifying_exam.no_stud_appeared) FROM stud_qualifying_exam WHERE stud_qualifying_exam.inst_id=m_institute.institute_id AND stud_qualifying_exam.ac_year_id=m_academic_year.year_id AND stud_qualifying_exam.del_status=1 AND stud_qualifying_exam.is_active=1 AND  stud_qualifying_exam.level_exam='International'),0) as int_level_appear\n" + 
			"\n" + 
			"\n" + 
			"FROM m_institute,m_academic_year WHERE m_academic_year.year_id=:yearId GROUP by m_institute.institute_id", nativeQuery = true)
	List<CompetitiveExamReport> getCompetitiveExamDet(@Param("yearId") String yearId
			);
}
