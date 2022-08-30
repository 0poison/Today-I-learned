package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MemberDAO { /* Database */
	String id = "scott";
	String pass = "tiger";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertMember(MemberBean mbean) {
		try {
			getCon();
			String sql = "insert into memberInfo values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mbean.getId());
			pstmt.setString(2, mbean.getPass1());
			pstmt.setString(3, mbean.getEmail());
			pstmt.setString(4, mbean.getTel());
			pstmt.setString(5, mbean.getHobby());
			pstmt.setString(6, mbean.getJob());
			pstmt.setString(7, mbean.getAge());
			pstmt.setString(8, mbean.getInfo());
			pstmt.executeUpdate();

			conn.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Vector<MemberBean> allSelectMember() {
//가변 길이로 데이터를 저장 프로그램이 종료할 때까지 사라지지 않도록 static을 붙인다.
		Vector<MemberBean> vec = new Vector<MemberBean>();

		try {
			getCon();
			String sql = "select * from memberInfo";
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
			getCon();
			String sql = "select * from memberInfo where id=mbean.setId";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mbean.setId(rs.getString(1));
				mbean.setId(rs.getString(2));
				mbean.setId(rs.getString(3));
				mbean.setId(rs.getString(4));
				mbean.setId(rs.getString(5));
				mbean.setId(rs.getString(6));
				mbean.setId(rs.getString(7));
				mbean.setId(rs.getString(8));
			}
			conn.close();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mbean;
	}

	public void updateMember(MemberBean bean) {
		getCon();
		try {
			String sql = "update memberInfo set email=?, tel=? where id=?";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			pstmt.setString(1, bean.getEmail());
			pstmt.setString(2, bean.getTel());
			pstmt.setString(3, bean.getId());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getPass1(String id) {
		String pass = "";
		getCon();
		try {
			String sql = "select pass1 from memberInfo where id=?";
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
}
