package com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.CompetitiveExamReport;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.FunctionalMouReport;

public interface FunctionalMouReportRepo extends JpaRepository<FunctionalMouReport, Integer> {

	
	

	@Query(value = "SELECT\n" + 
			"    m_institute.institute_id,\n" + 
			"    m_institute.institute_name,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            COUNT(t_institute_mou.mou_id)\n" + 
			"        FROM\n" + 
			"            t_institute_mou\n" + 
			"        WHERE\n" + 
			"            t_institute_mou.institute_id = m_institute.institute_id AND t_institute_mou.year_id = m_academic_year.year_id AND t_institute_mou.del_status = 1 AND t_institute_mou.is_active = 1\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS no_of_mous\n" + 
			"FROM\n" + 
			"    m_institute,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    m_institute.del_status = 1 AND m_academic_year.year_id = :yearId", nativeQuery = true)
	List<FunctionalMouReport> getFunctionalMouDet(@Param("yearId") int yearId
			);
}
