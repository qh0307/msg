 <%@ page language="java" contentType="text/html; charset=UTF-8" import="org.lanqiao.util.*"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html lang="en">
<head>

    <title>留言板</title>
    <meta charset="UTF-8">
    <style>
        div {
            margin: 0;
            padding: 0;
            font-size: 12px;
            margin: 0 auto;
        }

        h3 {
            text-align: center
        }

        #container {
            width: 500px;
        }

        .article {
            border: 1px solid #a6cbe7;
            margin-top: 5px;
        }

        .author {
            background-color: #0099FF;
            width: 100%;
            height: 24px;
            line-height: 24px;
        }

        .content {
            height: 40px;
            padding: 10px;
        }

        .author span {
            float: right;
            padding-right: 10px;
        }

        .time {
            border-top: solid 1px #a6cbe7;
        }

        .page {
            text-align: right;
            height: 30px;
            line-height: 30px;
            padding-right: 10px;
        }
    </style>
</head>

<body>
<div id="container">
    <div><h3>留言板</h3></div>
    <form action="searchMsg" method="post">
    <div>
                标题：<input type="text" name="title" size=55> <br> 起始时间：<input type="date" name="beginTime"> 借宿时间：<input type="date" name="endTime"><input type="submit" value="搜索">
    </div>
    </form>
    <div> 
    <c:forEach items="${mlist}" var="mess">
        <div class="article">  
            <div class="author">"${mess.name}"<span>"${mess.id}"</span></div>
            <div class="content">"${mess.content}</div>
            <div class="time page"><fmt:formatDate value="${mess.date}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
        </div>
      </c:forEach> 
    </div>

    <div class="page">
       <%=PageController.createPageCode((Integer)request.getAttribute("pageNum"),(Integer)request.getAttribute("maxPage"),"getMsgByPage")%>
    </div><br>
    <div>
        <form action="addMesg" method="post">
        <input type="hidden" name="id">
            <div>
                用户: <input type="text" name="author" value=""/>
            </div><br>
            <div>
                留言: <textarea name="message" rows="5" cols="72"></textarea>
            </div>
            <div align="center"><input type="reset" value="清除"/> <input type="submit" value="发表"/></div>
        </form>
    </div>
</div>
</body>
</html>
