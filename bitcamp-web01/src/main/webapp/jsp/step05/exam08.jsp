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

<h1> 배열 반복</h1>
<%
pageContext.setAttribute("names", new String[] { "홍길동", "임꺽정", "유관순", "안중근", "윤봉길", "김구", "신채호", "김원봉" });
%>

</body>
</html>