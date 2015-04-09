<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width; initial-scale=1.0" />
	<link rel="stylesheet" href="../resources/css/bootstrap-2.3.2/bootstrap.css" />
	<link rel="stylesheet" href="../resources/css/bootstrap-2.3.2/bootstrap-responsive.css" />
	<script src="../resources/js/jquery-1.11.2.js"></script>
	<script src="../resources/js/bootstrap-2.3.2/bootstrap.js"></script>
</head>
<body>
	<div class="container">
	<h1>
		<a href="add">添加</a> 
	</h1>
	--${LoginUser.nickname }
	<br/>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>用户名</th>
				<th>中文名</th>
				<th>密码</th>
				<th>邮箱</th>
				<th>修改</th>
				<th>删除</th>
			</tr>
		</thead>
		<c:forEach items="${users }" var="um">
			<tr><th>${um.value.username }</th>
				<th><a href="${um.value.username }">${um.value.nickname }</a></th>
				<th>${um.value.password }</th>
				<th>${um.value.email }</th>
				<th><a href="${um.value.username }/update">修改</a></th>
				<th><a href="${um.value.username }/delete">删除</a></th>
			</tr>
		</c:forEach>
	</table>
	
	</div>
</body>
</html>