<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ログインしてません</title>
</head>
<body>
  <h1>ログインしてませんがトップページ</h1>
  <ul>
    <li><a href="${pageContext.request.contextPath}/index">ログイン後トップページへ</a></li>
  </ul>
  <form action="logout" method="post">
    <button>ログアウト</button>
  </form>
</body>
</html>
