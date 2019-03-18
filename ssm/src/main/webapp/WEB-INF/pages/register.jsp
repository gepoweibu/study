<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="<%=request.getContextPath() %>/resources/js/jquery3.2.1.min.js">
</script>
<script src="<%=request.getContextPath() %>/resources/js/register.js"></script>
<title>欢迎注册</title>
<style type="text/css">
.register{
width: 200px;
height: 50px;
background: BlueViolet;
}
</style>
</head>
<body>
<div align="center">
<form>
	用户名：<input type="text" name="userName" id="u"/><br/><br/>
	密&nbsp;&nbsp;&nbsp;码：<input type="text" name="password" id="p"/><br/><br/>
	性&nbsp;&nbsp;&nbsp;别：<input type="text" name="gender" id="gender"/><br/><br/>
	年&nbsp;&nbsp;&nbsp;龄：<input type="text" name="age" id="age"><br/><br/>
	<input type="button" value="注册" class="register" id="r"/>
	
</form>
</div>
</body>
</html>