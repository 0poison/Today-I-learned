package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {

	ResultSet rs;
	Connection conn;
	PreparedStatement pstmt;

	Connection getConnection() {
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void insertMember(MemberBean mbean) { // DB에 데이터를 넣는 메서드
		String sql = "INSERT INTO memberINFO VALUES(?,?,?,?,?,?,?,?)";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mbean.getId());
			pstmt.setString(2, mbean.getPw());
			pstmt.setString(3, mbean.getEmail());
			pstmt.setString(4, mbean.getTel());
			pstmt.setString(5, mbean.getHobby());
			pstmt.setString(6, mbean.getJob());
			pstmt.setString(7, mbean.getAge());
			pstmt.setString(8, mbean.getInfo());
			pstmt.executeUpdate(); // insert, update, delete
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Vector<MemberBean> allSelectMember() {
		Vector<MemberBean> vec = new Vector<>();
		String sql = "SELECT * FROM memberInfo";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberBean mbean = new MemberBean();
				mbean.setId(rs.getString(1));
				mbean.setPw(rs.getString(2));
				mbean.setPw_check(rs.getString(2));
				mbean.setEmail(rs.getString(3));
				mbean.setTel(rs.getString(4));
				mbean.setHobby(rs.getString(5));
				mbean.setJob(rs.getString(6));
				mbean.setAge(rs.getString(7));
				mbean.setInfo(rs.getString(8));
				vec.add(mbean);
			}
			conn.close();
			pstmt.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return vec;
	}

	public MemberBean oneSelectMember(String id) {

		MemberBean mbean = new MemberBean();

		try {
			String sql = "SELECT * FROM memberInfo WHERE id=?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			mbean.setId(rs.getString(1));
			mbean.setPw(rs.getString(2));
			mbean.setEmail(rs.getString(3));
			mbean.setTel(rs.getString(4));
			mbean.setHobby(rs.getString(5));
			mbean.setJob(rs.getString(6));
			mbean.setAge(rs.getString(7));
			mbean.setInfo(rs.getString(8));

			conn.close();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mbean;
	}

	public void updateMember(MemberBean bean) {
		try {
			String sql = "UPDATE memberInfo SET email=?, tel=?, hobby=?, job=?, age=?, info=? WHERE id=?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bean.getEmail());
			pstmt.setString(2, bean.getTel());
			pstmt.setString(3, bean.getHobby());
			pstmt.setString(4, bean.getJob());
			pstmt.setString(5, bean.getAge());
			pstmt.setString(6, bean.getInfo());
			pstmt.setString(7, bean.getId());
			pstmt.executeUpdate();

			conn.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getPass1(String id) {

		String pass = " ";

		try {
			String sql = "SELECT pass1 FROM memberInfo WHERE id=?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				pass = rs.getString(1);
			}

			conn.close();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pass;
	}

	public void deleteMember(String id) {

		try {
			conn = getConnection();
			String sql = "DELETE FROM memberInfo WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();

			conn.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}