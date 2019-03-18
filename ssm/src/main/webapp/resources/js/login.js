$(document).ready(function(){
		$("#login").click(function(){
			var username=$("#u").val();
			var password=$("#p").val();
			var data={"userName":username,"password":password};
			$.ajax({
				url:'login',
				data:data,
				type:'post',
				success: function(data) {
					$("#uname").val(data.userName);
					alert("用户名："+data.userName+"  密码："+data.password);
				}
			});
		});
});
