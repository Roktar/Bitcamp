<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <html>
 <head>
 <meta charset='UTF-8'>
 <meta http-equiv="Refresu" content="5;url=<%= request.getContextPath() %>/auth/form.jsp">
 <title>LOGIN</title>
 </head>
 <body>

 <h1>로그인 실패</h1>
 <form action='login' method='post'>
 ID: <input type='text' name='id' value=><br>
 PW: <input type='password' name='password'><br>
 <p><input type='checkbox' name='saveId' />아이디 저장</p>
 <button>로그인</button>
 </form>

 </body>
</html>