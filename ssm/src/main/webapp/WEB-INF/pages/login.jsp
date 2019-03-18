<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="<%=request.getContextPath() %>/resources/js/jquery3.2.1.min.js">	
</script>
<script src="<%=request.getContextPath() %>/resources/js/login.js"></script>
<title>欢迎登陆</title>
<style type="text/css">
#login {
	background: BlueViolet;
	width: 250px;
	height: 50px;
}
</style>
</head>
<body>
	<form>
		<div align="center">
			用户名：<input type="text" name="userName" id="u"/><br />
			<br />密&nbsp;&nbsp;&nbsp;码：<input type="text" name="password" id="p"/><br /> <br />
			<input type="button" value="登陆" id="login" />
		</div>
	</form>
	<br/>
	<div align="center">
		用户名:<input type="text" id="uname"/>
	</div>
	
</body>
</html>