package com.wingerted.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.wingerted.dao.PurchaseRecordDao;
import com.wingerted.entity.PurchaseRecord;

public class PurchaseRecordDaoImpl implements PurchaseRecordDao {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.PurchaseRecordDao#getList(java.util.Calendar, java.util.Calendar)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@Transactional("txManager")
	public List<PurchaseRecord> getList(Calendar beginDate, Calendar endDate) {
		
		return sessionFactory.getCurrentSession()
			.createQuery("from PurchaseRecord record where " +
					"record.date between :beginDate and :endDate")
			.setParameter("beginDate", beginDate)
			.setParameter("endDate", endDate)
			.list();
	}

	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.PurchaseRecordDao#save(com.wingerted.entity.PurchaseRecord)
	 */
	@Override
	@Transactional("txManager")
	public void save(PurchaseRecord purchaseRecord) {

		sessionFactory.getCurrentSession()
			.save(purchaseRecord);
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.PurchaseRecordDao#save(java.util.List)
	 */
	@Override
	@Transactional("txManager")
	public void save(List<PurchaseRecord> purchaseRecordList) {

		for (PurchaseRecord purchaseRecord : purchaseRecordList) {
			this.save(purchaseRecord);
		}
	}
}
