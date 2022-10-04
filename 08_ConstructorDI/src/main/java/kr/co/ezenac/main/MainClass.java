package kr.co.ezenac.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezenac.beans.DataBean;
import kr.co.ezenac.beans.TestBean1;
import kr.co.ezenac.beans.TestBean2;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");

		TestBean1 obj1 = ctx.getBean("obj1", TestBean1.class);
		obj1.printData();
		line();

		TestBean1 obj2 = ctx.getBean("obj2", TestBean1.class);
		obj2.printData();
		line();

		TestBean1 obj3 = ctx.getBean("obj3", TestBean1.class);
		obj3.printData();
		line();

		TestBean1 obj4 = ctx.getBean("obj4", TestBean1.class);
		obj4.printData();
		line();

		TestBean1 obj5 = ctx.getBean("obj5", TestBean1.class);
		obj5.printData();
		line();

		TestBean1 obj6 = ctx.getBean("obj6", TestBean1.class);
		obj6.printData();
		line();

		TestBean1 obj7 = ctx.getBean("obj7", TestBean1.class);
		obj7.printData();
		line();

		DataBean d1 = new DataBean();
		DataBean d2 = new DataBean();

		TestBean2 t200 = new TestBean2(d1, d2);
		t200.printData();
		line();

		TestBean2 test2 = ctx.getBean("test2", TestBean2.class);
		test2.printData();
		line();

		TestBean2 obj9 = ctx.getBean("obj9", TestBean2.class);
		obj9.printData();
		line();

	}

	public static void line() {
		System.out.println("--------------------");
	}
}
