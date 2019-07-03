package com.ats.rusaaccessapi.RusaAccessWebapi.accessrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.Principal;


public interface PrincipalRepo extends JpaRepository<Principal, Integer> {
	
	Principal findByInstituteId(int instId);
	

}
