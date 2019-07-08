package com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.StudentParticipatedInSports;

public interface StudentParticipatedInSportsRepo extends JpaRepository<StudentParticipatedInSports, Integer>{

	
	@Query(value = "SELECT\n" + 
			"    m_institute.institute_id,\n" + 
			"    m_institute.institute_name,\n" + 
			"    m_academic_year.academic_year,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            SUM(\n" + 
			"                t_institute_activity.inst_activity_participation\n" + 
			"            )\n" + 
			"        FROM\n" + 
			"            t_institute_activity\n" + 
			"        WHERE\n" + 
			"            t_institute_activity.institute_id = m_institute.institute_id AND t_institute_activity.year_id = m_academic_year.year_id AND t_institute_activity.del_status = 1 AND t_institute_activity.is_active = 1 AND t_institute_activity.inst_activity_type = 'Sports'\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS sport_count,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            SUM(\n" + 
			"                t_institute_activity.inst_activity_participation\n" + 
			"            )\n" + 
			"        FROM\n" + 
			"            t_institute_activity\n" + 
			"        WHERE\n" + 
			"            t_institute_activity.institute_id = m_institute.institute_id AND t_institute_activity.year_id = m_academic_year.year_id AND t_institute_activity.del_status = 1 AND t_institute_activity.is_active = 1 AND t_institute_activity.inst_activity_type = 'Cultural'\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS cultural_count\n" + 
			"FROM\n" + 
			"    m_institute,\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    m_institute.del_status = 1 AND m_academic_year.year_id =:yearId ", nativeQuery = true)
	List<StudentParticipatedInSports> getStudentParDet(@Param("yearId") int yearId);
	
	
	
	
}
