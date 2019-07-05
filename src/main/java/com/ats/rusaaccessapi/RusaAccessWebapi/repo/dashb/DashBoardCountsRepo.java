package com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.GetCountsForDash;

public interface DashBoardCountsRepo extends JpaRepository<GetCountsForDash, Integer> {

	@Query(value = "SELECT\n" + 
			"        UUID() as id,\n" + 
			"        COUNT(m_institute.institute_id) AS count1\n" + 
			"      \n" + 
			"    FROM\n" + 
			"        m_institute \n" + 
			"    WHERE\n" + 
			"        m_institute.del_status = 1 \n" + 
			"        AND m_institute.is_active = 1", nativeQuery = true)
	GetCountsForDash getInstCountUsingRusaSw();

}
