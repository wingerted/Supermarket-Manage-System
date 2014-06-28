package com.wingerted.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.wingerted.dao.GoodDetailDao;
import com.wingerted.entity.Good;
import com.wingerted.entity.GoodDetail;

public class GoodDetailDaoImpl implements GoodDetailDao {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.GoodDetailDao#save(com.wingerted.entity.GoodDetail)
	 */
	@Override
	@Transactional("txManager")
	public void save(GoodDetail goodDetail) {

		sessionFactory.getCurrentSession()
			.save(goodDetail);
	}

	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.GoodDetailDao#get(com.wingerted.entity.Good)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@Transactional("txManager")
	public GoodDetail get(Good good) {

		List<GoodDetail> result = sessionFactory.getCurrentSession()
			.createQuery("from GoodDetail goodDetail where " +
				"goodDetail.good = :good order by goodDetail.endDate desc")
			.setEntity("good", good)
			.list();
		
		if (result.isEmpty()) {
			return null;
		} else {
			return (GoodDetail) result.get(0);
		}	
	}

	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.GoodDetailDao#update(com.wingerted.entity.GoodDetail)
	 */
	@Override
	@Transactional("txManager")
	public void update(GoodDetail goodDetail) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession()
			.update(goodDetail);
	}
}
