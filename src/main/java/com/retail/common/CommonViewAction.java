package com.retail.common;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;

import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
public class CommonViewAction implements Serializable {

	private List<CommonViewBean> commonViewBeans;
	
	private CommonViewBean selectedCommonViewBean;

	private CommonViewBeanHeader commonViewBeanHeader;

	private boolean loadFlag = true;
	
	public CommonViewAction() {
		commonViewBeans = new ArrayList<CommonViewBean>();
	}

	public List<CommonViewBean> getCommonViewBeans() {
		return commonViewBeans;
	}

	public void setCommonViewBeans(List<CommonViewBean> commonViewBeans) {
		this.commonViewBeans = commonViewBeans;
	}

	public void onLoad(PhaseEvent event) {
		if (loadFlag) {
			commonViewBeanHeader = new CommonViewBeanHeader("Bill No",
					"Customer Name", "Phone", "Address", "Mobile", "Date");
			CommonViewBean commonViewBean = new CommonViewBean();
			commonViewBean.setColumn1("001");
			commonViewBean.setColumn2("Gunasekaran");
			commonViewBean.setColumn3("65632");
			commonViewBean.setColumn4("Valayappaty");
			commonViewBean.setColumn5("9943838838");
			commonViewBean.setColumn6("22/10/2016");
			commonViewBeans.add(commonViewBean);
			
			commonViewBean = new CommonViewBean();
			commonViewBean.setColumn1("002");
			commonViewBean.setColumn2("Gunasekaran");
			commonViewBean.setColumn3("65632");
			commonViewBean.setColumn4("Valayappaty");
			commonViewBean.setColumn5("9943838838");
			commonViewBean.setColumn6("22/10/2016");
			commonViewBeans.add(commonViewBean);
			loadFlag=false;
		}
	}

	public CommonViewBeanHeader getCommonViewBeanHeader() {
		return commonViewBeanHeader;
	}

	public void setCommonViewBeanHeader(
			CommonViewBeanHeader commonViewBeanHeader) {
		this.commonViewBeanHeader = commonViewBeanHeader;
	}

	public boolean isLoadFlag() {
		return loadFlag;
	}

	public void setLoadFlag(boolean loadFlag) {
		this.loadFlag = loadFlag;
	}

	public CommonViewBean getSelectedCommonViewBean() {
		return selectedCommonViewBean;
	}

	public void setSelectedCommonViewBean(CommonViewBean selectedCommonViewBean) {
		this.selectedCommonViewBean = selectedCommonViewBean;
	}
	
	public void onRowSelect(SelectEvent event) throws IOException {
		System.out.println("CommonViewAction.onRowSelect()");
		FacesContext.getCurrentInstance().getExternalContext().redirect("sales.xhtml");
	}	

}
