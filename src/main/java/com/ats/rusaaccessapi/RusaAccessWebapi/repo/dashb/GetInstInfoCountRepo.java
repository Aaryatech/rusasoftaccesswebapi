package com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.GetInstInfoCount;

public interface GetInstInfoCountRepo extends JpaRepository<GetInstInfoCount, Integer> {
	
	@Query(value="SELECT 0 as id, " + 
			"COALESCE((SELECT COUNT(m_institute.institute_id) FROM m_institute WHERE m_institute.ex_var1=1 AND m_institute.del_status=1 AND m_institute.ex_int2=1),0) as govt, " +  
			"COALESCE((SELECT COUNT(m_institute.institute_id) FROM m_institute WHERE m_institute.ex_var1=2 AND m_institute.del_status=1 AND m_institute.ex_int2=1 ),0) as aided, " + 
			"COALESCE((SELECT COUNT(m_institute.institute_id) FROM m_institute WHERE m_institute.ex_var1=3 AND m_institute.del_status=1 AND m_institute.ex_int2=1 ),0) as unaided, " + 
			"COALESCE((SELECT COUNT(m_institute.institute_id) FROM m_institute WHERE m_institute.ex_var2=1 AND m_institute.del_status=1 AND m_institute.ex_int2=1 ),0) as autonmous",nativeQuery=true)
	GetInstInfoCount getInstituteOtherInfoCount();

}
