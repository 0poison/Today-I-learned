package kr.co.ezenac.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.co.ezenac.beans.JdbcBean;

@Component
public class MapperClass implements RowMapper<JdbcBean> {
	@Override
	public JdbcBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		JdbcBean bean = new JdbcBean();
		bean.setInt_data(rs.getInt("int_data"));
		bean.setStr_data(rs.getString("str_data"));

		return bean;
	}
}
