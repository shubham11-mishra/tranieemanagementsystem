package com.lexisnexis.tms.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

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

//        @OneToOne(cascade = CascadeType.ALL, mappedBy = "workHistory")
//        private WorkHistory workHistory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isSessionExpired() {
        return sessionExpired;
    }

    public void setSessionExpired(boolean sessionExpired) {
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

//    public WorkHistory getWorkHistory() {
//        return workHistory;
//    }
//
//    public void setWorkHistory(WorkHistory workHistory) {
//        this.workHistory = workHistory;
//    }
}

