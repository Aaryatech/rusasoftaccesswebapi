package com.ats.rusaaccessapi.RusaAccessWebapi.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
 
import com.ats.rusaaccessapi.RusaAccessWebapi.model.AcademicYear;

 



public interface AcademicYearRepo extends JpaRepository<AcademicYear, Integer>  {

	List<AcademicYear> findByTypeAndDelStatusOrderByYearIdDesc(int type, int i);

	
	@Query(value=" SELECT * FROM m_academic_year where m_academic_year.seq_no <= " + 
			" (select m_academic_year.seq_no from m_academic_year where m_academic_year.is_current=1)" + 
			" AND m_academic_year.del_status=1 order by seq_no desc limit 5",nativeQuery=true)

	List<AcademicYear> getLastFiveYears();
}
