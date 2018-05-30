<%@page import="jsp.Member"%>
<%@page import="jsp.Team"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL</title>
</head>
<body>

<% 
    Member member1 = new Member();
    member1.setId("user01");
    member1.setEmail("user01@test.com");
    member1.setPassword("1111");
    
    Member member2 = new Member();
    member2.setId("user02");
    member2.setEmail("user02@test.com");
    member2.setPassword("1111");
    
    Team team = new Team();
    team.setName("팀1");
    team.setDescription("웹 개발팀");
    team.setMembers(new Member[] {member1, member2} );
    
    pageContext.setAttribute("team", team);
%>

${team.name } <br>
<%= pageContext.getParameter("team").getName() %>

</body>
</html>