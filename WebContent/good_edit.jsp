<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>�޸�</title>
</head>
<body>
<div class="pageContent">
  <form method="post" action="staffManage!editStaff.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
    <div class="pageFormContent" layoutH="56">
      <p>
        <label>���ţ�</label>
        <s:textfield name="staff.staffId" size="30" readonly="readonly"></s:textfield>
      </p>
      <p>
        <label>������</label>
        <s:textfield name="staff.staffName" class="required" size="30"></s:textfield>
      </p>
      <p>
        <label>�Ա�</label>
        <select name="staff.sex" class="required combox">
          <option value="��" selected>��</option>
          <option value="Ů" >Ů</option>
        </select>
      </p>
      <p>
        <label>�������ڣ�</label>
        <s:textfield name="staff.birthday">
            <s:param name="value">
              <s:date name="staff.birthday" format="yyyy-MM-dd" />
            </s:param>
        </s:textfield>
      </p>
      <p>
        <label>���ţ�</label>
        <s:textfield name="staff.telephone" size="30" class="required"></s:textfield>
      </p>
      <p>
        <label>ְλ��</label>
        <select name="staff.job" class="required combox">
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