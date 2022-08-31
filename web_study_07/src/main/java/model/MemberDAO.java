package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MemberDAO {
	String id = "scott";
	String pass = "tiger";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public void getcon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insertMember(MemberBean mbean) { // DB에 데이터를 넣는 메서드

		try {
			getcon();
			String sql = "INSERT INTO memberINFO VALUES(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mbean.getId());
			pstmt.setString(2, mbean.getPass1());
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

		try {
			getcon();
			String sql = "SELECT * FROM memberInfo";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberBean mbean = new MemberBean();
				mbean.setId(rs.getString(1));
				mbean.setPass1(rs.getString(2));
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
			getcon();
			String sql = "SELECT * FROM memberInfo WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			mbean.setId(rs.getString(1));
			mbean.setPass1(rs.getString(2));
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
		getcon();
		try {
			String sql = "UPDATE memberInfo SET email=?, tel=? WHERE id=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bean.getEmail());
			pstmt.setString(2, bean.getTel());
			pstmt.setString(3, bean.getId());
			pstmt.executeUpdate();

			conn.close();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getPass1(String id) {

		String pass = "";
		getcon();

		try {
			String sql = "SELECT pass1 FROM memberInfo WHERE id=?";
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
		getcon();

		try {
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