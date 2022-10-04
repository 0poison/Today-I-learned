package kr.co.ezenac.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezenac.beans.TestBean;

public class Mainclass {
	public static void main(String[] args) {
		TestBean obj1 = new TestBean();
		obj1.setData1(100);
		System.out.printf("obj1.data1: %d\n", obj1.getData1());
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");
		TestBean t1 = ctx.getBean("t1", TestBean.class);
		System.out.printf("t1.data1 : %d\n", t1.getData1());
		System.out.printf("t2.data1 : %f\n", t1.getData2());
		System.out.printf("t3.data1 : %s\n", t1.isData3());
		System.out.printf("t4.data1 : %s\n", t1.getData4());
		System.out.printf("t5.data1 : %s\n", t1.getData5());
		System.out.printf("t6.data1 : %s\n", t1.getData6());

		ctx.close();

	}
}
