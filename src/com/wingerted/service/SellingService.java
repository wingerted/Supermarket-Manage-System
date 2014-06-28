package com.wingerted.service;

import java.util.Calendar;
import java.util.List;
import java.util.SortedMap;

import com.wingerted.entity.BillOfMaterial;
import com.wingerted.entity.Good;
import com.wingerted.entity.GoodDetail;
import com.wingerted.entity.ShoppingList;

public interface SellingService {

	public abstract GoodDetail getDetail(Long goodBarCode);

	public abstract void changeDetail(GoodDetail goodDetail, Long goodBarCode);

	public abstract List<BillOfMaterial> getBillOfMaterialList(Long barCode,
			Calendar beginDate, Calendar endDate);

	public abstract List<ShoppingList> getStaffShoppingLists(Long userId,
			Calendar beginDate, Calendar endDate);

	public abstract SortedMap<Long, Good> getGookRank(Calendar beginDate,
			Calendar endDate);
	
	public abstract Double getReportForms(String reportType);

}