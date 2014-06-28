package com.wingerted.dao;

import java.util.Calendar;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.wingerted.entity.ShoppingList;

public interface ShoppingListDao {

	@Transactional("txManager")
	public abstract void save(ShoppingList shoppingList);

	@Transactional("txManager")
	public abstract List<ShoppingList> getList(Long staffId);

	@Transactional("txManager")
	public abstract List<ShoppingList> getList(Long staffId,
			Calendar beginDate, Calendar endDate);

}