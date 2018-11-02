<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/static/css/style.css" />

	<script type="application/javascript" src="<%=request.getContextPath() %>/static/js/jquery.js" ></script>
	<script type="application/javascript" src="<%=request.getContextPath() %>/static/js/common.js" ></script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">供应商管理&gt;&gt;</div>
	</div>
	<form name="form1" method="post">
		<div class="content">
		<font color="red"></font>
		<table class="box">

			<tbody>
				<c:if test="${record.id!=null}">
				<tr>
					<td class="field">供应商编号：</td>
					<td><input name="id" class="text" type="text" value="${record.id }"  readonly/></td>
				</tr>
				</c:if>
				<tr>
					<td class="field">供应商名称：</td>
					<td><input name="name" class="text" type="text" value="${record.name }"  />
					<font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">电话：</td>
					<td><input name="tel" class="text" type="text" value="${record.tel }"  /></td>
				</tr>
				<tr>
					<td class="field">传真：</td>
					<td><input name="fax" class="text" type="text" value="${record.fax }"  /></td>
				</tr>
				<tr>
					<td class="field">地址：</td>
					<td><textarea name="address" cols="45" rows="5" >${record.address }</textarea></td>
				</tr>
				<tr>
					<td class="field">联系人：</td>
					<td><input name="contact" class="text" type="text" value="${record.contact }"  /></td>
				</tr>
				<tr>
					<td class="field">联系人电话：</td>
					<td><input name="contactTel" value="${record.contactTel }" class="text" type="text"  /></td>
				</tr>
			</tbody></table>
		</div>

		<div class="buttons">
			<input name="button" value="保存" class="input-button" type="button"
				   onclick="save('<%=request.getContextPath() %>/company/save', document.forms[0], '<%=request.getContextPath() %>/company/index')"/>
			<input name="button" onclick="history.go(-1);" value="返回" class="input-button" type="button" />
			<c:if test="${record.id!=null}">
				<input name="button" value="删除" class="input-button" type="button"
					   onclick="delete('<%=request.getContextPath() %>/company/delete', '${record.id }', '<%=request.getContextPath() %>/company/index');" />
			</c:if>
		</div>
	</form>
</div>
</body>
</html>
