package com.ats.rusaaccessapi.RusaAccessWebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.Cast;

public interface CastRepo extends JpaRepository<Cast, Integer>{
	
	
	List<Cast> findByDelStatusAndIsActiveOrderByCastIdDesc(int delStatus, int isActive);
	
	Cast findByDelStatusAndIsActiveAndCastId(int delStatus, int isActive, int castId);	

}
