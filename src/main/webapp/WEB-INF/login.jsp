<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"> 
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function Sub(){
	var name = document.getElementById("name").value; 
	var password = document.getElementById("pwd").value;
	if( name == ""  ){
  		alert("用户名不能为空");
  		return false;
	}
	
	if(password == ""  ){
	 	alert("密码不能为空");
  		return false;
	}
	document.getElementById("formid").submit();

}
</script>

<body>
<div id="login" class="span3 well well-large offset4">
  <h4>登陆界面</h4>
    <form class="form" id="formid" action="CheckUserInfo" method="post">
      <input type="text" name="name" placeholder="姓名" id="name"/>
      <input type="password"  name="pwd" placeholder="密码" id="pwd"/>
      <label class="checkbox" for="rememberme">
        <input type="checkbox" /> Remember me
      </label> <br />
      <input class="btn btn-success" value="Login" onclick="Sub() "/>
    </form>
</div>
</body>
</html>