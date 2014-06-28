
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
			action="sellingControl!queryStaffShoppingList.action">
			<table class="searchContent">
				<tbody>
					<s:textfield name="staffId" label="����Ա���� "></s:textfield>
					<tr>
						<td><br /></td>
					</tr>
					<s:textfield name="beginDate" label="��ʼʱ��">
						<s:param name="value">
							<s:date name="beginDate" format="yyyy-MM-dd" />
						</s:param>
					</s:textfield>
					<tr>
						<td><br /></td>
					</tr>
					<s:textfield name="endDate" label="����ʱ��">
						<s:param name="value">
							<s:date name="endDate" format="yyyy-MM-dd" />
						</s:param>
					</s:textfield>
				</tbody>
			</table>
			<div class="subBar">
				<div class="button">
					<div class="buttonContent">
						<button type="submit">��ѯԱ��������¼</button>
					</div>
				</div>
			</div>
		</s:form>
	</div>
	<div class="pageContent">
		<div id="w_list_print">
			<table class="table" width="98%" layoutH="150">
				<tbody>
					<s:iterator value="staffShoppingList" status="status">
						<td>��ˮ�ţ�${serialNumber}</td>
						<td>ʱ�䣺<s:date name="%{time.getTime()}"
								format="yyyy-MM-dd-hh:mm:ss" />
						</td>
						<tr>
							<s:iterator value="goodMap" status="status">
								<tr>
									<td><s:property value="%{key.getGoodName()}" /></td>
									<td><s:property value="value" /></td>
								</tr>
							</s:iterator>
						<tr>
							<td>Ӧ����${shouldPay}</td>
							<td>ʵ����${actuallyPay}</td>
						</tr>
						<tr>
							<td>�ۿۣ�${discount}</td>
							<td>���㣺${change}</td>
						</tr>
						<tr>
							<td><br /></td>
							<td><br /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
  </div>
</body>
</html>