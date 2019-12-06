<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学习次数设置结果成功</title>
</head>
<link rel="stylesheet" type="text/css" href="css/indexcss.css">
<body>
<header><font color="#fffff"><h1>加油，少年</h1></font></header>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
					设置成功，
					<!-- 延迟跳转（js版）跳转至login.jsp -->
					<span id="remainSeconds">3</span>
					<script type="text/javascript">
					    var sec = 3;
					    function jump(){
					        sec--;
					        if(sec > 0){
					            document.getElementById('remainSeconds').innerHTML = sec;
					            setTimeout(this.jump,1000);
					        }else{
					            window.location.href = 'userLogin.jsp';
					        }
					    }
					    setTimeout(jump,1000);
					</script>
					秒后返回选择菜单。
				</div>
			</div>
		</div>
	</div>	
</body>
<div id="footer">
			&copy;by 包子
		</div>
</html>