<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>����</title>
</head>
<body>
	<div class="pageHeader">
		<s:form onsubmit="return navTabSearch(this)"
			action="purchaseControl!showPurchaseList.action">
			<table class="searchContent">
				<tbody>
          <tr><td>��ʼ���ڣ�
            <input type="text" name="beginDate" class="date" size="30" />
            <a class="inputDateButton" href="javascript:;">ѡ��</a>
				  </td></tr>
					<tr>
						<td><br /></td>
					</tr>
					<tr><td>�������ڣ�
            <input type="text" name="endDate" class="date" size="30" />
            <a class="inputDateButton" href="javascript:;">ѡ��</a>
          </td></tr>
				</tbody>
			</table>
			<div class="subBar">
				<div class="button">
					<div class="buttonContent">
						<button type="submit">ȷ��</button>
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
						<td>��Ʒ����</td>
						<td>��������</td>
						<td>�����۸�</td>
						<td>����ʱ��</td>
						<td>����ʱ��</td>
						<td>��������</td>
					</tr>
					<s:iterator value="purchaseList" status="status">
						<tr>
							<td>${good.getGoodName()}</td>
							<td>${number}</td>
							<td>${importPrice}</td>
							<td><s:date name="%{date.getTime()}" format="yyyy-MM-dd" /></td>
							<td><s:date name="%{limitDate.getTime()}" format="yyyy-MM-dd" /></td>
							<td>${supplier.getSupplierName()}</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>






