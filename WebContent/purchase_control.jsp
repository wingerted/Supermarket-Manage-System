<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>进货管理</title>
</head>
<body>
<div class="pageHeader">
  <s:form onsubmit="return navTabSearch(this)" action="purchaseControl!createPurchasePlan.action">
    <div class="searchBar">
      <div class="buttonActive">
        <button class="buttonContent" type="submit">生成进货计划</button>
      </div>
    </div>
  </s:form>
</div>

<form action="purchaseControl!confirmPurchasePlan.action"
    onsubmit="return validateCallback(this, navTabAjaxDone)">
  <div class="pageContent">
    <div id="w_list_print">
      <table class="table" width="98%">
        <tbody>
          <tr>
            <td>商品名称</td>
            <td>进货数量</td>
            <td>进货价格</td>
            <td>进货时间</td>
            <td>过期时间</td>
            <td>供货商名</td>
          </tr>
          <s:iterator value="#session.purchaseRecordList" status="status">
            <tr> 
              <td>${good.getGoodName()}</td>
              <td><input type="text" name="purchaseNum" value="${number}" /></td>
              <td>${importPrice}</td>
              <td><s:date name="%{date.getTime()}" format="yyyy-MM-dd"/></td>
              <td><s:date name="%{limitDate.getTime()}" format="yyyy-MM-dd"/></td>
              <td>${supplier.getSupplierName()}</td>
            </tr>
          </s:iterator>
        </tbody>
      </table>
    </div>
  </div>
  <div class="formBar">
    <ul>
      <li>
        <div class="buttonActive">
          <button class="buttonContent" type="submit">确定进货</button>
        </div>
      </li>
    </ul>
  </div>  
</form>
</body>
</html>