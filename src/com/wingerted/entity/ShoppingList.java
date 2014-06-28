package com.wingerted.entity;

import java.util.Calendar;
import java.util.Map;

public class ShoppingList {
	private Long serialNumber;
	private Float shouldPay;
	private Float actuallyPay;
	private Float change;
	private Float discount;
	private Calendar time;
	private Long staffId;
	private Map<Good, Long> shoppingDetails;
	
	public Long getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Long serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Float getShouldPay() {
		return shouldPay;
	}
	public void setShouldPay(Float shouldPay) {
		this.shouldPay = shouldPay;
	}
	public Float getActuallyPay() {
		return actuallyPay;
	}
	public void setActuallyPay(Float actuallyPay) {
		this.actuallyPay = actuallyPay;
	}
	public Float getChange() {
		return change;
	}
	public void setChange(Float change) {
		this.change = change;
	}
	public Float getDiscount() {
		return discount;
	}
	public void setDiscount(Float discount) {
		this.discount = discount;
	}
	public Calendar getTime() {
		return time;
	}
	public void setTime(Calendar time) {
		this.time = time;
	}
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public Map<Good, Long> getShoppingDetails() {
		return shoppingDetails;
	}
	public void setShoppingDetails(Map<Good, Long> shoppingDetails) {
		this.shoppingDetails = shoppingDetails;
	}
}
