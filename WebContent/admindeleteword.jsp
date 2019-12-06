<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员删除单词</title>
</head>
<link rel="stylesheet" type="text/css" href="css/indexcss.css">
<body>
<script type="text/javascript">
	function dele() {
		document.chooseA.action="AdminDeleteWrods";//需改动
		document.chooseA.submit();
	}
	function cancle() {
		document.chooseA.action="managewords.jsp";//需改动
		document.chooseA.submit();
	}
</script>
	<header><font color="#fffff"><h1>你好，管理员</h1></font></header>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
				<font color="red" size="3">
					<%
						Cookie[] cookies = request.getCookies();
						for (Cookie cookie : cookies) {
							if ("admindelwordflag".equals(cookie.getName())) {
								out.print("单词不存在");
							}
						}
					%>
				</font>
				<form action="" method="get" name="chooseA">
					请输入要删除的单词英文：<input type="text" name="english"><br/><br/>
					<input type="button" value="删除" onclick="dele()">
					<input type="button" value="取消" onclick="cancle()">
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