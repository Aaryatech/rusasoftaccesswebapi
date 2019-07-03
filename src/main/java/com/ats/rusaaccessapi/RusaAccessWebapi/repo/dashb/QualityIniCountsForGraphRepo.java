package com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.QualityIniCountsForGraph;
 
public interface QualityIniCountsForGraphRepo extends JpaRepository<QualityIniCountsForGraph, Integer>{

	

	@Query(value="SELECT\n" + 
			"    m_academic_year.academic_year, m_academic_year.year_id,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            COUNT(m_institute.institute_id)\n" + 
			"        FROM\n" + 
			"            m_institute\n" + 
			"        WHERE\n" + 
			"            m_institute.del_status = 1 AND m_institute.is_active = 1 AND m_institute.ex_int1 = m_academic_year.year_id\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS count1,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            COUNT(t_institute_quality.quality_id)\n" + 
			"        FROM\n" + 
			"            t_institute_quality,\n" + 
			"            m_quality_initiatives\n" + 
			"        WHERE\n" + 
			"            m_quality_initiatives.quality_initiative_id = t_institute_quality.quality_initiative_id AND t_institute_quality.year_id = m_academic_year.year_id AND t_institute_quality.del_status = 1 AND t_institute_quality.is_active = 1 AND t_institute_quality.is_certi_obt = 1 AND m_quality_initiatives.quality_initiative_id =:qualId \n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS count2, 0 as count3\n" + 
			"FROM\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    m_academic_year.year_id IN(:lastFiveYears)\n" + 
			"GROUP BY\n" + 
			"    m_academic_year.year_id",nativeQuery=true)
	List<QualityIniCountsForGraph> getGraphForNaac(@Param("qualId")int qualId,@Param("lastFiveYears") List<Integer> lastFiveYears);
	
	
	

	@Query(value="SELECT\n" + 
			"    m_academic_year.academic_year, m_academic_year.year_id,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            COUNT(m_institute.institute_id)\n" + 
			"        FROM\n" + 
			"            m_institute\n" + 
			"        WHERE\n" + 
			"            m_institute.del_status = 1 AND m_institute.is_active = 1 AND m_institute.ex_int1 = m_academic_year.year_id\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS count1,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            COUNT(t_institute_quality.quality_id)\n" + 
			"        FROM\n" + 
			"            t_institute_quality,\n" + 
			"            m_quality_initiatives\n" + 
			"        WHERE\n" + 
			"            m_quality_initiatives.quality_initiative_id = t_institute_quality.quality_initiative_id AND t_institute_quality.year_id = m_academic_year.year_id AND t_institute_quality.del_status = 1 AND t_institute_quality.is_active = 1 AND t_institute_quality.is_certi_obt = 1 AND m_quality_initiatives.quality_initiative_id =:qualId \n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS count2,  COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            COUNT(t_institute_quality.quality_id)\n" + 
			"        FROM\n" + 
			"            t_institute_quality,\n" + 
			"            m_quality_initiatives\n" + 
			"        WHERE\n" + 
			"            m_quality_initiatives.quality_initiative_id = t_institute_quality.quality_initiative_id AND t_institute_quality.year_id = m_academic_year.year_id AND t_institute_quality.del_status = 1 AND t_institute_quality.is_active = 1 AND t_institute_quality.is_applicable = 1 AND m_quality_initiatives.quality_initiative_id =:qualId \n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS count3\n" + 
			"FROM\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    m_academic_year.year_id IN(:lastFiveYears)\n" + 
			"GROUP BY\n" + 
			"    m_academic_year.year_id",nativeQuery=true)
	List<QualityIniCountsForGraph> getGraphForNba(@Param("qualId")int qualId,@Param("lastFiveYears") List<Integer> lastFiveYears);
	
	
	
	@Query(value="SELECT\n" + 
			"    m_academic_year.academic_year, m_academic_year.year_id,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            COUNT(m_institute.institute_id)\n" + 
			"        FROM\n" + 
			"            m_institute\n" + 
			"        WHERE\n" + 
			"            m_institute.del_status = 1 AND m_institute.is_active = 1 AND m_institute.ex_int1 = m_academic_year.year_id\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS count1,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            COUNT(t_institute_quality.quality_id)\n" + 
			"        FROM\n" + 
			"            t_institute_quality,\n" + 
			"            m_quality_initiatives\n" + 
			"        WHERE\n" + 
			"            m_quality_initiatives.quality_initiative_id = t_institute_quality.quality_initiative_id AND t_institute_quality.year_id = m_academic_year.year_id AND t_institute_quality.del_status = 1 AND t_institute_quality.is_active = 1 AND t_institute_quality.is_certi_obt = 1 AND m_quality_initiatives.quality_initiative_id =:qualId \n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS count2, 0 AS count3\n" + 
			"FROM\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    m_academic_year.year_id IN(:lastFiveYears)\n" + 
			"GROUP BY\n" + 
			"    m_academic_year.year_id",nativeQuery=true)
	List<QualityIniCountsForGraph> getGraphForThe(@Param("qualId")int qualId,@Param("lastFiveYears") List<Integer> lastFiveYears);
	
	@Query(value="SELECT\n" + 
			"    m_academic_year.academic_year, m_academic_year.year_id,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            COUNT(m_institute.institute_id)\n" + 
			"        FROM\n" + 
			"            m_institute\n" + 
			"        WHERE\n" + 
			"            m_institute.del_status = 1 AND m_institute.is_active = 1 AND m_institute.ex_int1 = m_academic_year.year_id\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS count1,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            COUNT(t_institute_quality.quality_id)\n" + 
			"        FROM\n" + 
			"            t_institute_quality,\n" + 
			"            m_quality_initiatives\n" + 
			"        WHERE\n" + 
			"            m_quality_initiatives.quality_initiative_id = t_institute_quality.quality_initiative_id AND t_institute_quality.year_id = m_academic_year.year_id AND t_institute_quality.del_status = 1 AND t_institute_quality.is_active = 1 AND t_institute_quality.is_certi_obt = 1 AND m_quality_initiatives.quality_initiative_id =:qualId \n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS count2, 0 AS count3\n" + 
			"FROM\n" + 
			"    m_academic_year\n" + 
			"WHERE\n" + 
			"    m_academic_year.year_id IN(:lastFiveYears)\n" + 
			"GROUP BY\n" + 
			"    m_academic_year.year_id ",nativeQuery=true)
	List<QualityIniCountsForGraph> getGraphForNirf(@Param("qualId")int qualId,@Param("lastFiveYears") List<Integer> lastFiveYears);
	
	
	
	
	
	
	
}
