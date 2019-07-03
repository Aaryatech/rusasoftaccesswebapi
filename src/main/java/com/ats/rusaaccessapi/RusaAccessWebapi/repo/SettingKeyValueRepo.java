package com.ats.rusaaccessapi.RusaAccessWebapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.SettingKeyValue;


  
public interface SettingKeyValueRepo extends JpaRepository<SettingKeyValue, Integer>  {

	SettingKeyValue findBySettingKeyAndDelStatus(String string, int i);
	
	
	

}
