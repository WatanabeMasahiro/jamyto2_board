<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="classes.*"%>

<%@ page import="org.apache.commons.codec.digest.DigestUtils"%>

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
	<body>
		<div class="container">
			  <h2 class="mt-4 font-weight-bold">【掲示板】</h2>
			  <hr/>
			  <h4>記事の編集</h4>
			  <hr/>
			<%
			request.setCharacterEncoding("UTF-8");
			String strId = request.getParameter("id");
			int intId = 0;
			if (strId != null) {
			  intId = Integer.parseInt(strId);
			}
			String strPswd = request.getParameter("password");
			boolean blResult = article.load(intId, strPswd);
			
			if (blResult) {
			%>
			  <form name="form1" method="POST" action="edit_3.jsp">
			    <div style="margin-top: 20px;">
			      <p style="margin-bottom: 5px;">名前：<%= article.getAuthor() %></p>
			    </div>
			    <div style="margin-top: 20px;">
			      <p style="margin-bottom: 5px;">件名：　</p>
			      <input type="text" name="subject"  class="w-25" size="80" value="<%= article.getSubject() %>">
			    </div>
			    <div style="margin-top: 20px;">
			      <p style="margin-bottom: 5px;">本文：　</p>
			      <textarea cols="60" rows="5" name="body"><%= article.getBody() %></textarea>
			    </div>
			    <div class="mt-3">
			      <input type="hidden" name="password" value="<%= DigestUtils.sha256Hex(strPswd) %>">
			      <input type="submit" value="送信" class="btn btn-secondary border border-dark">
			    </div>
			  </form>
			<%
			} else {
			%>
			  <div>パスワードが違います。</div>
			<%
			}
			%>
			  <div style="margin-top: 25px;">
			    <a href="javascript:history.back()" style="text-decoration: underline;">戻る</a>
			  </div>
		
		</div>
	</body>
</html>