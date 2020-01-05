<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2019/11/25
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <script>
        <c:if test="${insert=='success'}">
        alert("添加成功！");
        </c:if>
        <c:if test="${insert=='fail'}">
        alert("添加失败！");
        </c:if>
        <c:if test="${del=='success'}">
        alert("删除成功！");
        </c:if>
        <c:if test="${del=='fail'}">
        alert("删除失败！");
        </c:if>
        <c:if test="${update=='success'}">
        alert("修改成功！");
        </c:if>
        <c:if test="${update=='fail'}">
        alert("修改失败！");
        </c:if>
    </script>
</head>
<body>
    <center>
        <h1>用户数据列表</h1>
            <table  border="1" cellspacing="0" cellpadding="5" width="80%">
                <form action="/list" method="post" id="myform">
                    <input type="hidden" name="p" id="p"/>
                    <tr align="center">
                        <td colspan="7">
                            卡种分类：
                            <select name="cId">
                                <option value="0">全部</option>
                                <c:forEach items="${edoccategories}" var="cards">
                                    <option value="${cards.id}"
                                            <c:if test="${cards.id==cid}">selected</c:if>
                                    >
                                            ${cards.name}
                                    </option>
                                </c:forEach>
                            </select>
<%--                            姓名：<input type="text" name="username" placeholder="请输入简称或姓" value="${user.username}">--%>
                            <input type="submit" value="查询">
                            <input type="button" onclick="add()" value="添加账户">
                        </td>
                    </tr>
                </form>
                <tr align="center">
                    <td>账户编号</td>
                    <td>图书名称</td>
                    <td>图书摘要</td>
                    <td>上传人</td>
                    <td>上传时间</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${pageInfo.list}" var="pageInfo">
                    <tr align="center">
                        <td>${pageInfo.id}</td>
                        <td>${pageInfo.title}</td>
                        <td>${pageInfo.summary}</td>
                        <td>${pageInfo.uploaduser}</td>
                        <td><fmt:formatDate value="${pageInfo.createdate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                        <td>
                            <input type="button" onclick="del(${pageInfo.id})" value="删除">
                        </td>
                        <td>
                            <input type="button" onclick="update(${pageInfo.id})" value="修改">
                        </td>
                    </tr>
                </c:forEach>


                <tr align="center">
                    <td colspan="7">
                        <a href="javascript:toPage(1)">首页</a>&nbsp;&nbsp;&nbsp;
                        <a href="javascript:toPage(${pageInfo.pageNum-1})">上一页</a>&nbsp;&nbsp;&nbsp;
                        <a href="javascript:toPage(${pageInfo.pageNum+1})">下一页</a>&nbsp;&nbsp;&nbsp;
                        <input type="text" name="" placeholder="请输入要查找的页面" id="yep">&nbsp;&nbsp;&nbsp;
                        <a href="javascript:fn(${pageInfo.pageNum})">go</a>&nbsp;&nbsp;&nbsp;
                        <a href="javascript:toPage(${pageInfo.pages})">尾页</a>&nbsp;&nbsp;&nbsp;
                        ${pageInfo.pageNum}/${pageInfo.pages}页
                    </td>
                </tr>
            </table>
    </center>
</body>
<script>
    function toPage(p) {
        //获取p的隐藏域的标签对象
        var op = document.getElementById("p");
        //给p的隐藏域的标签对象设置value值
        op.value = p;
        //提交表单
        //1.给form标签添加id属性
        //2.得到form标签对象调用submit()函数就OK
        var omyform = document.getElementById("myform");
        omyform.submit();
    }
    function fn(p){
        var value = document.getElementById("yep").value;
        var op = document.getElementById("p");
        p=value;
        op.value=p;
        var omyform = document.getElementById("myform");
        omyform.submit();
    }
    
    function add() {
        location.href="/add1";
    }
    function update(id) {
        location.href="/update?id="+id
    }
    function del(id) {
        location.href="/del?id="+id
    }
</script>
</html>
