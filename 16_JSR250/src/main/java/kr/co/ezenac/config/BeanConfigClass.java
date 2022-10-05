package kr.co.ezenac.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import kr.co.ezenac.beans.DataBean1;
import kr.co.ezenac.beans.DataBean2;
import kr.co.ezenac.beans.TestBean1;
import kr.co.ezenac.beans.TestBean2;
import kr.co.ezenac.beans.TestBean3;
import kr.co.ezenac.beans.TestBean4;
import kr.co.ezenac.beans.TestBean5;

@Configuration
public class BeanConfigClass {
	@Lazy
	@Bean(initMethod = "init1", destroyMethod = "destroy1")
	public TestBean1 obj1() {
		return new TestBean1();
	}

	@Lazy
	@Bean
	public TestBean2 obj2() {
		return new TestBean2();
	}

	@Bean
	public DataBean1 data1() {
		return new DataBean1();
	}

	@Bean
	public DataBean2 data2() {
		return new DataBean2();
	}

	@Bean(autowire = Autowire.BY_NAME)
	public TestBean3 obj3() {
		return new TestBean3();
	}

	@Bean
	public TestBean4 obj4() {
		return new TestBean4();
	}

	@Bean
	public TestBean5 obj5() {
		return new TestBean5();
	}

}
