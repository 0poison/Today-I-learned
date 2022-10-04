package kr.co.ezenac.main;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezenac.beans.DataBean;
import kr.co.ezenac.beans.TestBean;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");
		TestBean t1 = ctx.getBean("t1", TestBean.class);
		List<String> list1 = t1.getList1();
		for (String str : list1) {
			System.out.printf("list1 : %s\n", str);
		}
		List<Integer> list2 = t1.getList2();
		for (int value : list2) {
			System.out.printf("list2 : %d\n", value);
		}
		List<DataBean> list3 = t1.getList3();
		for (DataBean obj : list3) {
			System.out.printf("list3 : %s\n", obj);
		}

		System.out.println("---------------------------");
		Set<String> set1 = t1.getSet1();
		for (String str : set1) {
			System.out.printf("set1 : %s\n", str);
		}
		Set<Integer> set2 = t1.getSet2();
		for (Integer value : set2) {
			System.out.printf("set2 : %d\n", value);
		}
		Set<DataBean> set3 = t1.getSet3();
		for (DataBean obj : set3) {
			System.out.printf("set3 : %s\n", obj);
		}

		System.out.println("---------------------------");
		Map<String, Object> map1 = t1.getMap1();
		for (int i = 1; i <= map1.size(); i++) {
			System.out.printf("a" + i + ": %s\n", map1.get("a" + i));
		}
		System.out.println("---------------------------");
		Properties prop1 = t1.getProp1();

		String p1 = prop1.getProperty("p1");
		String p2 = prop1.getProperty("p2");
		String p3 = prop1.getProperty("p3");

		System.out.printf("p1 : %s\n", p1);
		System.out.printf("p2 : %s\n", p2);
		System.out.printf("p3 : %s\n", p3);

		ctx.close();

	}
}
