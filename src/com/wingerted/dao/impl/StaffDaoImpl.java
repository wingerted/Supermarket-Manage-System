package com.wingerted.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.wingerted.dao.StaffDao;
import com.wingerted.entity.Staff;

public class StaffDaoImpl implements StaffDao {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.StaffDao#save(com.wingerted.entity.Staff)
	 */
	@Override
	@Transactional("txManager")
	public void save(Staff staff) {
		
		sessionFactory.getCurrentSession()
			.save(staff);
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.StaffDao#update(com.wingerted.entity.Staff)
	 */
	@Override
	@Transactional("txManager")
	public void update(Staff staff) {
		
		sessionFactory.getCurrentSession()
			.update(staff);
	}

	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.StaffDao#valid(com.wingerted.entity.Staff)
	 */
	@Override
	@Transactional("txManager")
	public boolean valid(Staff staff) {
		
		Staff test = (Staff) sessionFactory.getCurrentSession()
				.get(Staff.class, staff.getStaffId());
		
		if (staff.getPassword().equals(test.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.StaffDao#get(java.lang.Long)
	 */
	@Override
	@Transactional("txManager")
	public Staff get(Long staffId) {
		
		return (Staff) sessionFactory.getCurrentSession()
			.get(Staff.class, staffId);
	}	
	
	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.StaffDao#getList(java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@Transactional("txManager")
	public List<Staff> getList(String job) {
		
		return sessionFactory.getCurrentSession()
			.createQuery("from Staff staff where staff.job = :job")
			.setParameter("job", job)
			.list();
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.dao.impl.StaffDao#deleteStaff(com.wingerted.entity.Staff)
	 */
	@Override
	@Transactional("txManager")
	public void deleteStaff(Staff staff) {

		sessionFactory.getCurrentSession()
			.delete(staff);
	}	
}
