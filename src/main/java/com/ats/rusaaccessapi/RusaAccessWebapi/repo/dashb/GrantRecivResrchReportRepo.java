package com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.GrantRecivResrchReport;

public interface GrantRecivResrchReportRepo extends JpaRepository<GrantRecivResrchReport, Integer> {
	
	@Query(value="SELECT UUID() as id," + 
			"	m_institute.institute_id," + 
			"	m_institute.institute_name," + 
			"   SUM(t_faculty_project.proj_total_amt) as grant_amt," + 
			"   m_academic_year.academic_year " + 
			"FROM " + 
			"	m_institute,t_faculty_project,m_faculty,m_academic_year " + 
			"WHERE " + 
			"	t_faculty_project.faculty_id=m_faculty.faculty_id AND " + 
			"   t_faculty_project.del_status=1 AND t_faculty_project.is_active=1 AND" + 
			"   t_faculty_project.year_id=m_academic_year.year_id AND" + 
			"	m_faculty.institute_id=m_institute.institute_id  AND " + 
			"	m_academic_year.year_id=:yearId " + 
			"GROUP by m_institute.institute_id",nativeQuery=true)
	
	List<GrantRecivResrchReport> getGrantRecivedResrchReport(@Param("yearId") String yearId);
}
