<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 浏览页面 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title></title>
        <style>
            body{
                margin: 0px;
                padding: 0px;
                background-image: url(imgs/大图.jpg);
            }
            #top{
                width: 100%px;
                height: 1000px;
                margin: 0px auto;
                border: 1px solid red;
            }
            #navigation{
                width: 100%;
                height: 80px;
                background-color: #242424;
                color: #e9ebea;
            }

            #ti{
                float: left;
                text-align: center;
                margin-left: 42%;
                font-size: 40px;
            }
            #login{
                float: right;
                font-size: 18px;
                text-align: center;
                line-height: 90px;
                color: #FF0000;
                }
                #list{
                    width: 1100px;
                    height: 100%;
                    margin: auto;
                }
                 #tables{
                    text-align: center;
                }
        </style>
    </head>
    <body>
        <div id="top">
            <div id="navigation">
                <div id="ti">
                    <span>图书管理系统</span>
                </div>
                    <!-- 如果不是登录状态下 -->
                <c:if test="${user == null}">
        <div id="login">
            <a href="${pageContext.request.contextPath}/user_login.jsp">登录</a>&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/register_user.jsp">注册</a>
        </div>
    </c:if>
    <c:if test="${user != null}">
        <div id="login">
            <span >欢迎您，${user.account}&nbsp;&nbsp;</span>
            <a href="${pageContext.request.contextPath}/user?method=showMyHistory">借阅记录</a>&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/user.do?method=logOut">注销</a>
        </div>
    </c:if>
            </div>
            <!-- 显示所有图书 -->
            <div id="context">
                <div id="list">
			        <table border="1px" cellspacing="0" width="100%" id="tables">
			            <tr>
			                <th>编号</th>
			                <th>类型</th>
			                <th>缩略图</th>
			            </tr>
			            <c:forEach items="${types}" var="type">
			                <tr>
			                    <td>${type.id}</td>
			                    <td>${type.type}</td>
			                    <td ><a href="book.do?method=queryAllBooksByType&typeId=${type.id}">查看圖書</a></td>
			                </tr>
			            </c:forEach> 
			        </table>
                </div>
            </div>
        </div>
    </body>
</html>