<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>单轮学习结束</title>
</head>
<link rel="stylesheet" type="text/css" href="css/userlogincss.css">
<body>
	<header><font color="#fffff"><h1>一次循环结束啦，厉害了</h1></font></header>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
					<font face="宋体" size="5">
						<%
							Cookie[] cookies = request.getCookies();
							for (Cookie cookie : cookies) {
								if ("studyGet".equals(cookie.getName())) {
									out.print("已学会：" + cookie.getValue());
									break;
								}
							}
							for (Cookie cookie : cookies) {
								if ("studyNotGet".equals(cookie.getName())) {
									out.print("未学会：" + cookie.getValue());
									break;
								}
							}
						%>
					</font>
					<form action="MemeryWordsServlet" method="post">
						<input type="hidden" value="return" name="word_flag">
						<input type="submit" value="返回继续背单词" >
					</form>
					<form action="MemeryWordsServlet" method="post">
						<input type="hidden" value="end" name="word_flag">
						<input type="submit" value="结束背单词" >
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