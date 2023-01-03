package com.lexisnexis.tms.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "WORK_HISTORY")
public class WorkHistory {

    @Id
    @Column(name = "userName")
    private String userName;
    @Column(name = "workingArea")
    private String workingArea;
    @Column(name = "comments")
    private String comments;
    @Column(name="loginAt")
    private LocalDateTime loginAt;
    @Column(name="lastUpdatedTime")
    private LocalDateTime lastUpdatedTime;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_Name")
//    private LoginTable loginTable;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWorkingArea() {
        return workingArea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
}
