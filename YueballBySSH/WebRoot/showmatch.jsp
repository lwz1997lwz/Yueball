<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'showmatch.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


</head>
<style>
body {
	background: url(image/fenye.jpg)
}
</style>
<style>
.font {
	font-size: 22px
}

#apDiv1 {
	position: absolute;
	width: 912px;
	height: 115px;
	z-index: 1;
	left: 450px;
	top: 602px;
}

#apDiv2 {
	position: absolute;
	width: 150px;
	height: 100px;
	z-index: 1;
	left: 120px;
	top: 100px;
}
</style>

<Body bgcolor=#66FFAA>


	<center>
		<p>
			<BR>
		</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<table width="1324" height="129" border=20 class="font">
			<tr>
				<th width="155" height="121">比赛类型</th>
				<th width="150">比赛日期</th>
				<th width="150">比赛发起人</th>
				<th width="150">人数限制</th>
				<th width="150">目前人数</th>
				<th width="150">比赛地点</th>
				<th width="150">比赛难度</th>
				<th width="350">赛事备注</th>
				<td width="150"><font color=blue>是否加入</font></td>
			</tr>

			<s:iterator value="#request['match']" var="match">
				<tr>
					<td><s:property value="#match.matchType" /></td>
					<td><s:property value="#match.matchDate" /></td>
					<td><s:property value="#match.matchOriginator" /></td>
					<td><s:property value="#match.matchLimit" /></td>
					<td><s:property value="#match.matchJoinnum" /></td>
					<td><s:property value="#match.matchAddress" /></td>
					<td><s:property value="#match.matchDifficulty" /></td>
					<td><s:property value="#match.matchMess" /></td>
					<td>
						<form action="joinMatch.action" method="post">
							<input type="hidden" name="matchId" value="<s:property value="#match.matchId" />">
							<input type="hidden" name="matchOriginator" value="<s:property value="#match.matchOriginator"/>">
							<input type="submit" id="joinMatchButton" value="是否加入"
								 onclick="javaScript:alert('您确定要参加吗？')">
						</form>
					</td>
				</tr>
			</s:iterator>
		</table>
		<BR>
		<div>
		<s:set value="#request.pager" var="pager"></s:set>
		<s:if test="#pager.hasFirst">
			<a href="getMatchPaging.action?currentPage=1"> 首页</a>
		</s:if>
		<s:if test="#pager.hasPrevious">
			<a
				href="getMatchPaging.action?currentPage=<s:property value="#pager.currentPage-1"/>">
				上一页 </a>
		</s:if>
		<s:if test="#pager.hasNext">
			<a
				href="getMatchPaging.action?currentPage=<s:property value="#pager.currentPage+1"/>">
				下一页 </a>
		</s:if>
		<s:if test="#pager.hasLast">
			<a
				href="getMatchPaging.action?currentPage=<s:property value="#pager.totalPage"/>">
				尾页 </a>
		</s:if>
		<br> 当前第
		<s:property value="#pager.currentPage" />
		页，总共
		<s:property value="#pager.totalPage" />
		页
		</div>
		<div id="apDiv2">
			<a href="skimmatch.jsp"><font size='5'>返回上一级</a>
		</div>
</BODY>
</html>
