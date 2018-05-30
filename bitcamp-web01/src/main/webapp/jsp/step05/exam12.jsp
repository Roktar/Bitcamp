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

<c:import url="http://search.zdnet.co.kr/" var="url1" scope="page" >
    <c:param name="kwd" value="정상회담" />
    <c:param name="x" value="0" />
    <c:param name="y" value="0" />
</c:import>

<a href=${url1}> 만든 url로 이동 </a>
</body>
</html>