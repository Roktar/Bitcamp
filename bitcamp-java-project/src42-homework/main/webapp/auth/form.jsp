<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <html>
 <head>
 <meta charset='UTF-8'>
 <title>LOGIN</title>
 </head>
 <body>

<%
HttpSession ses = request.getSession();
String id = request.getParameter("id");
%>
 
 <h1>로그인</h1>
 <form action='<%= request.getContextPath() %>/auth/login' method='post'>
 ID: <input type='text' name='id' value=<%= id %>><br>
 PW: <input type='password' name='password'><br>
 <p><input type='checkbox' name='saveId' />아이디 저장</p>
 <button>로그인</button>
 </form>

 </body>
</html>