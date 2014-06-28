<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>销售控制</title>
</head>
<body>
	<div style="display: block;" class="page unitBox">
		<div class="pageHeader">
			<s:form onsubmit="return navTabSearch(this)"
				action="sellingControl!queryGoodDetail">
				<table class="searchContent">
					<tbody>
						<s:textfield name="goodBarCode" label="商品条码" />
						<tr>
							<td><br /></td>
						</tr>
					</tbody>
				</table>
				<div class="subBar">
					<div class="button">
						<div class="buttonContent">
							<button type="submit">确认</button>
						</div>
					</div>
				</div>
			</s:form>
		</div>
		<div class="pageContent">
			<form method="post" action="sellingControl!changeGoodDetail"
				class="pageForm required-validate"
				onsubmit="return validateCallback(this)">
				<div style="height: 135px; overflow: auto;"
					class="pageFormContent nowrap" layouth="97">
					<dl>
            <dt>商品条码：</dt>
            <dd>
              <s:textfield name="goodBarCode" class="textInput readonly" readonly="true"/>
            </dd>
          </dl>
					<dl>
						<dt>开始时间：</dt>
						<dd>
							<s:textfield name="goodDetail.beginDate">
								<s:param name="value">
									<s:date name="goodDetail.beginDate" format="yyyy-MM-dd" />
								</s:param>
							</s:textfield>
						</dd>
					</dl>
					<dl>
						<dt>结束时间：</dt>
						<dd>
							<s:textfield name="goodDetail.endDate">
								<s:param name="value">
									<s:date name="goodDetail.endDate" format="yyyy-MM-dd" />
								</s:param>
							</s:textfield>
						</dd>
					</dl>
					<dl>
						<dt>价格：</dt>
						<dd>
							<s:textfield name="goodDetail.sellingPrice" />
						</dd>
					</dl>
					<dl>
						<dt>供应量：</dt>
						<dd>
							<s:textfield name="goodDetail.openNumber" />
						</dd>
					</dl>
					<dl>
            <dt>备注：</dt>
            <dd>
              <s:textfield name="goodDetail.remark" />
            </dd>
          </dl>
					<div class="formBar">
						<ul>
							<li>
								<div class="buttonActive">
									<div class="buttonContent">
										<button type="submit">提交</button>
									</div>
								</div>
							</li>
							<li>
								<div class="button">
									<div class="buttonContent">
										<button type="button" class="close">取消</button>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>