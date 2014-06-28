package com.wingerted.dao;

import org.springframework.transaction.annotation.Transactional;

import com.wingerted.entity.Vip;

public interface VipDao {

	@Transactional("txManager")
	public abstract Vip get(Long vipId);

}