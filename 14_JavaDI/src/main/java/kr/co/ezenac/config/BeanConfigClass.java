package kr.co.ezenac.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.co.ezenac.beans.DataBean1;
import kr.co.ezenac.beans.DataBean3;
import kr.co.ezenac.beans.TestBean1;
import kr.co.ezenac.beans.TestBean2;
import kr.co.ezenac.beans.TestBean3;

@Configuration
public class BeanConfigClass {

	@Bean
	public TestBean1 java1() {

		return new TestBean1(200, "문자열", new DataBean1());
	}

	@Bean
	public TestBean1 java2() {
		TestBean1 tbean1 = new TestBean1();
		tbean1.setData1(400);
		tbean1.setData2("문자열4");
		tbean1.setData3(new DataBean1());
		return tbean1;
	}

	@Bean(autowire = Autowire.BY_NAME)
	public TestBean2 java3() {
		return new TestBean2();
	}

	@Bean
	public DataBean3 data3() {
		return new DataBean3();
	}

	@Bean(autowire = Autowire.BY_TYPE)
	public TestBean3 java4() {
		return new TestBean3();
	}
}
