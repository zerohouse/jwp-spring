<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ include file="/include/tags.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SLiPP :: 로그인</title>

<%@ include file="/include/header.jspf"%>
</head>
<body>
	<%@ include file="/include/top.jspf"%>

	<div id="main">
		<c:if test="${not empty errorMessage}">
		<div class="error">${errorMessage}</div>
		</c:if>
		<form action="/users/login" method="post">
			<table>
				<tr>
					<td width="150">사용자 아이디</td>
					<td>
						<input type="text" id="userId" name="userId" size="70">
					</td>
				</tr>			
				<tr>
					<td width="150">비밀번호</td>
					<td>
						<input type="password" id="password" name="password" size="70">
					</td>
				</tr>
			</table>
			<input type="submit" value="로그인" />			
		</form>
	</div>
</body>
</html>