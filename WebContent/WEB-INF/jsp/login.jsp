<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/head.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>">
	
	<meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width; initial-scale=1.0" />
	<link rel="stylesheet" href="resources/css/bootstrap-2.3.2/bootstrap.css" />
	<link rel="stylesheet" href="resources/css/bootstrap-2.3.2/bootstrap-responsive.css" />
	<script src="resources/js/jquery-1.11.2.js"></script>
	<script src="resources/js/bootstrap-2.3.2/bootstrap.js"></script>
	<title>bootstrap登陆</title>
</head>
<body>
	<form class="form-horizontal" action="login" method="post" >
		<div class="container">
			<a href="#login" data-toggle="modal" class="btn btn-primary">点击登录</a>
			<div class="modal hide fade" id="login"><!-- fade 动画 -->
				<div class="modal-header">
					<a href="#" class="close" data-dismiss="modal">x</a>
					<h4>用户登录</h4>
				</div>
				<div class="modal-body">
					
						<div class="control-group">
							<label class="control-label">用户名</label>
							<div class="controls">
								<input type="text" name="username" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label">密码</label>
							<div class="controls">
								<input type="password" name="password" />
							</div>
						</div>					
						
				</div>
				
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">登录</button>
					<button type="reset" class="btn btn-primary">重置</button>
				</div>
				
			</div>
		</div>
	</form>
</body>
</html>