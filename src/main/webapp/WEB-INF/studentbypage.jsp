<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

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
           
           <table>
            <tr>
                <th>姓名</th>
                <th>年龄</th>
            </tr>
            <c:forEach items="${student}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                </tr>
            </c:forEach>
        </table>

</body>
</html>