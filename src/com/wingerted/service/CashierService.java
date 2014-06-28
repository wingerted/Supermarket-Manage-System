package com.wingerted.service;

import java.util.List;

import com.wingerted.entity.Good;
import com.wingerted.entity.ShoppingList;

public interface CashierService {

	public abstract boolean cashierShoppingList(ShoppingList shoppingList);

	public abstract boolean buyGoods(Long goodBarCode, Long number,
			ShoppingList shoppingList);

	public abstract List<Good> searchGood(String goodName);

	public abstract boolean createShoppingList(ShoppingList shoppingList,
			Long vipId);
	
}