<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="<%=request.getContextPath() %>/resources/js/jquery3.2.1.min.js">
	
</script>
<style type="text/css">
.btn {
	width: 200px;
	height: 50px;
	background: pink;
}
</style>
</head>
<body>
	<h2 align="center">Hello World!</h2>
	<div align="center">
	<input type="button" id="btnLogin" class="btn" value="登陆"/>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" id="btnRigister" class="btn" value="注册"/>
	</div><br/>
	<div align="center">
	<input type="button" id="btnUserMangger" class="btn" value="用户管理"/>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnLogin").click(function(){
				window.location.href="loginPage";
			});
			$("#btnRigister").click(function(){
				window.location.href="registerPage";
			});
			$("#btnUserMangger").click(function () {
				window.location.href="userManngerPage";
			});
		});
	</script>
</body>
</html>
