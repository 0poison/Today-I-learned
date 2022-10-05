package kr.co.ezenac.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TestBean4 {

	public TestBean4() {
		System.out.println("TestBean4의 생성자");
	}

}
