package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.AdminFindUserDao;
import modle.entity.Users;

public class AdminFindUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminFindUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("uname");
		Users user = new Users();
		int flag = AdminFindUserDao.findUser(name, user);
		if (flag == 0) {
			Cookie cookie = new Cookie("finduserflag", "no");
			response.addCookie(cookie);
			response.sendRedirect("adminfinduser.jsp");
			return ;
		} else {
			HttpSession sessions = request.getSession();
			sessions.setAttribute("userr", user);
			response.sendRedirect("adminfindusersuc.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
