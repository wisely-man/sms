<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
            <input name="goodsName" class="input-text" type="text" value="${record.goodsName }"/>
            &nbsp;&nbsp;&nbsp;&nbsp;
            供应商名称：
            <input name="companyName" class="input-text" type="text" value="${record.companyName }"/>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input value="组 合 查 询" type="submit" />
        </form></td></tr></tbody></table>
</div>
<div class="main">
    <div class="optitle clearfix">
        <em><input value="添加数据" class="input-button" style="margin-left: 5px;" onclick="window.location.href='<%=request.getContextPath() %>/turnover/toAdd';" type="button" /></em>
        <em><input value="导出" class="input-button" onclick="window.location.href='<%=request.getContextPath() %>/turnover/export';" type="button" /></em>
        <div class="title">销售流水&gt;&gt;</div>
    </div>

    <div class="content">
        <table class="list">
            <tbody>
            <tr>
                <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
                <td width="100"><div class="STYLE1" align="center">商品类别</div></td>
                <td width="200"><div class="STYLE1" align="center">商品名称</div></td>
                <td width="200"><div class="STYLE1" align="center">供应商名称</div></td>
                <td width="100"><div class="STYLE1" align="center">数量</div></td>
                <td width="100"><div class="STYLE1" align="center">操作类型</div></td>
                <td width="100"><div class="STYLE1" align="center">操作人</div></td>
                <td width="100"><div class="STYLE1" align="center">操作时间</div></td>
            </tr>
            <c:forEach var="item" items="${turnoverList }" varStatus="s">
                <tr>
                    <td width="70" height="29"><div class="STYLE1" align="center">${item.id }</div></td>
                    <td width="100"><div class="STYLE1" align="center">${categoryMap.get(item.goods.category) }</div></td>
                    <td width="200"><div class="STYLE1" align="center">
                        <a href="<%=request.getContextPath() %>/turnover/detail?id=${item.id }">${item.goods.name }</a></div></td>
                    <td width="200"><div class="STYLE1" align="center">${item.company.name }</div></td>
                    <td width="100"><div class="STYLE1" align="center">${item.goodsNum }</div></td>
                    <td width="100"><div class="STYLE1" align="center">${optTypeMap.get(item.optType)}</div></td>
                    <td width="100"><div class="STYLE1" align="center">${item.operator.userName }</div></td>
                    <td width="100"><div class="STYLE1" align="center"><fmt:formatDate value="${item.optTime }" pattern="yyyy-MM-dd HH:mm:ss"/></div></td>
                </tr>
            </c:forEach>
            </tbody></table>
        <%@ include file="../common/page.jsp" %>
    </div>
</div>
</body></html>