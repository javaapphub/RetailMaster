package com.retail.sales;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SalesHeadAction implements Serializable {
	
	private SalesHeadBean salesHeadBean = new SalesHeadBean();
	
	public SalesCompositeAction salesCompositeAction;
	
	private String customer;

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	public SalesHeadAction() {
		System.out.println("SalesHeadAction.SalesHeadAction()");
	}
	
	
	public SalesHeadBean getSalesHeadBean() {
		return salesHeadBean;
	}
	public void setSalesHeadBean(SalesHeadBean salesHeadBean) {
		this.salesHeadBean = salesHeadBean;
	}
	public SalesCompositeAction getSalesCompositeAction() {
		return salesCompositeAction;
	}
	public void setSalesCompositeAction(SalesCompositeAction salesCompositeAction) {
		this.salesCompositeAction = salesCompositeAction;
	}

    public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();
        for(int i = 0; i < 10; i++) {
            results.add(query + i);
        }
         
        return results;
    }

}
