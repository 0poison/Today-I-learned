package kr.co.ezenac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import kr.co.ezenac.beans.TestBean1;
import kr.co.ezenac.beans.TestBean2;
import kr.co.ezenac.beans2.TestBean4;

@ComponentScan(basePackages = "kr.co.ezenac.beans2")
@ComponentScan(basePackages = "kr.co.ezenac.beans3")
public class BeanConfigClass {
	@Bean
	public TestBean1 java1() {
		return new TestBean1();
	}

	@Bean
	public TestBean2 java2() {
		return new TestBean2();
	}

	@Bean
	public TestBean2 java3() {
		return new TestBean2();
	}

	@Bean
	public TestBean4 java100() {
		return new TestBean4();
	}

	@Bean()
	public TestBean4 java200() {
		return new TestBean4();
	}

}
