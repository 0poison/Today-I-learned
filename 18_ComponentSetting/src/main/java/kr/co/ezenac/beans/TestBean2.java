package kr.co.ezenac.beans;

import org.springframework.stereotype.Component;

@Component("t3")
public class TestBean2 {
	public TestBean2() {
		System.out.println("TestBean2의 생성자");
	}
}
