package com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.MaleFemaleRatioResponse;

public interface MaleFemaleRatioResponseRepo extends JpaRepository<MaleFemaleRatioResponse, Integer>{

	@Query(value="SELECT  UUID() as id," + 
			"    m_institute.institute_id," + 
			"    m_institute.institute_name," + 
			"    0 as male_faculty," + 
			"    0 as female_faculty,  0 as trans_faculty," + 
			"    0 as trans_student,0 as male_student,0 as female_student " + 
			"FROM m_institute  " + 
			"WHERE" + 
			"	 m_institute.del_status=1 AND" + 
			"    m_institute.is_active=1",nativeQuery=true)
	List<MaleFemaleRatioResponse> getInstList();
	
	
	@Query(value="SELECT UUID() as id,  m_institute.institute_id, m_institute.institute_name, \n" + 
			"    COUNT(m_faculty.faculty_id) as male_faculty,\n" + 
			"    0 as female_faculty, 0 as trans_faculty, 0 as trans_student,0 as male_student,0 as female_student \n" + 
			"FROM\n" + 
			"    m_faculty,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    m_institute.del_status=1 AND m_institute.is_active=1 AND m_faculty.institute_id = m_institute.institute_id AND m_faculty.del_status = 1 AND m_faculty.is_active = 1 AND m_faculty.f_gender =:typeId \n" + 
			"GROUP BY\n" + 
			"    m_institute.institute_id",nativeQuery=true)
	List<MaleFemaleRatioResponse> getFacultyList(@Param("typeId") int typeId);
	
	

	@Query(value="SELECT UUID() as id, \n" + 
			"  m_institute.institute_id, SUM(\n" + 
			"        t_program_student_location.female_student\n" + 
			"    ) AS female_student,\n" + 
			"    SUM(\n" + 
			"        t_program_student_location.male_student\n" + 
			"    ) AS male_student,\n" + 
			"    SUM(\n" + 
			"        t_program_student_location.trans_student\n" + 
			"    ) AS trans_student,0 as male_faculty,0 as female_faculty,0 as trans_faculty,  m_institute.institute_name\n" + 
			"   \n" + 
			"FROM  t_program_student_location,m_institute\n" + 
			"WHERE t_program_student_location.institute_id = m_institute.institute_id AND t_program_student_location.del_status = 1 AND t_program_student_location.is_active = 1 AND t_program_student_location.year_id =:yearId GROUP by m_institute.institute_id",nativeQuery=true)
	List<MaleFemaleRatioResponse> getStudentList(@Param("yearId") int yearId);
	
	
}
