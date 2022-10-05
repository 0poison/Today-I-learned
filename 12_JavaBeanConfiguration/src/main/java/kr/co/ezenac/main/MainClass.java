package kr.co.ezenac.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezenac.beans.TestBean1;
import kr.co.ezenac.beans.TestBean2;
import kr.co.ezenac.beans.TestBean3;
import kr.co.ezenac.beans.TestBean4;
import kr.co.ezenac.config.BeanConfigClass;

public class MainClass {

	public static void main(String[] args) {
//xml을 사용하는 방식
		ClassPathXmlApplicationContext ctx1 = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");
		TestBean1 xml1 = ctx1.getBean("xml1", TestBean1.class);
		System.out.printf("xml1 : %s\n", xml1);
		TestBean1 xml11 = ctx1.getBean("xml1", TestBean1.class);
		System.out.printf("xml11 : %s\n", xml11);
		TestBean2 xml2 = ctx1.getBean("xml2", TestBean2.class);
		System.out.printf("xml2 : %s\n", xml2);
		System.out.println("=============================================================");

		TestBean4 xml4 = ctx1.getBean(TestBean4.class);
		System.out.printf("xml4 : %s\n", xml4);
//java 파일을 사용하는 방식

		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(BeanConfigClass.class);

		TestBean1 java1 = ctx2.getBean("java1", TestBean1.class);
		System.out.printf("java1 : %s\n", java1);
		TestBean1 java11 = ctx2.getBean("java1", TestBean1.class);
		System.out.printf("java11 : %s\n", java11);

//		TestBean1 java500 = ctx2.getBean("java500", TestBean1.class);
//		System.out.printf("java500 : %s\n", java500);

		TestBean1 java600 = ctx2.getBean("java600", TestBean1.class);
		System.out.printf("java600 : %s\n", java600);
		TestBean2 java2 = ctx2.getBean("java2", TestBean2.class);
		System.out.printf("java2 : %s\n", java2);
		TestBean2 java22 = ctx2.getBean("java2", TestBean2.class);
		System.out.printf("java22 : %s\n", java22);

		TestBean3 xml3 = ctx1.getBean("xml3", TestBean3.class);
		System.out.printf("xml3 : %s\n", xml3); // scope prototype으로 생성
		TestBean3 xml33 = ctx1.getBean("xml3", TestBean3.class);
		System.out.printf("xml3 : %s\n", xml33); // scope prototype으로 생성
		TestBean3 java3 = ctx2.getBean("java3", TestBean3.class);
		System.out.printf("java3 : %s\n", java3);
		TestBean3 java33 = ctx2.getBean("java3", TestBean3.class);
		System.out.printf("java3 : %s\n", java33);

		TestBean4 java4 = ctx2.getBean("java4", TestBean4.class);
		System.out.printf("java4: %s\n", java4);
		ctx2.close();
	}

}
