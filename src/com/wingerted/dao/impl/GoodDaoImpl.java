package com.wingerted.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.wingerted.dao.GoodDao;
import com.wingerted.entity.Good;

public class GoodDaoImpl implements GoodDao {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.GoodDao#save(com.wingerted.entity.Good)
	 */
	@Override
	@Transactional("txManager")
	public void save(Good good) {

		sessionFactory.getCurrentSession()
			.save(good);
	}

	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.GoodDao#get(java.lang.Long)
	 */
	@Override
	@Transactional("txManager")
	public Good get(Long goodBarCode) {

		return (Good)sessionFactory.getCurrentSession()
			.get(Good.class, goodBarCode);
	}

	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.GoodDao#getList(java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@Transactional("txManager")
	public List<Good> getList(String goodName) {
		
		return sessionFactory.getCurrentSession()
			.createQuery("from Good good where good.goodName like :goodName")
			.setParameter("goodName", '%' + goodName + '%')
			.list();
	}

	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.GoodDao#getList()
	 */
	@Override
	@SuppressWarnings("unchecked")
	@Transactional("txManager")
	public List<Good> getList() {

		return sessionFactory.getCurrentSession()
			.createQuery("from Good")
			.list();
	}
}
