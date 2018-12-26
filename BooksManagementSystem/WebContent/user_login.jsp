<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 用户登录页面 -->
<html>
<head>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<title>Signin</title>
<link href="css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="App Sign in Form,Login Forms,Sign up Forms,Registration Forms,News latter Forms,Elements" />
</head>
<body>
	<h1>App Sign In Form</h1>
	<div class="app-cam">
		<div class="cam">
			<img src="images/cam.png" class="img-responsive" alt="" />
		</div>
		<form method="post" onsubmit="return false;" id="loginForm">
			<input type="text" class="text" name="account"> 
			<input type="password" name="password" >
			<div class="buttons">
				<ul>
					<li style="font-size: 18px; color: yellow;">
					   自动登录<input type="checkbox" name="autoLogin" value="autoLogin" />
					   <button id="xx">dd</button>
				    </li>
				</ul>
			</div>
			<div class="submit">
				<input type="submit" id="bt" value="Register To">
			</div>
			<div class="new">
				<p class="sign">
					<a href="register_user.jsp" style="color: yellow;"> 账号注册</a>
				</p>
				<p>
					<a href="empty.do" style="color: yellow;" >清除信息</a>
				</p>
				<div class="clear"></div>
			</div>
		</form>
	</div>
<script type="text/javascript">
	$("#xx").click(function(){
	    alert("测试")
	})
    $("#bt").click(function(){
        //向后台发送ajax请求
        $.post("${pageContext.request.contextPath}/user.do?method=login",$("#loginForm").serialize(),function(data){
            if(data == "1"){
                alert("登录失败，请重新登陆")
                location.reload();
            }else{
                location.href="new_file.jsp";
            }
        });
    });
</script>
</body>
</html>