<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2019/11/25
  Time: 13:48
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
        <h1>添加信息</h1>
        <form action="/add" method="post">
            <table>
                <tr align="center">
                    <td>图书名称</td>
                    <td>
                        <input type="text" name="bookname">
                    </td>
                </tr>
                <tr align="center">
                    <td>图书摘要</td>
                    <td>
                        <input type="text" name="bookzhai">
                    </td>
                </tr>
                <tr align="center">
                    <td>上传人</td>
                    <td>
                        <input type="text" name="bookr">
                    </td>
                </tr>
                <tr align="center">
                    <td>上传时间</td>
                    <td>
                        <input type="date" name="bookdate">
                    </td>
                </tr>
                <tr align="center">
                    <td>类型</td>
                    <td>
                        <select name="cId">
                            <option value="0">请选择</option>
                            <c:forEach items="${edoccategories}" var="cards">
                                <option value="${cards.id}">
                                        ${cards.name}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
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
</html>
