package com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.MaleFemaleRatioTemp;

public interface MaleFemaleRatioTempRepo extends JpaRepository< MaleFemaleRatioTemp, Integer> {
	
	
	@Query(value = "SELECT\n" + 
			"    COUNT(m_faculty.faculty_id) as fac_no,\n" + 
			"    m_institute.institute_id\n" + 
			"FROM\n" + 
			"    m_faculty,\n" + 
			"    m_institute\n" + 
			"WHERE\n" + 
			"    m_faculty.institute_id = m_institute.institute_id AND m_faculty.del_status = 1 AND m_faculty.is_active = 1 AND m_faculty.f_gender =:typeId \n" + 
			"GROUP BY\n" + 
			"    m_institute.institute_id", nativeQuery = true)
	List<MaleFemaleRatioTemp> getMaleFemaleFacRep(@Param("typeId") int typeId);

}
