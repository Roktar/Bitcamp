<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="facebookUrl" value="https://graph.facebook.com/v3.0/me">
    <c:param name="access_token" value="${param.accessToken}"/>
    <c:param name="fields" value="id,name,email,gender"/>
</c:url>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 클라이언트로부터 액세스 토큰을 받은 후
토큰을 사용하여 사용자 정보를 받아오고
클라이언트 입장에서는 서버에 요청했던 데이터를 표시해주는 ㅇ역할을 담당한다.
반환되는 형태는 JSON 타입인 듯. -->
<c:import url="${facebookUrl}"/>
</body>
</html>









