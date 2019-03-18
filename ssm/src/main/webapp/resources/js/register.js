$(document).ready(function(){
	$("#r").click(function(){
	var username=$("#u").val();
	var password=$("#p").val();
	var gender=$("#gender").val();
	var age=$("#age").val();
	var data={"userName":username,"password":password,"gender":gender,"age":age};
	$.ajax({
            type : "post",
            url : "register",
            contentType : "application/json;charset=utf-8",
            data : JSON.stringify(data),
            success : function(data) {
                alert("用户名："+data.userName+" 密码："+data.password);
            }
	    });
	});
});