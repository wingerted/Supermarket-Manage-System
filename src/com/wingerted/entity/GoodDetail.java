package com.wingerted.entity;

import java.util.Calendar;

public class GoodDetail {
	private Long id;
	private Good good;
	private Calendar beginDate;
	private Calendar endDate;
	private Float sellingPrice;
	private Integer openNumber;
	private String remark;
	
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
	public Calendar getEndDate() {
		return endDate;
	}
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}
	public Float getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(Float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public Integer getOpenNumber() {
		return openNumber;
	}
	public void setOpenNumber(Integer openNumber) {
		this.openNumber = openNumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Calendar getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Calendar beginDate) {
		this.beginDate = beginDate;
	}
}
