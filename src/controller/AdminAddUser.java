package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.AdminAddUserDao;

public class AdminAddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminAddUser() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("uname");
		String password = request.getParameter("upwd");
		String admina = request.getParameter("chooseA");
		boolean admin;
		if ("yes".equals(admina)) {
			admin = true;
		} else {
			admin = false;
		}
		if (admina == null) {
			admin = false;
		}
		int flag = AdminAddUserDao.adminAddUser(name, password, admin);
		if (flag == 0) {
			Cookie cookie = new Cookie("adminaduserflag", "no");
			response.addCookie(cookie);
			response.sendRedirect("adminadduseer.jsp");
			return ;
		} else {
			response.sendRedirect("adminaddusersuc.jsp"); //跳转到成功页面
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
