package com.lexisnexis.tms.entity;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "loginTable")
public class LoginTable {
	
	@Id
    @Column(name="userName")
    private String userName;
    
    @Column(name="sessionExpired")
    private LocalDateTime sessionExpired;

    @Column(name="status")
    private boolean status;

    @Column(name="loginAt")
    private LocalDateTime loginAt;
    
    @Column(name="lastUpdatedTime")
    private LocalDateTime lastUpdatedTime;

    @Column(name="count")
    private int count;


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getSessionExpired() {
		return sessionExpired;
	}

	public void setSessionExpired(LocalDateTime sessionExpired) {
		this.sessionExpired = sessionExpired;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public LocalDateTime getLoginAt() {
		return loginAt;
	}

	public void setLoginAt(LocalDateTime loginAt) {
		this.loginAt = loginAt;
	}

	public LocalDateTime getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}   
	
	@PrePersist
	public void onSave() {
		LocalDateTime currdatetime = LocalDateTime.now();
		 this.loginAt = currdatetime;
		 this.lastUpdatedTime=currdatetime;
	}
}
