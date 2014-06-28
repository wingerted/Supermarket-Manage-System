<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>销售查询</title>
</head>
<body>
	<div class="pageHeader">
		<s:form onsubmit="return navTabSearch(this)"
			action="sellingControl!queryGoodRank.action">
			<table class="searchContent">
				<tbody>
					    <tr><td>
          <input type="text" name="beginDate" class="date" size="30" />
            <a class="inputDateButton" href="javascript:;">选择</a>
            </td></tr>
					<tr>
						<td><br /></td>
					</tr>
					    <tr><td>
          <input type="text" name="endDate" class="date" size="30" />
            <a class="inputDateButton" href="javascript:;">选择</a>
            </td></tr>
				</tbody>
			</table>
			<div class="subBar">
				<div class="button">
					<div class="buttonContent">
						<button type="submit">查询销售排名</button>
					</div>
				</div>
			</div>
		</s:form>
	</div>
	<div class="pageContent">
		<div id="w_list_print">
			<table class="table" width="98%" layoutH="150">
				<tbody>
					<tr>
						<td>商品名称</td>
						<td>销售数量</td>
					</tr>
					<s:iterator value="goodRank" status="status">
						<tr>
							<td><s:property value="%{value.getGoodName()}" /></td>
							<td><s:property value="key" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>