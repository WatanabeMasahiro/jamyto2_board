<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.*"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>掲示板</title>
</head>
<body>
  <h2>【掲示板】</h2>
  <hr/>
  <%
  Context context = new InitialContext();
  DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/jamyto2");
  Connection conn = ds.getConnection();
  // JDBCドライバの指定
  //Class.forName("com.mysql.jdbc.Driver");
  // DB接続で、ドライバに渡す文字列
  //String strConn = "jdbc:mysql://localhost:3306/jamyto2" + "?user=root&password=nave2810" + "&userUnicode=true&characterEncoding=MS932";
  // DBのコネクション
  //Connection conn = DriverManager.getConnection(strConn);
  // ステートメント（SQL文をDBの送り込んで結果を取り出す）
  Statement stmt = conn.createStatement();
  // bbsテーブルのデータ取得を、DBで実行するSQL文
  String strSql = "SELECT * FROM bbs ORDER BY id";
  // リザルトセット
  ResultSet rs = stmt.executeQuery(strSql);
  // ＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊
  DateFormat df = new SimpleDateFormat("yyyy'年'MM'月'dd'日' E'曜日' HH'時'mm'分'");
  Date date = new Date();
  // リザルトセットから、データ読み出し
  while(rs.next()) {
	 long lngDateTime = rs.getLong("date_time");
	 date.setTime(lngDateTime);
  %>
  <!-- データの表示 -->
  <div>id: <%= rs.getInt("id") %></div>
  <div>date_time: <%= df.format(date) %></div>
  <div>author: <%= rs.getString("author") %></div>
  <div>subject: <%= rs.getString("subject") %></div>
  <div>body: <%= rs.getString("body") %></div>
  <hr/>
  <%
  }
  conn.close();
  %>
</body>
</html>