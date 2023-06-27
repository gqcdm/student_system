<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>班级列表</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/statics/css/bootstrap.min.css">
</head>
<body>
<center><h4 style="color: red">${requestScope.emg}</h4></center>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12" style="margin:20px 0px; ">
            <input type="button" value="添加班级" class="btn btn-sm btn-info" onclick="location.href='${pageContext.request.contextPath}/clazz/findAllTag'"/>
        </div>
        <div class="col-sm-12">
            <div class="row">
                <c:forEach items="${requestScope.all}" var="clazz">
                    <div class="col-sm-3">
                        <div class="thumbnail">
                            <img style="width: 520px;height: 180px;" src="${pageContext.request.contextPath}/upload${clazz.path}" alt="...">
                            <div class="caption">
                                <h4>${clazz.name}</h4>
                                <p><span class="label label-info">${clazz.tag.name}</span></p>
                                <p><a href="${pageContext.request.contextPath}/clazz/removeClazz?id=${clazz.id}" class="btn btn-danger btn-sm btn-block" role="button">删除班级</a>

                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>
<%--<c:if test="${requestScope.start == 1}">--%>
<%--    <script>--%>
<%--        window.alert("有学生不能删")--%>
<%--    </script>--%>
<%--</c:if>--%>
</html>