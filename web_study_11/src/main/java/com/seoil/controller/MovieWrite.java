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
 * Servlet implementation class MovieWrite
 */
@WebServlet("/moviewrite.do")
public class MovieWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieWrite() {
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
		String url = "movie/movieWrite.jsp";
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
		request.setCharacterEncoding("UTF-8");
		String saveDirectory = request.getServletContext().getRealPath("images");
		int maxPostSize = 5 * 1024 * 1024; // 5MB 까지 처리할 수 있다.
		String encType = "UTF-8";
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize, encType, policy);

		MovieVO mvo = new MovieVO();
		mvo.setTitle(multi.getParameter("title"));
		mvo.setPrice(Integer.parseInt(multi.getParameter("price")));
		mvo.setDirector(multi.getParameter("director"));
		mvo.setActor(multi.getParameter("actor"));
		mvo.setPoster(multi.getFilesystemName("poster"));
		mvo.setSynopsis(multi.getParameter("synopsis"));
		System.out.println(mvo);

		MovieDAO productDAO = MovieDAO.getInstance();
		productDAO.insertMovie(mvo);
		response.sendRedirect("movielist.do");
	}

}
