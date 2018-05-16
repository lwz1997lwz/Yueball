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

form#selectMatch {
	background: #3299cc;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	padding: 20px;
	width: 400px;
	margin: auto;
}

form#selectMatch fieldset {
	border: none;
	margin-bottom: 10px;
}

form#selectMatch fieldset:last-of-type
	{
	margin-bottom: 0;
}

form#selectMatch legend {
	color: #384313;
	font-size: 25px;
	font-weight: bold;
	padding-bottom: 10px;
	text-shadow: 0 1px 1px #c0d576;
}

form#selectMatch>fieldset>legend:before
	{
	content: "Step "
		counter(fieldsets) ": ";
	counter-increment: fieldsets;
}

form#selectMatch fieldset fieldset legend
	{
	color: #fffffff;
	font-size: 18px;
	font-weight: normal;
	padding-bottom: 0;
}

form#selectMatch ol li {
	background: #ffffff;
	background: rgba(255, 255, 255, .3);
	border-color: #ffffff;
	border-color: #ffffff;
	border-style: solid;
	border-width: 2px;
	-webkit-border-radius: 5px;
	line-height: 30px;
	list-style: none;
	padding: 5px 10px;
	margin-bottom: 2px;
}

form#selectMatch ol ol li {
	background: none;
	border: none;
	float: left;
}

form#selectMatch label {
	float: left;
	font-size: 18px;
	width: 110px;
}

form#selectMatch fieldset fieldset label
	{
	background: none no-repeat left
		50%;
	line-height: 20px;
	padding: 0 0 0 30px;
	width: auto;
}

form#selectMatch fieldset fieldset label:hover
	{
	cursor: pointer;
}

form#selectMatch input:not ([type=radio]
	), form#selectMatch textarea {
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

form#selectMatch input:not ([type=submit]
	):focus, form#selectMatch textarea:focus
	{
	background: #ffffff;
	border: #F00 solid 10px;
	align: center;
}

form#selectMatch input[type=radio] {
	float: left;
	margin-right: 5px;
}
</style>
<head>
<base href="<%=basePath%>">

<title>查询赛事</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="style2.css">
	

</head>
 
<body>
	<form id="selectMatch" action="selectMatchPaging.action" method="post">
    <fieldset>
        <legend>筛选条件</legend>
        <ol>
            <li>
                <label for="matchType">比赛类型：</label>
                <select name="matchType"> 
                  <option value="篮球">篮球</option> 
                  <option value="足球">足球</option> 
                  <option value="网球">网球</option> 
                  <option value="台球">台球</option> 
                  <option value="羽毛球">羽毛球</option> 
                </select>
            </li>
        
        </ol>
    </fieldset>
    <fieldset>
        
        <ol>
           
            <li>
                <label for="matchLimit">人数限制：</label>
                <input id="matchLimit" name="matchLimit" type="text" >
            </li>
            
        </ol>
    </fieldset>
    <fieldset>
        
        <ol>
            <li>
                <fieldset>
                    <legend>难度级别</legend>
                    <ol>
                        <li>
                            <input id="xinshou" name="matchDifficulty" type="radio" value="新手" checked >
                            <label for="xinshou">新手</label>
                        </li>
                        <li>
                            <input id="yiban" name="matchDifficulty" type="radio" value="一般">
                            <label for="yiban">一般</label>
                        </li>
                        <li>
                            <input id="gaoshou" name="matchDifficulty" type="radio" value="高手">
                            <label for="gaoshou">高手</label>
                        </li>
                    </ol>
     </fieldset>
      
      <fieldset>
            </li>
            <li>
                <label for="mess">筛选备注</label>
                <input id="mess" name="mess" type="text" value="比赛类型必选，其他两项不选则不加限制" readonly="true"style="height:100px;width:370px">
            </li>
         
        </ol>
      </fieldset>
    <fieldset>
        <center><button type="submit" ><font size=4>立即筛选</button></center>
    </fieldset>
</form>
</body>
</html>
