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

<c:url value="http://localhost:8888/bitcamp-java-project/member/add" var="url1" scope="page">
    <c:param name="id" value="user01" />
    <c:param name="email" value="user01@test.com" />
    <c:param name="password" value="1111" />
</c:url>

</body>
</html>