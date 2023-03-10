package com.lexisnexis.tms.service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.lexisnexis.tms.entity.LoginTable;
import com.lexisnexis.tms.entity.User;
import com.lexisnexis.tms.entity.WorkHistory;
import com.lexisnexis.tms.exception.BlogAPIException;
import com.lexisnexis.tms.repository.LoginTableRepository;
import com.lexisnexis.tms.repository.UserRepository;
import com.lexisnexis.tms.repository.WorkHistoryRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	WorkHistoryRepository workHistoryRepository;

	@Autowired
	LoginTableRepository loginTableRepository;

	@Override
	public String registerNewUser(User user) throws NoSuchAlgorithmException {

		// add check for username exists in database
		if (userRepository.existsByUserName(user.getUserName())) {
			throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
		} else {
			userRepository.save(user);
		}
		return "User registered successfully!.";
	}

	public WorkHistory updateWorkHistory(WorkHistory workHistory) {

		LoginTable loginTable1 = loginTableRepository.findByUserName(workHistory.getUserName());
		LocalDateTime loginAt = loginTable1.getLoginAt();
		LocalDateTime lastUpdate = loginTable1.getLastUpdatedTime();

		workHistory.setLoginAt(loginAt);
		workHistory.setLastUpdatedTime(lastUpdate);
		WorkHistory work = workHistoryRepository.save(workHistory);
		return work;
	}
}
