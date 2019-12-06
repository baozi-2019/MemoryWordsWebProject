package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UpdateWordsDao;

public class AdminDeleteWrods extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminDeleteWrods() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String english = request.getParameter("english");
		int flag = UpdateWordsDao.deleteWords(english);
		if (flag == 0) {
			Cookie cookie = new Cookie("admindelwordflag", "no");
			response.addCookie(cookie);
			response.sendRedirect("admindeleteword.jsp");
			return ;
		} else {
			response.sendRedirect("admindeletewordsec.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
