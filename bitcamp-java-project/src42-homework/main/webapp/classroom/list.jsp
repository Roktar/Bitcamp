<%@page import="java.util.List"%>
<%@page import="bitcamp.java106.pms.domain.Classroom"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>강의 목록</title>
</head>
<body>
<h1>강의 목록</h1>
<p><a href='form.html'>새 강의</a></p>
<table border='1'>
<tr>
    <th>번호</th><th>강의명</th><th>기간</th><th>강의실</th>
</tr>
    <% List<Classroom> list = (List<Classroom>) request.getAttribute("list");
    
    for(Classroom cls : list) {
    %>
    <tr>
    <td> <a href='view?no=<%= cls.getNo() %>'><%= cls.getNo() %></a> </td> <td> <%= cls.getTitle() %> </td><td> <%= cls.getStartDate() %> ~ <%= cls.getEndDate() %> </td><td> <%= cls.getRoom() %> </td>
    </tr>
    <% } %>
</table>
</body>
</html>
