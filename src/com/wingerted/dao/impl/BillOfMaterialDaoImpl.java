package com.wingerted.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.wingerted.dao.BillOfMaterialDao;
import com.wingerted.entity.BillOfMaterial;

public class BillOfMaterialDaoImpl implements BillOfMaterialDao{

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.BillOfMaterialDao#save(com.wingerted.entity.BillOfMaterial)
	 */

	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.BillOfMaterialDao#save(com.wingerted.entity.BillOfMaterial)
	 */
	@Override
	@Transactional("txManager")
	public void save(BillOfMaterial billOfMaterial) {

		sessionFactory.getCurrentSession()
			.save(billOfMaterial);
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.BillOfMaterialDao#getSellNumber(java.util.Calendar, java.util.Calendar, java.lang.Long)
	 */
	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.BillOfMaterialDao#getSellNumber(java.util.Calendar, java.util.Calendar, java.lang.Long)
	 */
	@Override
	@Transactional("txManager")
	public Long getSellNumber(Calendar beginDate, Calendar endDate,
			Long goodBarCode) {

		return (Long)sessionFactory.getCurrentSession()
			.createQuery("select sum(bill.number) from BillOfMaterial bill" +
				" where bill.goodBarCode = :goodBarCode and" +
				" bill.debtorOrCreditor = 'C' and" +
				" bill.remark = '销售' and" +
				" bill.date between :beginDate and :endDate")
			.setParameter("goodBarCode", goodBarCode)
			.setParameter("beginDate", beginDate)
			.setParameter("endDate", endDate)
			.uniqueResult();
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.BillOfMaterialDao#getBillOfMaterialList(java.util.Calendar, java.util.Calendar, java.lang.Long)
	 */
	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.BillOfMaterialDao#getBillOfMaterialList(java.util.Calendar, java.util.Calendar, java.lang.Long)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@Transactional("txManager")
	public List<BillOfMaterial> getBillOfMaterialList(Calendar beginDate,
			Calendar endDate, Long goodBarCode) {
		
		return sessionFactory.getCurrentSession()
			.createQuery("from BillOfMaterial bill where " +
				"bill.goodBarCode = :goodBarCode and " +
				"bill.date between :beginDate and :endDate and" +
				" bill.remark = '销售' ")
			.setParameter("goodBarCode", goodBarCode)
			.setParameter("beginDate", beginDate)
			.setParameter("endDate", endDate)
			.list();
	}
}
