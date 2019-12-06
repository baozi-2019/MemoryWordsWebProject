package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.AdminChangeUserDao;

/**
 * Servlet implementation class AdminChangeUser
 */
public class AdminChangeUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminChangeUser() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("uname");
		String password = request.getParameter("upwd");
		int flag = AdminChangeUserDao.adminChangeUser(name, password);
		if (flag == 0) {
			Cookie cookie = new Cookie("adminchangeuserflag", "no");
			response.addCookie(cookie);
			response.sendRedirect("adminchangeuser.jsp");
			return ;
		} else {
			response.sendRedirect("manageuser.jsp"); //跳转到成功页面
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
