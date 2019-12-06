<%@page import="modle.entity.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员登录</title>
<link rel="stylesheet" type="text/css" href="css/indexcss.css">
</head>
<script type="text/javascript">
	function remember() {
		document.chooseA.action="manageuser.jsp";
		document.chooseA.submit();
	}
	function setwords() {
		document.chooseA.action="managewords.jsp";
		document.chooseA.submit();
	}
</script>
<body>
	<header><font color="#fffff"><h1>你好，管理员</h1></font></header>
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
						<form name="chooseA" action="" method="get">
							<input type="button" value="管理用户" onclick="remember()"><br/><br/>
							<input type="button" value="管理词库" onclick="setwords()"><br/><br/>
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