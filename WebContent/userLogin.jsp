<%@page import="modle.entity.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/userlogincss.css">
<title>普通用户登录</title>
</head>
<script type="text/javascript">
	function remember() {
		document.choose.action="MemeryWordsServlet";
		document.choose.submit();
	}
	function settimes() {
		document.choose.action="settimes.jsp";
		document.choose.submit();
	}
</script>
<body>
	<header><font color="#fffff"><h1>今天你背单词了吗？</h1></font></header>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
					<%
						request.setCharacterEncoding("UTF-8");
						Users user = (Users)session.getAttribute("user");
						if (user == null) {
					%>
							您还没有登录，请先<a href="index.html"><u>登录</u></a><br/>
					<%
						} else {
							Cookie cookie = new Cookie("name", user.getName());
							response.addCookie(cookie);
							out.print("欢迎您" + user.getName());
					%>
						<a href="logout.jsp"><u>注销</u></a><br/><br/>
						<form name="choose" action="" method="get">
							<input type="button" value="开始背单词" onclick="remember()"><br/><br/>
							<input type="button" value="设置单词学习次数" onclick="settimes()"><br/><br/>
						</form>
					<%
						}
					%>
				</div>
			</div>
		</div>
	</div>
</body>
	<div id="footer">
		&copy;by 包子
	</div>
</html>