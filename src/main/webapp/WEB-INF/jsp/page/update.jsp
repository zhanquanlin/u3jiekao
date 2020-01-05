<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2019/11/25
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
    <center>
        <h1>修改信息</h1>
        <form action="/update2?id=${edocentry.id}" method="post">
            <table>
                <tr align="center">
                    <td>图书编号</td>
                    <td>
                        <input name="bookid" value="${edocentry.id}">
                    </td>
                </tr>
                <tr align="center">
                    <td>图书名称</td>
                    <td>
                        <input type="text" name="bookname" value="${edocentry.title}">
                    </td>
                </tr>
                <tr align="center">
                    <td>图书摘要</td>
                    <td>
                        <input type="text" name="bookzhai" value="${edocentry.summary}">
                    </td>
                </tr>
                <tr align="center">
                    <td>上传人</td>
                    <td>
                        <input type="text" name="shangchuanr" value="${edocentry.uploaduser}"/>
                    </td>
                </tr>

                <tr>
                    <td>上传时间</td>
                    <td><input type="date" name="shangchuanshi" value="${edocentry.createdate}"/></td>
                </tr>
                <tr align="center">
                    <td colspan="2">
                        <input type="submit" value="添加">
                        <input type="reset" value="重置">
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>

<script>
    
</script>
</html>
