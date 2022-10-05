package kr.co.ezenac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import kr.co.ezenac.beans.TestBean1;

public class BeanConfigClass {
	@Bean(initMethod = "init", destroyMethod = "destroy")
	@Lazy
	public TestBean1 java1() {
		return new TestBean1();
	}

}
