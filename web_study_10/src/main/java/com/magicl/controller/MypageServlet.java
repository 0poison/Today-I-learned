package com.magicl.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/mypage.do")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MypageServlet() {
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
		HttpSession session = request.getSession();
		EmployeesVO emp = (EmployeesVO) session.getAttribute("loginUser");
		if (emp != null) {
			String url = "mypage.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);

		} else {
			response.sendRedirect("login.jsp");
		}
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
		System.out.println(request.getParameter("name"));
		HttpSession session = request.getSession();
		EmployeesVO member = new EmployeesVO();
		member.setId(request.getParameter("id"));
		member.setPass(request.getParameter("pwd"));
		member.setName(request.getParameter("name"));

		if (request.getParameter("gender") != null) {
			member.setGender(Integer.parseInt(request.getParameter("gender").trim()));
			member.setPhone(request.getParameter("phone"));

			EmployeesDAO dao = EmployeesDAO.getInstance();
			int updateNumber = dao.updateMember(member);

			System.out.println("updateMember= " + updateNumber);
			// 여기까지 업데이트 된 결과
			EmployeesVO emp = dao.getMember(member.getId());
//해당 하는 아이디에 맞는 정보를 가져와 emp에 넣는다
			request.setAttribute("member", emp);
//emp의 정보들을 request에 넣는다
			request.setAttribute("message", "변경된 정보입니다.");

			session.setAttribute("loginUser", emp);
//loginUser라는 이름으로 세션에 저장한다.
			System.out.println(emp);

			int result = dao.userCheck(member.getId(), member.getPass(), member.getLev());
			session.setAttribute("result", result);

			String url = "joinsuccess.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(url);
			// servlet에서 jsp로 보낼때 쓰는 방법이다.
			rd.forward(request, response);

		}
	}

}
