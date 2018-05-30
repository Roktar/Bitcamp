<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL</title>
</head>
<body>

<%
pageContext.setAttribute("name", "길동 홍");
pageContext.setAttribute("age", 20);
request.setAttribute("name", "임꺽정");
session.setAttribute("name", "유관순");
application.setAttribute("name", "윤봉길");
%>

${pageScope.name} <br>
${requestScope.name } <br>
${sessionScope["name"] } <br>
${applicationScope['name'] } <br>
<%= request.getAttribute("name") %>

</body>
</html>