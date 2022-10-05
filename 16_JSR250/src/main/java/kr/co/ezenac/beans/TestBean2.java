package kr.co.ezenac.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;

public class TestBean2 {

	public TestBean2() {
		System.out.println("TestBean2의 생성자");
	}

	@Bean
	@PostConstruct
	public void init2() {
		System.out.println("TestBean2의 init메서드");
	}

	@Bean
	@PreDestroy
	public void destroy2() {
		System.out.println("TestBean2의 destroy메서드");
	}

}
