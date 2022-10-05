package kr.co.ezenac.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class TestBean4 {

	@Autowired
	private DataBean1 data1;
	@Autowired
	private DataBean1 data2;

	public DataBean1 getData1() {
		return data1;
	}

	public DataBean1 getData2() {
		return data2;
	}

}
