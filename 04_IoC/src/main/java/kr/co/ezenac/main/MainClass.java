package kr.co.ezenac.main;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import kr.co.ezenac.beans.TestBean;

public class MainClass {

	public static void main(String[] args) {
//		test1();
//		test2();
//		test3();
		test4();
	}

	// BeanFactory(더 이상 사용안함, 3점대 버젼에서 사용)-패키지 내부(beans.xml)
	public static void test1() {
		ClassPathResource res = new ClassPathResource("kr/co/ezenac/config/beans.xml");

		// beans.xml에서 설정한 TestBean 객체를 바로 생성하지 않는다.
		XmlBeanFactory factory = new XmlBeanFactory(res);
		// getBean()메서드로 객체를 가지고 올 때 생성
		TestBean t1 = factory.getBean("t1", TestBean.class);
		System.out.printf("t1: %s\n", t1);

		// 같은 아이디로 (t1)객체를 생성할 대 객체가 생성되지 않는다.
//		아이디 이름을 가져옴
		TestBean t2 = factory.getBean("t1", TestBean.class);
		System.out.printf("t2: %s\n", t2);
	}

//BeanFactory - 패키지 외부(beans.xml)
	public static void test2() {
		FileSystemResource res = new FileSystemResource("beans.xml");

//beans.xml에서 설정한 TestBean 객체를 바로 생성하지 않는다.
		XmlBeanFactory factory = new XmlBeanFactory(res);

		TestBean t1 = factory.getBean("t2", TestBean.class);
		System.out.printf("t1: %s\n", t1);

		TestBean t2 = factory.getBean("t2", TestBean.class);
		System.out.printf("t2: %s\n", t2);
	}

//ApplicationContext -패키지 내부
	public static void test3() {
//beans.xml을 로딩할 때 객체 생성된다.
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");
		System.out.printf("ctx: %s\n", ctx);

		TestBean t1 = ctx.getBean("t2", TestBean.class);
		System.out.printf("t1: %s\n", t1);

		TestBean t2 = ctx.getBean("t2", TestBean.class);
		System.out.printf("t2: %s\n", t2);
		ctx.close();
	}

	public static void test4() {
		// beans.xml을 로딩할 때 객체 생성된다.
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		// 이미 만들어진 객체 주소값을 가져온다.
		TestBean t1 = ctx.getBean("t2", TestBean.class);
		System.out.printf("t1: %s\n", t1);
//같은 객체 주소값을 가져온다.
		TestBean t2 = ctx.getBean("t2", TestBean.class);
		System.out.printf("t2: %s\n", t2);
		ctx.close();
	}

}
