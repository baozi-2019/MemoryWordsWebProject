<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理词库</title>
</head>
<link rel="stylesheet" type="text/css" href="css/indexcss.css">
<body>
	<script type="text/javascript">
	function add() {
		document.chooseA.action="adminaddwords.jsp";
		document.chooseA.submit();
	}
	function deletee() {
		document.chooseA.action="admindeleteword.jsp";
		document.chooseA.submit();
	}
	function change() {
		document.chooseA.action="adminchangewords.jsp";
		document.chooseA.submit();
	}
	function returnM() {
		document.chooseA.action="adminlogin.jsp";
		document.chooseA.submit();
	}
</script>
<body>
	<header><font color="#fffff"><h1>你好，管理员</h1></font></header>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
				<form action="" method="get" name="chooseA">
					<input type="button" value="增加单词" onclick="add()"><br/>
					<input type="button" value="删除单词" onclick="deletee()"><br/>
					<input type="button" value="改动单词" onclick="change()"><br/>
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