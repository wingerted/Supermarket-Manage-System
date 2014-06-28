package com.wingerted.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.wingerted.dao.BillOfMaterialDao;
import com.wingerted.dao.InventoryRecordDao;
import com.wingerted.entity.CheckRecord;
import com.wingerted.entity.InventoryRecord;
import com.wingerted.service.InventoryService;

public class InventoryServiceImpl implements InventoryService {
	private InventoryRecordDao inventoryRecordDao;
	private BillOfMaterialDao billOfMaterialDao;

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

	
	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.InventoryService#judgeInventoryNumber()
	 */
	@Override
	public List<InventoryRecord> judgeInventoryNumber() {
		List<InventoryRecord> inventoryList = getInventoryList();
		
		for (InventoryRecord inventoryRecord : inventoryList) {
			Float judgeNum = Float.valueOf(
				inventoryRecord.getTotalNumber()) / 
				inventoryRecordDao.getAverageSales(inventoryRecord.getGood(), 3);
			if (judgeNum > 1.5) {
				inventoryRecord.setState("¿â´æ¹ýÊ£");
			} else if (judgeNum>0 && judgeNum<1) {
				inventoryRecord.setState("¿â´æ¹ýÉÙ");
			} else if (judgeNum.intValue() == 0){
				inventoryRecord.setState("¿â´æÈ±»õ");
			} else {
				inventoryRecord.setState("¿â´æÕý³£");
			}
		}

		return inventoryList;
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.InventoryService#getInventoryList()
	 */
	@Override
	public List<InventoryRecord> getInventoryList() {
		
		return inventoryRecordDao.getList();
	}
	
	/* (non-Javadoc)
	 * @see com.wingerted.service.impl.InventoryService#checkInventory(java.util.Calendar, java.util.Calendar)
	 */
	@Override
	public List<CheckRecord> checkInventory(Calendar beginDate, Calendar endDate) {

		List<CheckRecord> checkList = new ArrayList<CheckRecord>();
		List<InventoryRecord> inventoryList = getInventoryList();
		
		for (InventoryRecord record : inventoryList) {
			CheckRecord data = new CheckRecord();
			data.setGood(record.getGood());
			data.setSellNumber(billOfMaterialDao.getSellNumber(beginDate, 
					endDate, record.getGood().getGoodBarCode()));
			data.setProfit((record.getGood()
				.getSellingPrice()-record
				.getGood()
				.getSupplier()
				.getGoodSupply()
				.get(record.getGood()))*data
						.getSellNumber());
			checkList.add(data);
		}
		
		return checkList;
	}
}
