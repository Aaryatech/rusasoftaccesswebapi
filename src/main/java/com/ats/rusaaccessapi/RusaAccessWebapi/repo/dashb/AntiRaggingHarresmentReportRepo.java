package com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.AntiRaggingHarresmentReport;
 
public interface AntiRaggingHarresmentReportRepo extends JpaRepository<AntiRaggingHarresmentReport, Integer> {

	@Query(value = "SELECT\n" + 
			"    m_institute.institute_id,\n" + 
			"    m_institute.institute_name,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            'Yes' \n" + 
			"        FROM\n" + 
			"            redressed_stud_grievance\n" + 
			"        WHERE\n" + 
			"            redressed_stud_grievance.stud_grievnce = 'Sexual Harassment' AND redressed_stud_grievance.del_status = 1 AND redressed_stud_grievance.is_active = 1 AND redressed_stud_grievance.inst_id = m_institute.institute_id AND redressed_stud_grievance.acad_year_id = m_academic_year.year_id\n" + 
			"        ORDER BY\n" + 
			"            redressed_stud_grievance.redrs_stud_grvnc_id\n" + 
			"        DESC\n" + 
			"    LIMIT 1\n" + 
			"    ),\n" + 
			"    'No' \n" + 
			"    ) AS sexual_harash_commitee, COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            'Yes' \n" + 
			"        FROM\n" + 
			"            redressed_stud_grievance\n" + 
			"        WHERE\n" + 
			"            redressed_stud_grievance.stud_grievnce = 'Ragging Cases' AND redressed_stud_grievance.del_status = 1 AND redressed_stud_grievance.is_active = 1 AND redressed_stud_grievance.inst_id = m_institute.institute_id AND redressed_stud_grievance.acad_year_id = m_academic_year.year_id\n" + 
			"        ORDER BY\n" + 
			"            redressed_stud_grievance.redrs_stud_grvnc_id\n" + 
			"        DESC\n" + 
			"    LIMIT 1\n" + 
			"    ),\n" + 
			"    'No' \n" + 
			"    ) AS ragging_commitee\n" + 
			"FROM\n" + 
			"    m_institute,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    m_institute.del_status = 1 AND m_academic_year.year_id =:yearId ", nativeQuery = true)
	List<AntiRaggingHarresmentReport> getAntiRaggingRep(@Param("yearId") int yearId);
	
	
}
