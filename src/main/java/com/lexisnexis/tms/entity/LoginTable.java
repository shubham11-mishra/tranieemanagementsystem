package com.lexisnexis.tms.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loginTable")
public class LoginTable {
	
	@Id    
	@Column(name="id")
	private int id;
	
    @Column(name="userName")
    private String userName;
    
    @Column(name="sessionExpired")
    private boolean sessionExpired;

    @Column(name="status")
    private Boolean status;

    @Column(name="loginAt")
    private LocalDateTime loginAt;
    
    @Column(name="lastUpdatedTime")
    private LocalDateTime lastUpdatedTime;

    @Column(name="count")
    private int count;
}
