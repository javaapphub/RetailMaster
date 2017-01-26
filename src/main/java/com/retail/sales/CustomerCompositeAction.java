package com.retail.sales;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class CustomerCompositeAction implements Serializable {
	
	private CustomerAction customerAction = new CustomerAction();

	public CustomerAction getCustomerAction() {
		return customerAction;
	}

	public void setCustomerAction(CustomerAction customerAction) {
		this.customerAction = customerAction;
	}

}
