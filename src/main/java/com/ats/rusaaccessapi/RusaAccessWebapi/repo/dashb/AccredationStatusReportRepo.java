package com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.AccredationStatusReport;
 
public interface AccredationStatusReportRepo extends JpaRepository<AccredationStatusReport, Integer> {

	@Query(value = "SELECT\n" + 
			"    m_institute.institute_id,\n" + 
			"    m_institute.institute_name,\n" + 
			"    t_institute_quality.quality_fromdt,\n" + 
			"    t_institute_quality.quality_todt,\n" + 
			"    m_institute.aishe_code,\n" + 
			"    m_quality_initiatives.quality_initiative_name\n" + 
			"FROM\n" + 
			"    m_institute,\n" + 
			"    t_institute_quality,\n" + 
			"    m_quality_initiatives\n" + 
			"WHERE\n" + 
			"    t_institute_quality.institute_id = m_institute.institute_id AND t_institute_quality.is_certi_obt = 1 AND t_institute_quality.quality_initiative_id = m_quality_initiatives.quality_initiative_id AND t_institute_quality.del_status = 1 AND t_institute_quality.is_active = 1 AND t_institute_quality.quality_initiative_id =:qualId", nativeQuery = true)
	List<AccredationStatusReport> getAccredationStat(@Param("qualId") int qualId
			);
	
	
}
