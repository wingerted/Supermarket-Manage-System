package com.wingerted.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.wingerted.dao.BillOfMaterialDao;
import com.wingerted.dao.FinancialRecordDao;
import com.wingerted.dao.InventoryRecordDao;
import com.wingerted.dao.ShoppingListDao;
import com.wingerted.dao.StaffDao;
import com.wingerted.entity.BillOfMaterial;
import com.wingerted.entity.FinancialRecord;
import com.wingerted.entity.Good;
import com.wingerted.entity.InventoryRecord;
import com.wingerted.entity.ShoppingList;
import com.wingerted.entity.Staff;
import com.wingerted.service.StaffService;


public class StaffServiceImpl implements StaffService {
	private StaffDao staffDao;
	private ShoppingListDao shoppingListDao;
	private InventoryRecordDao inventoryRecordDao;
	private BillOfMaterialDao billOfMaterialDao;
	private FinancialRecordDao financialRecordDao;
	
	public ShoppingListDao getShoppingListDao() {
		return shoppingListDao;
	}
	public void setShoppingListDao(ShoppingListDao shoppingListDao) {
		this.shoppingListDao = shoppingListDao;
	}
	public InventoryRecordDao getInventoryRecordDao() {
		return inventoryRecordDao;
	}
	public void setInventoryRecordDao(InventoryRecordDao inventoryRecordDao) {
		this.inventoryRecordDao = inventoryRecordDao;
	}
	public BillOfMaterialDao getBillOfMaterialDao() {
		return billOfMaterialDao;
	}
	public void setBillOfMaterialDao(BillOfMaterialDao billOfMaterialDao) {
		this.billOfMaterialDao = billOfMaterialDao;
	}
	public FinancialRecordDao getFinancialRecordDao() {
		return financialRecordDao;
	}
	public void setFinancialRecordDao(FinancialRecordDao financialRecordDao) {
		this.financialRecordDao = financialRecordDao;
	}
	public StaffDao getStaffDao() {
		return staffDao;
	}
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.StaffService#regiesterStaff(com.wingerted.entity.Staff)
	 */
	@Override
	public boolean regiesterStaff(Staff staff) {
		
		staffDao.save(staff);
		return true;
	}

	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.StaffService#deleteStaff(com.wingerted.entity.Staff)
	 */
	@Override
	public boolean deleteStaff(Staff staff) {
		
		staffDao.deleteStaff(staff);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.StaffService#searchStaff(java.lang.Long)
	 */
	@Override
	public List<Staff> searchStaff(Long staffId) {
		
		List<Staff> staffList = new ArrayList<Staff>();
		staffList.add(staffDao.get(staffId));
		return staffList;
	}

	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.StaffService#searchStaff(java.lang.String)
	 */
	@Override
	public List<Staff> searchStaff(String staffJob) {
		
		return staffDao.getList(staffJob);
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.StaffService#editStaff(com.wingerted.entity.Staff)
	 */
	@Override
	public void editStaff(Staff staff) {
		
		staffDao.update(staff);
	}

	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.StaffService#loginStaff(com.wingerted.entity.Staff)
	 */
	@Override
	public Staff loginStaff(Staff staff) {
		
		if (staffDao.valid(staff)) {
			return staffDao.get(staff.getStaffId());
		}

		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.StaffService#logoutStaff(com.wingerted.entity.Staff, java.util.Map)
	 */
	@Override
	public Float logoutStaff(Staff staff, Map<Good, Long> sumGoodMap) {
		
		List<ShoppingList> handoverAccount = 
			shoppingListDao.getList(staff.getStaffId(), 
				staff.getLoginTime(), 
				Calendar.getInstance());
		
		FinancialRecord financialRecord = new FinancialRecord();
		financialRecord.setDate(Calendar.getInstance());
		financialRecord.setDebtorOrCreditor('D');
		financialRecord.setRemark("销售");
		
		for (ShoppingList list : handoverAccount) {	
			if (financialRecord.getMoney() != null) {
				financialRecord.setMoney(financialRecord.getMoney() +
					list.getShouldPay() + list.getDiscount());
			} else {
				financialRecord.setMoney(list.getShouldPay() +
					list.getDiscount());
			}
				
			for (Iterator<Entry<Good, Long>> iter = 
					list.getShoppingDetails().entrySet().iterator(); 
					iter.hasNext();) {
				Entry<Good, Long> entry = iter.next();
				
				if (sumGoodMap.containsKey(entry.getKey())) {
					sumGoodMap.put(entry.getKey(), 
						sumGoodMap.get(entry.getKey()) + entry.getValue());
				} else {
					sumGoodMap.put(entry.getKey(), entry.getValue());
				}
			}
		}
			
		for (Iterator<Entry<Good, Long>> iter = 
				sumGoodMap.entrySet().iterator();iter.hasNext();) {
			Entry<Good, Long> entry = iter.next();
				
			InventoryRecord record = 
					inventoryRecordDao.get(entry.getKey().getGoodBarCode());
			record.setTotalNumber(record.getTotalNumber() - entry.getValue());
			inventoryRecordDao.update(record);
				
			BillOfMaterial billOfMaterial = new BillOfMaterial();
			billOfMaterial.setGoodBarCode(entry.getKey().getGoodBarCode());
			billOfMaterial.setDate(Calendar.getInstance());
			billOfMaterial.setDebtorOrCreditor('C');
			billOfMaterial.setNumber(entry.getValue());
			billOfMaterial.setRemark("销售");
			billOfMaterialDao.save(billOfMaterial);
		}
			
		financialRecordDao.save(financialRecord);
			
		return financialRecord.getMoney();
	}
}
