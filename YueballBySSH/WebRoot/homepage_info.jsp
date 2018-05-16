<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.sql.*"%>
<%@ include file="head.txt"%>
<%@ include file="homepage.txt"%>
<head>
<style>
body {
	background: url(image/homepage.jpg);
	background-size: 100% 100%;
}

.font {
	font-size: 18px
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>我的主页</title>
<script type="text/javascript">
	function show() {
		var x = event.clientX;
		var y = event.clientY;

		document.getElementById("pic").style.visibility = "visible";
		var formDiv = "<form action='updateUserInfo.action' method='post'>";
		formDiv += "<font size='5'>联系电话: <input type='text' name='Phone' /><br>";
		formDiv += "联系Q  Q: <input type='text' name='qq' /><br>";
		formDiv += "所在学校:  <input type='text' name='school' /><br>";
		formDiv += "<center><input type='submit' value='确定' onclick='hide()' class='font'/>";
		formDiv += "<input type='button' value='取消' onclick='cancel()'class='font'/></center></form>";
		document.getElementById("pic").innerHTML = formDiv;
	}

	function hide() {
		document.getElementById("pic").style.visibility = "hidden";
	}
	function cancel() {
		document.getElementById("pic").style.visibility = "hidden";
		document.action = " ";
		document.submit();
	}
	function quit() {
		document.action = "quitmatchservlet";
		document.submit();
	}
</script>
<style type="text/css">
#apDiv1 {
	position: absolute;
	width: 105px;
	height: 36px;
	z-index: 2;
	left: 850px;
	top: 530px;
}

#apDiv2 {
	position: absolute;
	width: 200px;
	height: 193px;
	z-index: 1;
	left: 1400px;
	top: 350px;
}

#apDiv3 {
	position: absolute;
	width: 200px;
	height: 193px;
	z-index: 1;
	left: 1400px;
	top: 200px;
}

#apDiv4 {
	position: absolute;
	width: 582px;
	height: 284px;
	z-index: 5;
	left: 600px;
	top: 240px;
}

#pic {
	position: absolute;
	width: 582px;
	height: 119px;
	z-index: 1;
	left: 750px;
	top: 590px;
}
</style>
</head>

<body>
	<div id="apDiv1">
		<input name="提交" type="submit" onClick="show()" value="我要修改"
			class='font' />
	</div>


	<div id="pic"
		style="border: 10;width: 300;height: 200; visibility :hidden"></div>
	<div id="apDiv4">
		<table width="552" height="244" border="10">
			<caption>
				<font size='5'>我的个人信息
			</caption>
			<tr>
				<td width="96" scope="col">联系电话</td>
				<td width="212" scope="col"><s:property
						value="#session.user.phone" /></td>
			</tr>
			<tr>
				<td>联系QQ</td>
				<td><s:property value="#session.user.qq" /></td>
			</tr>
			<tr>
				<td>学校</td>
				<td><s:property value="#session.user.school" /></td>
			</tr>
		</table>
		<p>&nbsp;</p>
	</div>
	<div id="apDiv2">
		<FORM method='post' action="loadTouxiang.action" enctype="multipart/form-data">
			图片:<INPUT TYPE="file" NAME="image"><BR> <INPUT
				TYPE="submit" value="修改头像" class='font'>
		</FORM>
	</div>
    <div id='apDiv3'> <p>我的头像 </p><img width=100 height=100 src='showTouxiang.action' /></div>
</body>
</html>