package com.wingerted.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.wingerted.entity.Good;

public interface GoodDao {

	@Transactional("txManager")
	public abstract void save(Good good);

	@Transactional("txManager")
	public abstract Good get(Long goodBarCode);

	@Transactional("txManager")
	public abstract List<Good> getList(String goodName);

	@Transactional("txManager")
	public abstract List<Good> getList();

}