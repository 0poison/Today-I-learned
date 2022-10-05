package kr.co.ezenac.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.ezenac.beans.TestBean1;
import kr.co.ezenac.beans.TestBean2;
import kr.co.ezenac.beans.TestBean3;
import kr.co.ezenac.beans.TestBean4;
import kr.co.ezenac.beans.TestBean5;
import kr.co.ezenac.config.BeanConfigClass;

public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		TestBean1 obj1 = ctx.getBean("obj1", TestBean1.class);

		TestBean2 obj2 = ctx.getBean("obj2", TestBean2.class);

		TestBean3 obj3 = ctx.getBean("obj3", TestBean3.class);
		System.out.printf("obj3.data1: %s\n", obj3.getData1());
		System.out.printf("obj3.data1: %s\n", obj3.getData2());

		TestBean4 obj4 = ctx.getBean("obj4", TestBean4.class);
		System.out.printf("obj4.data1: %s\n", obj4.getData1());
		System.out.printf("obj4.data1: %s\n", obj4.getData2());
		TestBean5 obj5 = ctx.getBean("obj5", TestBean5.class);
		System.out.printf("obj5.data1: %s\n", obj5.getData1());
		System.out.printf("obj5.data1: %s\n", obj5.getData2());

		ctx.close();
	}
}