package com.seoil.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.seoil.dao.MovieDAO;
import com.seoil.dto.MovieVO;

/**
 * Servlet implementation class MovieUpdate
 */
@WebServlet("/movieupdate.do")
public class MovieUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieUpdate() {
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
		String url = "movie/movieUpdate.jsp";
		int code = Integer.parseInt(request.getParameter("code"));
		MovieDAO dao = MovieDAO.getInstance();
		MovieVO mvo = dao.selectProductByCode(code);
		request.setAttribute("movie", mvo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		String saveDirectory = request.getServletContext().getRealPath("images");
		int maxPostSize = 5 * 1024 * 1024;
		String encType = "utf-8";
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		// 업데이트 할려고 저장한 정보를 가지고 와서 mvo로 보낸다
		MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize, encType, policy);
		MovieVO mvo = new MovieVO();
		// mvo에서 저장된 것을 db로 보낸다.

		mvo.setCode(Integer.parseInt(multi.getParameter("code")));
		mvo.setTitle(multi.getParameter("title"));
		mvo.setPrice(Integer.parseInt(multi.getParameter("price")));
		mvo.setDirector(multi.getParameter("director"));
		mvo.setActor(multi.getParameter("actor"));
		mvo.setSynopsis(multi.getParameter("synopsis"));
		if (multi.getFilesystemName("poster") == null) {
			mvo.setPoster(multi.getParameter("nomakeImg"));
		} else {
			mvo.setPoster(multi.getFilesystemName("poster"));
		}
		MovieDAO productDAO = MovieDAO.getInstance();
		productDAO.updateProduct(mvo);
		response.sendRedirect("movielist.do");

	}

}
