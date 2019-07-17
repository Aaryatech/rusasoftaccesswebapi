package com.ats.rusaaccessapi.RusaAccessWebapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
 
import com.ats.rusaaccessapi.RusaAccessWebapi.model.GetChangePrincipalDetails;
 
public interface GetChangePrincipalDetailsRepo extends JpaRepository<GetChangePrincipalDetails, Integer> {

	@Query(value = "SELECT\n" + 
			"    m_faculty.faculty_id,\n" + 
			"    m_faculty.institute_id,\n" + 
			"    m_faculty.faculty_first_name,\n" + 
			"    m_faculty.faculty_last_name,\n" + 
			"    m_faculty.contact_no,\n" + 
			"    m_faculty.email,\n" + 
			"     m_institute.institute_name\n" + 
			"FROM\n" + 
			"    m_institute,\n" + 
			"    m_faculty\n" + 
			"WHERE\n" + 
			"    m_faculty.\n" + 
			"    institute_id = m_institute.institute_id  AND m_faculty.del_status = 0 AND m_faculty.is_active = 0 AND m_faculty.is_principal = 1 AND m_faculty.is_enrolled = 0 AND is_blocked = 0", nativeQuery = true)
	List<GetChangePrincipalDetails> getChangePrinciRequest( );
	
}
