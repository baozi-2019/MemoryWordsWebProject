<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>背单词ing</title>
<link rel="stylesheet" type="text/css" href="css/remwords.css">
</head>
<body>
	<script type="text/javascript">
	function remember() {
		document.rem.action="MemeryWordsServlet";
		document.rem.submit();
	}
	function notremember() {
		document.rem.action="showChinese.jsp";
		document.rem.submit();
	}
	</script>
	<header><font color="#fffff"><h1>背单词可不能分心啊</h1></font></header>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
					<font size="12" face="黑体">
						<%
							Cookie[] cookies = request.getCookies();
							for (Cookie cookie : cookies) {
								if ("english".equals(cookie.getName())) {
									out.print(cookie.getValue());
									break;
								}
							}
						%>
					</font>
					<form action="" method="post" name="rem">
					<input type="hidden" value="yes" name="word_flag">
					<input type="button" value="会" onclick="remember()">
					<input type="button" value="不会" onclick="notremember()">
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