package com.retail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Objects of this class are used to persist the setup information of product data across pages.
 * @author Ganesh J (59951)
 *
 */
public class ProductSetupInfo implements Serializable {

	protected String levelDesc = "";
	
	protected String hierarchyCode = null;
	
	protected String hierarchyName = null;
	
	protected String hierarchyShortName = null;
	
	protected List<String> selectedCodeList = new ArrayList<String>();

	protected List<String> selectedCaptionList = new ArrayList<String>();

	protected String gridData = null;
	
	protected String jsTreeData = null;

	public ProductSetupInfo() {
		// do nothing
	}
	
	public String getLevelDesc() {
		return levelDesc;
	}

	public void setLevelDesc(String levelDesc) {
		this.levelDesc = levelDesc;
	}

	public String getHierarchyCode() {
		return hierarchyCode;
	}

	public void setHierarchyCode(String hierarchyCode) {
		this.hierarchyCode = hierarchyCode;
	}

	public String getHierarchyName() {
		return hierarchyName;
	}

	public void setHierarchyName(String hierarchyName) {
		this.hierarchyName = hierarchyName;
	}

	public String getHierarchyShortName() {
		return hierarchyShortName;
	}

	public void setHierarchyShortName(String hierarchyShortName) {
		this.hierarchyShortName = hierarchyShortName;
	}

	public List<String> getSelectedCodeList() {
		return selectedCodeList;
	}

	public void setSelectedCodeList(List<String> selectedCodeList) {
		this.selectedCodeList.clear();
		this.selectedCodeList.addAll(selectedCodeList);
	}

	public List<String> getSelectedCaptionList() {
		return selectedCaptionList;
	}

	public void setSelectedCaptionList(List<String> selectedCaptionList) {
		this.selectedCaptionList.clear();
		this.selectedCaptionList.addAll(selectedCaptionList);
	}

	public String getGridData() {
		return gridData;
	}

	public void setGridData(String gridData) {
		this.gridData = gridData;
	}

	public String getJsTreeData() {
		return jsTreeData;
	}

	public void setJsTreeData(String jsTreeData) {
		this.jsTreeData = jsTreeData;
	}
}