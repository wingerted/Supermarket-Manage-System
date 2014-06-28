<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>确认会员</title>
</head>
<body>
	<form action="cashierGood!confirmVIP.action" method="post"
		onsubmit="return validateCallback(this, dialogAjaxDone)">
		<s:textfield name="vipId" label="会员号" />
		<s:submit value="确认" />
	</form>
</body>
</html>
