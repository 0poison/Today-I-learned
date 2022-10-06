package kr.co.ezenac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.ezenac.beans.JdbcBean;

public interface MapperInterface {
	@Results({ @Result(column = "int_data", property = "int_data"),
			@Result(column = "str_data", property = "str_data") })

	@Select("select int_data, str_data from jdbc_table")
	List<JdbcBean> select_data();

	@Insert("insert into jdbc_table(int_data, str_data) values (#{int_data},#{str_data})")
	void insert_data(JdbcBean bean);

	@Update("update jdbc_table set str_data=#{str_data} where int_data=#{int_data}")
	void update_data(JdbcBean bean);

	@Delete("delete from jdbc_table where int_data=#{int_data}")
	void delete_data(int int_data);
}
