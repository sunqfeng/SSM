<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>添加用户</title>  
      
    <script type="text/javascript">  
    function addUser(){  
        var form = document.forms[0];
        form.action = "<%=basePath%>studentControl/AddStudent";  
        form.method="post";
        form.submit();  
    }  
	</script>  
  
  </head>  
    
  <body>  
    <h1><%=path%>添加用户<%=basePath%></h1>  
    <form action="" name="userForm">  
	id:<input type="text" name="name">  
	姓名：<input type="text" name="id">  
        <input type="button" value="添加" onclick="addUser()">  
    </form>  
  </body>  
</html>  
