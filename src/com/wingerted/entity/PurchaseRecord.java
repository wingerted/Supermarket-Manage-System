package com.wingerted.entity;

import java.util.Calendar;

public class PurchaseRecord {
	private Long id;
	private Good good;
	private Long number;
	private Float importPrice;
	private Calendar date;
	private Calendar limitDate;
	private Supplier supplier;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public Float getImportPrice() {
		return importPrice;
	}
	public void setImportPrice(Float importPrice) {
		this.importPrice = importPrice;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public Calendar getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(Calendar limitDate) {
		this.limitDate = limitDate;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}	
}
