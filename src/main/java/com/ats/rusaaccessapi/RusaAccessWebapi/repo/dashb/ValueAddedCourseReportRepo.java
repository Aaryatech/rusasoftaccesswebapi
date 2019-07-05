package com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.ValueAddedCourseReport;

public interface ValueAddedCourseReportRepo extends  JpaRepository<ValueAddedCourseReport, Integer> {

	
	@Query(value = "SELECT\n" + 
			"value_added_courses.value_added_course_id,\n" + 
			"    value_added_courses.value_added_course_name,\n" + 
			"    value_added_courses.no_of_students_enrolled,\n" + 
			"    value_added_courses.no_of_students_completed_course,\n" + 
			"    value_added_courses.course_code,\n" + 
			"    m_institute.institute_name,m_institute.institute_id, m_academic_year.academic_year \n" + 
			"FROM\n" + 
			"    value_added_courses,m_institute,m_academic_year  \n" + 
			"WHERE\n" + 
			"    value_added_courses.del_status = 1 AND value_added_courses.is_active = 1 AND value_added_courses.inst_id IN(:instIdList) AND m_institute.institute_id = value_added_courses.inst_id AND value_added_courses.academic_year_id = m_academic_year.year_id AND m_academic_year.year_id =:yearId ", nativeQuery = true)
	List<ValueAddedCourseReport> getvalueAddedCoursesDet(@Param("instIdList") List<Integer> instIdList,@Param("yearId") int yearId	);
		
	
	
}
