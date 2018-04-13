<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="head.txt" %> 
<head>
<title>浏览赛事</title>
 <style>
  body{background:url(image/skimmatch.jpg)}
  </style>
<style type="text/css">
#apDiv1 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 1;
	left: 896px;
	top: 180px;
}
#apDiv2 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 2;
	left: 267px;
	top: 180px;
}
#apDiv3 {
	position: absolute;
	width: 200px;
	height: 125px;
	z-index: 1;
	left: 496px;
	top: 290px;
}
#apDiv4 {
	position: absolute;
	width: 200px;
	height: 121px;
	z-index: 1;
	left: 373px;
	top: 465px;
}
#apDiv5 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 1;
	left: 581px;
	top: 180px;
}
</style>
</head>

<body>
<div id="apDiv1"><a href="getMatchPaging.action?matchType=台球"><img src="image/tableball.jpg" width="264" height="254" /></div>
<div id="apDiv2">
  <div id="apDiv3"><a href="getMatchPaging.action?matchType=羽毛球"><img src="image/yumao.jpg" width="268" height="247" /></div>
<a href="getMatchPaging.action?matchType=足球"><img src="image/football.jpg" width="270" height="255" /></div>
<div id="apDiv4"><a href="getMatchPaging.action?matchType=网球"><img src="image/tennis.jpg" width="266" height="256" /></div>
<div id="apDiv5"><a href="getMatchPaging.action?matchType=篮球"><img src="image/basketball.jpg" width="268" height="254" /></a></div> 
</body>
</html>
