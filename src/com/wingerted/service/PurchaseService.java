package com.wingerted.service;

import java.util.Calendar;
import java.util.List;

import com.wingerted.entity.PurchaseRecord;

public interface PurchaseService {

	public abstract List<PurchaseRecord> createPruchasePlan();

	public abstract boolean confirmPurchaseList(
			List<PurchaseRecord> pruchasePlan);

	public abstract List<PurchaseRecord> getPurchaseList(Calendar beginDate,
			Calendar endDate);

}