<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加用户</title>
	<meta name="viewport" content="width=device-width; initial-scale=1.0" />
	<link rel="stylesheet" href="../resources/css/bootstrap-2.3.2/bootstrap.css" />
	<link rel="stylesheet" href="../resources/css/bootstrap-2.3.2/bootstrap-responsive.css" />
</head>
<body>
	<div class="container">
		<h1><a href="#">返回</a></h1>
		<ul>
			<li>ID: ${user.id }</li>
			<li>Username: ${user.username }</li>
			<%-- <li>Password: ${user.password }</li> --%>
			<li>Nickname: ${user.nickname }</li>
			<li>Email: ${user.email }<br/></li>
		</ul>
	</div>
</body>
</html>