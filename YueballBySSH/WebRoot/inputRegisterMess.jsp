<%@ page contentType="text/html;charset=utf-8"%>

<HTML>
<head>
<title>注册页面</title>
<script type="text/javascript" src="dwr/engine.js"></script>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="dwr/interface/UserDaoAjax.js"></script>
<script type="text/javascript">
	function show(boolean) {
		if (boolean)
			alert("用户已存在");
	}
	function validate() {
		var name = form.name.value;
		if (name == "") {
			alert("用户名不能为空");
			return;
		}
		UserDaoAjax.existUser(name,show);
	}
</script>
</head>
<style>
    body {
	    background: url(image/zhuce.jpg)
    }
</style>
<style>
    .font {
	    font-size: 25px
    }

    #apDiv2 {
	    position: absolute;
	    width: 100px;
	    height: 100px;
	    z-index: 1;
	    left: 120px;
	    top: 100px;
    }
</style>

<body>
<div align="center">
	<form action="register.action" method="post" name="form" >
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<font size="6" color=red>用户名由字母、数字、下划线构成，*注释的项必须填写。</font>
		<table width="900" height="430" border="10" class="font">

			<tr>
				<td width="135" height="92"><div align="center">*用户名称:</div></td>
				<td width="257"><Input type=text name="logname" id="name"
					style="width:200px;height:50px"  onblur="validate()"></td>
				<td width="177"><div align="center">*用户密码:</div></td>
				<td width="258"><Input type=password name="password"
					style="width:200px;height:50px"></td>
			</tr>
			<tr>
				<td height="88"><div align="center">所在学校：</div></td>
				<td><Input type=text name="school"
					style="width:200px;height:50px"></td>
				<td><div align="center">联系电话:</div></td>
				<td><Input type=text name="phone"
					style="width:200px;height:50px"></td>
			</tr>
			<tr>
				<td height="106"><div align="center">联系QQ:</div></td>
				<td><Input type=text name="qq" style="width:200px;height:50px"></td>
				<td><div align="center">真实姓名:</div></td>
				<td><Input type=text name="realname"
					style="width:200px;height:50px"></td>
			</tr>
			<tr>
				
				<td  width="250" align="center"><Input type=submit name="g"
					value="提交" style="width:200px;height:50px" class="font"></td>
			</tr>
		</table>
	</form>
</div>

<div id="apDiv2">
	<a href="login.jsp"><font size='5'>返回登陆</a>
</div>
</Body>
</HTML>