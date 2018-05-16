<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="head.txt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style>
body {
	background:
		url(image/homepage.jpg);
	background-size: 100% 100%;
}
</style>
    <base href="<%=basePath%>">
    
    <title>我的主页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/style2.css">
	
   
</head>

<body>

<div class="navbox">
<ul class="nav">
<li><a href="showUserInfo.action"><font size="4">个人信息</a></li>
		<li><a href="getMatchPagingByMatchId.action">我的发布</a></li>
		<li><a href="getJoinMatchPaging.action">我的参加</a></li>
		<li><a href="">待我审核</a></li>
		<li><a href="">我的消息</a></li>

</ul>
</div>

</body>
</html>

  
