package com.retail.sales;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class SalesCompositeAction implements Serializable{
	
	private SalesHeadAction salesHeadAction =new SalesHeadAction();
	private SalesItemAction salesItemAction = new SalesItemAction();
	
	@PostConstruct
	public void init() {
		salesHeadAction.setSalesCompositeAction(this);
		salesItemAction.setSalesCompositeAction(this);
	}

	public SalesHeadAction getSalesHeadAction() {
		return salesHeadAction;
	}

	public void setSalesHeadAction(SalesHeadAction salesHeadAction) {
		this.salesHeadAction = salesHeadAction;
	}

	public SalesItemAction getSalesItemAction() {
		return salesItemAction;
	}

	public void setSalesItemAction(SalesItemAction salesItemAction) {
		this.salesItemAction = salesItemAction;
	}

}
