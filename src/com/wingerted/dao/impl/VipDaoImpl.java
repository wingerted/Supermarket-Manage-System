package com.wingerted.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.wingerted.dao.VipDao;
import com.wingerted.entity.Vip;

public class VipDaoImpl implements VipDao {
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.VipDao#get(java.lang.Long)
	 */
	@Override
	@Transactional("txManager")
	public Vip get(Long vipId) {

		return (Vip) sessionFactory.getCurrentSession()
			.get(Vip.class, vipId);
	}
}
