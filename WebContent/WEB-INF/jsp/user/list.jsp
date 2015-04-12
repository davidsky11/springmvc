<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/head.jsp" %>
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
		<h1>用户列表页面</h1>
		<h3>
			<a href="add">用户添加</a>
		</h3>
		<h3>
			<c:if test="${not empty loginUser }">
			当前用户： ${loginUser.nickname }
				<a href="<%=basePath %>/logout">退出</a> 
			</c:if>
		</h3>
		<hr/>
		<br/>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>用户标识</th>
					<th>用户名</th>
					<th>用户昵称</th>
					<th>密码</th>
					<th>邮箱</th>
					<th>修改</th>
					<th>删除</th>
				</tr>
			</thead>
			<c:if test="${pagers.total lt 0 }">
				<tr>
				<td colspan="7">目前还没有用户数据</td>
			</c:if>
			<c:if test="${pagers.total gt 0 }">
				<c:forEach items="${pagers.datas }" var="um">
					<tr>
						<th>${um.id }</th>
						<th>${um.username }</th>
						<th><a href="${um.id }">${um.nickname }</a></th>
						<th>${um.password }</th>
						<th>${um.email }</th>
						<th><a href="${um.username }/update">更新</a></th>
						<th><a href="${um.username }/delete">删除</a></th>
					</tr>
				</c:forEach>
			</c:if>
			<tr >
			<td colspan="7" align="center">
				<%-- <jsp:include page="/inc/pager.jsp">
					<jsp:param name="url" value="users" />
					<jsp:param name="items" value="${pagers.total }" />
				</jsp:include> --%>
				<c:import url="/inc/pager.jsp" >
					<c:param name="total" value="${pagers.total }"></c:param>
					<c:param name="pageSize" value="15"></c:param>
					<c:param name="pageEnumShow" value="3"></c:param>
					<c:param name="pageUrl" value="users"></c:param>
					<c:param name="pageIndex" value="0"></c:param>
				</c:import>
			</td>
			</tr>
		</table>
		<!-- <div class="pagination"> -->
			
		<!-- </div> -->
	</div>
</body>
</html>