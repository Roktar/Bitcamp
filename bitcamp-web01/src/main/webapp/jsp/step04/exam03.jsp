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
/* pageContext.setAttribute("tel", "1111");
request.setAttribute("tel", "1212");
session.setAttribute("tel", "1234"); */
application.setAttribute("tel", "1235");
%>

<%-- ${pageScope.name} <br>
${requestScope.name } <br>
${sessionScope["name"] } <br>
${applicationScope['name'] } <br>
<%= request.getAttribute("name") %> --%>

${tel}<br>

</body>
</html>