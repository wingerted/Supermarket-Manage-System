<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>���۲�ѯ</title>
</head>
<body>
	<div class="pageHeader">
		<s:form onsubmit="return navTabSearch(this)"
			action="sellingControl!queryBillList">
			<table class="searchContent">
				<tbody>
					<s:textfield name="goodBarCode" label="��Ʒ����"></s:textfield>
					<tr>
						<td><br /></td>
					</tr>
					    <tr><td>��ʼ����</td><td>
          <input type="text" name="beginDate" class="date" size="30" />
            <a class="inputDateButton" href="javascript:;">ѡ��</a>
            </td></tr>
					<tr>
						<td><br /></td>
					</tr>
					    <tr><td>��������</td><td>
          <input type="text" name="endDate" class="date" size="30" />
            <a class="inputDateButton" href="javascript:;">ѡ��</a>
            </td></tr>
				</tbody>
			</table>
			<div class="subBar">
				<div class="button">
					<div class="buttonContent">
						<button type="submit">��ѯ������ϸ</button>
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
						<td>��������</td>
						<td>��������</td>
					</tr>
					<s:iterator value="billList" status="status">
						<tr>
							<td><s:date name="%{date.getTime()}" format="yyyy-MM-dd" /></td>
							<td>${number}</td>		
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>