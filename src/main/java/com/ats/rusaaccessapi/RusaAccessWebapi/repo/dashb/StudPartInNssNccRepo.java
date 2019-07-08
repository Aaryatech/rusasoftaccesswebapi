package com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.StudPartInNssNcc;

public interface StudPartInNssNccRepo extends JpaRepository<StudPartInNssNcc, Integer>{
	
	@Query(value="SELECT\n" + 
			"    m_institute.institute_id,\n" + 
			"    m_institute.institute_name,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            t_extension_activity.no_of_stud_participated\n" + 
			"        FROM\n" + 
			"            t_extension_activity,\n" + 
			"            m_extension_activity\n" + 
			"        WHERE\n" + 
			"            m_extension_activity.extension_activity_id = 1 AND m_extension_activity.extension_activity_id = t_extension_activity.extension_activity_id AND t_extension_activity.del_status = 1 AND t_extension_activity.is_active = 1 AND t_extension_activity.inst_id = m_institute.institute_id AND t_extension_activity.ac_year_id = m_academic_year.year_id\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS nss_count,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            t_extension_activity.no_of_stud_participated\n" + 
			"        FROM\n" + 
			"            t_extension_activity,\n" + 
			"            m_extension_activity\n" + 
			"        WHERE\n" + 
			"            m_extension_activity.extension_activity_id = 2 AND m_extension_activity.extension_activity_id = t_extension_activity.extension_activity_id AND t_extension_activity.del_status = 1 AND t_extension_activity.is_active = 1 AND t_extension_activity.inst_id = m_institute.institute_id AND t_extension_activity.ac_year_id = m_academic_year.year_id\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS ncc_count\n" + 
			"FROM\n" + 
			"    m_institute,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    m_institute.del_status = 1 AND m_academic_year.year_id =:yearId",nativeQuery=true)
	List<StudPartInNssNcc> getStudPartNssNccDetList(@Param("yearId") int yearId);
	

}
