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
  <form method="post" action="staffManage!registerStaff.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
    <div class="pageFormContent" layoutH="56">
      <p>
        <label>������</label>
        <input name="staffName" class="required" type="text" size="30"/>
      </p>
      <p>
        <label>���룺</label>
        <input name="password" class="required" type="password" size="30" alt="����������"/>
      </p>
      <p>
        <label>�Ա�</label>
        <select name="sex" class="required combox">
          <option value="��" selected>��</option>
          <option value="Ů" >Ů</option>
        </select>
      </p>
      <p>
        <label>�������ڣ�</label>
        <input type="text" name="birthday" class="date" size="30" /><a class="inputDateButton" href="javascript:;">ѡ��</a>
      </p>
      <p>
        <label>��ϵ��ʽ��</label>
        <input name="telephone" class="required" type="text" size="30"/>
      </p>
      <p>
        <label>ְλ��</label>
        <select name="job" class="required combox">
          <option value="����Ա" selected>����Ա</option>
          <option value="���о���">���о���</option>
          <option value="�ܾ���">�ܾ���</option>
        </select>
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