package com.retail.common;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class IncludeAction implements Serializable {
	
	public String validateSession() {
		FacesContext context = FacesContext.getCurrentInstance();
		Object session = context.getExternalContext().getSession(true);
		return "";
	}
	
}
