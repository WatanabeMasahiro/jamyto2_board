<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="classes.*"%>

<jsp:useBean class="classes.BbsArticle" id="article" scope="session"/>

<%
String strAuthor = "";
Cookie[] aryCoo = request.getCookies();
for(int i=0; i<aryCoo.length; i++) {
	if(aryCoo[i].getName().equals("author")) {
		strAuthor = java.net.URLDecoder.decode(aryCoo[i].getValue(),"UTF-8");
	}
}
%>

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


	  <script type="text/javascript">
	  function f_check() {
		  if(document.form1.author.value == "") {
			  alert("名前を入力してください");
			  return false;
		  }
		  /*
		  if(document.form1.subject.value == "") {
			  alert("件名を入力してください");
			  return false;
		  }
		  if(document.form1.password.value == "") {
			  alert("パスワードを入力してください");
		    return false;
		  }
		  */
		  if(document.form1.password.value != document.form1.password_cfm.value) {
	      alert("確認用のパスワードと一致しません");
	      return false;
	    }
	  } 
	  </script>
	</head>
	<body>
	  <div class="container">
		  <h2 class="mt-4 font-weight-bold">【掲示板】</h2>
		  <hr/>
		  <%
		  String strParentId = request.getParameter("parent_id");
		  if(strParentId != null) {
			  int intParentId = Integer.parseInt(strParentId);
			  article.setParentId(intParentId);
			  String strParentSubject = article.getParentSubject();
			  if(strParentSubject.startsWith("RE:")) {
				  article.setSubject(strParentSubject);
			  } else {
				  article.setSubject("RE:" + strParentSubject);
			  }
		  } else {
			  article.setParentId(0);
			  article.setSubject("");
		  }
		  %>
		  <form name="form1" method="POST" action="write_2.jsp" onsubmit="return f_check()">
			  <div style="margin-top: 17px;">
			   <p style="margin-bottom: 5px;">名前：　</p>
			   <input type="text" name="author" size="25" class="w-25" value="<%= strAuthor %>">
			  </div>
			  <div style="margin-top: 15px;">
			   <p style="margin-bottom: 5px;">件名：　</p>
			   <input type="text" name="subject" size="50" class="w-25" value="<%= article.getSubject() %>">
			  </div>
			  <div style="margin-top: 15px;">
			   <p style="margin-bottom: 5px;">本文：　</p>
			   <textarea cols="60" rows="5" name="body" maxlength="250"></textarea>
			  </div>
			  <div style="margin-top: 17px;">
			   <p style="margin-bottom: 0px;">パスワード</p>
			   <input type="password" name="password" size="20">
			   <span style="color: red; font-size: 10px;">(※パスワードは、記事を編集/削除するときに使います。)</span>
			  </div>
			  <div>
		     <p style="margin-top: 8px; margin-bottom: 0px;">確認用パスワード</p>
		     <input type="password" name="password_cfm" size="20">
		    </div>
			  <div style="margin-top: 17px;">
			   <input type="submit" value="送信" class="btn btn-secondary btn-sm border border-dark">
			  </div>
		  </form>
		  <div style="margin-top: 18px;">
		    <a href="javascript:history.back()" style="text-decoration: underline;">戻る</a>
		  </div>
	  </div>
	</body>
</html>