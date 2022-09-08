package com.seoil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.seoil.dto.MovieVO;

import util.DBManager;

public class MovieDAO {
	private MovieDAO() {
		super();
	}

	private static MovieDAO instance = new MovieDAO();

	public static void setInstance(MovieDAO instance) {
		MovieDAO.instance = instance;
	}

	public static MovieDAO getInstance() {
		return instance;
	}

	public ArrayList<MovieVO> selectAllMovie() {
		String sql = "select * from movie order by code desc";
		ArrayList<MovieVO> productList = new ArrayList<MovieVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MovieVO mvo = new MovieVO();
				mvo.setCode(rs.getInt("code"));
				mvo.setTitle(rs.getString("title"));
				mvo.setPrice(rs.getInt("price"));
				mvo.setDirector(rs.getString("director"));
				mvo.setActor(rs.getString("actor"));
				mvo.setPoster(rs.getString("poster"));
				mvo.setSynopsis(rs.getString("synopsis"));
				productList.add(mvo);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(rs, pstmt, conn);

		}
		return productList;
	}

	public void insertMovie(MovieVO mVO) {
		String sql = "insert into movie values(movie_seq.nextval,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVO.getTitle());
			pstmt.setInt(2, mVO.getPrice());
			pstmt.setString(3, mVO.getDirector());
			pstmt.setString(4, mVO.getActor());
			pstmt.setString(5, mVO.getPoster());
			pstmt.setString(6, mVO.getSynopsis());
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
	}

	public MovieVO selectProductByCode(int code) {
		MovieVO mvo = null;
		String sql = "select * from movie where code=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				mvo = new MovieVO();
				mvo.setCode(rs.getInt(1));
				mvo.setTitle(rs.getString(2));
				mvo.setPrice(rs.getInt(3));
				mvo.setDirector(rs.getString(4));
				mvo.setActor(rs.getString(5));
				mvo.setPoster(rs.getString(6));
				mvo.setSynopsis(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return mvo;
	}

	public void deleteMovie(int code) {
		String sql = "delete from movie where code=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			pstmt.executeUpdate();
			conn.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
	}

	public void updateProduct(MovieVO mvo) {
		String sql = "update movie set title=? price=? director=? actor=? poster=? synopsis=? where code=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mvo.getTitle());
			pstmt.setInt(2, mvo.getPrice());
			pstmt.setString(3, mvo.getDirector());
			pstmt.setString(4, mvo.getActor());
			pstmt.setString(5, mvo.getPoster());
			pstmt.setString(6, mvo.getSynopsis());
			pstmt.setInt(7, mvo.getCode());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
	}

}
