<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/static/css/style.css" />
<script type="text/javascript">
</script>
</head>
<body>
<div class="menu">
<table><tbody><tr><td>
<form name="searchForm" method="post" action="<%=request.getContextPath() %>/company/index">
	<input type="hidden" name="page" value="${paginator.page}"/>
	<input type="hidden" name="itemsPerPage" value="${paginator.itemsPerPage}" />
	供应商名称：
	<input name="name" class="input-text" type="text" value="${record.name }"/>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input value="组 合 查 询" type="submit" />
</form></td></tr></tbody></table>
</div>
<div class="main">
<div class="optitle clearfix">
<em><input value="添加数据" class="input-button" onclick="window.location.href='<%=request.getContextPath() %>/company/toAdd';" type="button" /></em>
		<div class="title">供应商管理&gt;&gt;</div>
	</div>

	<div class="content">
<table class="list">
  <tbody>
	  <tr>
	    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
	    <td width="80"><div class="STYLE1" align="center">供应商名称</div></td>
	  	<td width="100"><div class="STYLE1" align="center">电话</div></td>
	  	<td width="100"><div class="STYLE1" align="center">传真</div></td>
	    <td width="100"><div class="STYLE1" align="center">地址</div></td>
	    <td width="100"><div class="STYLE1" align="center">联系人</div></td>
	    <td width="100"><div class="STYLE1" align="center">联系人电话</div></td>
	  </tr>
	  <c:forEach var="item" items="${companyList }" varStatus="s">
	  <tr>
	    <td width="70" height="29"><div class="STYLE1" align="center">${item.id }</div></td>
	    <td width="80"><div class="STYLE1" align="center">
	    	<a href="<%=request.getContextPath() %>/company/detail?id=${item.id }">${item.name }</a></div></td>
	    <td width="100"><div class="STYLE1" align="center">${item.tel }</div></td>
	    <td width="100"><div class="STYLE1" align="center">${item.fax }</div></td>
	    <td width="100"><div class="STYLE1" align="center">${item.address }</div></td>
	    <td width="100"><div class="STYLE1" align="center">${item.contact }</div></td>
	    <td width="100"><div class="STYLE1" align="center">${item.contactTel }</div></td>
	  </tr>
  	</c:forEach>
</tbody></table>
	<%@ include file="../common/page.jsp" %>
	</div>
</div>
</body></html>