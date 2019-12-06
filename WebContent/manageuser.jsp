<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理</title>
</head>
<script type="text/javascript">
	function add() {
		document.chooseA.action="adminadduseer.jsp";
		document.chooseA.submit();
	}
	function deletee() {
		document.chooseA.action="admindeleteuser.jsp";
		document.chooseA.submit();
	}
	function find() {
		document.chooseA.action="adminfinduser.jsp";
		document.chooseA.submit();
	}
	function change() {
		document.chooseA.action="adminchangeuser.jsp";
		document.chooseA.submit();
	}
	function returnM() {
		document.chooseA.action="adminlogin.jsp";
		document.chooseA.submit();
	}
</script>
<link rel="stylesheet" type="text/css" href="css/indexcss.css">
<body>
	<header><font color="#fffff"><h1>你好，管理员</h1></font></header>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
				<form action="" method="get" name="chooseA">
					<input type="button" value="增加用户" onclick="add()"><br/>
					<input type="button" value="删除用户" onclick="deletee()"><br/>
					<input type="button" value="改动用户" onclick="change()"><br/>
					<input type="button" value="查询用户" onclick="find()"><br/>
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