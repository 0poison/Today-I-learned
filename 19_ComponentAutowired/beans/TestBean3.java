package kr.co.ezenac.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TestBean3 {
	public TestBean3() {
		System.out.println("TestBean3의 생성자");
	}
}
