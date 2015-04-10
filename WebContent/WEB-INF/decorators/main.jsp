<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><decorator:title /></title>
<body>
	<p>Add head decorator...</p>
	<decorator:body />
	<p>Add foot decorator...</p>
</body>
</html>