<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>库存管理</title>
</head>
<body>
	<div class="pageHeader">
		<s:form onsubmit="return navTabSearch(this)"
			action="inventoryManage!queryInventory.action">
			<div class="subBar">
				<div class="button">
					<div class="buttonContent">
						<button type="submit">查询库存</button>
					</div>
				</div>
			</div>
		</s:form>
	</div>
	<div class="pageContent">
		<div id="w_list_print">
			<table class="table" width="98%">
				<tbody>
					<tr>
						<td>商品名称</td>
						<td>库存数量</td>
						<td>库存状态</td>
					</tr>
					<s:iterator value="inventoryList" status="status">
						<tr>
							<td>${good.getGoodName()}</td>
							<td>${totalNumber}</td>
							<td>${state}</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
