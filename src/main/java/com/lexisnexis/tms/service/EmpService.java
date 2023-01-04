package com.lexisnexis.tms.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.lexisnexis.tms.entity.EmpEntity;
import com.lexisnexis.tms.entity.LoginTable;
import com.lexisnexis.tms.exception.UserAlreadyHasAccount;
import com.lexisnexis.tms.exception.UserNotFoundException;

public interface EmpService {

	public List<EmpEntity> fetchAllEmpDetail() throws UserNotFoundException;

	public EmpEntity getDataByUsername(String username) throws UserNotFoundException;

	public void deleteDataByUsername(String username) throws UserNotFoundException;

	public EmpEntity addUser(@RequestBody EmpEntity emp) throws UserAlreadyHasAccount, NoSuchAlgorithmException;

	public EmpEntity updateUser(@PathVariable String username,@RequestBody EmpEntity em) throws UserNotFoundException, NoSuchAlgorithmException;

	public String getCount();

  public LoginTable loginUser(@RequestBody EmpEntity emp) throws UserNotFoundException ;
}
