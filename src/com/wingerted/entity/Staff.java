package com.wingerted.entity;

import java.util.Calendar;

public class Staff {
	private Long staffId;
	private String staffName;
	private String password;
	private String sex;
	private Calendar birthday;
	private String telephone;
	private String job;
	private Calendar loginTime;
	
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Calendar getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Calendar loginTime) {
		this.loginTime = loginTime;
	}
}
