package com.retail.login;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class LoginBean implements Serializable {
	
	private String userName = "mani"; 
	private String password = "mani";
	private String companyCode = "Navaladiyar";
	
	protected HashMap<String,String> companies = new HashMap<String, String>();
	
	{
		companies.put("Navaladiyar", "Navaladiyar");
		companies.put("Vinayaga", "Vinayaga");
		companies.put("KSR Agro", "KSR Agro");
		companies.put("Shanti Agro", "Shanti Agro");
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyCode() {
		return companyCode;
	}
	
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	public Map<String,String> getCompanies() {
		return companies;
	}

	public void setCompanies(HashMap<String, String> companies) {
		this.companies = companies;
	}
}