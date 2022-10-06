package kr.co.ezenac.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestBean2 {
	private int data1; // 100
	private String data2; // 문자열
	private DataBean4 data3;
	private DataBean5 data4;

	@Autowired
	public TestBean2(@Value("100") int data1, @Value("문자열") String data2, DataBean4 data3, DataBean5 data4) {

		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
		this.data4 = data4;
	}

	public TestBean2() {
	}

	public final int getData1() {
		return data1;
	}

	public final String getData2() {
		return data2;
	}

	public final DataBean4 getData3() {
		return data3;
	}

	public final DataBean5 getData4() {
		return data4;
	}
}
