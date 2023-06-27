<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/statics/css/bootstrap.min.css">
	<title>城市列表</title>
</head>
<body>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">
			<input type="button" class="btn btn-success btn-sm" value="添加城市" onclick="location.href='${pageContext.request.contextPath}/back/city/add.jsp'"/>
		</div>
	</div>
	<div class="row" style="margin-top: 15px;">
		<div class="col-sm-12">
			<table class="table table-striped table-bordered table-hover" width="35%">
				<tr>
					<th>编号</th>
					<th>名称</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${requestScope.byPage}" var="city">
					<tr>
						<td>${city.id}</td>
						<td>${city.name}</td>
						<td>
							<a href="${pageContext.request.contextPath}/city/removeCity?id=${city.id}" onclick='delRow(${city.id})' class="btn btn-danger btn-sm">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>

			<div align="center">
				<%--判断当前页数>1 有上一页    --%>
				<c:if test="${requestScope.pageNumber>1}">
					<a href="${pageContext.request.contextPath}/city/findByPage?pageNumber=${requestScope.pageNumber-1}">
						<input type="button" value="上一页"></a>
				</c:if>
				<%--判断当前页数<=1 没有上一页--%>
				<c:if test="${requestScope.pageNumber<=1}">
					<a href=""><input type="button" value="上一页"></a>
				</c:if>

				<%--遍历页号--%>
				<c:forEach var="i" begin="1" end="${requestScope.totalCount}" step="1">
					<a href="${pageContext.request.contextPath}/city/findByPage?pageNumber=${i}">${i}</a>
				</c:forEach>

				<%--判断当前页数<总页数  有下一页--%>

				<c:if test="${requestScope.pageNumber < requestScope.totalCount}">
					<a href="${pageContext.request.contextPath}/city/findByPage?pageNumber=${requestScope.pageNumber+1}"><input
							type="button" value="下一页"></a><br>
				</c:if>

				<%--判断当前页数>总页数  没有下一页--%>
				<c:if test="${requestScope.pageNumber >= requestScope.totalCount}">
					<a ><input type="button" value="下一页"></a><br>
				</c:if>


			</div>
		</div>
	</div>

</div>


</body>
</html>
<script>
	function delRow(id){
		if(window.confirm('确定要删除这条记录吗?')) location.href='${pageContext.request.contextPath}/city/delete?id='+id;
	}
</script>