package com.wingerted.dao.impl;

import java.util.Calendar;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.wingerted.dao.FinancialRecordDao;
import com.wingerted.entity.FinancialRecord;

public class FinancialRecordDaoImpl implements FinancialRecordDao {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.FinancialRecordDao#save(com.wingerted.entity.FinancialRecord)
	 */
	@Override
	@Transactional("txManager")
	public void save(FinancialRecord financialRecord) {

		sessionFactory.getCurrentSession()
			.save(financialRecord);
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.FinancialRecordDao#getSumProfit(com.wingerted.entity.FinancialRecord)
	 */
	@Override
	@Transactional("txManager")
	public Double getSumProfit(Calendar beginDate, Calendar endDate) {	
		Double input = (Double) sessionFactory.getCurrentSession().createQuery("select sum(record.money) from FinancialRecord record " +
				"where record.date between :beginDate and :endDate and record.debtorOrCreditor = 'C'")
				.setParameter("beginDate", beginDate)
				.setParameter("endDate", endDate)
				.uniqueResult();
		
		Double output = (Double) sessionFactory.getCurrentSession().createQuery("select sum(record.money) from FinancialRecord record " +
				"where record.date between :beginDate and :endDate and record.debtorOrCreditor = 'D'")
				.setParameter("beginDate", beginDate)
				.setParameter("endDate", endDate)
				.uniqueResult();	
		if (output == null) {
			output = 0.0;
		}
		
		if (input == null) {
			return 0.0;
		}
		
		return input - output;
		
	}
}
