<%@ page
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view</title>
</head>
<body>

<jsp:include page="header.jsp" />

<h1>Exam09_1의 실행 결과</h1>
name : ${requestScope.name}<br>
age : ${requestScope.age}<br> 

<jsp:include page="footer.jsp"/>
</body>
</html>

<% System.out.println("exam09_1.jsp 실행"); %>