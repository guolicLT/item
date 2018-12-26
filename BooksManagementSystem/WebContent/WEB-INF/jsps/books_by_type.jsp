<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 浏览页面 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <script type="text/javascript" src="/BooksManagementSystem/js/jquery-1.12.4.js"></script>
    <title></title>
    </head>
    <body>
    <jsp:include page="header.jsp"></jsp:include>
        <div id="top">
            <div id="navigation">
            </div>
            <!-- 显示所有图书 -->
            <div id="context">
                <div id="list">
			        <table border="1px" cellspacing="0" width="100%" id="tables">
			            <tr>
			                <th>编号</th>
			                <th>书名</th>
			                <th>作者</th>
			                <th>缩略图</th>
			                <th>操作</th>
			            </tr>
            
			            <c:forEach items="${books}" var="book">
			                <tr>
			                    <td>${book.id}</td>
			                    <td>${book.name}</td>
			                    <td>${book.writer}</td>
			                    <td>暂无</td>
			                    <td>
			                        <c:if test="${book.isBorrowed == '0'}">
			                            <font color="green">可借</font>
			                        </c:if>
			                        <c:if test="${book.isBorrowed == '1'}">
			                            <font color="red">不可借</font>
			                        </c:if>
			                        <!--
			                         href="javascript:void(0)":阻止a链接的默认跳转行为
			                     -->
			                    
			                        <c:if test="${book.isBorrowed == '0'}">
			                            <a class="borrow" href="javascript:void(0)">借阅</a> 
			                        </c:if>
			                        <input type="hidden" value="${book.id}" /> 
			                        <input type="hidden" value="${book.typeId}" />
			                    </td>
			                </tr>
			            </c:forEach>

			        </table>
			        <input type="hidden" value="${user.id}" id="uid" />
                </div>
            </div>
        </div>
        <script>
      //为借阅的a标签加上的点击事件
        $(".borrow").each(function(){
            var a = $(this);
            var bid;
            var typeId;
            a.click(function(){
                bid = a.nextAll("input").eq(0).val();
                typeId = a.nextAll("input").eq(1).val();
                //判断用户是否登陆
                if(!$("#uid").val()){
                    alert("你还没有登陆，请先去登陆");
                    location.href="${pageContext.request.contextPath}/user_login.jsp";
                    return;
                }
                 $.post("${pageContext.request.contextPath}/user?method=borrowOneBook",{"bid":bid},function(data){
                	 if("0" == data){
                            alert("借阅成功");
                        }
                        if("1" == data){
                            alert("借阅失败");
                        }
                        location.href="${pageContext.request.contextPath}/book.do?method=queryAllBooksByType&typeId="+typeId;
                 }); 
            }); 
        });
    </script>
    </body>
</html>