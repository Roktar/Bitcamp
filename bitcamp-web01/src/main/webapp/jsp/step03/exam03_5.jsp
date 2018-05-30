<%@page import="java.util.ArrayList"%>
<%@page import="jsp.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam03_5</title>
</head>
<body>
<h1>JSP 전용 태그: useBean + scope 속성</h1>

<%
Member obj = new Member();
obj.setId("홍길동");
obj.setEmail("hong@test.com");
obj.setPassword("1111");

Member obj2 = new Member();
obj.setId("홍길동");
obj.setEmail("hong@test.com");
obj.setPassword("1111");
//pageContext.setAttribute("member", obj);
ArrayList<Member> arr = new ArrayList<>();
arr.add(obj);
arr.add(obj2);

pageContext.setAttribute("list", arr);
%>
<jsp:useBean id="list" type="java.util.ArrayList<Member>" />

<%-- 자바 코드: 
jsp.Member member = (jsp.Member)pageContext.getAttribute("member");
if (member == null) {
    member = new jsp.Member();
    pageContext.setAttribute("member", member);
}
--%>
<% for(Member member : list) { %>
아이디: <%=member.getId()%><br>
이메일: <%=member.getEmail()%><br>
암호: <%=member.getPassword()%><br>
<% } %>

</body>
</html>
