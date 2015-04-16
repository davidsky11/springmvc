<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加用户</title>
	<meta name="viewport" content="width=device-width; initial-scale=1.0" />
	<link rel="stylesheet" href="../../resources/css/bootstrap-2.3.2/bootstrap.css" />
	<link rel="stylesheet" href="../../resources/css/bootstrap-2.3.2/bootstrap-responsive.css" />
</head>
<body>
	<div class="container">
		<h1><a href="#">返回</a></h1>
		<!-- 此时没有写action，直接提交给/add -->
		<sf:form class="form-horizontal" method="post" modelAttribute="user"><br/>
			<fieldset>
			<legend>更新用户信息</legend>
			<sf:hidden id="id" path="id"/>
			<div class="control-group">
				<label class="control-label" for="username">用户名</label>
				<div class="controls">
					<sf:input id="username" path="username"/><sf:errors path="username" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="password">密码</label>
				<div class="controls">
					<sf:password id="password" path="password"/><sf:errors path="password" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="nickname">中文名</label>
				<div class="controls">
					<sf:input id="nickname" path="nickname"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="email">邮箱</label>
				<div class="controls">
					<sf:input id="email" path="email"/><sf:errors path="email" />
				</div>
			</div>
			</fieldset>
			<div class="form-actions">
				<button type="submit" class="btn btn-primary">提交</button>
				<button type="reset" class="btn btn-primary">重置</button>
			</div>
		</sf:form>
	</div>
</body>
</html>