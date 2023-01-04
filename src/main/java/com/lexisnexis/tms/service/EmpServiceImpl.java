package com.lexisnexis.tms.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.lexisnexis.tms.encrypt.PasswEncrypt;
import com.lexisnexis.tms.entity.EmpEntity;
import com.lexisnexis.tms.entity.LoginTable;
import com.lexisnexis.tms.exception.UserAlreadyHasAccount;
import com.lexisnexis.tms.exception.UserNotFoundException;
import com.lexisnexis.tms.repository.EmpRepo;
import com.lexisnexis.tms.repository.LoginRepo;

@Service
public class EmpServiceImpl implements EmpService {

	int countFetchAllEmpDetailSuccess=0;
	int countFetchAllEmpDetailFailed=0;

	@Autowired
	LoginTable logintable;

	@Autowired
	LoginRepo  loginrepo;

	@Autowired 
	EmpRepo emprepo;

	@Autowired
	PasswEncrypt PasswEncrypt;

	@Override
	public List<EmpEntity> fetchAllEmpDetail() throws UserNotFoundException {
		long count=emprepo.count();		
		if(count!=0) {
			countFetchAllEmpDetailSuccess++;
			return  (List<EmpEntity>)emprepo.findAll();
		}else {
			countFetchAllEmpDetailFailed++;
			throw new UserNotFoundException("We Dont Have Any employee yet");
		}
	}

	@Override
	public EmpEntity getDataByUsername(String username) throws UserNotFoundException {	
		EmpEntity emp=emprepo.findByUserName(username); 

		if(emp!=null) {
			return emp;
		}else {
			throw new UserNotFoundException("Usrname name does not Exist"+" "+username);
		}
	}

	@Override
	public void deleteDataByUsername(String username) throws UserNotFoundException {
		EmpEntity emp=emprepo.findByUserName(username); 
		LoginTable login=loginrepo.findByUserName(username);
		
		if(emp!=null) {
			emprepo.deleteById(username);
		} 
		else {
			throw new UserNotFoundException("Username name does not Exist"+" "+username);
		}
	}

	@Override
	public EmpEntity addUser(EmpEntity emp) throws UserAlreadyHasAccount, NoSuchAlgorithmException {

		EmpEntity emp1=emprepo.findByUserName(emp.getUserName());
		if(emp1!=null) {
			throw new UserAlreadyHasAccount("Employee Already have Account with This Username"+" "+emp1.getUserName());
		}else {
			emp.setPassword(PasswEncrypt.encryptPass(emp.getPassword()));
			return emprepo.save(emp);
		}
	}

	@Override
	public EmpEntity updateUser(@PathVariable String username,@RequestBody EmpEntity em) throws UserNotFoundException, NoSuchAlgorithmException{
		EmpEntity emp=emprepo.findByUserName(username);

		if(emp!=null) {
			em.setPassword(PasswEncrypt.encryptPass(em.getPassword()));
			return	emprepo.save(em);
		}
		else
		{
			throw new UserNotFoundException("Usrname name does not Exist"+" "+username+" "+"So yoou can't Update.");
		}	
	}

	@Override
	public String getCount() {
		return "Get All method is called"+ countFetchAllEmpDetailSuccess 	+"times";
	}


	@Override
	public LoginTable loginUser(@RequestBody EmpEntity emp) throws UserNotFoundException {
		EmpEntity user=emprepo.findByUserName(emp.getUserName());
		if(user!=null) {
			if(user.getUserName().equalsIgnoreCase(emp.getUserName()) && user.getPassword().equalsIgnoreCase(emp.getPassword())) {
				logintable.setUserName(user.getUserName());
				logintable.setCount(0);
				logintable.setStatus(true);
				logintable.setLoginAt(logintable.getLoginAt());
				logintable.onSave();
				return loginrepo.save(logintable);
			}
			else
			{
				throw new UserNotFoundException("Invalid Password");
			}	
		}
		else
		{
			throw new UserNotFoundException("Invalid Password");
		}	
	}
}
