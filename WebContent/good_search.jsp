<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>搜索商品</title>
</head>
<body>
	<div class="pageHeader">
		<s:form onsubmit="return navTabSearch(this)" action="cashierGood!searchGood.action">
			<table class="searchContent">
        <tbody>
          <s:textfield name="goodName" label="商品名称" />
          <tr>
            <td><br /></td>
          </tr>
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
	<form action="cashier!Good.action"
		onsubmit="return validateCallback(this, navTabAjaxDone)">
		<div class="pageContent">
			<div id="w_list_print">
				<table class="table" width="98%">
					<tbody>
						<tr>
							<td>商品条码</td>
							<td>商品名称</td>
							<td>商品类别</td>
							<td>商品价格</td>
							<td>供货商名</td>
						</tr>
						<s:iterator value="goodList" status="status">
							<tr>
								<td>${goodBarCode}</td>
								<td>${goodName}</td>
								<td>${category}</td>
								<td>${sellingPrice}</td>
								<td>${supplier.getSupplierName()}</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
	</form>
</body>
</html>