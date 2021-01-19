<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="register.controller" method="post">
<div>註冊會員</div>
<br/>
<div>帳號:&nbsp;<input type="text" id="account" name="account" />${err.account }${err.repeat}</div>
<br/>
<div>密碼:&nbsp;<input type="password" id="password" name="password" />${err.password }</div>
<br/>
<div>姓名:&nbsp;<input type="text" id="username" name="username" />${err.userName }</div>
<br/>
<div>信箱:&nbsp;<input type="email" id="email" name="email" />${err.email }</div>
<br/>
<div>電話:&nbsp;<input type="text" id="phone" name="phone" />${err.phone }</div>
<br/>
<div>地址:&nbsp;<input type="text" id="address" name="address" />${err.address }</div>
<br/>
<div>生日:&nbsp;<input type="date" id="birthday" name="birthday" />${err.birthday }</div>
<br/>
<div>性別:&nbsp;<input type="text" id="gender" name="gender" />${err.gender }</div>
<br/>
<div>
    <input type="submit" id="send" value="送出" />&nbsp;&nbsp;
</div>

</form>

</body>
</html>