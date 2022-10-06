package kr.co.ezenac.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezenac.beans.TestBean1;
import kr.co.ezenac.config.BeanConfigClass;

public class MainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx1 = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");

		TestBean1 xml1 = ctx1.getBean(TestBean1.class);
		try {
			xml1.method1();
		} catch (Exception e) {
			System.out.println(e);
		}
		ctx1.close();
		System.out.println("==================================");

		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		TestBean1 java1 = ctx2.getBean(TestBean1.class);
		try {
			java1.method1();
		} catch (Exception e) {
			System.out.println(e);
		}
		ctx2.close();
	}

}
