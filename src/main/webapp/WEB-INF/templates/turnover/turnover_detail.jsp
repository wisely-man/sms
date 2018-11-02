<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
		<div class="title">销售流水管理&gt;&gt;</div>
	</div>
	<form name="form1" method="post" >
		<div class="content">
			<font color="red"></font>
			<table class="box">

				<tbody>
				<c:if test="${record.id!=null}">
					<tr>
						<td class="field">流水编号：</td>
						<td><input name="id" class="text" type="text" value="${record.id }"  readonly/></td>
					</tr>
				</c:if>
				<tr>
					<td class="field">商品：</td>
					<td>
						<input type="hidden" name="goodsName" value="${record.goodsName}"/>
						<select name="goodsId" class="text">
							<c:forEach var="item" items="${goodsList }" varStatus="s">
								<option value="${item.id}" ${record.goodsId==item.id?"selected":""}>${item.name}</option>
							</c:forEach>
						</select>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="field">数量：</td>
					<td>
						<input name="goodsNum" class="text" type="text" value="${record.goodsNum }"  />
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="field">供应商：</td>
					<td>
						<input type="hidden" name="companyName" value="${record.companyName}"/>
						<select name="companyId" class="text">
							<option value="">--请选择--</option>
							<c:forEach var="item" items="${companyList }" varStatus="s">
								<option value="${item.id}" ${record.companyId==item.id?"selected":""}>${item.name}</option>
							</c:forEach>
						</select>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="field">操作类型：</td>
					<td>
						<select name="optType" class="text">
							<option value="">--请选择--</option>
							<c:forEach var="item" items="${optTypeMap }" varStatus="s">
								<option value="${item.key}" ${record.optType==item.key?"selected":""}>${item.value}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<c:if test="${record.id!=null}">
				<tr>
					<td class="field">操作人：</td>
					<td><input class="text" type="text" value="${record.operator.userName }"  /></td>
				</tr>
				<tr>
					<td class="field">操作时间：</td>
					<td><input class="text" type="text" value="<fmt:formatDate value="${record.optTime }" pattern="yyyy-MM-dd HH:mm:ss"  />" /></td>
				</tr>
				</c:if>
				</tbody>
			</table>
		</div>

		<div class="buttons">
			<input name="button" value="保存" class="input-button" type="button"
				onclick="save('<%=request.getContextPath() %>/turnover/save', document.forms[0], '<%=request.getContextPath() %>/turnover/index')"/>
			<input name="button" onclick="history.go(-1);" value="返回" class="input-button" type="button" />
			<c:if test="${record.id!=null}">
				<input name="button" value="删除" class="input-button" type="button"
					   onclick="delete('<%=request.getContextPath() %>/turnover/delete', '${record.id }', '<%=request.getContextPath() %>/turnover/index');" />
			</c:if>
		</div>
	</form>
</div>
</body>
</html>

<script type="application/javascript">
	$("select").change(function(){
	    var _td = $(this).closest("td");
	    var _input = _td.find("input[type=hidden]");
	    if(_input.length == 0){
	        return;
		}

		_input.val($(this).find("option:selected").text());
	});
</script>