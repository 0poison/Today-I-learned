package kr.co.ezenac.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezenac.beans.TestBean1;
import kr.co.ezenac.beans.TestBean2;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");

		TestBean1 t1 = ctx.getBean("t1", TestBean1.class);
		TestBean2 t2 = ctx.getBean("t2", TestBean2.class);
		System.out.printf("t1 : %s\n", t1);
		System.out.printf("t2 : %s\n", t2);
		ctx.close();
	}
}
