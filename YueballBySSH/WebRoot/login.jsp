<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
 <style>
  body{background:url(image/login1.jpg)}
  </style>
<body>

  <div align="center" ;valign="center">
 <p>&nbsp;</p>
 <p>&nbsp;</p>
 <p>&nbsp;</p>
 <p>&nbsp;</p>
 <table width="356" border=4 style="width:400px;height:300px">
<tr> <th width="340" style="font-size:20px">登录</th></tr>
<FORM id="loginform" action="login.action" Method="post">
<tr><td  style="font-size:20px">登录名称:<Input name="logname" type=text style="width:200px;height:50px"></td></tr>
<tr><td style="font-size:20px">输入密码:<Input type=password style="width:200px;height:50px"name="password"></td></tr>
<tr><td style="font-size:20px">输验证码:<Input name="code" type=text style="width:200px;height:50px"></td></tr>
<tr><td><div align="center"><img border=0 src="getImage.action"></div></td></tr>
</table>
 <Input style="font-size:20px"type=submit name="g" value="登陆">
 <Input style="font-size:20px"type=submit name="g" value="注册" onclick="register();">
</form>
 <script type="text/javascript">
     function register() {
       document.forms.loginform.action="inputRegisterMess.jsp";
       document.forms.loginform.submit();
         }
</script>
	
</div>
</body>
</html>
