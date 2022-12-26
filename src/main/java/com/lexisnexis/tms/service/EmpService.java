package com.lexisnexis.tms.service;

import java.util.List;

import com.lexisnexis.tms.entity.EmpEntity;

public interface EmpService {

	public List<EmpEntity> fetchAllEmpDetail();
	
	public EmpEntity getDataByUsername(String username);
	
	public void deleteDataByUsername(String username);
	
	
	
}
