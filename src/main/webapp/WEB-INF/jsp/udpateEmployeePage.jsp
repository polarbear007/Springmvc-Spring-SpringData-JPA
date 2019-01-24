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
		<table border="1px" style="width: 500px; ">
			<caption><h2>修改员工信息页面</h2></caption>
			<tr>
				<td>编号</td>
				<td><input type="text" name="employeeId" value="${employees.employeeId }" readonly="readonly"></td>
			</tr>
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
							<c:choose>
								<c:when test="${employees.department.departmentId == dept.departmentId }">
									<option value="${dept.departmentId }" selected="selected">${dept.departmentName }</option>
								</c:when>
								<c:otherwise>
									<option value="${dept.departmentId }" >${dept.departmentName }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
					<%-- <input type="text" name="department.departmentName" value="${employees.department.departmentName }" >
					<input type="hidden" name="department.departmentId" value="${employees.department.departmentId }"> --%>
				</td>
			</tr>
			<tr>
				<td>工种</td>
				<td>
					<select name="job.jobId">
						<c:forEach items="${jobList }" var="jobItem">
							<c:choose>
								<c:when test="${employees.job.jobId == jobItem.jobId }">
									<option value="${jobItem.jobId }" selected="selected">${jobItem.jobTitle }</option>
								</c:when>
								<c:otherwise>
									<option value="${jobItem.jobId }" >${jobItem.jobTitle }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
					<%-- <input type="text" name="job.jobTitle" value="${employees.job.jobTitle }" >
					<input type="hidden" name="job.jobId" value="${employees.job.jobId }"> --%>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="修改">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>