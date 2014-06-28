package com.wingerted.dao;

import java.util.Calendar;

import org.springframework.transaction.annotation.Transactional;

import com.wingerted.entity.FinancialRecord;

public interface FinancialRecordDao {

	@Transactional("txManager")
	public abstract void save(FinancialRecord financialRecord);
	
	@Transactional("txManager")
	public abstract Double getSumProfit(Calendar beginDate, Calendar endDate);

}