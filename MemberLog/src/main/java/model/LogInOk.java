package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LogInOk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection;
	private Statement stmt;
	private ResultSet resultSet;

	private String id, pw, email, tel, hobby, job, age, info;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogInOk() {
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
		RequestDispatcher rd = request.getRequestDispatcher("MemberUpdate.jsp");
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
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		id = request.getParameter("id");
		pw = request.getParameter("pw");

		String query = "select * from memberInfo where id='" + id + "' and pw='" + pw + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(query);

			if (resultSet.next()) {
				id = resultSet.getString("id");
				pw = resultSet.getString("pw");
				email = resultSet.getString("email");
				tel = resultSet.getString("tel");
				hobby = resultSet.getString("hobby");
				job = resultSet.getString("job");
				age = resultSet.getString("age");
				info = resultSet.getString("info");

			}
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("id", id);
			httpSession.setAttribute("pw", pw);
			httpSession.setAttribute("email", email);
			httpSession.setAttribute("tel", tel);
			httpSession.setAttribute("hobby", hobby);
			httpSession.setAttribute("job", job);
			httpSession.setAttribute("age", age);
			httpSession.setAttribute("info", info);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (stmt != null)
					stmt.close();
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
