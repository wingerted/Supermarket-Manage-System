package com.wingerted.dao;

import java.util.Calendar;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.wingerted.entity.PurchaseRecord;

public interface PurchaseRecordDao {

	@Transactional("txManager")
	public abstract List<PurchaseRecord> getList(Calendar beginDate,
			Calendar endDate);

	@Transactional("txManager")
	public abstract void save(PurchaseRecord purchaseRecord);

	@Transactional("txManager")
	public abstract void save(List<PurchaseRecord> purchaseRecordList);

}