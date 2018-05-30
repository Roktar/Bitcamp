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

<c:set var="age" value="20" scope="page"/>

<c:if test="${20 > 25 }" var="r1" scope="page" />
${r1}
<c:if test="${ age > 19 }" >
성년
</c:if>

</body>
</html>