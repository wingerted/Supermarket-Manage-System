<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>修改</title>
</head>
<body>
<div class="pageContent">
  <form method="post" action="staffManage!editStaff.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
    <div class="pageFormContent" layoutH="56">
      <p>
        <label>工号：</label>
        <s:textfield name="staff.staffId" size="30" readonly="readonly"></s:textfield>
      </p>
      <p>
        <label>姓名：</label>
        <s:textfield name="staff.staffName" class="required" size="30"></s:textfield>
      </p>
      <p>
        <label>性别：</label>
        <select name="staff.sex" class="required combox">
          <option value="男" selected>男</option>
          <option value="女" >女</option>
        </select>
      </p>
      <p>
        <label>出生日期：</label>
        <s:textfield name="staff.birthday">
            <s:param name="value">
              <s:date name="staff.birthday" format="yyyy-MM-dd" />
            </s:param>
        </s:textfield>
      </p>
      <p>
        <label>工号：</label>
        <s:textfield name="staff.telephone" size="30" class="required"></s:textfield>
      </p>
      <p>
        <label>职位：</label>
        <select name="staff.job" class="required combox">
          <option value="收银员" selected>收银员</option>
          <option value="超市经理">超市经理</option>
          <option value="总经理">总经理</option>
        </select>
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