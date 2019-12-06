<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>全部学习完成</title>
</head>
<link rel="stylesheet" type="text/css" href="css/userlogincss.css">
<body>
	<header><font color="#fffff"><h1>一次循环结束啦，厉害了</h1></font></header>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
					恭喜，您已全部学会！！
					<form action="MemeryWordsServlet" method="post">
						<input type="hidden" value="end" name="word_flag">
						<input type="submit" value="返回选择菜单" >
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<div id="footer">
			&copy;by 包子
		</div>
</html>