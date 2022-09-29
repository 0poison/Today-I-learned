package kr.co.ezenac.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezenac.beans.TestBean;

public class MainClass {

	public static void main(String[] args) {
		// 메모리에 로딩할 때 객체를 생성한다.
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");
		TestBean t1 = ctx.getBean("test1", TestBean.class);
		System.out.printf("t1: %s\n", t1);
		TestBean t2 = ctx.getBean("test1", TestBean.class);
		System.out.printf("t2: %s\n", t2);
		TestBean t3 = ctx.getBean("test2", TestBean.class);
		System.out.printf("t3: %s\n", t3);
		TestBean t4 = ctx.getBean("test2", TestBean.class);
		System.out.printf("t4: %s\n", t4);
		TestBean t5 = ctx.getBean("test3", TestBean.class);
		System.out.printf("t3: %s\n", t5);
		TestBean t6 = ctx.getBean("test3", TestBean.class);
		System.out.printf("t4: %s\n", t6);
		ctx.close();
	}
}
