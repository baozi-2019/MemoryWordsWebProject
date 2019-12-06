package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UpdateWordsDao;


public class AdminChangeWords extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminChangeWords() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String english = request.getParameter("english");
		String chinese = request.getParameter("chinese");
		int times = Integer.parseInt(request.getParameter("times"));
		int flag = UpdateWordsDao.changeWords(english, chinese, times);
		if (flag == 0) {
			Cookie cookie = new Cookie("adminchangewordflag", "no");
			response.addCookie(cookie);
			response.sendRedirect("adminchangewords.jsp");
		} else {
			response.sendRedirect("adminchangewordsec.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
