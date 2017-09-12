<%@page import="org.lanqiao.util.PageController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
	import="org.lanqiao.entity.* ,java.util.*,org.lanqiao.servlet.*,org.lanqiao.util.*">
<script src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("tr:even").css("background-color", "#f1f1f1");
		$("#btn").click(function() {
			location.href = "ShowServlet";
		});

		$(".del").click(function() {
			var id = $(this).attr("alt");
			$.get("DelServlet", {
				"id" : id
			}, function(ret) {
				if (ret == "ok") {
					alert("删除成功！");
					location.reload();
				}
			}, "text");
		});
	})
</script>
<title>Insert title here</title>
</head>
<body>

	<table border="1" width="600" align="center">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>生日</td>
			<td>班级</td>
			<td>电话</td>
			<td>操作</td>

		</tr>
		<c:forEach items="${list}" var="stu">
			<tr>
				<td><a href="ShowServlet?id=${stu.stuId}">${stu.stuId}</a></td>
				<td>${stu.stuName}</td>
				<td>${stu.stuGender}</td>
				<td>${stu.stuBirthday}</td>
				<td>${stu.classId}</td>
				<td>${stu.stuTelephone}</td>
				<td><span class="del" alt="${stu.stuId}">删除</span></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7" align="center"><%=PageController.createPageCode((Integer) request.getAttribute("pageNum"),
					(Integer) request.getAttribute("maxPage"), "IndexServlet")%></td>
		</tr>
		<tr>
			<td colspan="7" align="center"><input id="btn" type="button"
				value="添加信息"></td>
	</table>

</body>
</html>