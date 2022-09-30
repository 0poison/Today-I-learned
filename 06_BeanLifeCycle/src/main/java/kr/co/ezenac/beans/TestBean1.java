package kr.co.ezenac.beans;

public class TestBean1 {

	public TestBean1() {
		System.out.println("TestBean1의 생성자입니다.");
	}

	public void bean1_init() {
		System.out.println("TestBean1의 init 메서드");
	}

	public void bean1_destroy() {
		System.out.println("TestBean1의 destroy 메서드");
	}

}