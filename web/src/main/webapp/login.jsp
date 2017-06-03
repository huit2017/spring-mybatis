<h1>ログインページ</h1>
<%-- エラーメッセージの表示 --%>
<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
ログインエラーです<br>
例外型：${SPRING_SECURITY_LAST_EXCEPTION.getClass().name}<br>
メッセージ：${SPRING_SECURITY_LAST_EXCEPTION.message}<br>
<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session" />
</c:if>
<form action="${pageContext.request.contextPath}/login" method="post">
	<dl>
		<dt>ログインID</dt>
		<dd>
			<input type="text" name="paramLoginId">
		</dd>


		<dt>パスワード
		<dd>
			<input type="password" name="paramPassword">
		</dd>
	</dl>
	<button>ログイン</button>
</form>