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
			action="sellingControl!queryReportForms">
			<table class="searchContent">
				<tbody>
				  <tr><td>
					<select class="combox" name="reportType">
                <option value="">ѡ�񱨱�����</option>
                <option value="�ձ�">��һ��</option>
                <option value="�±�">��һ��</option>
                <option value="���">��һ��</option>
            </select>
         <td><tr>
				</tbody>
			</table>
			<div class="subBar">
				<div class="button">
					<div class="buttonContent">
						<button type="submit">��ѯ����</button>
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
						<td>����ӯ��</td>
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