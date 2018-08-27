<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>查询userinfo表的员工信息</title>
</head>
<body>

		<div>
           <table  class="table table-bordered">
            <tr>
            	<th>姓名</th>
                <th>电话</th>
                <th>员工号</th>
            	</tr>
            	<c:forEach items="${userinfo}" var="userinfo">
                	<tr>
                    	<td>${userinfo.username}</td>
                    	<td>${userinfo.useriphoncode}</td>
                    	<td>${userinfo.usercode}</td>
                	</tr>
            	</c:forEach>
        	</table>
        </div>
        <!-- 分页功能 start -->
        <div align="center">
               <span>共 ${page.totalPageCount} 页</span> <span >第
               ${page.pageNow} 页</span> <a href="?pageNow=1">首页</a>
               <c:choose>
                   <c:when test="${page.pageNow - 1 > 0}">
                       <a href="?pageNow=${page.pageNow - 1}">上一页</a>
                   </c:when>
                   <c:when test="${page.pageNow - 1 <= 0}">
                       <a href="?pageNow=1">上一页</a>
                   </c:when>
               </c:choose>
               <c:choose>
                   <c:when test="${page.totalPageCount==0}">
                       <a href="?pageNow=${page.pageNow}">下一页</a>
                   </c:when>
                   <c:when test="${page.pageNow + 1 < page.totalPageCount}">
                       <a href="?pageNow=${page.pageNow + 1}">下一页</a>
                   </c:when>
                   <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
                       <a href="?pageNow=${page.totalPageCount}">下一页</a>
                   </c:when>
               </c:choose>
               <c:choose>
                   <c:when test="${page.totalPageCount==0}">
                       <a href="?pageNow=${page.pageNow}">尾页</a>
                   </c:when>
                   <c:otherwise>
                       <a href="?pageNow=${page.totalPageCount}">尾页</a>
                   </c:otherwise>
               </c:choose>
           </div>
           <!-- 分页功能 End -->
</body>
</html>