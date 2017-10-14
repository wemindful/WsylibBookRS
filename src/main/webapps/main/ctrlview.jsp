<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<meta http-equiv="Pragma" content="no-cache" />
<title>排名显示及下载</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.css" />
<script src="../js/jquery-3.2.1.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="../js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	
	<header style="background-color: #00AAEE;">
			<div  style="text-align: center;">
				<h2>操作图书馆受理的图书列表(15天更新一次)</h2>
			</div>
	</header>
	
	
	<div class="container">

		<div class="panel-body">
			<table class="table table-bordered">
				<thead>
					<th class="col-md-4">书名(排名由高到低)</th>
					<th>作者</th>
					<th>出版日期</th>
					<th>平均分</th>
					<th>价格</th>
					<th>接受</th>
					<th>删除</th>
				</thead>
				<tbody id="tbody">
					<s:iterator step="1" value="#books" var="book">
						<tr>
							<td> <s:property value="#book.bookname"/>    </td>
							<td>${book.author}</td>
							<td>${book.datepicker}</td>
							<td>${book.average}</td>
							<td>${book.price}</td>
							<td> <a  onclick="subgo()"   href="addReplay.action?bookname=${book.bookname}&author=${book.author}&datepicker=${book.datepicker}&average=${book.average}&price=${book.price}">接受</a></td>
							<td> <a  onclick="previousgo()"    href="deleteAction.action?bookname=${book.bookname}">删除</a></td>
						</tr>

					</s:iterator>
				</tbody>
			</table>
		</div>
		 <ul class="pager">
		    <li><a href="ctrlReplayAction.action?page=${currentpage-1 }" >Previous</a> </li>
		    <li><a href="ctrlReplayAction.action?page=${currentpage+1 }" >Next</a> </li>
		 </ul>
		</div>
</body>
	<script type="text/javascript">
		function subgo(){
			alert("增加成功");
		}
		function previousgo(){
			alert("删除成功");
		}
	</script>
</html>