package com.wingerted.entity;

import java.util.Map;

public class Supplier {
	private Long supplierId;
	private String supplierName;
	private String telephone;
	private Map<Good, Float> goodSupply	;
	
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Map<Good, Float> getGoodSupply() {
		return goodSupply;
	}
	public void setGoodSupply(Map<Good, Float> goodSupply) {
		this.goodSupply = goodSupply;
	}
}
