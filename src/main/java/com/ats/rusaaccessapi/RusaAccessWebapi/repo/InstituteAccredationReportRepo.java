package com.ats.rusaaccessapi.RusaAccessWebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.InstituteAccredationReport;

public interface InstituteAccredationReportRepo extends JpaRepository<InstituteAccredationReport, Integer>{

	 @Query(value="SELECT\n" + 
	 		"    m_institute.institute_id,\n" + 
	 		"    m_institute.institute_name, m_institute.district as district_name, \n" + 
	 		"    COALESCE(\n" + 
	 		"        (\n" + 
	 		"        SELECT\n" + 
	 		"            'Yes'\n" + 
	 		"        FROM\n" + 
	 		"            t_institute_quality,\n" + 
	 		"            m_quality_initiatives\n" + 
	 		"        WHERE\n" + 
	 		"            t_institute_quality.institute_id = m_institute.institute_id AND t_institute_quality.is_certi_obt=1 AND t_institute_quality.quality_initiative_id = m_quality_initiatives.quality_initiative_id AND t_institute_quality.del_status = 1 AND t_institute_quality.is_active = 1 AND t_institute_quality.quality_initiative_id =:stkIdNba \n" + 
	 		"    ),\n" + 
	 		"    'No'\n" + 
	 		"    ) AS 'NBA', \n" + 
	 		"    COALESCE(\n" + 
	 		"        (\n" + 
	 		"        SELECT\n" + 
	 		"           'Yes'\n" + 
	 		"        FROM\n" + 
	 		"            t_institute_quality,\n" + 
	 		"            m_quality_initiatives\n" + 
	 		"        WHERE\n" + 
	 		"            t_institute_quality.institute_id = m_institute.institute_id AND t_institute_quality.quality_initiative_id = m_quality_initiatives.quality_initiative_id AND t_institute_quality.del_status = 1 AND t_institute_quality.is_active = 1 AND t_institute_quality.quality_initiative_id = :stkIdNacc \n" + 
	 		"    ),\n" + 
	 		"    'No'\n" + 
	 		"    ) AS 'NAAC',\n" + 
	 		"    \n" + 
	 		"    COALESCE(\n" + 
	 		"        (\n" + 
	 		"        SELECT\n" + 
	 		"           'Yes'\n" + 
	 		"        FROM\n" + 
	 		"            t_institute_quality,\n" + 
	 		"            m_quality_initiatives\n" + 
	 		"        WHERE\n" + 
	 		"            t_institute_quality.institute_id = m_institute.institute_id AND t_institute_quality.quality_initiative_id = m_quality_initiatives.quality_initiative_id AND t_institute_quality.del_status = 1 AND t_institute_quality.is_active = 1 AND t_institute_quality.quality_initiative_id =:stkIdNirf \n" + 
	 		"    ),\n" + 
	 		"   'No'\n" + 
	 		"    ) AS 'NIRF',\n" + 
	 		"    COALESCE(\n" + 
	 		"        (\n" + 
	 		"        SELECT\n" + 
	 		"         'Yes'\n" + 
	 		"        FROM\n" + 
	 		"            t_institute_quality,\n" + 
	 		"            m_quality_initiatives\n" + 
	 		"        WHERE\n" + 
	 		"            t_institute_quality.institute_id = m_institute.institute_id AND t_institute_quality.quality_initiative_id = m_quality_initiatives.quality_initiative_id AND t_institute_quality.del_status = 1 AND t_institute_quality.is_active = 1 AND t_institute_quality.quality_initiative_id =:stkIdThe \n" + 
	 		"    ),\n" + 
	 		"   'No'\n" + 
	 		"    ) AS 'THE'\n" + 
	 		"FROM\n" + 
	 		"    m_institute", nativeQuery=true)
	List<InstituteAccredationReport> getInstituteAccreDetail(@Param("stkIdNacc") int stkIdNacc,@Param("stkIdNba") int stkIdNba,@Param("stkIdNirf") int stkIdNirf,@Param("stkIdThe") int stkIdThe);
	 
	
	
}
