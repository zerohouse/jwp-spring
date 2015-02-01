<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ include file="/include/tags.jspf"
%><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SLiPP :: 회원가입</title>

<%@ include file="/include/header.jspf"%>
</head>
<body>
	<%@ include file="/include/top.jspf"%>
	
	<div id="main">
		<form:form modelAttribute="user" action="/users" method="post">
			<table>
				<tr>
					<td width="150">사용자 아이디</td>
					<td>
						<form:input path="userId" size="50"/>
						<form:errors path="userId" cssClass="error" />
					</td>
				</tr>			
				<tr>
					<td width="150">비밀번호</td>
					<td>
						<form:password path="password" size="50"/>
						<form:errors path="password" cssClass="error" />					
					</td>
				</tr>
				<tr>
					<td width="150">이름</td>
					<td>
						<form:input path="name" size="50"/>
						<form:errors path="name" cssClass="error" />
				</tr>
				<tr>
					<td width="150">이메일</td>
					<td>
						<form:input path="email" size="50"/>
						<form:errors path="email" cssClass="error" />
				</tr>
			</table>
			<input type="submit" value="회원가입" />			
		</form:form>
	</div>
</body>
</html>