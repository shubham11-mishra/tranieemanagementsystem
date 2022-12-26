package com.lexisnexis.tms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lexisnexis.tms.entity.EmpEntity;

@Repository
public interface EmpRepo extends CrudRepository<EmpEntity, String> {
	
	public EmpEntity findByUsername(String username);
	
	public EmpEntity deleteByUsername(String username);
	
}
