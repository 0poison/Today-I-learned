package kr.co.ezenac.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezenac.beans.HelloWorld;

public class MainClass {

	public static void main(String[] args) {
//beans.xml 파일을 로딩한다
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");
		// beans.xml 파일을 로딩한다.
		HelloWorld hello1 = (HelloWorld) ctx.getBean("hello");
		// beans.xml에 정의한 bean 객체의 주소값을 가져온다.
		callMethod(hello1);

		HelloWorld hello2 = ctx.getBean("hello", HelloWorld.class);
		callMethod(hello2);
		ctx.close(); // 객체 생성이 끝나면 항상 닫아줘야 한다
		
	}

	public static void callMethod(HelloWorld hello) {
		hello.sayHello();
	}

}
