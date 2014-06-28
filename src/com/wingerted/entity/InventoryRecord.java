package com.wingerted.entity;

public class InventoryRecord {
	private Long id;
	private Good good;
	private Long totalNumber;
	private String state;
	
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
	public Long getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(Long totalNumber) {
		this.totalNumber = totalNumber;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
