<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>单词意思</title>
</head>
<link rel="stylesheet" type="text/css" href="css/remwords.css">
<body>
	<header><font color="#fffff"><h1>背单词可不能分心啊</h1></font></header>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
					<font face="黑体" size="12">
					<%
						Cookie[] cookies = request.getCookies();
						for (Cookie cookie : cookies) {
							if ("chinese".equals(cookie.getName())) {
								out.print(cookie.getValue());
								break;
							}
						}
					%>
					</font>
					<form action="MemeryWordsServlet" method="post">
						<input type="hidden" value="no" name="word_flag">
						<input type="submit" value="返回背单词" >
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