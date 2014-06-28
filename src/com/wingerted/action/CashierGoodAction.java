package com.wingerted.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wingerted.entity.Good;
import com.wingerted.entity.ShoppingList;
import com.wingerted.entity.Staff;
import com.wingerted.service.CashierService;

public class CashierGoodAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CashierService cashierService;
	private ShoppingList shoppingList;
	private Long goodBarCode;
	private Long number;
	private Float actuallyPay;
	private Long vipId;
	private String goodName;
	private Good good;

	public String getGoodName() {
		return goodName;
	}
 	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public CashierService getCashierService() {
		return cashierService;
	}

	public void setCashierService(CashierService cashierService) {
		this.cashierService = cashierService;
	}

	public ShoppingList getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(ShoppingList shoppingList) {
		this.shoppingList = shoppingList;
	}

	public Long getGoodBarCode() {
		return goodBarCode;
	}

	public void setGoodBarCode(Long goodBarCode) {
		this.goodBarCode = goodBarCode;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
	public Float getActuallyPay() {
		return actuallyPay;
	}

	public void setActuallyPay(Float actuallyPay) {
		this.actuallyPay = actuallyPay;
	}

	public Long getVipId() {
		return vipId;
	}

	public void setVipId(Long vipId) {
		this.vipId = vipId;
	}

	public String buyGoods() {
		ActionContext context = ActionContext.getContext();
		if (context.getSession().containsKey("shoppingList")) {
			shoppingList = (ShoppingList)context.getSession().get("shoppingList");
		} else {
			shoppingList.getShoppingDetails().clear();
		}
		 
		if (!cashierService.buyGoods(goodBarCode, number, shoppingList)) {
			return INPUT;
		}
	
		context.getSession().put("shoppingList", shoppingList);

		return SUCCESS;
	}
	
	public String searchGood() throws Exception {	
		ActionContext.getContext().put("goodList", cashierService.searchGood(goodName));
		return "search";
	}
	
	public String confirmVIP() throws IOException {
		ShoppingList shoppingList = (ShoppingList)ActionContext.getContext()
										.getSession()
										.get("shoppingList");
		
		cashierService.createShoppingList(shoppingList, vipId);
		
		JSONObject object=new JSONObject();
		object.put("statusCode", "200");
		object.put("message", "操作成功!");
		object.put("navTabId", "good_buy");
		object.put("rel", "");
		object.put("callbackType", "closeCurrent");  //closeCurrent
		object.put("forwardUrl", "");
		
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().print(object);
		ServletActionContext.getResponse().getWriter().close();
		
		return "cashier";
	}
	
	public String cashierShoppingList() throws IOException {
		shoppingList = ((ShoppingList) ActionContext.getContext().getSession()
							.get("shoppingList"));
		cashierService.createShoppingList(shoppingList, vipId);
		shoppingList.setStaffId(((Staff)ActionContext.getContext()
			.getSession().get("staff")).getStaffId());
		shoppingList.setActuallyPay(actuallyPay);
		
		cashierService.cashierShoppingList(shoppingList);
	
		JSONObject object=new JSONObject();
		object.put("statusCode", "200");
		object.put("message", "操作成功!\n需要找零：" + shoppingList.getChange());
		object.put("navTabId", "good_buy");
		object.put("rel", "");
		object.put("callbackType", "closeCurrent");  //closeCurrent
		object.put("forwardUrl", "");
		
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().print(object);
		ServletActionContext.getResponse().getWriter().close();
		
		ActionContext.getContext().getSession().remove("shoppingList");
		
		return SUCCESS;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
}