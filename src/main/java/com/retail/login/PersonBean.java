package com.retail.login;

import java.io.Serializable;
import java.util.Date;

public class PersonBean implements Serializable {
	
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private int mobile;
    private int landLine;
    private String image="images/mani.png";
    private String address;
    
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public int getLandLine() {
		return landLine;
	}
	public void setLandLine(int landLine) {
		this.landLine = landLine;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
}
