<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>设置学习次数</title>
</head>
<link rel="stylesheet" type="text/css" href="css/indexcss.css">
<body>
<header><font color="#fffff"><h1>加油，少年</h1></font></header>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
					<%
						Cookie[] cookies = request.getCookies();
						for (Cookie cookie : cookies) {
							if ("name".equals(cookie.getName())) {
								out.print(cookie.getValue() + "，请选择学习次数，点击提交确认");
								break;
							}
						}
					%>
					<form action="SetTimes" action="get">
						<select id="type" name="setstudytimes">
				            <option value="0">==请选择==</option>
				            <option value="1">1</option>
				            <option value="2">2</option>
				            <option value="3">3</option>
				            <option value="4">4</option>
				            <option value="5">5</option>
				            <option value="6">6</option>
				            <option value="7">7</option>
				        </select>
					    <input type="submit" value="提交"><br/>
					    <a href="userLogin.jsp">点此返回</a>
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