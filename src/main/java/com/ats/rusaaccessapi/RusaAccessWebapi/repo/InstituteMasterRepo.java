package com.ats.rusaaccessapi.RusaAccessWebapi.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.InstituteMaster;


public interface InstituteMasterRepo extends JpaRepository<InstituteMaster, Integer> {
	
	InstituteMaster findByAisheCode(String aisheCode);
	
	@Transactional
	@Modifying
	@Query(value = " DELETE FROM  mh_institute_master WHERE mh_inst_id=:mhInstId ", nativeQuery = true)
	int deleteMhInstMaster(@Param("mhInstId") int mhInstId);

}
