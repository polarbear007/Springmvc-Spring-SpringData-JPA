<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$("#deleteOne").click(function(){
			var url = this.href;
			$("#deleteForm").attr("action", url).submit();
			return false;
		});
	})
</script>
</head>
<body>
	<form id="deleteForm" action="" method="post">
		<input type="hidden" name="_method" value="delete">
	</form>
	<form id="putForm" action="" method="post">
		<input type="hidden" name="_method" value="put">
	</form>
	<table border="1px" style="width: 1200px; ">
		<caption><h2>所有员工信息</h2></caption>
		<thead>
			<tr>
				<td><input id="selectAll" type="checkbox" >全选</td>
				<td>编号</td>
				<td>姓</td>
				<td>名</td>
				<td>邮箱</td>
				<td>电话</td>
				<td>薪水</td>
				<td>入职日期</td>
				<td>部门</td>
				<td>工种</td>
				<td colspan="2">操作</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.content }" var="emp">
				<tr>
					<td><input name="select" type="checkbox" value="${emp.employeeId }"></td>
					<td>${emp.employeeId }</td>
					<td>${emp.firstName }</td>
					<td>${emp.lastName }</td>
					<td>${emp.email }</td>
					<td>${emp.phoneNumber }</td>
					<td>${emp.salary }</td>
					<td><fmt:formatDate value="${emp.hireDate }" pattern="yyyy-MM-dd"/></td>
					<td>${emp.department.departmentName }</td>
					<td>${emp.job.jobTitle }</td>
					<td><a href="${pageContext.request.contextPath }/employees/updateEmployeesPage/${emp.employeeId}">修改</a></td>
					<td><a id="deleteOne" href="${pageContext.request.contextPath }/employees/emp/${emp.employeeId}">删除</a></td>
				</tr>	
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td>
					<input type="button" value="删除选中">
				</td>
				<td colspan="9" align="center">
					<c:if test="${page.firstPage }">
						上一页
					</c:if>
					<c:if test="${ !page.firstPage }">
						<a href="${pageContext.request.contextPath }/employees/emp/0">首页</a>
						<a href="${pageContext.request.contextPath }/employees/emp/${page.number - 1}">上一页</a>
					</c:if>
					当前页<input type="text" value="${page.number + 1 }"  style="width:25px" /> / 总页数<input type="text" value="${page.totalPages }" style="width:25px" />
					<c:if test="${page.lastPage }">
						下一页
					</c:if>
					<c:if test="${ !page.lastPage }">
						<a href="${pageContext.request.contextPath }/employees/emp/${page.number + 1}">下一页</a>
						<a href="${pageContext.request.contextPath }/employees/emp/${page.totalPages - 1}">最后一页</a>
					</c:if>
				</td>
				<td colspan="2">
					<a href="${pageContext.request.contextPath}/employees/addEmployeePage">添加员工</a>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>