package com.wingerted.entity;

import java.util.Calendar;

public class FinancialRecord {
	private Long id;
	private Float money;
	private Calendar date;
	private Character debtorOrCreditor;
	private String remark;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Float getMoney() {
		return money;
	}
	public void setMoney(Float money) {
		this.money = money;
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
