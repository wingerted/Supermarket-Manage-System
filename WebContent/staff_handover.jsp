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
<div class="navTab-panel tabsPageContent layoutBox">
          <div class="page unitBox">
            <div class="accountInfo">
              <div class="alertInfo">
                <h2>
                                                请确认信息后立即登出
                </h2>
                </div>
                <p>
                员工编号： ${staff.getStaffId()}
                </p>
                      <p>
                员工姓名： ${staff.getStaffName()}
                </p>
                </div>
                </div>
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
						<s:iterator value="sumGoodMap" status="status">
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
				<li>总计：${sumMoney}</li>
			</ul>
	</div>
</body>
</html>
