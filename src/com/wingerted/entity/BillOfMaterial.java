package com.wingerted.entity;

import java.util.Calendar;

public class BillOfMaterial {
	private Long id;
	private Long goodBarCode;
	private Long number;
	private Calendar date;
	private Character debtorOrCreditor;
	private String remark;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getGoodBarCode() {
		return goodBarCode;
	}
	public void setGoodBarCode(Long goodBarCode) {
		this.goodBarCode = goodBarCode;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public Character getDebtorOrCreditor() {
		return debtorOrCreditor;
	}
	public void setDebtorOrCreditor(Character debtorOrCreditor) {
		this.debtorOrCreditor = debtorOrCreditor;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
