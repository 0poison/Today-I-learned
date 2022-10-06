package kr.co.ezenac.beans;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TestBean1 {
	public TestBean1() {
		System.out.println("TestBean1의 생성자");
	}

	@Autowired
	private DataBean1 data1;

	@Autowired
	@Qualifier("obj2")
	private DataBean2 data2;

	@Resource(name = "obj3")
	private DataBean3 data3;
	@Resource(name = "obj4")
	private DataBean3 data4;
	private DataBean3 data5;

	public DataBean1 getData1() {
		return data1;
	}

	public DataBean2 getData2() {
		return data2;
	}

	public DataBean3 getData3() {
		return data3;
	}

	public DataBean3 getData4() {
		return data4;
	}

	public DataBean3 getData5() {
		return data5;
	}

	public void setData5(DataBean3 data5) {
		this.data5 = data5;
	}

}
