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
  <form method="post" action="staffManage!registerStaff.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
    <div class="pageFormContent" layoutH="56">
      <p>
        <label>姓名：</label>
        <input name="staffName" class="required" type="text" size="30"/>
      </p>
      <p>
        <label>密码：</label>
        <input name="password" class="required" type="password" size="30" alt="请输入密码"/>
      </p>
      <p>
        <label>性别：</label>
        <select name="sex" class="required combox">
          <option value="男" selected>男</option>
          <option value="女" >女</option>
        </select>
      </p>
      <p>
        <label>出生日期：</label>
        <input type="text" name="birthday" class="date" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
      </p>
      <p>
        <label>联系方式：</label>
        <input name="telephone" class="required" type="text" size="30"/>
      </p>
      <p>
        <label>职位：</label>
        <select name="job" class="required combox">
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