<%@page import="java.util.HashMap"%>
<%@page import="jsp.Member"%>
<%@page import="jsp.Team"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>맵에서 값 꺼내기</title>
</head>
<body>

<%

HashMap<String, String> names3 = new HashMap<>();
names3.put("s01", "홍길동");
pageContext.setAttribute("names3", names3);

%>

${names3.get("s01") } <br>

<h1> 일반 자바객체에서의 값 꺼내기</h1>

${team.name }
${team["name"] }
${team['name'] }

</body>
</html>