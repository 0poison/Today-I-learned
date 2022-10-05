package kr.co.ezenac.beans;

import org.springframework.context.annotation.Bean;

public class TestBean1 {

	public TestBean1() {
		System.out.println("TestBean1의 생성자");
	}

	@Bean
	public void init1() {
		System.out.println("TestBean1의 init");
	}

	@Bean
	public void destroy1() {
		System.out.println("TestBean1의 destroy");
	}

}
