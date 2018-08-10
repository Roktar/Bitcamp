<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 업로드 결과 </h1>

name:${name}<br>
age:${age }<br>
<%-- file0-origin:${file0Origin}<br>
file0-new:${file0New}<br>
file1-origin:${file1Origin}<br>
file1-new:${file1New}<br></body> --%>
file0: <img src="../../files/${file0New}" width="200">${file0Origin}<br>
file1: <img src="../../files/${file1New}" width="200">${file1Origin}<br>

</html>