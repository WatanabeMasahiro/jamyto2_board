<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="classes.*"%>

<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>

<jsp:useBean class="classes.BbsArticle" id="article" scope="session"/>

<!DOCTYPE html>
<html>
	<head>
	  <meta charset="UTF-8">
	  <title>掲示板</title>
	  
	  <script src="https://code.jquery.com/jquery-3.6.0.min.js"
	    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	  <script src="<%=request.getContextPath() %>/js/main.js"></script>
	  
	  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	    crossorigin="anonymous">
	  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
	  
	</head>
	<%
	String strPswd = request.getParameter("password");
	boolean blResult = false;
	try {
		blResult = article.delete(strPswd);
	} catch(SessionTimeoutException e) {
	  %><jsp:forward page="/session_timeout.jsp"/><%
	}
	%>
	<body>
    <div class="container">

		  <h2 class="mt-4 font-weight-bold">【掲示板】</h2>
		  <hr/>
		  <h4>記事の削除</h4>
		  <hr/>
		<% if (blResult) { %>
		  <div class="my-3">削除を完了しました。</div>
		<% } else { %>
		  <div class="my-3">エラーです。</div>
		<% } %>
		  <div>
		    <a href="index.jsp?jump_to=<%= article.getId() %>#anc<%= article.getId() %>" style="text-decoration: underline;">一覧に戻る</a>
		  </div>
	  
    </div>
	</body>
</html>