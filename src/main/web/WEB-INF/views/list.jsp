<%--
  Created by IntelliJ IDEA.
  User: lse
  Date: 9/23/18
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<table width="500" cellpadding="0" cellspacing="0" border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Title</td>
        <td>Date</td>
        <td>Hit</td>
    </tr>
    <c:forEach items="${list}" var="dto">
        <tr>
            <td>${dto.bId}</td>
            <td>${dto.bName}</td>
            <td>
                <c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
                <a href="content_view?bId=${dto.bId}">${dto.bTitle}</a></td>
            <td>${dto.bDate}</td>
            <td>${dto.bHit}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5"><a href="write_view">Write</a></td>
    </tr>
</table>
</body>
</html>
