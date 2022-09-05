package kr.co.ezenac;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Servlet implementation class LoginOk
 */
@WebServlet("/ModifyOk")
public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection;
	private Statement stmt;

	private String name, id, pw, phone1, phone2, phone3, gender;
	HttpSession httpSession;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyOk() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		httpSession = request.getSession();

		name = request.getParameter("name");
		id = (String) httpSession.getAttribute("id");
		pw = request.getParameter("pw");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");

		if (pwConfirm()) {
			System.out.println("Ok");
			// name phone gender
			String query = "UPDATE member SET name='" + name + "', phone1='" + phone1 + "', phone2='" + phone2
					+ "', phone3='" + phone3 + "', gender='" + gender + "' WHERE id='" + id + "'";

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				stmt = connection.createStatement();
				int i = stmt.executeUpdate(query);

				if (i == 1) {
					System.out.println("update success");
					httpSession.setAttribute("name", name);
					response.sendRedirect("modifyResult.jsp");
				} else {
					System.out.println("update fail");
					response.sendRedirect("modify.jsp");
				}

				connection.close();
				stmt.close();

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				try {
					if (stmt != null)
						stmt.close();
					if (connection != null)
						connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		} else {
			System.out.println("NG");
		}
	}

	private boolean pwConfirm() {
		boolean rs = false;
		String sessionPw = (String) httpSession.getAttribute("pw");

		if (sessionPw.equals(pw)) {
			rs = true;
		}
		return rs;
	}
}