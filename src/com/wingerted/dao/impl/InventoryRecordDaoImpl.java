package com.wingerted.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;


import com.wingerted.dao.InventoryRecordDao;
import com.wingerted.entity.Good;
import com.wingerted.entity.InventoryRecord;

public class InventoryRecordDaoImpl implements InventoryRecordDao  {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.InventoryRecordDao#getList()
	 */
	@Override
	@SuppressWarnings("unchecked")
	@Transactional("txManager")
	public List<InventoryRecord> getList() {
		
		return sessionFactory.getCurrentSession()
			.createQuery("from InventoryRecord inventoryRecord")
			.list();
	}


	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.InventoryRecordDao#get(java.lang.Long)
	 */
	@Override
	@Transactional("txManager")
	public InventoryRecord get(Long barCode) {

		return (InventoryRecord) sessionFactory.getCurrentSession()
			.createQuery("from InventoryRecord inventoryRecord where " +
					"GOOD_BARCODE = :barCode")
			.setParameter("barCode", barCode)
			.uniqueResult();
	}


	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.InventoryRecordDao#update(com.wingerted.entity.InventoryRecord)
	 */
	@Override
	@Transactional("txManager")
	public void update(InventoryRecord inventoryRecord) {

		sessionFactory.getCurrentSession()
			.update(inventoryRecord);
	}


	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.InventoryRecordDao#getAverageSales(com.wingerted.entity.Good, java.lang.Integer)
	 */
	@Override
	@Transactional("txManager")
	public Long getAverageSales(Good good, Integer round) {

		Calendar date = Calendar.getInstance();
		date.add(Calendar.DAY_OF_YEAR, - round * good.getShelfLife());
		
		Long sum = (Long) sessionFactory.getCurrentSession()
			.createQuery("select sum(bill.number) from BillOfMaterial bill " +
					"where bill.goodBarCode = :goodBarCode and " +
					"bill.debtorOrCreditor = 'C' and " +
					"bill.remark = 'œ˙ €' and " +
					"bill.date between :beginDate and :endDate")
			.setParameter("goodBarCode", good.getGoodBarCode())
			.setParameter("beginDate", date)
			.setParameter("endDate", Calendar.getInstance())
			.uniqueResult();
		
		return sum / round;
	}
}
