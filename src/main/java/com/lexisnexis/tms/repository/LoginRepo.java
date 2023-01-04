package com.lexisnexis.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lexisnexis.tms.entity.LoginTable;

@Repository
public interface LoginRepo extends JpaRepository<LoginTable, String> {

	public LoginTable findByUserName(String username);

}
