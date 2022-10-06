package kr.co.ezenac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import kr.co.ezenac.beans.DataBean3;
import kr.co.ezenac.beans.DataBean4;
import kr.co.ezenac.beans.DataBean5;
import kr.co.ezenac.beans.TestBean2;
import kr.co.ezenac.beans.TestBean3;

@Configuration
@ComponentScan(basePackages = "kr.co.ezenac.beans")
public class BeanConfigClass {

	@Bean
	public DataBean3 obj4() {
		return new DataBean3();
	}

	@Bean
	public DataBean3 obj5() {
		return new DataBean3();
	}

	public TestBean3 java2() {
		return new TestBean3();

	}

}
