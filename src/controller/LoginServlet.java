package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.LoginDao;
import modle.entity.Users;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		Users user = new Users(uname, upwd);
		int flag = LoginDao.login(user);
		if (flag > 0) {		//登录成功
			switch (flag) {
				case 1 : 
					user.setAdmin(false);
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					request.getRequestDispatcher("userLogin.jsp").forward(request, response) ;break;     //普通用户登录
				case 2 : 
					user.setAdmin(true);
					HttpSession sessions = request.getSession();
					sessions.setAttribute("user", user);
					request.getRequestDispatcher("adminlogin.jsp").forward(request, response) ;break;     //管理员登录
				default : 
					Cookie cookie = new Cookie("erroCode", "0");
					response.addCookie(cookie);
					response.sendRedirect("unsuccess.jsp");			//未知代码，跳转至登录失败
			}
		} else {
			Cookie cookie = new Cookie("erroCode", Integer.toString(flag));
			response.addCookie(cookie);
			response.sendRedirect("unsuccess.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
