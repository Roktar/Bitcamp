<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 스크립틀릿 </title>
</head>
<body>

<% int i=10; %>
bbb
<% i *= 20; %>
ccc
<% if(i > 10)
    out.println("10이상");
   else
    out.println("10이하");
%>

</body>
</html>