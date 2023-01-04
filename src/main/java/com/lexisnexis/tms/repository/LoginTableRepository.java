package com.lexisnexis.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lexisnexis.tms.entity.LoginTable;

public interface LoginTableRepository extends JpaRepository<LoginTable, Integer>
{
   // List<LoginTable> findByuserName(String userName);
    LoginTable findByUserName(String userName);
}
