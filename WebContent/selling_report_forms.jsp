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
			action="sellingControl!queryReportForms">
			<table class="searchContent">
				<tbody>
				  <tr><td>
					<select class="combox" name="reportType">
                <option value="">选择报表类型</option>
                <option value="日表">上一日</option>
                <option value="月表">上一月</option>
                <option value="年表">上一年</option>
            </select>
         <td><tr>
				</tbody>
			</table>
			<div class="subBar">
				<div class="button">
					<div class="buttonContent">
						<button type="submit">查询报表</button>
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
						<td>销售盈利</td>
					</tr>
						<tr>
							<td>${money}</td>		
						</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>