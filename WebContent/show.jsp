<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">

$(function() {
	
	$("input[type='radio'][value='${stu.stuGender}']").prop("checked",true);
	$("select").prop("value",${stu.classId})
})
</script>
<title>Insert title here</title>
</head>
<body>
	<form action="DoUpdateServlet" method="post">
		<input type="hidden" name="id" value="${stu.stuId}">
		<div style="width: 100" alien="center">
			<h1>学生信息修改</h1>
			姓名：<input type="text" name="sname" value="${stu.stuName}"><br>
			性别：<input type="radio" name="gender" value="男">男<input
				type="radio" name="gender" value="女">女<br> 生日：<input
				type="text" name="birthday" value="${stu.stuBirthday}"><br>
			班级： <select name="classid">
				<c:forEach items="${classList}" var="clazz">
					<option value="${clazz.classId}">${clazz.className}</option>
				</c:forEach>
			</select><br> <input type="submit" value="提交">
		</div>
	</form>
</body>
</html>