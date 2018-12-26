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
				<div id="login">
					<span>${user.account}.借阅记录&nbsp;&nbsp;</span> <a
						href="${pageContext.request.contextPath}/NewFile?method=toHome">首页</a>&nbsp;&nbsp;
				</div>
		</div>
		<!-- 显示所有图书 -->
		<div id="context">
			<div id="list">
				<table border="1px" cellspacing="0" width="100%" id="tables">
					<tr>
						<th>编号</th>
						<th>书名</th>
						<th>借阅时间</th>
						<th>归还时间</th>
					</tr>
					<c:forEach items="${historys}" var="history">
						<tr>
							<td>${history.id}</td>
							<td>${history.bid}</td>
							<td>${history.borrow_time}</td>
							<c:if test="${history.return_time == null}">
								<td>未归还,<a class="return" href="javacript:void(0)">归还</a></td>
							</c:if>
							<c:if test="${history.return_time != null}">
								<td>${history.return_time}</td>
							</c:if> 
							
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	    $(".return").each(function(){
	        var a = $(this);
	        var hid;
	        var bid;
	        a.click(function(){
	            var tr = a.parent().parent();
	            var tds = tr.children("td");
	            hid = tds.eq(0).text();
	            bid = tds.eq(1).text()
	            
	             $.post("${pageContext.request.contextPath}/user?method=returnBack",{"bid":bid,"hid":hid},function(data){
	                    if("0" == data){
	                        alert("归还成功");
	                    }
	                    if("1" == data){
	                        alert("归还失败");
	                    }
	                    location.href="${pageContext.request.contextPath}/user?method=showMyHistory";
	             });
	            
	        }); 
	    });
	    
	</script>
</body>
</html>