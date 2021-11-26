<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="classes.*"%>
<%@ page import="org.apache.commons.lang3.StringUtils"%>


<jsp:useBean class="classes.BbsArticleList" id="articleList" scope="page"/>

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
		  <hr style="border-width: 2px;"/>
		  <h4>検索結果</h4>
      <hr style="border-width: 2px;"/>
		<%
		request.setCharacterEncoding("UTF-8");
		String strSearchString = request.getParameter("search");
		articleList.search(strSearchString);
		while(articleList.next()) {
			BbsArticle article = articleList.getArticle();
		%>
				<table style="border-collapse:separate; border-spacing: 5px;">
				  <tr>
		        <td style="width: 80px;">
		          <a href="index.jsp?jump_to=<%= article.getId() %>#anc<%= article.getId() %>" style="text-decoration: underline;">番号: <%= article.getId() %></a>
		        </td>
		        <td style="width: 150px;" class="text-info font-weight-bold bg-white p-1 rounded">
		          <div class="text-secondary">名前: </div><%= StringUtils.abbreviate(TextConv.beforeHtml(article.getAuthor()), 20) %>
		        </td>
		        <td style="width: 180px;" class="bg-white bgwhiteNo1 p-1 rounded">
		          <div class="text-secondary font-weight-bold">件名: </div><%= StringUtils.abbreviate(TextConv.beforeHtml(article.getSubject()), 20) %>
		        </td>
		      </tr>
		      <tr>
		        <td style="width: 450px;" class="bg-white bgwhiteNo2 p-1 rounded" colspan="3">
		          <div class="text-secondary font-weight-bold">本文: </div><%= StringUtils.abbreviate(TextConv.embedLink(TextConv.beforehtmlAddNewline(article.getBody())), 30) %>
		        </td>
		      </tr>
				</table>
			<hr/>
		<% } %>
		
		<!-- もし検索結果がなければ、　「検索結果がありませんでした。」の表示。 -->
		  <hr/>
		  <div class="mb-5">
		    <a href="javascript:history.back()" style="text-decoration: underline;">戻る</a>
		  </div>

    </div>
	</body>
</html>