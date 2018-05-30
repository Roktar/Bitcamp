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

<c:set var="name" value="길동" scope="page" />
<c:set var="name2" value="꺽정" scope="page" />
<c:set var="name3" scope="page"> 관순 </c:set>

page name : ${pageScope.name } <br>
request name : ${requestScope.name } <br>
session name : ${sessionScope.name } <br>
servletContext name : ${applicationScope.name } <br>
page name : ${pageScope.name2 } <br>
request name : ${requestScope.name2 } <br>
session name : ${sessionScope.name2 } <br>
servletContext name : ${applicationScope.name2 } <br>
page name : ${pageScope.name3 } <br>
request name : ${requestScope.name3 } <br>
session name : ${sessionScope.name3 } <br>
servletContext name : ${applicationScope.name3 } <br>

</body>
</html>