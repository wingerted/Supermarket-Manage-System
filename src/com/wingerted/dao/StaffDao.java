package com.wingerted.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.wingerted.entity.Staff;

public interface StaffDao {

	@Transactional("txManager")
	public abstract void save(Staff staff);
	
	@Transactional("txManager")
	public void update(Staff staff);

	@Transactional("txManager")
	public abstract boolean valid(Staff staff);

	@Transactional("txManager")
	public abstract Staff get(Long staffId);

	@Transactional("txManager")
	public abstract List<Staff> getList(String staffJob);

	@Transactional("txManager")
	public abstract void deleteStaff(Staff staff);

}