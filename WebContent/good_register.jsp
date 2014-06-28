<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>注册</title>
</head>
<body>
<div class="pageContent">
  <form method="post" action="cashierGood!RegisterGood.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
    <div class="pageFormContent" layoutH="56">
      <p>
        <label>商品条码：</label>
        <input name="good.goodBarCode" class="required" type="text" size="30"/>
      </p>
      <p>
        <label>商品名称：</label>
        <input name="good.goodName" class="required" type="text" size="30"/>
      </p>
      <p>
        <label>保质期：</label>
        <input name="good.shelfLife" class="required" type="text" size="30"/>
      </p>
      <p>
        <label>类别：</label>
        <input name="good.category" class="required" type="text" size="30"/>
      </p>
      <p>
        <label>供应商编号：</label>
        <input name="good.supplier.supplierId" class="required" type="text" size="30"/>
      </p>
    </div>
    <div class="formBar">
      <ul>
        <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
        <li>
          <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
        </li>
      </ul>
    </div>
  </form>
</div>
</body>
</html>