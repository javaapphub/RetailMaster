package com.retail.sales;

import java.io.Serializable;

import com.massmani.retailmaster.model.Address;
import com.massmani.retailmaster.model.Area;
import com.massmani.retailmaster.model.City;
import com.massmani.retailmaster.model.Customer;

@SuppressWarnings("serial")
public class CustomerBean implements Serializable {

	public String firstName;
	public String lastName;
	public String fatherName;
	
	public String street;
	
	public String place;
	public String post;
	public String taluk;
	public String area;
	public String city;
	public String district;

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

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Customer getCustomer() {
		Customer customer = new Customer();
		customer.setFirst_name(firstName);
		customer.setLast_name(lastName);
		customer.setFather_name(fatherName);
		Address address = new Address();
		Area area2 = new Area();
		area2.setName(area);
		address.setArea(area2);
		City city2 = new City();
		city2.setName(city);
		address.setCity(city2);
		address.setDistrict(district);
		address.setStreet(street);
		address.setPlace(place);
		address.setPost(post);
		address.setTaluk(taluk);
		customer.setAddress(address);
		return customer;
	}
}