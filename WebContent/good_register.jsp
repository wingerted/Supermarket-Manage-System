<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>ע��</title>
</head>
<body>
<div class="pageContent">
  <form method="post" action="cashierGood!RegisterGood.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
    <div class="pageFormContent" layoutH="56">
      <p>
        <label>��Ʒ���룺</label>
        <input name="good.goodBarCode" class="required" type="text" size="30"/>
      </p>
      <p>
        <label>��Ʒ���ƣ�</label>
        <input name="good.goodName" class="required" type="text" size="30"/>
      </p>
      <p>
        <label>�����ڣ�</label>
        <input name="good.shelfLife" class="required" type="text" size="30"/>
      </p>
      <p>
        <label>���</label>
        <input name="good.category" class="required" type="text" size="30"/>
      </p>
      <p>
        <label>��Ӧ�̱�ţ�</label>
        <input name="good.supplier.supplierId" class="required" type="text" size="30"/>
      </p>
    </div>
    <div class="formBar">
      <ul>
        <li><div class="buttonActive"><div class="buttonContent"><button type="submit">����</button></div></div></li>
        <li>
          <div class="button"><div class="buttonContent"><button type="button" class="close">ȡ��</button></div></div>
        </li>
      </ul>
    </div>
  </form>
</div>
</body>
</html>