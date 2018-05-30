<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jsp.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL</title>
</head>
<body>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1> 리스트 반복</h1>
<%
List<String> names = new ArrayList<String>();
names.add("홍길동");
names.add("임꺽정");
names.add("유관순");
names.add("안중근");
names.add("윤봉길");
names.add("김구");
names.add("신채호");
names.add("김원봉");
%>

<c:forEach items="${names}" begin="0" end="7" var="name">
</c:forEach>

<h1> 맵 반복 </h1>

<%
Map<String, String> names2 = new HashMap<>();
names2.put("s01", "홍길동");
names2.put("s02","임꺽정");
names2.put("s03","유관순");
names2.put("s04","안중근");
names2.put("s05","윤봉길");
names2.put("s06","김구");
names2.put("s07","신채호");
names2.put("s08","김원봉");
pageContext.setAttribute("names2", names2);
%>

<c:forEach items="${names2}" var="name">
${pageScope.name.key } ==> ${pageScope.name.value }
</c:forEach>


</body>
</html>