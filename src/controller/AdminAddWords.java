package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UpdateWordsDao;


public class AdminAddWords extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminAddWords() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String english = request.getParameter("english");
		String chinese = request.getParameter("chinese");
		int flag = UpdateWordsDao.addWords(english, chinese);
		if (flag == 0) {
			Cookie cookie = new Cookie("adminadwordflag", "no");
			response.addCookie(cookie);
			response.sendRedirect("adminaddwords.jsp");
			return ;
		} else {
			response.sendRedirect("adminaddwordssuc.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
