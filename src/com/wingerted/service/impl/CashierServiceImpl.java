package com.wingerted.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.wingerted.dao.BillOfMaterialDao;
import com.wingerted.dao.GoodDao;
import com.wingerted.dao.GoodDetailDao;
import com.wingerted.dao.ShoppingListDao;
import com.wingerted.dao.VipDao;
import com.wingerted.entity.Good;
import com.wingerted.entity.ShoppingList;
import com.wingerted.service.CashierService;

public class CashierServiceImpl implements CashierService {
	private GoodDao goodDao;
	private GoodDetailDao goodDetailDao;
	private ShoppingListDao shoppingListDao;
	private BillOfMaterialDao billOfMaterialDao;
	private VipDao vipDao;
	
	public VipDao getVipDao() {
		return vipDao;
	}
	public void setVipDao(VipDao vipDao) {
		this.vipDao = vipDao;
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
	public ShoppingListDao getShoppingListDao() {
		return shoppingListDao;
	}
	public void setShoppingListDao(ShoppingListDao shoppingListDao) {
		this.shoppingListDao = shoppingListDao;
	}
	public BillOfMaterialDao getBillOfMaterialDao() {
		return billOfMaterialDao;
	}
	public void setBillOfMaterialDao(BillOfMaterialDao billOfMaterialDao) {
		this.billOfMaterialDao = billOfMaterialDao;
	}

	
	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.CashierService#cashierShoppingList(com.wingerted.entity.ShoppingList)
	 */
	@Override
	public boolean cashierShoppingList(ShoppingList shoppingList) {

		shoppingList.setChange(shoppingList.getActuallyPay() 
				- shoppingList.getShouldPay() - shoppingList.getDiscount());
		shoppingList.setTime(Calendar.getInstance());
		shoppingListDao.save(shoppingList);
		
		return true;
	}

	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.CashierService#buyGoods(java.lang.Long, java.lang.Long, com.wingerted.entity.ShoppingList)
	 */
	@Override
	public boolean buyGoods(Long goodBarCode, Long number, ShoppingList shoppingList) {

		Map<Good, Long> shoppingDetails = shoppingList.getShoppingDetails();
		
		Good good = goodDao.get(goodBarCode);
		Integer goodOpenNumber = goodDetailDao.get(good).getOpenNumber();
		
		if (shoppingDetails.containsKey(good) && 
				shoppingDetails.get(good)+number <= goodOpenNumber) {
			shoppingDetails.put(good, shoppingDetails.get(good) + number);
		} else if (goodOpenNumber >= number) {
			shoppingDetails.put(good, number);
		} else {
			return false;
		}
		
		if (shoppingList.getShouldPay() != null) {
			shoppingList.setShouldPay(shoppingList.getShouldPay() 
				+ good.getSellingPrice() * number);
		} else {
			shoppingList.setShouldPay(good.getSellingPrice() * number);
		}
		
		return true;
	}

	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.CashierService#searchGood(java.lang.String)
	 */
	@Override
	public List<Good> searchGood(String goodName) {
	
		return goodDao.getList(goodName);
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.CashierService#createShoppingList(com.wingerted.entity.ShoppingList, java.lang.Long)
	 */
	@Override
	public boolean createShoppingList(ShoppingList shoppingList, Long vipId) {

		if (vipId != null) {
			shoppingList.setDiscount(0 - shoppingList.getShouldPay() + 
				vipDao.get(vipId).getVipLevel() * shoppingList.getShouldPay());
		} else if (shoppingList.getDiscount() == null) {
			shoppingList.setDiscount(Float.intBitsToFloat(0));
		}
		
		return true;
	}
}
