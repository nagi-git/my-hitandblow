<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8' %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Hit And Blow</title>
</head>
<body>
	<h2>ヒット＆ブロー</h2>
	<div class="container">
		<div>
			<p>4桁の数字を当てるゲームです。</p>
			<p>答えの欄に数字を4桁入力すると、HIT（数字も場所も正解）の数、BLOW（数字は正解だが場所が違う）の数が表記されるので、その結果をもとに正しい数字を当ててください！
			<br/>使われる数字は0～9で、同じ数字が複数存在することはありません。</p>
			<p>【例】<br/>入力：1234、正解：3248の場合<br/>HIT数→1[2]　BLOW数→2[3,4]</p>
		</div>
	<div>
	<c:if test="${errorCode == 1}">
		<div class="alert alert-info" role="alert">
			<i class="fas fa-exclamation-triangle"></i>
			半角数字4桁を入力してください！
		</div>
	</c:if>
	<c:if test="${errorCode == 2}">
		<div class="alert alert-info" role="alert">
			<i class="fas fa-exclamation-triangle"></i>
			4桁とも違う数字を入力してください！
		</div>
	</c:if>
		<form action="./play" method="post">
			<div class="form-group row">
				<label class="col-2 col-form-lebel">答え(半角数字4桁)</label>
				<div class="col-10">
					<input type="text" class="form-control" name="result" />
				</div>
				<div class="offset-2 col-10">
					<button type="submit" class="btn btn-primary">登録</button>
					<button class="btn btn-success" type="submit" name="resetBtn" id="inputAnswer" value="run">リセット</button>
				</div>
				<c:if test="${results != null}">
					<input type="hidden" class="form-control" name="count" value="${ fn:length(results) }" />
				</c:if>
				<c:if test="${results == null}">
					<input type="hidden" class="form-control" name="count" value="0" />
				</c:if>
			</div>
		</form>
	</div>
	<c:if test="${results != null}">
		<div>
			<%-- セッションスコープにある ArrayList 型のオブジェクトを参照 --%>
			<jsp:useBean id="results" scope="session" type="java.util.List<dto.ResultDTO>" />
			<table class="table table-striped table-bordered">
				<tr>
					<th class="text-center">回数</th>
					<th class="text-center">入力値</th>
					<th class="text-center">HIT</th>
					<th class="text-center">BLOW</th>
				</tr>

				<%-- リストにある要素の数だけ繰り返し --%>
				<c:forEach var="result" items="${results}">
					<tr>
						<td class="text-center">${result.turnCount}回目</td>
						<td class="text-center">${result.inputAnswer}</td>
						<td class="text-center">${result.hitCount}</td>
						<td class="text-center">${result.blowCount}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
	</div>
	<!-- Optional JavaScript -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	<script defer src="https://use.fontawesome.com/releases/v5.7.2/js/all.js"></script>
</body>
</html>