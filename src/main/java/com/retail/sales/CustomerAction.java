package com.retail.sales;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.retail.RMRESTClient;

@SuppressWarnings("serial")
public class CustomerAction implements Serializable {
	
	public CustomerBean customerBean = new CustomerBean();

	public CustomerAction() {
		customerBean = new CustomerBean();
	}

    public CustomerBean getCustomerBean() {
		return customerBean;
	}

	public void setCustomerBean(CustomerBean customerBean) {
		this.customerBean = customerBean;
	}

	public String createCustomer() {
		RMRESTClient rmrestClient = new RMRESTClient("http://localhost/RetailMasterSvc");
		String responseBody = rmrestClient.executeInsert("/RetailMasterDMLService/createCustomer", customerBean.getCustomer());
		if (responseBody != null && responseBody.trim().equals("success")) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Customer created successfully."));
    		return "createcustomer.xhtml";
		} else {
    		return "commonSalesView.xhtml";
		}
    }
}
