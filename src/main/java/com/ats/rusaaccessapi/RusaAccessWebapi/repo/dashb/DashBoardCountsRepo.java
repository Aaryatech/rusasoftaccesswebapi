package com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.GetCountsForDash;
import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.GetInstInfoCount;

public interface DashBoardCountsRepo extends JpaRepository<GetCountsForDash, Integer> {

	@Query(value = "SELECT\n" + 
			"        UUID() as id,\n" + 
			"        COUNT(m_institute.institute_id) AS count1\n" + 
			"     " + 
			"    FROM\n" + 
			"        m_institute" + 
			"    WHERE\n" + 
			"        m_institute.del_status = 1" + 
			"        AND m_institute.is_active = 1", nativeQuery = true)
	GetCountsForDash getInstCountUsingRusaSw();

/**************Mahendra 01/08/2019*********************/		
	@Query(value="SELECT  UUID() as id, COUNT(institute_id) AS count1 " + 
			"FROM `m_institute` " + 
			"WHERE is_active=1 AND" + 
			"	   del_status=1 AND" + 
			"      ex_int2=1",nativeQuery=true)
	GetCountsForDash getRegInstCount();

	@Query(value="SELECT  UUID() as id, COUNT(institute_id) AS count1 " + 
			"FROM `m_institute` " + 
			"WHERE is_active=1 AND" + 
			"	   del_status=1 AND" + 
			"      ex_var2=1",nativeQuery=true)
	GetCountsForDash getAutonomousInstCount();

}
