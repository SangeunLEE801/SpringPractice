<%--
  Created by IntelliJ IDEA.
  User: lse
  Date: 10/1/18
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table width="500" cellpadding="0" cellspacing="0" border="1">
    <form action="write" method="post">
        <tr>
            <td> Name </td>
            <td> <input type="text" name="bName" size = "50"> </td>
        </tr>
        <tr>
            <td> Title </td>
            <td> <input type="text" name="bTitle" size = "50"> </td>
        </tr>
        <tr>
            <td> Content </td>
            <td> <textarea name="bContent" rows="10" ></textarea> </td>
        </tr>
        <tr >
            <td colspan="2"> <input type="submit" value="submit"> &nbsp;&nbsp; <a href="list">list</a></td>
        </tr>
    </form>
</table>
</body>
</html>
