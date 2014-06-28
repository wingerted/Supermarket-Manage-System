package com.wingerted.action;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import com.wingerted.entity.Good;
import com.wingerted.entity.Staff;
import com.wingerted.service.StaffService;

public class StaffManageAction extends ActionSupport 
	implements ModelDriven<Staff> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Staff staff;
	private StaffService staffService;
	
	
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public StaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	public String searchStaff() {
		
		if (staff.getStaffId() != null) {
			ActionContext.getContext().put("staffList", staffService.searchStaff(staff.getStaffId()));
		} else if (staff.getJob() != null) {
			ActionContext.getContext().put("staffList", staffService.searchStaff(staff.getJob()));
		}

		return "search";	
		
	}

	public String registerStaff() throws Exception {	
		staffService.regiesterStaff(staff);
		
		JSONObject object=new JSONObject();
		object.put("statusCode", "200");
		object.put("message", "操作成功!\n您的员工号为：" + staff.getStaffId());
		object.put("navTabId", "staff_manage");
		object.put("rel", "");
		object.put("callbackType", "closeCurrent");
		object.put("forwardUrl", "");
		
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().print(object);
		ServletActionContext.getResponse().getWriter().close();
		
		return "register";
	}
	
	public String showStaff() {

		ActionContext.getContext().put("staff", staffService.searchStaff(staff.getStaffId()).get(0));
		
		staff = staffService.searchStaff(staff.getStaffId()).get(0);

		return "show";	
	}
	
	public String editStaff() throws Exception {
		staffService.editStaff(staff);
		
		JSONObject object=new JSONObject();
		object.put("statusCode", "200");
		object.put("message", "操作成功!");
		object.put("navTabId", "staff_manage");
		object.put("rel", "");
		object.put("callbackType", "closeCurrent");
		object.put("forwardUrl", "");
		
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().print(object);
		ServletActionContext.getResponse().getWriter().close();
		
		return "edit";
	}
	
	public String loginStaff() {	
		staff = staffService.loginStaff(staff);
		if (staff != null) {
			staff.setLoginTime(Calendar.getInstance());
			
			ActionContext.getContext().getSession().put("staff", staff);
			if (staff.getJob().equals("收银员")) {
				return "cashier";
			} else if (staff.getJob().equals("超市经理")){
				return "manager";
			}
		}
		return "login";
	}
	
	public String logoutStaff() {	
		staff = (Staff)ActionContext.getContext().getSession().get("staff");
		if (staff.getJob().equals("收银员")) {
			Map<Good, Long> sumGoodMap = new HashMap<Good, Long>();
			Float sumMoney = staffService.logoutStaff(staff, sumGoodMap);
			
			ActionContext.getContext().put("sumMoney", sumMoney);
			ActionContext.getContext().put("sumGoodMap", sumGoodMap);
			ActionContext.getContext().put("staff", staff);
		}

		ActionContext.getContext().getSession().remove("staff");
		return "handover";
	}
	
	public String deleteStaff() throws Exception {
		staffService.deleteStaff(staff);
		
		JSONObject object=new JSONObject();
		object.put("statusCode", "200");
		object.put("message", "操作成功!");
		object.put("navTabId", "staff_manage");
		object.put("rel", "");
		object.put("callbackType", "");
		object.put("forwardUrl", "");
		
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().print(object);
		ServletActionContext.getResponse().getWriter().close();
		return "delete";	
	}
	
	@Override
	public Staff getModel() {

		return staff;
	}

}
