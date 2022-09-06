package com.magicl.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		// servlet에서 jsp로 보낼때 쓰는 방법이다.
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String lev = request.getParameter("lev");
		String url = null;

		EmployeesDAO empDAO = EmployeesDAO.getInstance();
		int result = empDAO.userCheck(id, pwd, lev);

		if (result == 2 || result == 3) {
			EmployeesVO emp = new EmployeesVO();
			emp = empDAO.getMember(id);

			HttpSession session = request.getSession();
			session.setAttribute("loginUser", emp); // loginUser는 한 사람의 개인정보를 저장
			session.setAttribute("result", result); // 관리자인지 아닌지 저장
			url = "main.jsp";
		} else {
			url = "login.jsp";
			if (result == 1) {
				request.setAttribute("message", "레벨 불일치 로그인 실패");
			} else if (result == 0) {
				request.setAttribute("message", "비밀 번호 불일치 로그인 실패");
			} else {
				request.setAttribute("message", "아이디 로그인 불일치 실패");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		// servlet에서 jsp로 보낼때 쓰는 방법이다.
		rd.forward(request, response);
	}

}
