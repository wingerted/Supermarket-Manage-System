package com.wingerted.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.wingerted.entity.Good;
import com.wingerted.entity.InventoryRecord;

public interface InventoryRecordDao {

	@Transactional("txManager")
	public abstract List<InventoryRecord> getList();

	@Transactional("txManager")
	public abstract InventoryRecord get(Long barCode);

	@Transactional("txManager")
	public abstract void update(InventoryRecord inventoryRecord);

	@Transactional("txManager")
	public abstract Long getAverageSales(Good good, Integer round);

}