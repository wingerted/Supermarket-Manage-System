<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>库存管理</title>
</head>
<body>
	<div class="pageHeader">
    <s:form onsubmit="return navTabSearch(this)"
      action="inventoryManage!checkInventory.action">
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
            <button type="submit">库存盘点</button>
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
      <td>商品名称</td>
      <td>商品销量</td>
      <td>商品盈利</td>
    </tr>
		<s:iterator value="checkList" status="status">
      <tr>
        <td>${good.getGoodName()}</td>
        <td>${sellNumber}</td>
        <td>${profit}</td>
      </tr>
    </s:iterator>
		</tbody>
		</table>
		</div>
		</div>

</body>
</html>