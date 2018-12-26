<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 用户注册页面 -->
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
		<form id="registryForm"  onsubmit="return false;">
		    <tr>
                    <th colspan="2">用户注册</th>
            </tr>
            <tr>
                <td>
			        <input type="text" class="text" name="account" id="name">
                </td>
                <td>
                    <span id="nameSpan"></span> 
                </td>
            </tr> 
            <tr>
                <td>
			        <input type="password" name="password"  id="password">
			    </td>
            </tr> 
			<tr>
				<div class="clear">
				 <span style = " color:#e9ebea">请再次确认密码</span>
				</div>
			</tr>
			<tr>
			    <td>
			        <input type="password" name="RePassword" id="RePassword"/>
			    </td>
			</tr>
			<tr>
			    <td>
					<div class="submit">
						<input type="submit" id="bt" value="Register To">
					</div>
				</td>
			</tr>
			<tr>
			     <td>
			        <div class="clear"></div>
			     </td>
			</tr>	
			<tr>
			    <td>
					<div class="new">
						<div class="clear"></div>
					</div>
			    </td>
			</tr>
		</form>
	</div>
	
	<script type="text/javascript">
		var yes=0;
			
			
		/*
		    检测用户名是否已经被占用
		*/
		$("#name").blur(function(){
			
		    //向后台发送ajax请求
		    $.post("${pageContext.request.contextPath}/user.do?method=checkName",{name:$("#name").val()},function(data){
		        var nameSpan = $("#nameSpan");
		        if(data == "0"){
		            nameSpan.html("<img src='imgs/right.jpg' width='16' height='16'  />");
		            if(yes > 0){
		            	yes--;
		            }
		        }else{
		            nameSpan.html("<img src='imgs/wrong.jpg' width='16' height='16' />");
		            yes++;
		        }
		    });
		});
		
		/*
		    检测两次输入密码不一致的问题
		*/
		$("#RePassword").blur(function(){
		    var RePassword = $("#RePassword");
		    var password = $("#password");
		    if(RePassword.val() != password.val()){
		        alert("两次密码输入不一致，请重新检查");
		        yes++;
		    }else if(yes>0){
		    	yes--;
		    }
		})
        /*
           注册
        */
        $("#bt").click(function(){
        	if(yes==0){
			    //向后台发送ajax请求
			    $.post("${pageContext.request.contextPath}/user.do?method=registry",$("#registryForm").serialize(),function(data){
			    	location.href="user_login.jsp";
			    });
        	}else{
        		alert("输入有误");
        	}
		});
    </script>
</body>
</html>