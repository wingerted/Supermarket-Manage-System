package com.wingerted.service;

import java.util.List;
import java.util.Map;

import com.wingerted.entity.Good;
import com.wingerted.entity.Staff;

public interface StaffService {

	public abstract boolean regiesterStaff(Staff staff);

	public abstract boolean deleteStaff(Staff staff);

	public abstract List<Staff> searchStaff(Long staffId);

	public abstract List<Staff> searchStaff(String staffJob);

	public abstract Staff loginStaff(Staff staff);
	
	public void editStaff(Staff staff);

	public abstract Float logoutStaff(Staff staff, Map<Good, Long> sumGoodMap);

}