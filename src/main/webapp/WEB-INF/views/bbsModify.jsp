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
    <title>帖子修改</title>
</head>
<body>
    <form action="/modBbsDetail" method="post">
        <input type="hidden" name="id" value="${bbsDetail.id}"/>
        <table align="center" width="60%" border="1px" cellspacing="0">
            <tr style="background-color: dodgerblue; height: 80px;">
                <th colspan="2">修改新帖</th>
            </tr>
            <tr>
                <td>发布版区：</td>
                <td>
                    <select name="sortId" id="sortId">
                        <c:forEach items="${bbsSorts}" var="bbsSort">
                            <c:if test="${bbsDetail.sortId == bbsSort.id}" var="flag">
                                <option value="${bbsSort.id}" selected>${bbsSort.name}</option>
                            </c:if>
                            <c:if test="${!flag}">
                                <option value="${bbsSort.id}">${bbsSort.name}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>作者：</td>
                <td>
                    <input type="text" name="author" id="author" value="${bbsDetail.author}"/>&nbsp;&nbsp;<span style="color: red;">*</span>
                </td>
            </tr>
            <tr>
                <td>标题：</td>
                <td>
                    <input type="text" name="title" id="title" value="${bbsDetail.title}"/>&nbsp;&nbsp;<span style="color: red;">*</span>
                </td>
            </tr>
            <tr>
                <td>回复数量：</td>
                <td>
                    <input type="text" name="replyCount" id="replyCount" value="${bbsDetail.replyCount}"/>&nbsp;&nbsp;<span style="color: red;">*</span>
                </td>
            </tr>
            <tr>
                <td>详细内容：</td>
                <td>
                    <textarea cols="50" rows="5" name="detail">${bbsDetail.detail}</textarea>&nbsp;&nbsp;<span style="color: red;">*</span>
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

            // 异步请求方式，处理
            $.ajax({
                "url" : "modBbsDetail",
                "type" : "post",
                "data" : $("form").serialize(),
                "dataType" : "json",
                "success" : function (data) {
                    if(data){
                        alert("修改成功！！！");
                        location.href="bbsList";
                    } else {
                        alert("修改失败！！！");
                    }
                }
            });

            // 一旦有了异步，必须取消默认提交
            return false;
        })
    })
</script>

</html>
