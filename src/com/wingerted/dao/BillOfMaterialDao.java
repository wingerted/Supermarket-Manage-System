package com.wingerted.dao;

import java.util.Calendar;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.wingerted.entity.BillOfMaterial;

public interface BillOfMaterialDao {

	@Transactional("txManager")
	public abstract void save(BillOfMaterial billOfMaterial);

	@Transactional("txManager")
	public abstract Long getSellNumber(Calendar beginDate, Calendar endDate,
			Long goodBarCode);

	@Transactional("txManager")
	public abstract List<BillOfMaterial> getBillOfMaterialList(
			Calendar beginDate, Calendar endDate, Long goodBarCode);

}