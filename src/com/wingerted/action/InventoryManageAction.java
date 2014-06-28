package com.wingerted.action;

import java.util.Calendar;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wingerted.service.InventoryService;

public class InventoryManageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InventoryService inventoryService;
	private Calendar beginDate;
	private Calendar endDate;
	
	public InventoryService getInventoryService() {
		return inventoryService;
	}

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	public Calendar getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Calendar beginDate) {
		this.beginDate = beginDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public String queryInventory() {	
		ActionContext.getContext().put("inventoryList", inventoryService.judgeInventoryNumber());      	
		
		return "query";	
	}
	
	public String checkInventory() {	
		ActionContext.getContext().put("checkList", inventoryService.checkInventory(beginDate, endDate));      	
		
		return "check";	
	}
}
