package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.LoadWordsDao;
import model.dao.SetNewTimesDao;
import modle.entity.Words;

public class MemeryWordsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Vector<Words> words;
	private int i;
	private String name;

    public MemeryWordsServlet() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//读取单词
		request.setCharacterEncoding("UTF-8");
		Cookie[] cookies = request.getCookies();
		name = null;
		for (Cookie cookie : cookies) {
			if ("name".equals(cookie.getName())) {
				name = cookie.getValue();
			}
		}
		Vector<Words> wordss = LoadWordsDao.loadwords(name);
		words = wordss;
		i = 0;
		Words word;
		for (; i < this.words.size(); i++) {
			word = words.elementAt(i);
			if (words.elementAt(i).getTimes() > 0) {
				Cookie cookie1 = new Cookie("english", word.getEnglish());
				Cookie cookie2 = new Cookie("chinese", word.getChinese());
				response.addCookie(cookie1);
				response.addCookie(cookie2);
				response.sendRedirect("memorywords.jsp");
				return;
			}
		}
		response.sendRedirect("allstudied.jsp");//本次学习已结束
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String wordFlag = request.getParameter("word_flag");
		if ("yes".equals(wordFlag)) {
			int temp = words.elementAt(i).getTimes() - 1;
			words.elementAt(i).setTimes(temp);
		} else if ("no".equals(wordFlag)) {
			int temp = words.elementAt(i).getTimes() + 1;
			words.elementAt(i).setTimes(temp);
		} else if ("return".equals(wordFlag)) {
			i = -1;
		} else if ("end".equals(wordFlag)) {
			SetNewTimesDao.setNewTimes(name, words);
			response.sendRedirect("userLogin.jsp");
			return ;
		}
		for (i = i + 1; i < words.size(); i++) {
			if (words.elementAt(i).getTimes() > 0) {
				Cookie cookie1 = new Cookie("english", words.elementAt(i).getEnglish());
				Cookie cookie2 = new Cookie("chinese", words.elementAt(i).getChinese());
				response.addCookie(cookie1);
				response.addCookie(cookie2);
				response.sendRedirect("memorywords.jsp");
				return;
			}
		}
		int j, studyGet = 0, studyNotGet = 0;
		for (j = 0; j < words.size(); j++) {
			if (words.elementAt(j).getTimes() == 0) {
				studyGet++;
			} else {
				studyNotGet++;
			}
		}
		if (studyNotGet == 0) {
			response.sendRedirect("allstudied.jsp");
			return ;
		} else {
			Cookie cookie1 = new Cookie("studyGet", Integer.toString(studyGet));
			Cookie cookie2 = new Cookie("studyNotGet", Integer.toString(studyNotGet));
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.sendRedirect("oncestudyfinish.jsp");
		}
	}

}
