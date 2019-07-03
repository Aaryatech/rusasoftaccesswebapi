package com.ats.rusaaccessapi.RusaAccessWebapi.repo.dashb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.dashb.QualityIniCountsForGraph;

public interface QualityIniCountsForGraphRepo extends JpaRepository<QualityIniCountsForGraph, String> {

	@Query(value = "SELECT  m_academic_year.academic_year, UUID() AS year_id,  COALESCE( "
			+ " ( SELECT  COUNT(m_institute.institute_id)  FROM "
			+ " m_institute  WHERE "
			+ " m_institute.del_status = 1 AND m_institute.is_active = 1 AND m_institute.ex_int1 = m_academic_year.year_id "
			+ "    ), 0) AS count1,  COALESCE(  (SELECT "
			+ " COUNT(t_institute_quality.quality_id) FROM "
			+ " t_institute_quality,m_quality_initiatives  WHERE "
			+ " m_quality_initiatives.quality_initiative_id = t_institute_quality.quality_initiative_id AND "
			+ " t_institute_quality.year_id = m_academic_year.year_id AND t_institute_quality.del_status = 1 "
			+ "AND t_institute_quality.is_active = 1 AND t_institute_quality.is_certi_obt = 1 AND "
			+ "m_quality_initiatives.quality_initiative_id =:qualId "
			+ "    ),     0 ) AS count2, 0 as count3 FROM   m_academic_year "
			+ "WHERE  m_academic_year.year_id IN(:lastFiveYears) GROUP BY "
			+ "    m_academic_year.year_id", nativeQuery = true)
	List<QualityIniCountsForGraph> getGraphForNaac(@Param("qualId") int qualId,
			@Param("lastFiveYears") List<Integer> lastFiveYears);

	@Query(value = "SELECT m_academic_year.academic_year, UUID() AS year_id,  COALESCE("
			+ " (  SELECT COUNT(m_institute.institute_id)  FROM "
			+ " m_institute WHERE "
			+ " m_institute.del_status = 1 AND m_institute.is_active = 1 AND m_institute.ex_int1 = m_academic_year.year_id "
			+ "    ),0) AS count1, COALESCE( (  SELECT"
			+ " COUNT(t_institute_quality.quality_id)" + " FROM"
			+ " t_institute_quality," + " m_quality_initiatives" + " WHERE"
			+ " m_quality_initiatives.quality_initiative_id = t_institute_quality.quality_initiative_id AND t_institute_quality.year_id = m_academic_year.year_id AND t_institute_quality.del_status = 1 AND t_institute_quality.is_active = 1 AND t_institute_quality.is_certi_obt = 1 AND m_quality_initiatives.quality_initiative_id =:qualId "
			+ "    ), 0 ) AS count2,  COALESCE((SELECT "
			+ " COUNT(t_institute_quality.quality_id) FROM "
			+ " t_institute_quality, m_quality_initiatives WHERE "
			+ " m_quality_initiatives.quality_initiative_id = t_institute_quality.quality_initiative_id AND t_institute_quality.year_id = m_academic_year.year_id AND t_institute_quality.del_status = 1 AND t_institute_quality.is_active = 1 AND t_institute_quality.is_applicable = 1 AND m_quality_initiatives.quality_initiative_id =:qualId "
			+ "    ),  0 ), 0 AS count3 FROM  m_academic_year WHERE "
			+ "    m_academic_year.year_id IN(:lastFiveYears)" + "GROUP BY"
			+ "    m_academic_year.year_id", nativeQuery = true)
	List<QualityIniCountsForGraph> getGraphForNba(@Param("qualId") int qualId,
			@Param("lastFiveYears") List<Integer> lastFiveYears);

	@Query(value = "SELECT  m_academic_year.academic_year,  UUID() AS year_id," + "    COALESCE("
			+ " ( SELECT  COUNT(m_institute.institute_id)  FROM "
			+ " m_institute  WHERE"
			+ " m_institute.del_status = 1 AND m_institute.is_active = 1 AND m_institute.ex_int1 = m_academic_year.year_id"
			+ "    ),   0 ) AS count1, COALESCE( ( SELECT"
			+ " COUNT(t_institute_quality.quality_id) FROM "
			+ " t_institute_quality, m_quality_initiatives WHERE "
			+ " m_quality_initiatives.quality_initiative_id = t_institute_quality.quality_initiative_id AND t_institute_quality.year_id = m_academic_year.year_id AND t_institute_quality.del_status = 1 AND t_institute_quality.is_active = 1 AND t_institute_quality.is_certi_obt = 1 AND m_quality_initiatives.quality_initiative_id =:qualId "
			+ "    ),   0" + "   ) AS count2,0 as count3  FROM  m_academic_year "
			+ " WHERE   m_academic_year.year_id IN(:lastFiveYears) GROUP BY"
			+ "    m_academic_year.year_id", nativeQuery = true)
	List<QualityIniCountsForGraph> getGraphForThe(@Param("qualId") int qualId,
			@Param("lastFiveYears") List<Integer> lastFiveYears);

	@Query(value = " SELECT  m_academic_year.academic_year, UUID() AS year_id,   COALESCE("
			+ " (  SELECT  COUNT(m_institute.institute_id)  FROM"
			+ " m_institute  WHERE "
			+ " m_institute.del_status = 1 AND m_institute.is_active = 1 AND m_institute.ex_int1 = m_academic_year.year_id"
			+ "    ),  0  ) AS count1,  COALESCE(  (  SELECT "
			+ " COUNT(t_institute_quality.quality_id)  FROM "
			+ " t_institute_quality,  m_quality_initiatives  WHERE "
			+ " m_quality_initiatives.quality_initiative_id = t_institute_quality.quality_initiative_id AND t_institute_quality.year_id = m_academic_year.year_id AND t_institute_quality.del_status = 1 AND t_institute_quality.is_active = 1 AND t_institute_quality.is_certi_obt = 1 AND m_quality_initiatives.quality_initiative_id =:qualId "
			+ "    ),  0  ) AS count2,0 as count3 FROM  m_academic_year "
			+ " WHERE  m_academic_year.year_id IN(:lastFiveYears) GROUP BY "
			+ "    m_academic_year.year_id ", nativeQuery = true)
	List<QualityIniCountsForGraph> getGraphForNirf(@Param("qualId") int qualId,
			@Param("lastFiveYears") List<Integer> lastFiveYears);

	@Query(value = "SELECT  m_academic_year.academic_year, UUID() AS year_id,  COALESCE("
			+ " (  SELECT  COUNT(m_institute.institute_id)  FROM "
			+ " m_institute  WHERE "
			+ " m_institute.del_status = 1 AND m_institute.is_active = 1 AND m_institute.ex_int1 = m_academic_year.year_id"
			+ "    ),    0 ) AS count1,   COALESCE( (  SELECT "
			+ " COUNT(m_institute.institute_id)  FROM "
			+ " m_institute,t_institute_info_detail  WHERE "
			+ " m_institute.del_status = 1 AND m_institute.is_active = 1 AND m_institute.ex_int1 = m_academic_year.year_id AND t_institute_info_detail.auton_status=1 AND m_institute.institute_id=t_institute_info_detail.institute_id AND m_academic_year.year_id = t_institute_info_detail.year_id "
			+ "    ), 0   ) as count2, 0 as count3 FROM  m_academic_year "
			+ "WHERE  m_academic_year.year_id IN(:lastFiveYears) GROUP BY"
			+ "    m_academic_year.year_id ", nativeQuery = true)
	List<QualityIniCountsForGraph> getGraphForAutonomous(@Param("lastFiveYears") List<Integer> lastFiveYears);

}
