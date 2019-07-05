package com.ats.rusaaccessapi.RusaAccessWebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.CurricularActivityCnts;

public interface CurricularActivityCntsRepo extends JpaRepository<CurricularActivityCnts, Integer> {

	@Query(value="SELECT UUID() as id, " + 
			"    m_institute.institute_id," + 
			"    m_institute.institute_name," + 
			"    0 as curri_cnt," + 
			"    0 as co_curry_cnt," + 
			"    0 as extra_co_carry_cnt " + 
			"FROM m_institute  " + 
			"WHERE" + 
			"	 m_institute.del_status=1 AND" + 
			"    m_institute.is_active=1",nativeQuery=true)
	List<CurricularActivityCnts> getInstList();
	

	@Query(value="SELECT " + 
			"	UUID() as id, m_institute.institute_id,m_institute.institute_name," + 
			" 	COUNT(t_program_student_activity.student_activity_id) as curri_cnt," + 
			"	0 as co_curry_cnt," + 
			" 	0 as extra_co_carry_cnt " + 
			"FROM " + 
			"	m_institute,t_program_student_activity " + 
			"WHERE" + 
			"	t_program_student_activity.del_status=1 AND" + 
			"    t_program_student_activity.is_active=1 AND" + 
			"    t_program_student_activity.year_id=:yearId AND" + 
			"    t_program_student_activity.institute_id=m_institute.institute_id AND " + 
			"    t_program_student_activity.activity_name='Curricular'AND" + 
			"    m_institute.del_status=1 AND" + 
			"    m_institute.is_active=1"
			+ "  GROUP BY t_program_student_activity.institute_id",nativeQuery=true)
	List<CurricularActivityCnts> getCurriActCnt(@Param("yearId") int yearId);


	@Query(value="SELECT " + 
			"	UUID() as id, m_institute.institute_id,m_institute.institute_name," + 
			" 	0 as curri_cnt," + 
			"	COUNT(t_program_student_activity.student_activity_id) as co_curry_cnt," + 
			" 	0 as extra_co_carry_cnt " + 
			"FROM " + 
			"	m_institute,t_program_student_activity " + 
			"WHERE" + 
			"	t_program_student_activity.del_status=1 AND" + 
			"    t_program_student_activity.is_active=1 AND" + 
			"    t_program_student_activity.year_id=:yearId AND" + 
			"    t_program_student_activity.institute_id=m_institute.institute_id AND " + 
			"    t_program_student_activity.activity_name='Co-curricular'AND" + 
			"    m_institute.del_status=1 AND" + 
			"    m_institute.is_active=1"
			+ "  GROUP BY t_program_student_activity.institute_id",nativeQuery=true)
	List<CurricularActivityCnts> getCoCurriActCnt(@Param("yearId") int yearId);


	@Query(value="SELECT " + 
			"	UUID() as id, m_institute.institute_id,m_institute.institute_name," + 
			" 	0 as curri_cnt," + 
			"	0 as co_curry_cnt," + 
			" 	COUNT(t_program_student_activity.student_activity_id) as extra_co_carry_cnt " + 
			"FROM " + 
			"	m_institute,t_program_student_activity " + 
			"WHERE" + 
			"	t_program_student_activity.del_status=1 AND" + 
			"    t_program_student_activity.is_active=1 AND" + 
			"    t_program_student_activity.year_id=:yearId AND" + 
			"    t_program_student_activity.institute_id=m_institute.institute_id AND " + 
			"    t_program_student_activity.activity_name='Extra Curricular' AND" + 
			"    m_institute.del_status=1 AND" + 
			"    m_institute.is_active=1"
			+ "		GROUP BY t_program_student_activity.institute_id",nativeQuery=true)
	List<CurricularActivityCnts> getExtraCoCurriActCnt(@Param("yearId") int yearId);

}
