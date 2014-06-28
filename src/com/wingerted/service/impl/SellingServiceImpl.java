package com.wingerted.service.impl;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import com.wingerted.dao.BillOfMaterialDao;
import com.wingerted.dao.FinancialRecordDao;
import com.wingerted.dao.GoodDao;
import com.wingerted.dao.GoodDetailDao;
import com.wingerted.dao.ShoppingListDao;
import com.wingerted.entity.BillOfMaterial;
import com.wingerted.entity.Good;
import com.wingerted.entity.GoodDetail;
import com.wingerted.entity.ShoppingList;
import com.wingerted.service.SellingService;

public class SellingServiceImpl implements SellingService {
	private GoodDao goodDao;
	private GoodDetailDao goodDetailDao;
	private BillOfMaterialDao billOfMaterialDao;
	private FinancialRecordDao financialRecordDao;
	private ShoppingListDao shoppingListDao;

	public FinancialRecordDao getFinancialRecordDao() {
		return financialRecordDao;
	}
	public void setFinancialRecordDao(FinancialRecordDao financialRecordDao) {
		this.financialRecordDao = financialRecordDao;
	}
	public BillOfMaterialDao getBillOfMaterialDao() {
		return billOfMaterialDao;
	}
	public void setBillOfMaterialDao(BillOfMaterialDao billOfMaterialDao) {
		this.billOfMaterialDao = billOfMaterialDao;
	}
	public ShoppingListDao getShoppingListDao() {
		return shoppingListDao;
	}
	public void setShoppingListDao(ShoppingListDao shoppingListDao) {
		this.shoppingListDao = shoppingListDao;
	}
	public GoodDao getGoodDao() {
		return goodDao;
	}
	public void setGoodDao(GoodDao goodDao) {
		this.goodDao = goodDao;
	}
	public GoodDetailDao getGoodDetailDao() {
		return goodDetailDao;
	}
	public void setGoodDetailDao(GoodDetailDao goodDetailDao) {
		this.goodDetailDao = goodDetailDao;
	}
	
	
	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.SellingService#getDetail(java.lang.Long)
	 */
	@Override
	public GoodDetail getDetail(Long goodBarCode) {

		return goodDetailDao.get(goodDao.get(goodBarCode));
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.SellingService#changeDetail(com.wingerted.entity.GoodDetail, java.lang.Long)
	 */
	@Override
	public void changeDetail(GoodDetail goodDetail, Long goodBarCode) {

		goodDetail.setGood(goodDao.get(goodBarCode));
		
		GoodDetail oldGoodDetail = goodDetailDao.get(goodDao.get(goodBarCode));
		
		if (oldGoodDetail != null) {
			oldGoodDetail.setEndDate(goodDetail.getBeginDate());
			goodDetailDao.update(oldGoodDetail);
		}
		
		goodDetail.getGood().setSellingPrice(goodDetail.getSellingPrice());
		goodDetailDao.save(goodDetail);	
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.SellingService#getBillOfMaterialList(java.lang.Long, java.util.Calendar, java.util.Calendar)
	 */
	@Override
	public List<BillOfMaterial> getBillOfMaterialList(Long barCode,
			Calendar beginDate, Calendar endDate) {
		
		return billOfMaterialDao.getBillOfMaterialList(beginDate, endDate, barCode);
	}

	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.SellingService#getReportForms(java.lang.String reportType)
	 */
	@Override
	public Double getReportForms(String reportType) {
		Calendar beginDate = Calendar.getInstance();
		
		if (reportType.equals("日表")) {		
			beginDate.add(Calendar.DAY_OF_YEAR, - 1);	
		} else if (reportType.equals("月表")) {
			beginDate.add(Calendar.MONTH, - 1);
		} else if (reportType.equals("年表")) {
			beginDate.add(Calendar.YEAR, - 1);
		}
		
		return financialRecordDao.getSumProfit(beginDate, Calendar.getInstance());
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.SellingService#getStaffShoppingLists(java.lang.Long, java.util.Calendar, java.util.Calendar)
	 */
	@Override
	public List<ShoppingList> getStaffShoppingLists(Long userId, Calendar beginDate,
			Calendar endDate) {
		
		return shoppingListDao.getList(userId, beginDate, endDate);
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.SellingService#getGookRank(java.util.Calendar, java.util.Calendar)
	 */
	@Override
	public SortedMap<Long, Good> getGookRank(Calendar beginDate, Calendar endDate) {
		
		SortedMap<Long, Good> goodRank = new TreeMap<Long, Good>(
				new Comparator<Long>() {
					@Override
					public int compare(Long a, Long b) {
						return b.compareTo(a);
					}
				}
		);
	
		List<Good> goodList = goodDao.getList();
		for (Good good : goodList) {
			goodRank.put(billOfMaterialDao.getSellNumber(beginDate, 
					endDate, good.getGoodBarCode()), good);
		}
		
		return goodRank;
	}
}
