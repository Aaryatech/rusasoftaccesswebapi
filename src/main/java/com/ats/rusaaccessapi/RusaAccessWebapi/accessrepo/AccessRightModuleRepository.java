package com.ats.rusaaccessapi.RusaAccessWebapi.accessrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.rusaaccessapi.RusaAccessWebapi.service.AccessRightModule;
 


public interface AccessRightModuleRepository extends JpaRepository<AccessRightModule, String> {

	// List<AccessRightModule> findByDelStatus(int delStatus);

	@Query(value = " SELECT * FROM m_module_rusa WHERE " + "del_status =0 ORDER BY order_by ASC;" + "", nativeQuery = true)
	List<AccessRightModule> getModule();
	/*
	 * List<AccessRightModule> findAllByDelStatus(int delStatus); OrderByLevelDesc()
	 */

}
