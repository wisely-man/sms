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
            商品名称：
            <input name="name" class="input-text" type="text" value="${record.name }"/>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input value="组 合 查 询" type="submit" />
        </form></td></tr></tbody></table>
</div>
<div class="main">
    <div class="optitle clearfix">
        <em><input value="添加数据" class="input-button" onclick="window.location.href='<%=request.getContextPath() %>/goods/toAdd';" type="button" /></em>
        <div class="title">商品管理&gt;&gt;</div>
    </div>

    <div class="content">
        <table class="list">
            <tbody>
            <tr>
                <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
                <td width="200"><div class="STYLE1" align="center">商品名称</div></td>
                <td width="150"><div class="STYLE1" align="center">品类</div></td>
                <td width="100"><div class="STYLE1" align="center">单价</div></td>
                <td width="100"><div class="STYLE1" align="center">规格</div></td>
            </tr>
            <c:forEach var="item" items="${goodsList }" varStatus="s">
                <tr>
                    <td width="70" height="29"><div class="STYLE1" align="center">${item.id }</div></td>
                    <td width="200"><div class="STYLE1" align="center">
                        <a href="<%=request.getContextPath() %>/goods/detail?id=${item.id }">${item.name }</a></div></td>
                    <td width="150"><div class="STYLE1" align="center">${categoryMap.get(item.category) }</div></td>
                    <td width="100"><div class="STYLE1" align="center">${item.unitPrice }</div></td>
                    <td width="100"><div class="STYLE1" align="center">${item.standards }</div></td>
                </tr>
            </c:forEach>
            </tbody></table>
        <%@ include file="../common/page.jsp" %>
    </div>
</div>
</body></html>