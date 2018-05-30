<%@page import="bitcamp.java106.pms.domain.Team"%>
<%@page import="java.util.List"%>
<%@page import="bitcamp.java106.pms.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>회원 목록</h2>
<form action='member/add' method='post'>
<input type='hidden' name='teamName' value='123'/><br><input type='text' name='memberId' placeholder='회원 ID를 입력하십시오.' /><br>
<button>추가</button>
<table border=1>
<tr>
<% List<Member> members = (List<Member>)request.getAttribute("members"); %>
<th>계정</th><th>이메일</th><th> </th>
</tr>
<% for(Member mb : members) { %>
<tr>
    <td> <%= mb.getId() %> </td> <td> <%= mb.getEmail() %> </td> <td> <a href='member/delete?teamName=<%= ((Team)request.getAttribute("team")).getName() %>&memberId=<%= mb.getId() %>'>삭제</a></td>
<% } %>
</table>
</form>