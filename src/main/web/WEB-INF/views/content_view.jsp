<%--
  Created by IntelliJ IDEA.
  User: lse
  Date: 9/24/18
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Page</title>
</head>
<body>
    <table width="500" cellpadding="0" cellspacing="0" border="1">
        <form action="modify" method="post">
            <input type="hidden" name="bId" value="${content_view.bId}">
            <tr>
                <td> Id </td>
                <td> ${content_view.bId} </td>
            </tr>
            <tr>
                <td> Hit </td>
                <td> ${content_view.bHit} </td>
            </tr>
            <tr>
                <td> Name </td>
                <td> <input type="text" name="bName" value="${content_view.bName}"></td>
            </tr>
            <tr>
                <td> Title </td>
                <td> <input type="text" name="bTitle" value="${content_view.bTitle}"></td>
            </tr>
            <tr>
                <td> Content </td>
                <td> <textarea rows="10" name="bContent" >${content_view.bContent}</textarea></td>
            </tr>
            <tr >
                <td colspan="2"> <input type="submit" value="Modify"> &nbsp;&nbsp; <a href="list">list</a> &nbsp;&nbsp; <a href="delete?bId=${content_view.bId}">delete</a> &nbsp;&nbsp; <a href="reply_view?bId=${content_view.bId}">reply</a></td>
            </tr>
        </form>
    </table>
</body>
</html>
