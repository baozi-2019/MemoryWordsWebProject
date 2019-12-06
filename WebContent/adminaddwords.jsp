<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员添加单词</title>
</head>
<link rel="stylesheet" type="text/css" href="css/indexcss.css">
<body>
	<script type="text/javascript">
	function sub() {
		document.adduser.action="AdminAddWords";
		document.adduser.submit();
	}
	function returnmauser() {
		document.adduser.action="managewords.jsp";
		document.adduser.submit();
	}
	</script>
	<header><font color="#fffff"><h1>请填写添加单词的信息</h1></font></header>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
					<font color="red" size="3">
						<%
							Cookie[] cookies = request.getCookies();
							for (Cookie cookie : cookies) {
								if ("adminadwordflag".equals(cookie.getName())) {
									out.print("单词重复！！");
								}
							}
						%>
					</font>
					<form action="" method="post" name="adduser">
						<table>
							<tr>
								<td>英文：</td>
								<td><input type="text" name="english"></td>
							</tr>
							<tr>
								<td>中文：</td>
								<td><input type="text" name="chinese"></td>
							</tr>
							<tr>
								<td><input type="button" value="提交" onclick="sub()"></td>
								<td><input type="button" value="取消" onclick="returnmauser()"></td>
							</tr>
						</table>
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