<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"> 
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>zhuce title</title>
</head>
<body>

<div class="container">
    <div class="col-md-6 col-md-offset-3" id="form-container">
        <h1 class="text-center">
            用 户 注 册
        </h1>
        <form action="zhuceyh" class="form-inline" method="post" onsubmit="return checkRegister()" role="form">
            <div class="form-group" style="padding-bottom: 8px;">
                <label class="col-md-6 text-center" for="telephone">
                    手 机 号 :
                </label>
                <div class="col-md-6">
                    <input class="form-control" id="telephone" name="telephone" onblur="checkPhone()" required="true" type="text"/>
                    <p id="telephoneError" style="margin-bottom: -2px;color: red;">
                    </p>
                </div>
            </div>
            <div class="form-group" style="padding-bottom: 8px;">
                <label class="col-md-6 text-center" for="password">
                    密      码 :
                </label>
                <div class="col-md-6">
                    <input class="form-control" id="password" name="password" onblur="checkPassword()" required="true" type="password"/>
                    <p id="passwordError" style="margin-bottom: -2px;color: red;">
                    </p>
                </div>
            </div>
            <div class="form-group" style="padding-bottom: 8px;">
                <label class="col-md-6 text-center" for="rePassword">
                    重复密码:
                </label>
                <div class="col-md-6">
                    <input class="form-control" id="rePassword" name="rePassword" onblur="checkrePassword()" required="true" type="password"/>
                    <p id="rePasswordError" style="margin-bottom: -2px;color: red;">
                    </p>
                </div>
            </div>
            <div class="form-group" style="padding-bottom: 8px;">
                <label class="col-md-6 text-center" for="name">
                    联 系 人 :
                </label>
                <div class="col-md-6">
                    <input class="form-control" id="name" name="name" onblur="checkName()" required="true" type="text"/>
                    <p id="nameError" style="margin-bottom: -2px;color: red;">
                    </p>
                </div>
            </div>
            <div class="col-lg-6" style="margin-bottom: 8px">
                <input class="btn btn-primary btn-block" type="submit" value="注册"/>
            </div>
            <div class="col-lg-6" style="margin-bottom: 18px">
                <a class="btn btn-primary btn-block" href="index.html">
                    已有账号
                </a>
            </div>
        </form>
    </div>
</div>


</body>
</html>