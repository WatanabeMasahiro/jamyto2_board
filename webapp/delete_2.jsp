<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="java.text.*"%>
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
		  <h4>記事の削除</h4>
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
			DateFormat df = new SimpleDateFormat("yyyy'年'MM'月'dd'日' E'曜日' HH'時'mm'分'");
		%>
		  <table>
		    <tr>
		      <td>【番号】</td>
		      <td><%= article.getId() %>
		    </tr>
		    <tr>
		      <td>【日時】</td>
		      <td class="small" style="font-style: italic"><%= df.format(article.getDateTime()) %></td>
		    </tr>
		    <% if(article.getEditDatetime() != 0) { %>
		    <tr class="text-secondary">
		      <td></td>
		      <td class="small" style="font-style: italic"><%= df.format(article.getEditDatetimeFormat()) %>　更新</td>
		    </tr>
		    <% } %>
		    <tr>
		      <td>【名前】</td>
		      <td><%= TextConv.beforeHtml(article.getAuthor()) %></td>
		    </tr>
		    <tr>
		      <td>【件名】</td>
		      <td><%= TextConv.beforeHtml(article.getSubject()) %></td>
		    </tr>
		    <tr style="vertical-align: top;">
		      <td>【本文】</td>
		      <td><%= TextConv.embedLink(TextConv.beforeHtml(article.getBody()))
		    		  %></td>
		    </tr>
		  </table>
		  <hr/>
		
			<form method="POST" action="delete_3.jsp">
			  <div style="margin-top: 20px;">
			    <p class="my-3">この記事を削除する場合は［削除］ボタンを押してください。</p>
			    <input type="hidden" name="password" value="<%= DigestUtils.sha256Hex(strPswd) %>">
			    <input type="submit" value="削除" class="btn btn-secondary border border-dark">
			  </div>
			</form>
		<%
		} else {
		%>
		  <div>パスワードが違います。</div>
		<%
		}
		%>
		  <div class="mt-4">
		    <a href="javascript:history.back()" style="text-decoration: underline;">戻る</a>
		  </div>

	  </div>
	</body>
</html>