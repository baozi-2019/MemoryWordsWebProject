package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SetTimesDao;


public class SetTimes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetTimes() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int times = Integer.parseInt(request.getParameter("setstudytimes"));
		String name = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("name".equals(cookie.getName())) {
				name = cookie.getValue();
			}
		}
		int flag = SetTimesDao.setTimes(times, name);
		if (flag > 0) {
			response.sendRedirect("settimesuc.jsp");
			return;
		}
		response.sendRedirect("settimeunsuc.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
