package com.ats.rusaaccessapi.RusaAccessWebapi.repo.reportnew;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.reportnew.AvgEnrollmentPrcnt;

  
 
public interface AvgEnrollmentPrcntRepo extends JpaRepository<AvgEnrollmentPrcnt, Integer>  {
	
	/*
	 * @Query(value=" SELECT\n" + "    m_academic_year.academic_year,\n" +
	 * "    m_academic_year.year_id,\n" + "    m_institute.institute_name,\n" +
	 * "    COALESCE(\n" + "        (\n" + "        SELECT\n" +
	 * "            SUM(t_program.sanctional_intake)\n" + "        FROM\n" +
	 * "            t_program\n" + "        WHERE\n" +
	 * "            t_program.del_status = 1 AND t_program.is_active = 1 AND t_program.institute_id = :instId AND t_program.year_id = m_academic_year.year_id\n"
	 * + "    ),\n" + "    0\n" + "    ) AS total_sanct_intake,\n" +
	 * "    COALESCE(\n" + "        (\n" + "        SELECT\n" +
	 * "            t_institute_info_detail.no_current_admited_stnt\n" +
	 * "        FROM\n" + "            t_institute_info_detail\n" +
	 * "        WHERE\n" +
	 * "            t_institute_info_detail.institute_id = :instId  AND t_institute_info_detail.year_id = m_academic_year.year_id\n"
	 * + "    ),\n" + "    0\n" + "    ) AS no_current_admited_stnt\n" + "FROM\n" +
	 * "    m_academic_year,m_institute\n" + "WHERE\n" +
	 * "    m_academic_year.year_id IN (:acYearList) AND m_institute.institute_id=:instId "
	 * ,nativeQuery=true)
	 * 
	 * List<AvgEnrollmentPrcnt> getAvgEnrollmentPrcnt(@Param("instId") int
	 * instId,@Param("acYearList") List<Integer> acYearList);
	 */
	

	@Query(value="SELECT m_academic_year.academic_year,  m_academic_year.year_id,  m_institute.institute_name,\n" + 
			" " + 
			"COALESCE(( SELECT SUM(t_prog_sanc_intake.sanc_intake) FROM t_prog_sanc_intake WHERE t_prog_sanc_intake.inst_id=m_institute.institute_id and t_prog_sanc_intake.ac_year_id=m_academic_year.year_id AND t_prog_sanc_intake.del_status=1),0)\n" + 
			" AS total_sanct_intake, " + 
			" " + 
			" COALESCE(( SELECT t_institute_info_detail.no_current_admited_stnt FROM t_institute_info_detail WHERE\n" + 
			"           t_institute_info_detail.institute_id=m_institute.institute_id AND t_institute_info_detail.year_id=m_academic_year.year_id AND t_institute_info_detail.del_status=1\n" + 
			"          ),0) AS no_current_admited_stnt\n" + 
			"          FROM m_institute,m_academic_year\n" + 
			"          WHERE m_institute.institute_id=:instId and m_academic_year.year_id in (:acYearList) \n" + 
			"          GROUP by m_academic_year.year_id",nativeQuery=true)

	List<AvgEnrollmentPrcnt> getAvgEnrollmentPrcnt(@Param("instId")   int instId,@Param("acYearList")   List<Integer> acYearList);

}
		/**********19/07/2019***********/

/*SELECT\n" + 
"        m_academic_year.academic_year,\n" + 
"        m_academic_year.year_id,\n" + 
"        m_institute.institute_name,\n" + 
"        COALESCE(         (         SELECT\n" + 
"            SUM(t_program.sanctional_intake)         \n" + 
"        FROM\n" + 
"            t_program         \n" + 
"        WHERE\n" + 
"            t_program.del_status = 1 \n" + 
"            AND t_program.is_active = 1 \n" + 
"            AND t_program.institute_id = m_institute.institute_id\n" + 
"               ),\n" + 
"        0     ) AS total_sanct_intake,\n" + 
"        COALESCE(         (         SELECT\n" + 
"            t_institute_info_detail.no_current_admited_stnt         \n" + 
"        FROM\n" + 
"            t_institute_info_detail         \n" + 
"        WHERE\n" + 
"            t_institute_info_detail.institute_id = m_institute.institute_id\n" + 
"            AND t_institute_info_detail.year_id = m_academic_year.year_id     ),\n" + 
"        0     ) AS no_current_admited_stnt \n" + 
"    FROM\n" + 
"        m_academic_year,\n" + 
"        m_institute \n" + 
"    WHERE\n" + 
"        m_academic_year.year_id IN (\n" + 
"           :acYearList \n" + 
"        ) \n" + 
"        AND m_institute.institute_id=:instId */
