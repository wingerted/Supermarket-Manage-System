package com.wingerted.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.wingerted.dao.BillOfMaterialDao;
import com.wingerted.dao.FinancialRecordDao;
import com.wingerted.dao.InventoryRecordDao;
import com.wingerted.dao.PurchaseRecordDao;
import com.wingerted.entity.BillOfMaterial;
import com.wingerted.entity.FinancialRecord;
import com.wingerted.entity.InventoryRecord;
import com.wingerted.entity.PurchaseRecord;
import com.wingerted.service.PurchaseService;

public class PurchaseServiceImpl implements PurchaseService {

	private InventoryRecordDao inventoryRecordDao;
	private FinancialRecordDao financialRecordDao;
	private PurchaseRecordDao purchaseRecordDao;
	private BillOfMaterialDao billOfMaterialDao;
	
	public InventoryRecordDao getInventoryRecordDao() {
		return inventoryRecordDao;
	}
	public void setInventoryRecordDao(InventoryRecordDao inventoryRecordDao) {
		this.inventoryRecordDao = inventoryRecordDao;
	}
	public FinancialRecordDao getFinancialRecordDao() {
		return financialRecordDao;
	}
	public void setFinancialRecordDao(FinancialRecordDao financialRecordDao) {
		this.financialRecordDao = financialRecordDao;
	}
	public PurchaseRecordDao getPurchaseRecordDao() {
		return purchaseRecordDao;
	}
	public void setPurchaseRecordDao(PurchaseRecordDao purchaseRecordDao) {
		this.purchaseRecordDao = purchaseRecordDao;
	}
	public BillOfMaterialDao getBillOfMaterialDao() {
		return billOfMaterialDao;
	}
	public void setBillOfMaterialDao(BillOfMaterialDao billOfMaterialDao) {
		this.billOfMaterialDao = billOfMaterialDao;
	}

	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.PurchaseService#createPruchasePlan()
	 */
	@Override
	public List<PurchaseRecord> createPruchasePlan() {

		List<PurchaseRecord> purchaseRecordList = new ArrayList<PurchaseRecord>();

		List<InventoryRecord> inventoryRecordList = inventoryRecordDao.getList();

		for (InventoryRecord iter : inventoryRecordList) {
			Long avgNum = inventoryRecordDao.getAverageSales(iter.getGood(), 3);
			if (avgNum - iter.getTotalNumber() > 0) {
				PurchaseRecord data = new PurchaseRecord();
				data.setDate(Calendar.getInstance());
				data.setGood(iter.getGood());
				Calendar limitDate = Calendar.getInstance();
				limitDate.add(Calendar.DAY_OF_YEAR, iter.getGood().getShelfLife());
				data.setLimitDate(limitDate);
				data.setNumber(avgNum - iter.getTotalNumber());
				data.setImportPrice(iter.getGood()
					.getSupplier()
					.getGoodSupply()
					.get(iter.getGood()));
				data.setSupplier(iter.getGood().getSupplier());

				purchaseRecordList.add(data);
			}
		}

		return purchaseRecordList;
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.PurchaseService#confirmPurchaseList(java.util.List)
	 */
	@Override
	public boolean confirmPurchaseList(List<PurchaseRecord> pruchasePlan) {
		
		for (PurchaseRecord iter : pruchasePlan) {
			InventoryRecord data = inventoryRecordDao.get(iter.getGood().getGoodBarCode());
			data.setTotalNumber(data.getTotalNumber() + iter.getNumber());
			inventoryRecordDao.update(data);
			
			FinancialRecord financialRecord = new FinancialRecord();
			financialRecord.setDate(iter.getDate());
			financialRecord.setDebtorOrCreditor('C');
			financialRecord.setMoney(iter.getImportPrice() * iter.getNumber());
			financialRecord.setRemark("进货");
			financialRecordDao.save(financialRecord);
			
			BillOfMaterial billOfMaterial = new BillOfMaterial();
			billOfMaterial.setGoodBarCode(data.getId());
			billOfMaterial.setDate(iter.getDate());
			billOfMaterial.setDebtorOrCreditor('D');
			billOfMaterial.setNumber(iter.getNumber());
			billOfMaterial.setRemark("进货");
			billOfMaterialDao.save(billOfMaterial);
		}
		
		purchaseRecordDao.save(pruchasePlan);
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.PurchaseService#getPurchaseList(java.util.Calendar, java.util.Calendar)
	 */
	@Override
	public List<PurchaseRecord> getPurchaseList(Calendar beginDate, Calendar endDate) {

		return purchaseRecordDao.getList(beginDate, endDate);
	}	
}
