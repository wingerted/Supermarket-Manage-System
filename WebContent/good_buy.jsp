<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>收银</title>
</head>
<body>

	<div class="pageHeader">
		<s:form onsubmit="return navTabSearch(this)"
			action="cashierGood!buyGoods.action">
			<table class="searchContent">
				<tbody>
					<s:textfield name="goodBarCode" label="商品条码" />
					<tr>
						<td><br /></td>
					</tr>
					<s:textfield name="number" label="数量" />
				</tbody>
			</table>

			<div class="subBar">
				<div class="button">
					<div class="buttonContent">
						<button type="submit">确认</button>
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
						<td>商品条码</td>
						<td>商品名称</td>
						<td>商品类别</td>
						<td>商品价格</td>
						<td>商品数量</td>
					</tr>
					<tr>
						<s:iterator value="#session.shoppingList.shoppingDetails" status="status">
							<tr>
								<td><s:property value="%{key.getGoodBarCode()}" /></td>
								<td><s:property value="%{key.getGoodName()}" /></td>
								<td><s:property value="%{key.getCategory()}" /></td>
								<td><s:property value="%{key.getSellingPrice()}" /></td>
								<td><s:property value="value" /></td>
							</tr>
						</s:iterator>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="formBar">
			<ul>
				<li>总计：${session.shoppingList.shouldPay}</li>
				<li>折扣：${session.shoppingList.discount}</li>
				<li>应付：${session.shoppingList.shouldPay + session.shoppingList.discount}</li>
				<li>
					<a class="buttonActive" target="dialog" href="good_pay.jsp">
            <span>付款</span>
          </a>
					<a class="buttonActive" target="dialog" href="vip_confirm.jsp">
					  <span>确认会员</span>
					</a>
				</li>
			</ul>
	</div>
</body>
</html>
