package com.retail.login;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ManagedBean
@SessionScoped
public class LoginCompositeAction implements Serializable {
	
	private LoginAction loginAction = new LoginAction();

	public LoginAction getLoginAction() {
		return loginAction;
	}

	public void setLoginAction(LoginAction loginAction) {
		this.loginAction = loginAction;
	}

}
