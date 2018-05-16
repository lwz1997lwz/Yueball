<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ include file="head.txt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
			 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style type="text/css">
/*分别定义HTML中和标记之的距离样式*/
html, body, h1, form, fieldset,
	legend, ol, li {
	margin: 0;
	padding: 0;
}
/*定义<body>标记样式*/
body {
	background:
		url(image/rapidlaunch.jpg);
	background-size: 100% 100%;
	color: #111111;
	font-family: Georgia,
		"Times New Roman", Times,
		serif;
	padding-left: 20px;
	margin-top: 150px;
}

form#payment {
	background: #9cbc2c;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	padding: 20px;
	width: 400px;
	margin: auto;
}

form#payment fieldset {
	border: none;
	margin-bottom: 10px;
}

form#payment fieldset:last-of-type
	{
	margin-bottom: 0;
}

form#payment legend {
	color: #384313;
	font-size: 25px;
	font-weight: bold;
	padding-bottom: 10px;
	text-shadow: 0 1px 1px #c0d576;
}

form#payment>fieldset>legend:before
	{
	content: "Step "
		counter(fieldsets) ": ";
	counter-increment: fieldsets;
}

form#payment fieldset fieldset legend
	{
	color: #111111;
	font-size: 18px;
	font-weight: normal;
	padding-bottom: 0;
}

form#payment ol li {
	background: #b9cf6a;
	background: rgba(255, 255, 255, .3);
	border-color: #e3ebc3;
	border-color: rgba(255, 255, 255, .6);
	border-style: solid;
	border-width: 2px;
	-webkit-border-radius: 5px;
	line-height: 30px;
	list-style: none;
	padding: 5px 10px;
	margin-bottom: 2px;
}

form#payment ol ol li {
	background: none;
	border: none;
	float: left;
}

form#payment label {
	float: left;
	font-size: 18px;
	width: 110px;
}

form#payment fieldset fieldset label
	{
	background: none no-repeat left
		50%;
	line-height: 20px;
	padding: 0 0 0 30px;
	width: auto;
}

form#payment fieldset fieldset label:hover
	{
	cursor: pointer;
}

form#payment input:not ([type=radio]
	), form#payment textarea {
	background: #ffffff;
	border: #FC3 solid 1px;
	-webkit-border-radius: 3px;
	font: italic 13px Georgia,
		"Times New Roman", Times,
		serif;
	outline: none;
	padding: 5px;
	width: 200px;
}

form#payment input:not ([type=submit]
	):focus, form#payment textarea:focus
	{
	background: #eaeaea;
	border: #F00 solid 10px;
	align: center;
}

form#payment input[type=radio] {
	float: left;
	margin-right: 5px;
}
</style>
<head>
<base href="<%=basePath%>">

<title>My JSP 'rapidlaunch.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="style2.css">


</head>

<body>
	<form id="payment" action="orginMatch.action" method="post">
		<fieldset>
			<legend>比赛详细信息</legend>
			<ol>
				<li><label for="type">比赛类型：</label> <select name="matchType">
						<option value="篮球">篮球</option>
						<option value="足球">足球</option>
						<option value="网球">网球</option>
						<option value="台球">台球</option>
						<option value="羽毛球">羽毛球</option>
				</select></li>
				<li><label for="date">比赛日期：</label> <input id="date"
					name="matchDate" type="text"></li>
				<li><label for="originator">发起人：</label> 
				 <input id="originator" name="matchOriginator" type="tel"
				 value="<s:property value='#session.user.logname'/>"
					placeholder="< s:property value='#session.user.logname'/>"  required readonly="true"></li>
			</ol>
		</fieldset>
		<fieldset>

			<ol>
				<li><label for="address">详细地址：</label> <textarea id="address"
						name="matchAddress" rows="1" required></textarea></li>
				<li><label for="limit">人数限制：</label> <input id="limit"
					name="matchLimit" type="text" required></li>
			</ol>
		</fieldset>
		<fieldset>

			<ol>
				<li>
					<fieldset>
						<legend>难度级别</legend>
						<ol>
							<li><input id="xinshou" name="matchDifficulty" type="radio"
								value="新手"> <label for="xinshou">新手</label></li>
							<li><input id="yiban" name="matchDifficulty" type="radio"
								value="一般"> <label for="yiban">一般</label></li>
							<li><input id="gaoshou" name="matchDifficulty" type="radio"
								value="高手"> <label for="gaoshou">高手</label></li>
						</ol>
					</fieldset>
				</li>
				<li><label for="mess">信息备注：</label> <input id="mess"
					name="matchMess" type="text" style="height:100px;width:370px"></li><!-- name -->

			</ol>
		</fieldset>
		<fieldset>
			<center><button type="submit" class='font'>立即发布</button></center>
		</fieldset>
	</form>
</body>
</html>
