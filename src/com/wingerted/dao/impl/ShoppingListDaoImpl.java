package com.wingerted.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.wingerted.dao.ShoppingListDao;
import com.wingerted.entity.ShoppingList;

public class ShoppingListDaoImpl implements ShoppingListDao {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.ShoppingListDao#save(com.wingerted.entity.ShoppingList)
	 */
	@Override
	@Transactional("txManager")
	public void save(ShoppingList shoppingList) {

		sessionFactory.getCurrentSession()
			.save(shoppingList);
	}

	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.ShoppingListDao#getList(java.lang.Long)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@Transactional("txManager")
	public List<ShoppingList> getList(Long staffId) {

		return sessionFactory.getCurrentSession()
			.createQuery("from ShoppingList list where list.staffId = :staffId")
			.setParameter("staffId", staffId)
			.list();
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.ShoppingListDao#getList(java.lang.Long, java.util.Calendar, java.util.Calendar)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@Transactional("txManager")
	public List<ShoppingList> getList(Long staffId, Calendar beginDate,
			Calendar endDate) {

		return sessionFactory.getCurrentSession()
			.createQuery("from ShoppingList list where " +
					"list.staffId = :staffId and " +
					"time between :beginDate and :endDate")
			.setParameter("staffId", staffId)
			.setParameter("beginDate", beginDate)
			.setParameter("endDate", endDate)
			.list();
	}	
}
