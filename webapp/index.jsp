<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="java.text.*" %>
<%@ page import="classes.*" %>

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
      <hr/>
	    <div class="d-flex flex-row">
	      <div class="mr-5 ml-2">
	        <a href="write_1.jsp" class="d-inline h5 indexP_writeAnchor">投稿する</a>
	      </div>
	      <div>
	        <form method="POST" action="search.jsp" class="form-inline ml-5">
            <input type="text" name="search" class="mr-1 w-50">
            <input type="submit" value="検索" class="btn btn-secondary btn-sm border border-dark">
          </form>
        </div>
			</div>
			<hr class="mb-1"/>
			<div class="ml-1">
      <%
      articleList.setLimit(10);  // 表示行数/ページ
      int intPage;
      String strJumpTo = request.getParameter("jump_to");
      String strPage = request.getParameter("page");
      if(strJumpTo != null) {
    	  intPage = articleList.getPageFromId(Integer.parseInt(strJumpTo));
      } else if(strPage != null) {
        intPage = Integer.parseInt(strPage);
      } else {
    	  intPage = articleList.getLastPage();
      }
      articleList.setPage(intPage);

      if(intPage > 1) { %>
          <a href="index.jsp?page=<%= intPage -1 %>" class="mr-3">前のページ</a>
      <% }
      for(int i=1; i<=articleList.getLastPage(); i++) {
    	  if(i != intPage) { %>
    		  <a href="index.jsp?page=<%= i %>" class="mx-1"><%= i %></a>
    		<% } else { %>
    			<span>【<%= i %>】</span>
    	<% }
      }
      if(articleList.getLastPage() > intPage) { %>
          <a href="index.jsp?page=<%= intPage +1 %>" class="ml-3">次のページ</a>
      <% } %>
      </div>
			<hr class="mt-1"/>
      <%
      DateFormat df = new SimpleDateFormat("yyyy'年'MM'月'dd'日' E'曜日' HH'時'mm'分'");
      articleList.setParentId(0);   //  親Id
      articleList.makeList();
      while(articleList.next()) {
        BbsArticle article = articleList.getArticle();
      %>
      <a id="anc<%= article.getId() %>"></a>
      <table style="border-collapse:separate; border-spacing: 0 5px;">
        <tr>
          <td>【番号】</td>
          <td><%= article.getId() %>
          <% if(article.getPswdSet()) { %>
          <a style="margin-left:10px;" href="delete_1.jsp?id=<%= article.getId() %>">[削除]</a>
          <a style="margin-left: 5px;" href="edit_1.jsp?id=<%= article.getId() %>">[編集]</a>
          <% } %>
          </td>
        </tr>
        <tr>
          <td>【日時】</td>
          <td class="small" style="font-style: italic"><%= df.format(article.getDateTime()) %></td>
        </tr>
        <% if(article.getEditDatetime() != 0) { %>
        <tr class="text-secondary">
          <td></td>
          <td class="small" style="font-style: italic"><%= df.format(article.getEditDatetime()) %>　更新</td>
        </tr>
        <% } %>
        <tr style="vertical-align: top;">
          <td>【名前】</td>
          <td class="text-info font-weight-bold bg-white p-1 rounded" style="width: 250px; word-break: break-all;"><%= TextConv.beforeHtml(article.getAuthor()) %></td>
        </tr>
        <tr style="vertical-align: top;">
          <td>【件名】</td>
          <td class="bg-white bgwhiteNo1 p-1 rounded" style="width: 250px; word-break: break-all;"><%= TextConv.beforeHtml(article.getSubject()) %></td>
        </tr>
        <tr style="vertical-align: top;">
          <td>【本文】</td>
          <td class="bg-white bgwhiteNo2 p-1 pb-4 rounded" style="width: 250px; word-break: break-all;"><%= TextConv.embedLink(TextConv.beforeHtml(article.getBody())) %></td>
        </tr>
      </table>
      <div class="mt-3">
        <a href="write_1.jsp?parent_id=<%= article.getId() %>" style="text-decoration: underline;">コメントを書く</a>
      </div>
      <hr/>
	      <%
	      classes.BbsArticleList children = new classes.BbsArticleList();
	      children.setParentId(article.getId());  //  子Id
	      children.makeList();
	      while(children.next()) {
	    	  BbsArticle child = children.getArticle();
	    	%>
	    	
	    	  <a id="anc<%= child.getId() %>"></a>
		      <table style="border-collapse:separate; border-spacing: 0 5px;" class="ml-5">
		        <tr>
		          <td colspan="2" class="text-danger small">>><%= article.getId() %></td>
		        </tr>
		        <tr>
		          <td>【番号】</td>
		          <td><%= child.getId() %>
		          <% if(child.getPswdSet()) { %>
		          <a style="margin-left:10px;" href="delete_1.jsp?id=<%= child.getId() %>">[削除]</a>
		          <a style="margin-left: 5px;" href="edit_1.jsp?id=<%= child.getId() %>">[編集]</a>
		          <% } %>
		          </td>
		        </tr>
		        <tr>
		          <td>【日時】</td>
		          <td class="small" style="font-style: italic"><%= df.format(child.getDateTime()) %></td>
		        </tr>
		        <% if(child.getEditDatetime() != 0) { %>
		        <tr class="text-secondary">
		          <td></td>
		          <td class="small" style="font-style: italic"><%= df.format(child.getEditDatetime()) %>　更新</td>
		        </tr>
		        <% } %>
		        <tr>
		          <td>【名前】</td>
		          <td class="text-info font-weight-bold bg-white p-1 rounded" style="width: 250px; word-break: break-all;"><%= TextConv.beforeHtml(child.getAuthor()) %></td>
		        </tr>
		        <tr>
		          <td>【件名】</td>
		          <td class="bg-white bgwhiteNo1 p-1 rounded" style="width: 250px; word-break: break-all;"><%= TextConv.beforeHtml(child.getSubject()) %></td>
		        </tr>
		        <tr style="vertical-align: top;">
		          <td>【本文】</td>
		          <td class="bg-white bgwhiteNo2 p-1 pb-4 rounded" style="width: 250px; word-break: break-all;"><%= TextConv.embedLink(TextConv.beforeHtml(child.getBody())) %></td>
		        </tr>
		      </table>
		      <!-- <div class="mt-3">
		        <a href="write_1.jsp?parent_id=<％= /* child.getId() */ ％>" style="text-decoration: underline;">コメントを書く</a>
		      </div> -->
		      <hr/>
	    	
	    	<% }
      } %>
      <div class="ml-1">
	      <div id="writeAnchorBtn">
	        <a href="write_1.jsp" class="toggleWanchor btn btn-primary btn-lg rounded-pill border border-info">投稿する</a>
	      </div>
	      <%
	      if(intPage > 1) { %>
	      <a href="index.jsp?page=<%=intPage-1%>" class="mr-3">前のページ</a>
				<% }
				for(int i=1; i<=articleList.getLastPage(); i++) {
				  if(i != intPage) { %>
			      <a href="index.jsp?page=<%= i %>" class="mx-1"><%= i %></a>
			    <% } else { %>
			      【<%= i %>】
				<% }
				}
				if(articleList.getLastPage() > intPage) { %>
			    <a href="index.jsp?page=<%=intPage+1%>" class="ml-3">次のページ</a>
				<% } %>
			</div>
    </div>
    <hr/>

    <div class="container-fluid footer">
      <hr/>
      <div class="row justify-content-center">
        <p class="mt-3"><b>Copyright - M-Watanabe, 2021.11 ~</b></p>
      </div>
    </div>
    <hr/>
    
    
    <!--
    課題：
    １、子スレが5つになったら、親スレの「コメントを書く」を表示しないようにする。
      また、もしいたずらでwrite1ページへ行ったら、存在しない親はエラー、親IDから子ID×５の数を取得し、それ以上は追加処理出来ないようにする。
    
    ２、親スレは最大１００件までで、それ以上は投稿できないようにする。
    -->
    
    <!-- search.jsp   もし検索結果がなければ、　「検索結果がありませんでした。」の表示。 -->


  </body>
</html>