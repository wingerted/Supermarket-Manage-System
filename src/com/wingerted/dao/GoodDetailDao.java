package com.wingerted.dao;

import org.springframework.transaction.annotation.Transactional;

import com.wingerted.entity.Good;
import com.wingerted.entity.GoodDetail;

public interface GoodDetailDao {

	@Transactional("txManager")
	public abstract void save(GoodDetail goodDetail);

	@Transactional("txManager")
	public abstract GoodDetail get(Good good);

	@Transactional("txManager")
	public abstract void update(GoodDetail goodDetail);

}