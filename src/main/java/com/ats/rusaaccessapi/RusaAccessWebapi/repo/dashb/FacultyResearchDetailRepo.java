package com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.FacultyResearchDetail;

public interface FacultyResearchDetailRepo extends JpaRepository<FacultyResearchDetail, Integer> {

	@Query(value="SELECT UUID() as id," + 
			"	 m_institute.institute_id, m_institute.institute_name,m_academic_year.academic_year," + 
			"    m_faculty.faculty_first_name," + 
			"    t_faculty_project.proj_name,t_faculty_project.proj_total_amt," + 
			"    t_faculty_project.proj_sponsor " + 
			"FROM m_institute,m_academic_year,m_faculty,t_faculty_project " + 
			"WHERE m_institute.del_status=1 AND" + 
			"     m_academic_year.year_id=1 AND" + 
			"     t_faculty_project.faculty_id=m_faculty.faculty_id AND" + 
			"     m_faculty.institute_id=m_institute.institute_id AND" + 
			"     t_faculty_project.year_id=m_academic_year.year_id AND " + 
			"     m_institute.institute_id=:instId",nativeQuery=true)
	List<FacultyResearchDetail> getFacultyResrchReport(@Param("instId") int instId);
}
