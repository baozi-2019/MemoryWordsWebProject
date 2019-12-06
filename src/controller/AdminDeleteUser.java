package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.AdminDeleteUserDao;

public class AdminDeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminDeleteUser() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("uname");
		String admina = request.getParameter("chooseA");
		boolean admin;
		if ("yes".equals(admina)) {
			admin = true;
		} else {
			admin = false;
		}
		int flag = AdminDeleteUserDao.adminDeleteUser(name, admin);
		if (flag == 1) {
			response.sendRedirect("admindeletesuc.jsp");
		} else {
			Cookie cookie = new Cookie("deleteuser", "no");
			response.addCookie(cookie);
			response.sendRedirect("admindeleteuser.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
