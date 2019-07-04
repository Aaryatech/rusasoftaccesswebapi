package com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.PlacementUgPgStud;
 
public interface PlacementUgPgStudRepo extends JpaRepository<PlacementUgPgStud, Integer>{

	
	
	@Query(value = "SELECT\n" + 
			"    m_institute.institute_name,\n" + 
			"    t_traning_placement.institute_id,\n" + 
			"    t_traning_placement.pakage_offerd AS min_pck,\n" + 
			"    t_traning_placement.ex_var1 AS max_pck,\n" + 
			"    SUM(\n" + 
			"        t_traning_placement.no_student_placed\n" + 
			"    ) AS stud_placed\n" + 
			"FROM\n" + 
			"    m_institute,\n" + 
			"    m_academic_year,\n" + 
			"    t_traning_placement,\n" + 
			"    m_program_type\n" + 
			"WHERE\n" + 
			"    t_traning_placement.institute_id = m_institute.institute_id AND t_traning_placement.year_id = m_academic_year.year_id AND t_traning_placement.program_type = m_program_type.program_id AND m_program_type.program_id IN(:proType) AND t_traning_placement.del_status = 1 AND t_traning_placement.is_active = 1\n" + 
			"GROUP BY\n" + 
			"    m_institute.institute_id", nativeQuery = true)
	List<PlacementUgPgStud> getUgpgRep(@Param("proType") List<Integer> proType);
			
	
}
