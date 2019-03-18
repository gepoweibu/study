<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/demo/demo.css"> 
<script	src="<%=request.getContextPath()%>/resources/js/jquery3.2.1.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/userMannger.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.easyui.min.js"></script>
<meta charset="UTF-8">
<title>用户管理</title>
</head>
<body>
	<h2>客户端数据分页</h2>
	<p>This sample shows how to implement client side pagination in DataGrid.</p>
	<div style="margin:20px 0;"></div>
	
	<table id="dg" title="用户信息管理" style="width:700px;height:300px" data-options="
				rownumbers:true,
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10">
		<thead>
			<tr> 
				<th field="id" width="80">用户ID</th>
				<th field="userName" width="100">用户名</th>
				<th field="password" width="100">密码</th>
				<th field="gender" width="80">性别</th>
				<th field="age" width="80">年龄</th>
			</tr>
		</thead>
	</table>
</body>
</html>