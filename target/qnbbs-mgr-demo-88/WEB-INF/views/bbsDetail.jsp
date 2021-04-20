<%--
  Created by IntelliJ IDEA.
  User: zhukang
  Date: 2021-04-16
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>帖子添加</title>
</head>
<body>
    <form action="/addBbsDetail" method="post">
        <table align="center" width="60%" border="1px" cellspacing="0">
            <tr style="background-color: dodgerblue; height: 80px;">
                <th colspan="2">发布新帖</th>
            </tr>
            <tr>
                <td>发布版区：</td>
                <td>
                    <select name="sortId" id="sortId">
                        <c:forEach items="${bbsSorts}" var="bbsSort">
                            <option value="${bbsSort.id}">${bbsSort.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>作者：</td>
                <td>
                    <input type="text" name="author" id="author"/>&nbsp;&nbsp;<span style="color: red;">*</span>
                </td>
            </tr>
            <tr>
                <td>标题：</td>
                <td>
                    <input type="text" name="title" id="title"/>&nbsp;&nbsp;<span style="color: red;">*</span>
                </td>
            </tr>
            <tr>
                <td>详细内容：</td>
                <td>
                    <textarea cols="50" rows="5" name="detail"></textarea>&nbsp;&nbsp;<span style="color: red;">*</span>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="button" value="返回"/>
                </td>
            </tr>
        </table>
    </form>
</body>
<script src="js/jquery-3.5.1.min.js"></script>
<script>
    $(function () {
        $("input[type=button]").click(function () {
            history.back();
        });

        // 提交表单
        $("form").submit(function () {
            // 作者不能为空
            if($("#author").val() == ""){
                alert("作者不能为空");
                return false;
            }

            if($("#title").val() == ""){
                alert("标题不能为空");
                return false;
            }
        })
    })
</script>

</html>
