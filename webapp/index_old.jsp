<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="java.text.*" %>
<%@ page import="classes.*" %>

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
	  <script src="${pageContext.request.contextPath}/js/main.js"></script>
	  
	  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	  crossorigin="anonymous">
	  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">

	</head>
	<body>
		<div class="container">
			<h2 class="mt-4 font-weight-bold">【掲示板】</h2>
			<hr/>
    <div class="d-flex flex-row">
			<div><a href="write_1.jsp" class="h5 indexP_writeAnchor">投稿する</a></div>
			<div class="ml-5">ここにページネーション</div>
		</div>
			<hr/>
			<%
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/jamyto2");
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			String strSql = "SELECT * FROM bbs ORDER BY id";
			ResultSet rs = stmt.executeQuery(strSql);
			DateFormat df = new SimpleDateFormat("yyyy'年'MM'月'dd'日' E'曜日' HH'時'mm'分'");
			java.util.Date date = new java.util.Date();
			java.util.Date editDate = new java.util.Date();
			while(rs.next()) {
			long lngDateTime = rs.getLong("date_time");
			date.setTime(lngDateTime);
			long lngEditDateTime = rs.getLong("edit_date_time");
			editDate.setTime(lngEditDateTime);
			%>
			<table>
				<tr>
					<td>【番号】</td>
					<td><%= rs.getInt("id") %>
					<% if(rs.getBoolean("password_set")) { %>
					<a style="margin-left:10px;" href="delete_1.jsp?id=<%= rs.getInt("id") %>">[削除]</a>
					<a style="margin-left: 5px;" href="edit_1.jsp?id=<%= rs.getInt("id") %>">[編集]</a>
					<% } %>
					</td>
				</tr>
				<tr>
					<td>【日時】</td>
					<td class="small" style="font-style: italic"><%= df.format(date) %></td>
				</tr>
				<% if(lngEditDateTime != 0) { %>
				<tr class="text-secondary">
          <td></td>
          <td class="small" style="font-style: italic"><%= df.format(editDate) %>　更新</td>
        </tr>
        <% } %>
				<tr>
					<td>【名前】</td>
					<td class="text-info font-weight-bold"><%= TextConv.beforeHtml(rs.getString("author")) %></td>
				</tr>
				<tr>
					<td>【件名】</td>
					<td><%=  TextConv.beforeHtml(rs.getString("subject")) %></td>
				</tr>
				<tr style="vertical-align: top;">
					<td>【本文】</td>
					<td><%= TextConv.embedLink(TextConv.beforeHtml(rs.getString("body"))) %></td>
				</tr>
			</table>
			<hr/>
			<%
			}
			conn.close();
			%>
			<div id="writeAnchorBtn">
        <a href="write_1.jsp" class="toggleWanchor btn btn-primary btn-lg rounded-pill border border-info">投稿する</a>
      </div>
			<div>ここにページネーション</div>
		</div>
		<hr/>
	
		<div class="container-fluid footer">
			<hr/>
			<div class="row justify-content-center">
				<p class="mt-3"><b>Copyright - M-Watanabe, 2021.11 ~</b></p>
			</div>
		</div>
		<hr/>
	
	</body>
</html>