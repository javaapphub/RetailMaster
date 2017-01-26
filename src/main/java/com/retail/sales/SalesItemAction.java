package com.retail.sales;

import java.io.Serializable;
import java.util.List;

public class SalesItemAction implements Serializable {
	
	public SalesCompositeAction salesCompositeAction;
	
	public SalesItemBean salesItemBean = new SalesItemBean();
	
	private List<SalesItemBean> salesItemBeans;
	
	public SalesCompositeAction getSalesCompositeAction() { 
		return salesCompositeAction;
	}
	public void setSalesCompositeAction(SalesCompositeAction salesCompositeAction) {
		this.salesCompositeAction = salesCompositeAction;
	}
	public SalesItemBean getSalesItemBean() {
		return salesItemBean;
	}
	public void setSalesItemBean(SalesItemBean salesItemBean) {
		this.salesItemBean = salesItemBean;
	}
	public List<SalesItemBean> getSalesItemBeans() {
		return salesItemBeans;
	}
	public void setSalesItemBeans(List<SalesItemBean> salesItemBeans) {
		this.salesItemBeans = salesItemBeans;
	}
	
	

}
