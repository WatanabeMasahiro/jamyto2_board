<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="java.text.*"%>
<%@ page import="classes.*"%>

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
	Context context = new InitialContext();
	DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/jamyto2");
	Connection conn = ds.getConnection();
	
	request.setCharacterEncoding("UTF-8");
	String strId = request.getParameter("id");
	int intId = 0;
	try {
		intId = Integer.parseInt(strId);
	} catch (Exception e) {
		  ;
	}
	
	String strSql = "SELECT * FROM bbs WHERE id= ?";
	  PreparedStatement pstmt = conn.prepareStatement(strSql);
	  pstmt.setInt(1, intId);
	ResultSet rs = pstmt.executeQuery();
	%>
	<body>
    <div class="container">
		  <h2 class="mt-4 font-weight-bold">【掲示板】</h2>
		  <hr/>
		  <h4>記事の編集</h4>
		  <hr/>
			<%
			if (rs.next() == true && !(rs.getString("password") == null)) {
			%>
				<form method="POST" action="edit_2.jsp">
					<div class="mt-4">
						<p class="my-2">パスワードを入力してください。　</p>
						<table>
						  <tr><td>
						    <input type=hidden name="id" value="<%= intId %>">
						    <input type="password" name="password" class="mr-1"></td><td>
						    <input type="submit" value="送信" class="btn btn-secondary btn-sm border border-dark">
						  </td></tr>
					  </table>
					</div>
				</form>
			<%
			} else {
			%>
			  <div>編集のできない投稿です。</div>
			<%
			}
			conn.close();
			%>
		  <div style="margin-top: 20px;">
		    <a href="javascript:history.back()" style="text-decoration: underline;">戻る</a>
		  </div>
    </div>
	</body>
</html>