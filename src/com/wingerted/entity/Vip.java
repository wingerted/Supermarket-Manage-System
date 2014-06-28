package com.wingerted.entity;

import java.util.Calendar;

public class Vip {
	private Long vipId;
	private String vipName;
	private String sex;
	private Calendar birthday;
	private String telephone;
	private Float vipLevel;
	
	public Long getVipId() {
		return vipId;
	}
	public void setVipId(Long vipId) {
		this.vipId = vipId;
	}
	public String getVipName() {
		return vipName;
	}
	public void setVipName(String vipName) {
		this.vipName = vipName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Calendar getBirthday() {
		return birthday;
	}
	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Float getVipLevel() {
		return vipLevel;
	}
	public void setVipLevel(Float vipLevel) {
		this.vipLevel = vipLevel;
	}
}
