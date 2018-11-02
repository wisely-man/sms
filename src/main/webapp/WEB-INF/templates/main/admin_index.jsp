<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>商品销售管理系统</title>
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/static/css/style.css" />
</head>
<frameset rows="100,*" cols="*" >
	<frame src="<%=request.getContextPath() %>/login/top" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
	<frameset cols="200,*" >
		<frame src="<%=request.getContextPath() %>/login/left" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" />
		<frame src="<%=request.getContextPath() %>/goods/index" name="mainFrame" id="mainFrame" />
	</frameset>
</frameset>
</html>
