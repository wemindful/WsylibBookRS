<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta name="copyright" content="Copyright    版权所有">
		<link rel="icon" href="<%=basePath%>img/favicon.ico" type="image/x-icon" />
		<title>404</title>
		<link rel="stylesheet" type="text/css" href="css/error.css"/>
		<meta http-equiv="refresh" content="60;url=http://localhost:8080/BooksRecommand/">
 </head>
<body>
		<div id="container"><img class="png" src="<%=basePath%>img/404.png" /> <img class="png msg" src="<%=basePath%>img/404_msg.png" />
			<p>
				<a href="<%=basePath%>index.html" target="_blank"><img class="png" src="<%=basePath%>img/404_to_index.png" /></a>
			</p>
		</div>
		<div id="cloud" class="png"></div>

	</body>
</html>