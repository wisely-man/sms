<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/static/css/style.css" />
</head>
<body class="frame-bd">
<ul class="left-menu">

	<%-- 商品管理 --%>
	<li>
		<a href="<%=request.getContextPath() %>/goods/index" target="mainFrame">
			<img src="<%=request.getContextPath() %>/static/images/btn_users.png" /></a>
	</li>
	<%-- 供应商管理 --%>
	<li>
		<a href="<%=request.getContextPath() %>/company/index" target="mainFrame">
		<img src="<%=request.getContextPath() %>/static/images/btn_suppliers.gif" /></a>
	</li>
	<%-- 销售流水 --%>
	<li>
		<a href="<%=request.getContextPath() %>/turnover/index" target="mainFrame">
		<img src="<%=request.getContextPath() %>/static/images/btn_bill.gif" /></a>
	</li>

	<li>
		<a target="_top" href="<%=request.getContextPath() %>/login/loginOut" >
			<img src="<%=request.getContextPath() %>/static/images/btn_exit.gif" />
		</a>
	</li>
</ul>
</body>
</html>
