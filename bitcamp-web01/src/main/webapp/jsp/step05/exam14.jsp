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
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:choose>
    <c:when test="${param.type == 1 }">
        <fmt:parseDate value="${param.date }" pattern="yyyy-MM-dd" var="d1" />
    </c:when>
    <c:when test="${param.type == 2 }">
        <fmt:parseDate value="${param.date }" pattern="MM/dd/yyyy" var="d1" />
    </c:when>
    <c:otherwise>
        <c:set var="d1" value="유효한 형식이 아님" />
    </c:otherwise>
</c:choose>

날짜 : ${d1}

</body>
</html>