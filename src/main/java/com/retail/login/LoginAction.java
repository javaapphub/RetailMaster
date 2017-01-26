package com.retail.login;

import java.io.Serializable;
import java.net.URLEncoder;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.retail.RMRESTClient;

public class LoginAction implements Serializable {
	
	private LoginBean loginBean;
	private PersonBean personBean;
	
	public PersonBean getPersonBean() {
		return personBean;
	}

	public void setPersonBean(PersonBean personBean) {
		this.personBean = personBean;
	}

	public LoginAction() {
		loginBean = new LoginBean();
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
    public String doLogin() {
		RMRESTClient rmrestClient = new RMRESTClient("http://localhost/RetailMasterSvc");
		String responseBody = rmrestClient.executeGet("/RetailMasterQueryService/authenticate?input=" + URLEncoder.encode("<queryinput><key>rm.user.authenticate</key><params><param name=\"login_name\" type=\"I\" dataType=\"VARCHAR\" value=\"" + loginBean.getUserName() + "\"/><param name=\"password\" type=\"I\" dataType=\"VARCHAR\" value=\"" + loginBean.getPassword() + "\"/></params></queryinput>"));
		if (responseBody == null || responseBody.trim().equals("[]")) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Invalid Username or Password"));
    		return "login.xhtml";
		} else {
    		return "commonSalesView.xhtml";
		}
    }
    
    public String doLogout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }
}
