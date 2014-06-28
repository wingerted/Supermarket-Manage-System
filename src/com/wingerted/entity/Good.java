package com.wingerted.entity;

public class Good {
	private Long goodBarCode;
	private String goodName;
	private Float sellingPrice;
	private String category;
	private Integer shelfLife;
	private Supplier supplier;

	public boolean equals(Object o) {
		if (((Good) o).getGoodBarCode().equals(goodBarCode)) {
			return true;
		} else {
			return false;
		}
	}
	public int hashCode() {
		return goodBarCode.hashCode();
	}
	
	public Long getGoodBarCode() {
		return goodBarCode;
	}
	public void setGoodBarCode(Long goodBarCode) {
		this.goodBarCode = goodBarCode;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public Float getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(Float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(Integer shelfLife) {
		this.shelfLife = shelfLife;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}
