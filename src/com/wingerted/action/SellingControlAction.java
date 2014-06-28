package com.wingerted.action;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wingerted.entity.GoodDetail;
import com.wingerted.service.SellingService;

public class SellingControlAction extends ActionSupport 
	implements ModelDriven<GoodDetail>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GoodDetail goodDetail;
	private SellingService sellingService;
	private Long goodBarCode;
	private Long staffId;
	private String reportType;
	
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public GoodDetail getGoodDetail() {
		return goodDetail;
	}
	public void setGoodDetail(GoodDetail goodDetail) {
		this.goodDetail = goodDetail;
	}
	public SellingService getSellingService() {
		return sellingService;
	}
	public void setSellingService(SellingService sellingService) {
		this.sellingService = sellingService;
	}
	public Long getGoodBarCode() {
		return goodBarCode;
	}
	public void setGoodBarCode(Long goodBarCode) {
		this.goodBarCode = goodBarCode;
	}

	@Override
	public GoodDetail getModel() {

		return goodDetail;
	}
	
	public String changeGoodDetail() throws Exception {	
		sellingService.changeDetail(goodDetail, goodBarCode);
		
		JSONObject object=new JSONObject();
		object.put("statusCode", "200");
		object.put("message", "²Ù×÷³É¹¦!");
		object.put("navTabId", "selling_control");
		object.put("rel", "");
		object.put("callbackType", "forward");  //closeCurrent
		object.put("forwardUrl", "selling_control");
		
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().print(object);
		ServletActionContext.getResponse().getWriter().close();
		
		return "selling_control";
	}
	
	public String queryGoodDetail() {	
		goodDetail = sellingService.getDetail(goodBarCode);
		ActionContext.getContext().put("goodDetail", goodDetail);
		return "selling_control";
	}
	
	public String queryBillList() {
		
		ActionContext.getContext().put("billList", 
				sellingService.getBillOfMaterialList(goodBarCode, 
						goodDetail.getBeginDate(), 
						goodDetail.getEndDate()));
		
		return "selling_detail";
	}
	
	public String queryReportForms() {
		
		ActionContext.getContext().put("money", sellingService.getReportForms(reportType));
		
		return "selling_report";
	}
	
	public String queryStaffShoppingList() {
		
		ActionContext.getContext().put("staffShoppingList", 
				sellingService.getStaffShoppingLists(staffId, 
						goodDetail.getBeginDate(),
						goodDetail.getEndDate()));
		
		return "selling_record";
	}
	
	public String queryGoodRank() throws Exception {
		ActionContext.getContext().put("goodRank", 
				sellingService.getGookRank(goodDetail.getBeginDate(), 
						goodDetail.getEndDate()));
		
		return "selling_rank";
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
}
