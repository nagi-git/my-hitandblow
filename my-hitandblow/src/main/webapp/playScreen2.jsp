<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
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
	<div>
		<form action="./play" method="post">
			<div class="form-group row">
				<label class="col-2 col-form-lebel">答え</label>
				<div class="col-10">
					<input type="text" class="form-control" name="result">
				</div>
				<div class="offset-2 col-10">
					<button type="submit" class="btn btn-primary">登録</button>
				</div>
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
</body>
</html>