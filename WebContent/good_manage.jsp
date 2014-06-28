<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工管理</title>
</head>
<body>
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="staffManage!searchStaff.action"
			method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>员工号：<input type="text" name="staffId" />
						</td>
						<td><select class="combox" name="job">
								<option value="">选择职位</option>
								<option value="收银员">收银员</option>
								<option value="超市经理">超市经理</option>
								<option value="总经理">总经理</option>
						</select></td>
					</tr>
				</table>
				<div class="subBar">
					<ul>
						<li>
							<div class="buttonActive">
								<div class="buttonContent">
									<button type="submit">检索</button>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</form>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="staff_register.jsp" target="navTab"><span>添加</span></a></li>
				<li><a class="delete" href="staffManage!deleteStaff.action?staff.staffId={staffId}"
					target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
				<li><a class="edit" href="staffManage!showStaff.action?staff.staffId={staffId}"
					target="navTab"><span>修改</span></a></li>
				<li class="line">line</li>
			</ul>
		</div>
		<table class="table" width="100%" layoutH="138" align="center">
			<thead>
				<tr>
					<th>员工号</th>
					<th>员工姓名</th>
					<th>员工性别</th>
					<th>员工生日</th>
					<th>员工联系方式</th>
					<th>员工职务</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="staffList" status="status">
					<tr target="staffId" rel="${staffId}" align="center">
						<td>${staffId}</td>
						<td>${staffName}</td>
						<td>${sex}</td>
						<td><s:date name="birthday" format="yyyy-MM-dd" /></td>
						<td>${telephone}</td>
						<td>${job}</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>
</html>