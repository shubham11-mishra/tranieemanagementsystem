package com.lexisnexis.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.invoker.HttpServiceArgumentResolver;

import com.lexisnexis.tms.entity.EmpEntity;
import com.lexisnexis.tms.exceptions.UserDoesNotExistException;
import com.lexisnexis.tms.service.EmpService;

@RestController
public class EmpController {
	
	@Autowired
	EmpService empservice;
	
	@GetMapping("/	")
	public ResponseEntity<List<EmpEntity>>  fetchAllEmpDetail(){
		return new ResponseEntity<>(this.empservice.fetchAllEmpDetail(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getDataByUsername/{username}")
	public EmpEntity getData(@PathVariable String username) {
		return empservice.getDataByUsername(username);
	}
	
	@DeleteMapping("/deleteDataByUsername/{username}")
	public String deleteDataByUsername(@PathVariable String username)
	{
	empservice.deleteDataByUsername(username);	
		return "User removed successfully "+username;
	}
	
	
	
}
