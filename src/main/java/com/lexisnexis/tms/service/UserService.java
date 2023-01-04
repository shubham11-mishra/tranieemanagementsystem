package com.lexisnexis.tms.service;

import java.security.NoSuchAlgorithmException;

import com.lexisnexis.tms.entity.User;
import com.lexisnexis.tms.entity.WorkHistory;

public interface UserService {

    String registerNewUser(User user) throws NoSuchAlgorithmException;

    WorkHistory updateWorkHistory(WorkHistory workHistory);
}
