package com.retail.sales;

import java.io.Serializable;

public class SalesItemBean implements Serializable {
	
	private Long id;
	private Long headId;
	private String itemCode;
	private String itemDesc;
	private String uom;
	private String deliveryLocation;
	private String itemQty;
	private String itemLooseQty;
	private Double price;
	private Double grossValue;
	private Double discPercentage;
	private Double discPrice;
	private Double stock;
	private Double netValue;
	
	public Double getNetValue() {
		return netValue;
	}
	public void setNetValue(Double netValue) {
		this.netValue = netValue;
	}
	public Double getStock() {
		return stock;
	}
	public void setStock(Double stock) {
		this.stock = stock;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getHeadId() {
		return headId;
	}
	public void setHeadId(Long headId) {
		this.headId = headId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getDeliveryLocation() {
		return deliveryLocation;
	}
	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}
	public String getItemQty() {
		return itemQty;
	}
	public void setItemQty(String itemQty) {
		this.itemQty = itemQty;
	}
	public String getItemLooseQty() {
		return itemLooseQty;
	}
	public void setItemLooseQty(String itemLooseQty) {
		this.itemLooseQty = itemLooseQty;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getGrossValue() {
		return grossValue;
	}
	public void setGrossValue(Double grossValue) {
		this.grossValue = grossValue;
	}
	public Double getDiscPercentage() {
		return discPercentage;
	}
	public void setDiscPercentage(Double discPercentage) {
		this.discPercentage = discPercentage;
	}
	public Double getDiscPrice() {
		return discPrice;
	}
	public void setDiscPrice(Double discPrice) {
		this.discPrice = discPrice;
	}

}
