package kr.co.ezenac.beans;

public class TestBean2 {

	public TestBean2() {
		System.out.println("TestBean2의 생성자입니다.");
	}

	public void bean1_init() {
		System.out.println("TestBean2의 init 메서드");
	}

	public void bean1_destroy() {
		System.out.println("TestBean2의 destroy 메서드");
	}

}