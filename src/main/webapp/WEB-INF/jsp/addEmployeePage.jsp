<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/employees/emp" method="post">
		<input type="hidden" name="_method" value="put">
		<table border="1px" style="width: 500px; ">
			<caption><h2>添加员工信息页面</h2></caption>
			<tr>
				<td>姓</td>
				<td><input type="text" name="firstName" value="${employees.firstName }" ></td>
			</tr>
			<tr>
				<td>名</td>
				<td><input type="text" name="lastName" value="${employees.lastName }" ></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email" value="${employees.email }" ></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="phoneNumber" value="${employees.phoneNumber }" ></td>
			</tr>
			<tr>
				<td>薪水</td>
				<td><input type="text" name="salary" value="${employees.salary }" ></td>
			</tr>
			<tr>
				<td>入职日期</td>
				<td><input type="text" name="hireDate" value='<fmt:formatDate value="${employees.hireDate }" pattern="yyyy-MM-dd" />' ></td>
			</tr>
			<tr>
				<td>部门</td>
				<td>
					<select name="department.departmentId">
						<c:forEach items="${deptList }" var="dept">
							<option value="${dept.departmentId }" >${dept.departmentName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>工种</td>
				<td>
					<select name="job.jobId">
						<c:forEach items="${jobList }" var="jobItem">
							<option value="${jobItem.jobId }" >${jobItem.jobTitle }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="添加">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>