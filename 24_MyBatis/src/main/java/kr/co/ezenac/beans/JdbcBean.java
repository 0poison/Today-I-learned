package kr.co.ezenac.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class JdbcBean {
	private int int_data;
	private String str_data;

	public final int getInt_data() {
		return int_data;
	}

	public final void setInt_data(int int_data) {
		this.int_data = int_data;
	}

	public final String getStr_data() {
		return str_data;
	}

	public final void setStr_data(String str_data) {
		this.str_data = str_data;
	}

}
