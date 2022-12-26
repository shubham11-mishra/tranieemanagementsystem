package com.lexisnexis.tms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lexisnexis.tms.entity.EmpEntity;
import com.lexisnexis.tms.repository.EmpRepo;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired 
	EmpRepo emprepo;

	@Override
	public List<EmpEntity> fetchAllEmpDetail() {	
		return  (List<EmpEntity>)emprepo.findAll();
	}

	@Override
	public EmpEntity getDataByUsername(String username) {	
		return emprepo.findByUsername(username); 
	}

	@Override
	public void deleteDataByUsername(String username) {
		emprepo.deleteById(username);
	}

	
}
