<%--
  Created by IntelliJ IDEA.
  User: zhukang
  Date: 2021-04-16
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>论坛帖子列表</title>
</head>
<body>
    <h2 align="center">海角论坛-帖子列表</h2>
    <form action="/bbsListUsePage" method="post">
        <p align="center">
            <span>讨论版区：</span>
            <select name="sortId" id="sortId">
                <option value="0">全部</option>
                <c:forEach items="${bbsSorts}" var="bbsSort">
                    <c:if test="${bbsSort.id == sortId}">
                        <option value="${bbsSort.id}" selected>${bbsSort.name}</option>
                    </c:if>
                    <c:if test="${bbsSort.id != sortId}">
                        <option value="${bbsSort.id}">${bbsSort.name}</option>
                    </c:if>
                </c:forEach>
            </select>&nbsp;&nbsp;
            标题：<input type="text" name="title" id="title" value="${title}"/>
            <input type="submit" value="搜索"/>&nbsp;&nbsp;
            <input type="button" value="发帖"/>
        </p>
    </form>
    <table align="center" width="100%" border="1px" cellspacing="0">
        <thead>
            <tr style="height: 60px; background-color: dodgerblue;">
                <th>帖子ID</th>
                <th>标题</th>
                <th>详情</th>
                <th>作者</th>
                <th>发布时间</th>
                <th>回复次数</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${bbsDetails}" var="bbsDetail">
                <tr align="center">
                    <td>${bbsDetail.id}</td>
                    <td>${bbsDetail.title}</td>
                    <td>${bbsDetail.detail}</td>
                    <td>${bbsDetail.author}</td>
                    <td><fmt:formatDate value="${bbsDetail.createDate}" pattern="yyy-MM-dd"/> </td>
                    <td>${bbsDetail.replyCount}</td>
                    <td>
                        <a href="toModBbsDetail?id=${bbsDetail.id}">修改</a>&nbsp;
                        <a href="delBbsDetail?id=${bbsDetail.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="7" align="center">
                    当前[${page.currPageNo}]页&nbsp;&nbsp;
                    <a href="1">首页</a>&nbsp;&nbsp;
                    <a href="${page.currPageNo - 1}">上一页</a>&nbsp;&nbsp;
                    <a href="${page.currPageNo + 1}">下一页</a>&nbsp;&nbsp;
                    <a href="${page.totalPage}">尾页</a>&nbsp;&nbsp;
                    共[${page.totalPage}]页
                </td>
            </tr>
        </tfoot>
    </table>
</body>
<p style="color: red; text-align: center;">${msg}</p>
<script src="js/jquery-3.5.1.min.js"></script>
<script>
    $(function () {
        // 发帖
        $("input:last").click(function () {
            location.href="/toAddBbsDetail";
        });

        // 分页
        $("tfoot a").click(function () {
            location.href = "bbsListUsePage?sortId=" + $("#sortId").val() + "&title=" + $("#title").val() + "&pageNo=" + $(this).attr("href");
            return false;
        })
    })
</script>
</html>
