<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
<%@page import="modle.entity.Words"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		Words nword = (Words)session.getAttribute("now_word");
		int time = nword.getTimes() - 1;
		HashSet<Words> words = (HashSet)session.getAttribute("words");
		Iterator<Words> it = words.iterator();
		Words word = null;
		while (it.hasNext()) {
			word = it.next();
			if (word.getChinese().equals(nword.getChinese())) {
				word.setTimes(time);
				break;
			}
		}
		session.setAttribute("words", words);
		System.out.println(time);
		request.getRequestDispatcher("memwords.jsp").forward(request, response);
	%>
</body>
</html>