<%@ page language="java" contentType="text/html; charset=GB2312"
  pageEncoding="GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>登录</title>
<link href="themes/css/login.css" rel="stylesheet" type="text/css" />
</head>

<body>
  <div id="login">
    <div id="login_header">
      <h1 class="login_logo">
        <a href="http://demo.dwzjs.com"><img
          src="themes/default/images/login_logo.gif" /></a>
      </h1>
      <div class="login_headerContent">
        <div class="navList">
        </div>
        <h2 class="login_title">
          <img src="themes/default/images/login_title.png" />
        </h2>
      </div>
    </div>
    <div id="login_content">
      <div class="loginForm">
        <s:form action="staffManage!loginStaff.action">
          <p>
            <label>工号：</label> <input type="text" name="staffId" size="20"
              class="login_input" />
          </p>
          <p>
            <label>密码：</label> <input type="password" name="password"
              size="20" class="login_input" />
          </p>
          <div class="login_bar">
            <input class="sub" type="submit" value=" " />
          </div>
        </s:form>
      </div>
      <div class="login_banner">
        <img src="themes/default/images/login_banner.jpg" />
      </div>
      <div class="login_main"></div>
    </div>
    <div id="login_footer">Copy LEFT!!! &copy; 2012 Wingerted Inc.
      All Rights Reserved.</div>
  </div>
</body>


</html>