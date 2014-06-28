package com.wingerted.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wingerted.entity.PurchaseRecord;
import com.wingerted.service.PurchaseService;

public class PurchaseControlAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PurchaseService purchaseService;
	Calendar beginDate ;
	Calendar endDate;
	List<Long> purchaseNum = new ArrayList<Long>();
	
	

	public List<Long> getPurchaseNum() {
		return purchaseNum;
	}

	public void setPurchaseNum(List<Long> purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	public PurchaseService getPurchaseService() {
		return purchaseService;
	}

	public void setPurchaseService(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
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

	public String createPurchasePlan() {
		List<PurchaseRecord> purchaseRecordList = purchaseService.createPruchasePlan();
		
		ActionContext.getContext().getSession()
			.put("purchaseRecordList", purchaseRecordList);
		
		return "create";
	}
	
	@SuppressWarnings("unchecked")
	public String confirmPurchasePlan() throws IOException{	
		List<PurchaseRecord> purchaseList = (List<PurchaseRecord>) ActionContext
				.getContext()
				.getSession()
				.get("purchaseRecordList");
		
		for (int i=0; i!=purchaseList.size(); ++i) {
			purchaseList.get(i).setNumber(purchaseNum.get(i));
		}
		
		
		purchaseService.confirmPurchaseList(purchaseList);
		
		ActionContext.getContext().getSession()
				.remove("purchaseRecordList");
		
		JSONObject object=new JSONObject();
		object.put("statusCode", "200");
		object.put("message", "²Ù×÷³É¹¦!");
		object.put("navTabId", "purchase_control");
		object.put("rel", "");
		object.put("callbackType", "closeCurrent"); 
		object.put("forwardUrl", "");
		
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().print(object);
		ServletActionContext.getResponse().getWriter().close();
		
		return SUCCESS;
	}
	
	public String showPurchaseList() {
		
		List<PurchaseRecord> purchaseList = 
				purchaseService.getPurchaseList(beginDate, endDate);
		ActionContext.getContext().put("purchaseList", purchaseList);
		
		return "query";
	}
}
