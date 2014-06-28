package com.wingerted.service;

import java.util.Calendar;
import java.util.List;

import com.wingerted.entity.CheckRecord;
import com.wingerted.entity.InventoryRecord;

public interface InventoryService {

	public abstract List<InventoryRecord> judgeInventoryNumber();

	public abstract List<InventoryRecord> getInventoryList();

	public abstract List<CheckRecord> checkInventory(Calendar beginDate,
			Calendar endDate);

}