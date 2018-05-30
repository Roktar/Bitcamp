<%@page import="bitcamp.java106.pms.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id='header'>
<% 
HttpSession ses = request.getSession();
Member loginUser = (Member) ses.getAttribute("loginUser");
%>
<% 
if(loginUser == null) { %>
    <a href='<%= request.getContextPath() %>/auth/login'>로그인</a>
<%  } else { %>
    <%= loginUser.getId() %> <a href='<%= request.getContextPath() %>/auth/logout'>로그아웃</a>
<% } %>
</div>
