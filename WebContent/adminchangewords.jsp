<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员更改词库</title>
</head>
<link rel="stylesheet" type="text/css" href="css/adminchangewords.css">
<body>
	<script type="text/javascript">
	function change() {
		document.chooseA.action="AdminChangeWords";
		document.chooseA.submit();
	}
	function returnM() {
		document.chooseA.action="managewords.jsp";
		document.chooseA.submit();
	}
</script>
<body>
	<header><font color="#fffff"><h1>你好，管理员，请注意，是用英文找所有参数</h1></font></header>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
				<font color="red" size="3">
						<%
							Cookie[] cookies = request.getCookies();
							for (Cookie cookie : cookies) {
								if ("adminchangewordflag".equals(cookie.getName())) {
									out.print("单词不存在，请先添加");
									break;
								}
							}
						%>
				</font>
				<form action="" method="get" name="chooseA">
					请输入单词：<input type="text" name="english"><br/>
					请输入中文：<input type="text" name="chinese"><br/>
					请选择学习次数：<br/>
					<input type="radio" name="times" value="1">1<br/>
					<input type="radio" name="times" value="2">2<br/>
					<input type="radio" name="times" value="3">3<br/>
					<input type="radio" name="times" value="4">4<br/>
					<input type="radio" name="times" value="5">5<br/>
					<input type="radio" name="times" value="6">6<br/>
					<input type="radio" name="times" value="7">7<br/>
					<input type="button" value="改动单词" onclick="change()">
					<input type="button" value="返回选择管理" onclick="returnM()">
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