<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>セッションエラー｜掲示板</title>
		
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
    <div class="container text-center">
      <h2 class="mt-4 font-weight-bold">【掲示板】</h2>
      <hr/>
		  <div class="mt-5">
			  <p class="my-2">セッションがタイムアウトにより切断させました。</p>
			  <p class="my-2">登録、削除、更新の処理は行われていません。</p>
			</div>
			<div class="mt-4">
			  <p class="my-2">現在サーバーで設定されているタイムアウトのインターバルは</p>
			  <p class="my-2"><%= session.getMaxInactiveInterval()/60 %>分です。</p>
		  </div>
		  <div class="mt-5"><a href="index.jsp" style="text-decoration: underline;">一覧に戻る</a></div>
    </div>
	</body>
</html>