<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
function jump(p,s){
	var oForm = document.searchForm || document.forms[0];
	with(oForm){
		page.value = p ;
        itemsPerPage.value = s ;
		submit();
	}
}
</script>
<table>
	<tr>
		<td>
			第${paginator.page }/${paginator.pages }页 共${paginator.items }条
			<c:choose>
				<c:when test="${paginator.page==1 }">
					首页
					上一页
				</c:when>
				<c:otherwise>
					<a href="javascript:jump(1,${paginator.itemsPerPage })">首页</a>
					<a href="javascript:jump(${paginator.page-1 },${paginator.itemsPerPage })">上一页</a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${paginator.page==paginator.pages }">
					下一页
					末页
				</c:when>
				<c:otherwise>
					<a href="javascript:jump(${paginator.page+1 },${paginator.itemsPerPage })">下一页</a>
					<a href="javascript:jump(${paginator.pages},${paginator.itemsPerPage })">末页</a>
				</c:otherwise>
			</c:choose>
			跳转到：
			<input type="text" id="pageId" value="${paginator.page }" style="width:20px;">
			<input type="button" value="GO" onclick="jump(document.getElementById('pageId').value,${paginator.itemsPerPage })">
			每页显示
			<select onchange="jump(1,this.value)">
				<option value="3" ${paginator.itemsPerPage==3?"selected":"" }>3</option>
				<option value="5" ${paginator.itemsPerPage==5?"selected":"" }>5</option>
				<option value="10" ${paginator.itemsPerPage==10?"selected":"" }>10</option>
				<option value="15" ${paginator.itemsPerPage==15?"selected":"" }>15</option>
				<option value="20" ${paginator.itemsPerPage==20?"selected":"" }>20</option>
			</select>
			条
		</td>
	</tr>
</table>