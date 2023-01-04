package com.lexisnexis.tms.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Component
@Entity
@Table(name="user")
public class EmpEntity {

	@Id
    @Column(name = "userName")
	@NotBlank(message = "username should not be null")
    private String userName;
	
	
    @Column(name = "firstName")
    @NotBlank(message = "firstname should not be null")
    private String firstName;
   
	
    @Column(name = "lastName")
    @NotBlank(message = "lastname should not be null")
    private String lastName;
	
	
    @Column(name = "mobileNo")
    @NotBlank(message = "mobile should not be null")
    private String mobileNo;
    
	
    @Column(name = "email")
    @Email(message = "invalid Email")
    private String email;
   
	
    @Column(name = "location")
    @NotBlank(message = "location should not be null")
    private String location;
   
	
    @Column(name = "password")
   // @NotBlank(message = "password should not be null")
   // @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
   @NotBlank
    private String password;
   
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	    
}
