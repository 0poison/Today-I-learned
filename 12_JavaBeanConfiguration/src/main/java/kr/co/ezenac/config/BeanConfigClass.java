package kr.co.ezenac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import kr.co.ezenac.beans.TestBean1;
import kr.co.ezenac.beans.TestBean2;
import kr.co.ezenac.beans.TestBean3;
import kr.co.ezenac.beans.TestBean4;

@Configuration
public class BeanConfigClass {

	@Bean
	public TestBean1 java1() {
		TestBean1 tBean1 = new TestBean1();
		return tBean1;
	}

	@Bean(name = "java600")
	public TestBean1 java500() {
		TestBean1 tBean1 = new TestBean1();
		return tBean1;
	}

	@Bean
	@Lazy
	public TestBean2 java2() {
		TestBean2 tBean2 = new TestBean2();
		return tBean2;
	}

	@Bean
	@Scope("prototype")
	public TestBean3 java3() {
		TestBean3 t3 = new TestBean3();
		return t3;
	}

	@Bean
	@Primary
	public TestBean4 java4() {
		TestBean4 t4 = new TestBean4();
		return t4;
	}
}
